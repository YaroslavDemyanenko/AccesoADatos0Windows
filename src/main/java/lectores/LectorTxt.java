package lectores;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import objetos.Libro;

public class LectorTxt {

	private FileReader filereader = null;
	private BufferedReader bufferedReader = null;
	private File archivo = null;
	

	public LectorTxt() {
		
	}


	public List<Libro> cargarTxt(String ruta,Libro metodo) {
		try {
			List<Libro> registro=new ArrayList<Libro>();
			archivo = new File(ruta);
			filereader = new FileReader(archivo);
			bufferedReader = new BufferedReader(filereader);

			String linea;
			while ((linea = bufferedReader.readLine()) != null) {
				String[] values = linea.split(";");
				for(int i=0;i<values.length;i++) {
					values[i]=values[i].split(":")[1];
				}
				registro.add(metodo.toLibro(values));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != filereader) {
					filereader.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return registro;

	}
}
