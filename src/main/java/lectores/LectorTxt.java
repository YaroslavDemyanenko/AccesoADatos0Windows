package lectores;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import objetos.Libro;

public class LectorTxt {
	
	private FileReader fr = null;
	private BufferedReader bf = null;
	private File ruta = new File("C:/Users/in1DM3b_02/Desktop/DemosReto");
	private File f = new File(ruta, "prueba.txt");
	private List<Libro> registro;
	
	public LectorTxt() {
		registro = new ArrayList<>();
	}
	
	/**
	public void Comprobacion() throws IOException {
		if (!f.exists()) { // se comprueba si el fichero existe o no
			System.out.println("Fichero " + f.getName() + " no existe");
			if (!ruta.exists()) { // se comprueba si la ruta existe o no
				System.out.println("El directorio " + ruta.getName() + " no existe");
				if (ruta.mkdir()) { // se crea la ruta. Si se ha creado correctamente
					System.out.println("Directorio creado");
					if (f.createNewFile()) { // se crea el fichero. Si se ha creado correctamente
						System.out.println("Fichero " + f.getName() + " creado");
					} else {
						System.out.println("No se ha podido crear " + f.getName());
					}
				} else {
					System.out.println("No se ha podido crear " + ruta.getName());
				}
			} else { // si la ruta existe creamos el fichero
				if (f.createNewFile()) {
					System.out.println("Fichero " + f.getName() + " creado");
				} else {
					System.out.println("No se ha podido crear " + f.getName());
				}
			}
		} else { // el fichero existe. Mostramos el tama�o
			System.out.println("Fichero " + f.getName() + " existe");
			System.out.println("Tama�o " + f.length() + " bytes");
		}
	}
	**/

	// Metodo para leer el contenido del archivo
	public boolean cargarTxt(String nombreArchivo) {
		try {

			f  = new File(nombreArchivo);
			fr = new FileReader(f);
			bf = new BufferedReader(fr);

			System.out.println("Leyendo el contendio de " + nombreArchivo);
			String linea;
			while ((linea = bf.readLine()) != null)
				System.out.println(linea);
				String[] values = linea.split(",");
				registro.add(Libro.toLibro(values));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != fr) {
					fr.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return true;
	}
	public boolean leerTxt() {
		for(Libro libro: registro) {
			System.out.println(libro.toString());
		}
		return true;
	}
}
