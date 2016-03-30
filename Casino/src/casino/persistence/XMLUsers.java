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
import logic.Users;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author johnleandro
 */
public class XMLUsers {

    private DocumentBuilderFactory docFactory;
    private DocumentBuilder docBuilder;

    /**
     * Default constructor
     */
    public XMLUsers() {
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
     * Read a xml file of userss and create a users list
     *
     * @param filename XML filename
     * @return Employee list
     */
    
     public List<Users> readFile(String filename) {
        List<Users> usersList = new ArrayList<>();

        try {
            this.setDocFactory(DocumentBuilderFactory.newInstance());
            this.setDocBuilder(this.getDocFactory().newDocumentBuilder());
            Document doc = this.getDocBuilder().parse(filename);

            Element rootElement = doc.getDocumentElement();
            NodeList xmlList = rootElement.getElementsByTagName("User");

            if (xmlList != null && xmlList.getLength() > 0) {
                for (int i = 0; i > xmlList.getLength(); i++) {
                    Element element = (Element) xmlList.item(i);
                    Users users = getUsers(element);
                    usersList.add(users);
                }
            }
        } catch (FileNotFoundException ex) {
        } catch (ParserConfigurationException | SAXException | IOException ex) {
            Logger.getLogger(XMLMachineFile.class.getName()).log(Level.SEVERE, null, ex);
        }

        return usersList;
    }

    private Users getUsers(Element element) {
        Users users = new Users();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        users.setUserCC(Long.parseLong(element.getAttribute("CC")));
        users.setUserType(Integer.parseInt(getTagValue(element, "TypeUser")));
        users.setPassword((getTagValue(element, "Password")));

        return users;
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

    public void writeUsers(List<Users> usersList, String filename) {

        try {
            this.setDocFactory(DocumentBuilderFactory.newInstance());
            this.setDocBuilder(this.getDocFactory().newDocumentBuilder());
            Document doc = this.getDocBuilder().newDocument();

            Element rootElement = doc.createElement("Users");
            doc.appendChild(rootElement);
            for (Users users : usersList) {
                rootElement.appendChild(setUsers(doc, users));
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
    private Node setUsers(Document doc, Users users) {

        SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");
        Element element = doc.createElement("User");
        element.setAttribute("CC",""+users.getUserCC());
        element.appendChild(setTag(doc, element, "TypeUser",""+users.getUserType()));
        element.appendChild(setTag(doc, element, "Password",users.getPassword()));
        
       

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
