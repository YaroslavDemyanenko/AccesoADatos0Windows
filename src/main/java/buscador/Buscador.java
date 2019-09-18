package buscador;

import java.io.File;

public class Buscador {

	public Buscador() {

	}

	public void verArchivos(File directorioActual,String sufijo) {
		if (directorioActual == null) {
			directorioActual = new File(".");
		}
		File[] filesList = directorioActual.listFiles();

		for (File f : filesList) {
			if (f.isDirectory())
				verArchivos(f,sufijo);
			if (f.isFile() && (f.getName().substring(f.getName().length()-sufijo.length())).equals(sufijo)) {
				System.out.println(f.getName());
			}
		}

	}
}
