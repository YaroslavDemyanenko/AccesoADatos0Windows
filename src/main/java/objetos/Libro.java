package objetos;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Libro {
	private Long isbn;
	private String titulo, autor, genero, descripcion;

	public Libro(Long isbn, String titulo, String autor, String genero, String descripcion) {
		this.isbn = isbn;
		this.titulo = titulo;
		this.autor = autor;
		this.genero = genero;
		this.descripcion = descripcion;
	}

	public Libro() {

	}

	public Libro registrarLibro(Scanner reader) {
		Long isbn = 0l;
		String titulo, autor, genero, descripcion;
		System.out.println("Registra el libro rellenando los siguentes campos");

		while (isbn.toString().length() != 13) {
			try {
				System.out.println("Introduce el ISBN (13 digitos)");
				isbn = reader.nextLong();
			} catch (InputMismatchException e) {
				System.out.println("Opcion invalida, introduce un numero de 13 digitos");
				continue;
			}
		}
		reader.nextLine();
		System.out.println("Introduce el titulo");
		titulo = reader.nextLine();
		System.out.println("Introduce el nombre del autor");
		autor = reader.nextLine();
		System.out.println("Introduce el genero");
		genero = reader.nextLine();
		System.out.println("Introduce una descripcion del libro");
		descripcion = reader.nextLine();
		return new Libro(isbn, titulo, autor, genero, descripcion);
	}

	public Libro toLibro(String[] datos) {
		if (datos.length == 5)
			return new Libro(Long.parseLong(datos[0]), datos[1], datos[2], datos[3], datos[4]);
		else
			return new Libro();
	}
	
	public String toCsv() {
		String resultado = "";
		resultado+=this.isbn.toString()+","+this.titulo+","+this.autor+","+this.genero+","+this.descripcion;
		return resultado;
	}

	@Override
	public String toString() {
		return "Libro [isbn: " + isbn + ", titulo: " + titulo + ", autor: " + autor + ", genero: " + genero + ", descripcion: " + descripcion + "]";
	}

	public Long getIsbn() {
		return isbn;
	}

	public void setIsbn(Long isbn) {
		this.isbn = isbn;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
