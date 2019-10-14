package escritores;

import java.io.FileWriter;
import java.io.IOException;

import java.io.FileWriter;
import java.io.IOException;
import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;
import objetos.Libro;

public class EscritorXml {
	
	public void escribirXml(Libro libro, String path) {
		
		try {
			 
			Element catalogo = new Element("Catalogo");
			
			Element book = new Element("Libro");
			book.setAttribute(new Attribute("isbn", libro.getIsbn().toString()));
			book.addContent(new Element("Titulo").setText(libro.getTitulo()));
			book.addContent(new Element("Autor").setText(libro.getAutor()));
			book.addContent(new Element("Genero").setText(libro.getGenero()));
			book.addContent(new Element("Descripcion").setText(libro.getDescripcion()));
			book.detach();
			
			catalogo.addContent(book);
	 
	 
			XMLOutputter xmlOutput = new XMLOutputter();
	 
			// display nice nice
			xmlOutput.setFormat(Format.getPrettyFormat());
			
			FileWriter file = new FileWriter("C:\\Workspace_reto0\\AccesoADatos0Windows\\reto0\\" +libro.getIsbn() + ".xml");
			xmlOutput.output(catalogo, file);
	 
			System.out.println("File Saved!");
			file.close();
		  } catch (IOException io) {
			System.out.println(io.getMessage());
		  }
	}

}
