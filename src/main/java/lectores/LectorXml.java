package lectores;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class LectorXml {

	public void leerXml(String path) {
		try {
    		
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();

            DefaultHandler handler = new DefaultHandler() {

                boolean bNombre = false;
                boolean bUsername = false;
                boolean bPassword = false;

                public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                	
            		if (qName.equalsIgnoreCase("empleado")) {
            			String id = attributes.getValue("id");
            			System.out.println("id: " + id);
            		}
					            		
					if (qName.equalsIgnoreCase("nombre")) {
					    bNombre = true;
					}
					
					if (qName.equalsIgnoreCase("username")) {
					    bUsername = true;
					}

					if (qName.equalsIgnoreCase("password")) {
					    bUsername = true;
					}
				}
					
				public void characters(char ch[], int start, int length) throws SAXException {
					    if (bNombre) {
					        System.out.println("nombre: " + new String(ch, start, length));
					        bNombre = false;
					    }
					
					    if (bUsername) {
					    	System.out.println("username: " + new String(ch, start, length));
					    	bUsername = false;
					    }
					
					    if (bPassword) {
					    	System.out.println("password: " + new String(ch, start, length));
					        bPassword = false;
				        }
				    }
					
			};

				File file = new File(path);
				InputStream inputStream = new FileInputStream(file);
				Reader reader = new InputStreamReader(inputStream, "UTF-8");
				
				InputSource is = new InputSource(reader);
				is.setEncoding("UTF-8");
	            saxParser.parse(is, handler);
	
		        } 
    	catch (Exception e) {
    		e.printStackTrace();
		}
		
		return;
    }
	
}
