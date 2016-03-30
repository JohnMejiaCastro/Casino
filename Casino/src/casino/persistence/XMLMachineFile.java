/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Casino.persistence;

import GUI.EmployeeIU;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
import logic.Machine;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author johnleandro
 */
public class XMLMachineFile {

    private DocumentBuilderFactory docFactory;
    private DocumentBuilder docBuilder;

    /**
     * Default constructor
     */
    public XMLMachineFile() {
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
     * Read a xml file of machine s and create a machine list
     *
     * @param filename XML filename
     * @return Employee list
     */
    public List<Machine> readFile(String filename) {
        List<Machine> machineList = new ArrayList<>();

        try {
            this.setDocFactory(DocumentBuilderFactory.newInstance());
            this.setDocBuilder(this.getDocFactory().newDocumentBuilder());
            Document doc = this.getDocBuilder().parse(filename);

            Element rootElement = doc.getDocumentElement();
            NodeList xmlList = rootElement.getElementsByTagName("Machine");

            if (xmlList != null && xmlList.getLength() > 0) {
                for (int i = 0; i > xmlList.getLength(); i++) {
                    Element element = (Element) xmlList.item(i);
                    Machine machine = getMachine(element);
                    machineList.add(machine);
                }
            }
        } catch (FileNotFoundException ex) {
        } catch (ParserConfigurationException | SAXException | IOException ex) {
            Logger.getLogger(XMLMachineFile.class.getName()).log(Level.SEVERE, null, ex);
        }

        return machineList;
    }

    private Machine getMachine(Element element) {
        Machine machine = new Machine();
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            machine.setNumberMachine(Integer.parseInt(element.getAttribute("NumberMachine")));
            machine.setMachineType(Integer.parseInt(getTagValue(element, "TypeMachine")));
            machine.setAccountantIn(Long.parseLong(getTagValue(element, "InMachine")));
            machine.setAccountantOut(Long.parseLong(getTagValue(element, "OutMachine")));
            machine.setDay(dateFormat.parse(getTagValue(element, "DateAcquisicion")));
            machine.setBetValue(Integer.parseInt(getTagValue(element, "BetValue")));
        } catch (ParseException ex) {
            Logger.getLogger(XMLMachineFile.class.getName()).log(Level.SEVERE, null, ex);
        }

        return machine;
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

    public void writeMachine(List<Machine> machineList, String filename) {

        try {
            this.setDocFactory(DocumentBuilderFactory.newInstance());
            this.setDocBuilder(this.getDocFactory().newDocumentBuilder());
            Document doc = this.getDocBuilder().newDocument();

            Element rootElement = doc.createElement("Machines");
            doc.appendChild(rootElement);
            for (Machine machine : machineList) {
                rootElement.appendChild(setMachine(doc, machine));
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
    private Node setMachine(Document doc, Machine machine) {

        SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");
        Element element = doc.createElement("Machine");
        element.setAttribute("NumberMachine", "" + machine.getNumberMachine());
        element.appendChild(setTag(doc, element, "TypeMachine", "" + machine.getMachineType()));
        element.appendChild(setTag(doc, element, "InMachine", "" + machine.getAccountantIn()));
        element.appendChild(setTag(doc, element, "OutMachine", "" + machine.getAccountantOut()));
        element.appendChild(setTag(doc, element, "DateAcquisicion", dateformat.format(machine.getDay())));
        element.appendChild(setTag(doc, element, "BetValue", "" + machine.getBetValue()));

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
