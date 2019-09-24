package objetos;

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

	public static Libro toLibro(String[] datos) {
		if (datos.length == 5)
			return new Libro(Long.parseLong(datos[0]), datos[1], datos[2], datos[3], datos[4]);
		else
			return new Libro();
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
