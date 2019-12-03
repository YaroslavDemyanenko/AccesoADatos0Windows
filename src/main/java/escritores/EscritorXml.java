package escritores;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import objetos.Libro;

public class EscritorXml {

	public void escribirXml(Libro libro, String path) {

		try {
			Element catalogo = new Element("Catalogo");
			catalogo.addContent(libro.toXmlElement());

			XMLOutputter xmlOutput = new XMLOutputter();

			// display nice nice
			xmlOutput.setFormat(Format.getPrettyFormat());

			// TODO
			FileWriter file = new FileWriter("PONER RUTA");
			xmlOutput.output(catalogo, file);

			System.out.println("File Saved!");
			file.close();
		} catch (IOException io) {
			System.out.println(io.getMessage());
		}
	}

	public void anyadirLibrosAXml(List<Libro> libros) {
		File archivo = new File("/archivosXml/librosXmp.xml");

		Document xmlEnDocument = null;
		Element elementoRaiz = null;
		FileInputStream fis;

		try {
			if (archivo.exists()) {
				fis = new FileInputStream(archivo);
				SAXBuilder sb = new SAXBuilder();
				xmlEnDocument = sb.build(fis);
				elementoRaiz = xmlEnDocument.getRootElement();
				fis.close();
			} else {
				xmlEnDocument = new Document();
				elementoRaiz = new Element("catalogo");
			}
			
			for (Libro libro : libros) {
				elementoRaiz.addContent(libro.toXmlElement());
			}
			
			xmlEnDocument.setContent(elementoRaiz);
		    try {
		        FileWriter writer = new FileWriter("products.xml");
		        XMLOutputter outputter = new XMLOutputter();
		        outputter.setFormat(Format.getPrettyFormat());
		        outputter.output(xmlEnDocument, writer);
		        outputter.output(xmlEnDocument, System.out);
		        writer.close(); // close writer
		    } catch (IOException e) {
		        e.printStackTrace();
		    }
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (JDOMException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
