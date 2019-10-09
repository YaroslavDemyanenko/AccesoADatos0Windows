package lectores;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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


	public boolean cargarTxt(String nombreArchivo,Libro metodo) {

		try {

			f = new File(nombreArchivo);
			fr = new FileReader(f);
			bf = new BufferedReader(fr);

			String linea;
			while ((linea = bf.readLine()) != null) {
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
				if (null != fr) {
					fr.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return true;

	}

	public void escribirTxt() {
		
		try {
			
			FileWriter txtWriter = new FileWriter(this.ruta, true);
			txtWriter.append("\n");
			txtWriter.append(registro.get(registro.size() - 1).toTxt());
			txtWriter.flush();
			txtWriter.close();
			
		} catch (IOException e) {
			
			System.out.println("Es posible que otro usuario esté editando el archivo");
		}
	}

	public boolean leerTxt() {
		
		for (Libro libro : registro) {
			
			System.out.println(libro.toString());
		}
		return true;
	}
}
