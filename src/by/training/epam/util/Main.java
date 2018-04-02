package by.training.epam.util;

import org.apache.log4j.BasicConfigurator;
public class Main {

    public static final String XML_NAME = "C:\\\\Users\\Лена\\IdeaProjects\\XMLProcessor\\src\\res\\Candies.xml";
    public static final String XML_SCHEMA_NAME = "C:\\\\Users\\Лена\\IdeaProjects\\XMLProcessor\\src\\res\\CandiesXSD.xsd";
    public static final String XSLT_NAME = "C:\\\\Users\\Лена\\IdeaProjects\\XMLProcessor\\src\\res\\transform.xslt";
    public static final String HTML_NAME = "C:\\\\Users\\Лена\\IdeaProjects\\XMLProcessor\\src\\res\\CandiesHTM.html";

    public static void main(String[] args)  {

        BasicConfigurator.configure();
        XMLValidator xmVal = new XMLValidator();
        xmVal.validate(XML_NAME, XML_SCHEMA_NAME);

        XSLTTransformer xsltTransformer = new XSLTTransformer();
        xsltTransformer.convertXMLToHTML(XML_NAME, XSLT_NAME,HTML_NAME);
    }

}
