package by.training.epam.util;

import org.apache.log4j.Logger;

import javax.xml.transform.*;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.*;

public class XSLTTransformer {
    private static final Logger log = Logger.getLogger(XMLValidator.class);

    public void convertXMLToHTML(String xmlFileName, String xsltFileName, String htmlFileName) {
        TransformerFactory tFactory = TransformerFactory.newInstance();
        try {
            FileInputStream xmlStream = new FileInputStream(xmlFileName);
            FileInputStream xsltStream = new FileInputStream(xsltFileName);
            FileOutputStream htmlStream = new FileOutputStream(htmlFileName);

            StreamSource xmlInputFile = new StreamSource(xmlStream);
            StreamSource xslTransformationFile = new StreamSource(xsltStream);
            StreamResult xmlOutputFile = new StreamResult(htmlStream);

            Transformer transformer = tFactory.newTransformer(xslTransformationFile);
            transformer.transform(xmlInputFile, xmlOutputFile);

        } catch (TransformerConfigurationException e) {
            log.error(e.getMessage());
        } catch (TransformerException e) {
            log.error(e.getMessage());
        } catch (FileNotFoundException e) {
            log.error("File is not valid" + e.getMessage());
        }
        System.out.println("Done!");
        log.info("XML file has been transformed successfully!");



    }
}
