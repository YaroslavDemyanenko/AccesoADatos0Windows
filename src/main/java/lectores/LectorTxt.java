package lectores;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class LectorTxt {
	private Scanner reader = new Scanner(System.in);
	private String entrada = "";
	private FileReader fr = null;
	private BufferedReader bf = null;
	private File ruta = new File("C:/Users/in1DM3b_02/Desktop/DemosReto");
	private File f = new File(ruta, "prueba.txt");

	// Constructor del lector .txt
//    public LectorTxt(){
//    	try {
//			fr = new FileReader("C:/Users/in1DM3b_02/Desktop/DemosReto/prueba.txt");
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//			}
//        	try {
//				while ((entrada = bf.readLine())!= null) {
//			    	System.out.println(entrada);
//			 	}
//			} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			}
//  	}

	// Metodo para comprobar si existe el directorio y el archivo
	public void Comprobacion() throws IOException {
//    	System.out.println(f.getAbsolutePath()); //Devuelve la ruta absoluta asociada al objeto File
//        System.out.println(f.getParent()); //Devuelve un String conteniendo el directorio padre del File. Devuelve null si no tiene directorio padre
//        System.out.println(ruta.getAbsolutePath());
//        System.out.println(ruta.getParent());

//        entrada = reader.next();

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

	// Metodo para leer el contenido del archivo
	public void leer(String nombreArchivo) {
		try {

			f  = new File(nombreArchivo);
			fr = new FileReader(f);
			bf = new BufferedReader(fr);

			System.out.println("Leyendo el contendio de " + nombreArchivo);
			String linea;
			while ((linea = bf.readLine()) != null)
				System.out.println(linea);
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
	}

}
