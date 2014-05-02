/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.*;
import org.xml.sax.SAXException;

/**
 *
 * @author michaelz
 * stolen from http://stackoverflow.com/questions/15732/whats-the-best-way-to-validate-an-xml-file-against-an-xsd-file
 */
public class ValidateXML {

    /**
     * @param args the command line arguments\
     * arg1: xsd
     * arg2: file to validate
     */
    public static void main(String[] args) throws MalformedURLException, SAXException, IOException {
       //URL schemaFile = new URL("http://java.sun.com/xml/ns/j2ee/web-app_2_4.xsd");
       File schemaFile = new File(args[0]);
      Source xmlFile = new StreamSource(new File(args[1]));
        SchemaFactory schemaFactory = SchemaFactory
                .newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        Schema schema = schemaFactory.newSchema(schemaFile);
        Validator validator = schema.newValidator();
        try {
            validator.validate(xmlFile);
            System.out.println(xmlFile.getSystemId() + " is valid");
        } catch (SAXException e) {
            System.out.println(xmlFile.getSystemId() + " is NOT valid");
            System.out.println("Reason: " + e.getLocalizedMessage());
        }

    }

}
