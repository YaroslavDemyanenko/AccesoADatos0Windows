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
    		
            SAXParserFactory parserFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = parserFactory.newSAXParser();

            DefaultHandler handler = new DefaultHandler() {

            	boolean bTitulo = false;
                boolean bAutor = false;
                boolean bGenero = false;
                boolean bDescripcion = false;

                public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                	
            		if (qName.equalsIgnoreCase("libro")) {
            			String id = attributes.getValue("id");
            			System.out.println("id: " + id);
            		}
            		
            		if (qName.equalsIgnoreCase("titulo")) {
						bTitulo = true;
					}
            		
					if (qName.equalsIgnoreCase("autor")) {
						bAutor = true;
					}

					if (qName.equalsIgnoreCase("genero")) {
						bGenero = true;
					}
					
					if (qName.equalsIgnoreCase("descripcion")) {
						bDescripcion = true;
					}
				}
					
				public void characters(char ch[], int start, int length) throws SAXException {
					    
					    if (bTitulo) {
					    	System.out.println("Titulo: " + new String(ch, start, length));
					    	bTitulo = false;
					    }
					    
					    if (bAutor) {
					        System.out.println("Autor: " + new String(ch, start, length));
					        bAutor = false;
					    }
					
					    if (bGenero) {
					    	System.out.println("Genero: " + new String(ch, start, length));
					    	bGenero = false;
				        }
					    if (bDescripcion) {
					    	System.out.println("Descripcion: " + new String(ch, start, length));
					    	bDescripcion = false;
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
