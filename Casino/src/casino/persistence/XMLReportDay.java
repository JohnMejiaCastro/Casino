package Casino.persistence;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import logic.DataDayReport;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author johnleandro
 */
public class XMLReportDay {

    private DocumentBuilderFactory docFactory;
    private DocumentBuilder docBuilder;

    /**
     * Default constructor
     */
    public XMLReportDay() {
    }

    /**
     * Get Document Builder Factory
     *
     * @return Document Builder Factory
     */
    public DocumentBuilderFactory getDocFactory() {
        return docFactory;
    }

    /**
     * Set Document Builder Factory
     *
     * @param docFactory Document Builder Factory
     */
    public void setDocFactory(DocumentBuilderFactory docFactory) {
        this.docFactory = docFactory;
    }

    /**
     * Get Document Builder
     *
     * @return Document Builder
     */
    public DocumentBuilder getDocBuilder() {
        return docBuilder;
    }

    /**
     * Set Document Builder
     *
     * @param docBuilder Document Builder
     */
    public void setDocBuilder(DocumentBuilder docBuilder) {
        this.docBuilder = docBuilder;
    }

    /**
     * Read a xml file of betValues and create a betValue list
     *
     * @param filename XML filename
     * @return Employee list
     */
     public List<DataDayReport> readFile(String filename) {
        List<DataDayReport> dataDayReportList = new ArrayList<>();

        try {
            this.setDocFactory(DocumentBuilderFactory.newInstance());
            this.setDocBuilder(this.getDocFactory().newDocumentBuilder());
            Document doc = this.getDocBuilder().parse(filename);

            Element rootElement = doc.getDocumentElement();
            NodeList xmlList = rootElement.getElementsByTagName("Day");

            if (xmlList != null && xmlList.getLength() > 0) {
                for (int i = 0; i > xmlList.getLength(); i++) {
                    Element element = (Element) xmlList.item(i);
                    DataDayReport dataDayReport = getDataDayReport(element);
                    dataDayReportList.add(dataDayReport);
                }
            }
        } catch (FileNotFoundException ex) {
        } catch (ParserConfigurationException | SAXException | IOException ex) {
            Logger.getLogger(XMLMachineFile.class.getName()).log(Level.SEVERE, null, ex);
        }

        return dataDayReportList;
    }

    private DataDayReport getDataDayReport(Element element) {
        DataDayReport dataDayReport = new DataDayReport();
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            dataDayReport.setNumberMachine((element.getAttribute("NumberMachine")));
            dataDayReport.setMachineInputDayCurrent(Long.parseLong(getTagValue(element, "InMachine")));
            dataDayReport.setMachineOutDayCurrent(Long.parseLong(getTagValue(element, "OutMachine")));
            dataDayReport.setDayDate(dateFormat.parse(getTagValue(element, "DateDay")));
           
        } catch (ParseException ex) {
            Logger.getLogger(XMLMachineFile.class.getName()).log(Level.SEVERE, null, ex);
        }

        return dataDayReport;
    }

    /**
     * take a xml
     *
     * @param element element
     * @param tagName element name
     * @return
     */
    private String getTagValue(Element element, String tagName) {
        String textVal = null;
        NodeList nl = element.getElementsByTagName(tagName);
        if (nl != null && nl.getLength() > 0) {

            Element tagElement = (Element) nl.item(0);
            textVal = tagElement.getFirstChild().getNodeValue();

        }
        return textVal;
    }

    public void writeDataDayReport(List<DataDayReport> dataDayReportsList, String filename) {

        try {
            this.setDocFactory(DocumentBuilderFactory.newInstance());
            this.setDocBuilder(this.getDocFactory().newDocumentBuilder());
            Document doc = this.getDocBuilder().newDocument();

            Element rootElement = doc.createElement("Days");
            doc.appendChild(rootElement);
            for (DataDayReport dataDayReport : dataDayReportsList) {
                rootElement.appendChild(setDataDayReport(doc, dataDayReport));
            }
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer transformer = tf.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(filename));
            transformer.transform(source, result);
        } catch (ParserConfigurationException | TransformerConfigurationException ex) {
            Logger.getLogger(XMLMachineFile.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerException ex) {
            Logger.getLogger(XMLMachineFile.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * build machine xml record
     *
     * @param doc document
     * @param machine Machine
     * @return machine element node
     */
    private Node setDataDayReport(Document doc, DataDayReport dataDayReport) {

        SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");
        Element element = doc.createElement("Day");
        element.setAttribute("NumberMachine", dataDayReport.getNumberMachine());
        element.appendChild(setTag(doc, element, "InMachine", "" + dataDayReport.getMachineInputDayCurrent()));
        element.appendChild(setTag(doc, element, "OutMachine", "" + dataDayReport.getMachineOutDayCurrent()));
        element.appendChild(setTag(doc, element, "DateDay", dateformat.format(dataDayReport.getDayDate())));
       

        return element;
    }

    /**
     *
     * @param doc
     * @param element
     * @param tagName
     * @param tagValue
     * @return
     */
    private Node setTag(Document doc, Element element, String tagName, String tagValue) {
        Element node = doc.createElement(tagName);
        node.appendChild(doc.createTextNode(tagValue));

        return node;
    }

}
