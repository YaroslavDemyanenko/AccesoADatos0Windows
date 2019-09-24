package buscador;

import java.io.File;

public class Buscador {

	public Buscador() {

	}

	/**
	 * 	Desde el directorio "actual" muestra la lista de archivos que contiene el directorio + subdirectorios
	 * @param directorioActual Directorio actual
	 * @param sufijo Extension del archivo
	 */
	public void verArchivos(File directorioActual,String sufijo) {
		if (directorioActual == null) {
			directorioActual = new File(".");
		}
		File[] filesList = directorioActual.listFiles();

		for (File f : filesList) {
			if (f.isDirectory())
				verArchivos(f,sufijo);
			if (f.isFile() && (f.getName().substring(f.getName().length()-sufijo.length())).equals(sufijo)) {
				System.out.println(f.getName().substring(0,f.getName().length()-sufijo.length()));
			}
		}
	}
	
	/**
	 * Recibe el directorio actual, el nombre del archivo y su extension y devuelve la ruta del archivo buscado
	 * @param directorioActual Directorio actual
	 * @param nombre Nombre del archivo a buscar
	 * @param sufijo Extension del archivo a buscar ("." incluido)
	 * @return La ruta del archivo
	 */
	public String buscarArchivo(File directorioActual, String nombre, String sufijo) {
		if (directorioActual == null) {
			directorioActual = new File(".");
		}
		File[] filesList = directorioActual.listFiles();
		String pathResultado=null;
		for (File f : filesList) {
			if (f.isFile() && (f.getName().equals(nombre+sufijo))) {
				return f.getAbsolutePath();
			}
			if (f.isDirectory()) {
				pathResultado = buscarArchivo(f,nombre,sufijo);
				if(pathResultado!=null) {
					return pathResultado;
				}
			}
			
		}
		return pathResultado;
	}
}
