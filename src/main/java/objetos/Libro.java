package objetos;

import java.util.Arrays;

import org.jdom2.Attribute;
import org.jdom2.Element;

public class Libro {
	private Long isbn;
	private String titulo, autor, descripcion;
	private String[] generos;

	public Libro(Long isbn, String titulo, String autor, String descripcion) {
		super();
		this.isbn = isbn;
		this.titulo = titulo;
		this.autor = autor;
		this.descripcion = descripcion;
	}

	public Libro(Long isbn, String titulo, String autor, String descripcion, String[] generos) {
		this.isbn = isbn;
		this.titulo = titulo;
		this.autor = autor;
		this.descripcion = descripcion;
		this.generos = generos;
	}

	public Libro() {

	}

	public Libro toLibro(String[] datos) {
		if (datos.length > 4) {
			Libro libroNuevo = new Libro(Long.parseLong(datos[0]), datos[1], datos[2], datos[3]);
			String[] generos = Arrays.copyOfRange(datos, 4, datos.length);
			libroNuevo.setGeneros(generos);
			return libroNuevo;
		} else {
			return null;
		}
	}

	public Element toXmlElement() {
			Element libro = new Element("Libro");
			libro.setAttribute(new Attribute("isbn", isbn.toString()));
			libro.addContent(new Element("Titulo").setText(titulo));
			libro.addContent(new Element("Autor").setText(autor));
			libro.addContent(new Element("Descripcion").setText(descripcion));
			Element generos = new Element("Generos");
			for (String genero : this.generos) {
				generos.addContent(new Element("Genero").setText(genero));
			}
			libro.addContent(generos);
			return libro;
	}

	public String[] getGeneros() {
		return generos;
	}

	public void setGeneros(String[] generos) {
		this.generos = generos;
	}

}
