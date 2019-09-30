package lectores;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import objetos.Libro;

public class LectorCsv {

	private List<Libro> registro;
	private String[] campos;
	private String linea;
	private String ruta;

	public LectorCsv() {
		registro = new ArrayList<>();
	}

	public List<Libro> cargarCsv(String path, Libro metodo) {
		ruta = path;
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			String line=br.readLine();
			linea=line;
			campos=line.split(",");
			while ((line = br.readLine()) != null) {
				String[] values = line.split(",");
				registro.add(metodo.toLibro(values));
			}
		} catch (FileNotFoundException e) {
			System.out.println("Archivo no encontrado");
		} catch (IOException e) {
			System.out.println("Algo ha fallado a la hora de escribir o leer tu archivo");
		}
		return registro;
	}

	public void escribirCsv() {
		try {
			FileWriter csvWriter = new FileWriter(this.ruta);
			
			csvWriter.append(linea);
			csvWriter.append("\n");
			for (int i = 0; i < registro.size(); i++) {
				csvWriter.append(registro.get(i).toCsv());
				csvWriter.append("\n");
			}
			csvWriter.flush();
			csvWriter.close();
		} catch (IOException e) {
			System.out.println("Parece que alguien mas esta editando el archivo");
		}

	}

	public Libro cargarCamposCsv() {
		return registro.get(0);
	}

	public boolean leerCsv() {
		for (Libro libro : registro) {
			System.out.println(libro.toString());
		}
		return true;
	}

	public boolean meterLibro(Libro libro) {
		if (registro != null) {
			registro.add(libro);
			return true;
		} else
			return false;
	}

	public List<Libro> getRegistro() {
		return registro;
	}

	public void setRegistro(List<Libro> registro) {
		this.registro = registro;
	}

	public String getRuta() {
		return ruta;
	}

	public void setRuta(String ruta) {
		this.ruta = ruta;
	}
}
