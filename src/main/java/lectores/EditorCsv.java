package lectores;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import objetos.Libro;

public class EditorCsv {

	private List<Libro> registro;
	private String[] campos;
	private String ruta;

	public EditorCsv() {
		registro = new ArrayList<>();
	}

	public List<Libro> cargarCsv(String path) {
		ruta = path;
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			String line = br.readLine();
			campos = line.split(",");
			while ((line = br.readLine()) != null) {
				String[] values = line.split(",");
				registro.add(Libro.toLibro(values));
			}
		} catch (FileNotFoundException e) {
			System.out.println("Archivo no encontrado");
		} catch (IOException e) {
			System.out.println("Algo ha fallado a la hora de escribir o leer tu archivo");
		}
		return registro;
	}

	public List<Libro> cargarCsv2(String path) {
		ruta = path;
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			String line = br.readLine();
			campos = line.split(",");
			while ((line = br.readLine()) != null) {
				if(line.equals("")) {
					continue;
				}
				StringTokenizer tokenizer = new StringTokenizer(line, ",");
				ArrayList<String> arrayDatos = new ArrayList<String>();
				while ((tokenizer.hasMoreTokens())) {
					arrayDatos.add(tokenizer.nextToken());
				}
				String[] stringArray = Arrays.copyOf(arrayDatos.toArray(), arrayDatos.size(), String[].class);
				registro.add(Libro.toLibro(stringArray));
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
			FileWriter csvWriter = new FileWriter(this.ruta, true);
			csvWriter.append("\n");
			csvWriter.append(registro.get(registro.size() - 1).toCsv());
			csvWriter.flush();
			csvWriter.close();
		} catch (IOException e) {
			System.out.println("Es posible que otro usuario esté editando el archivo");
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
