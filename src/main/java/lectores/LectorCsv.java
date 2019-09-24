package lectores;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import objetos.Libro;

public class LectorCsv {

	private List<Libro> registro;
	
	public LectorCsv() {
		registro = new ArrayList<>();
	}
	
	public List<Libro> cargarCsv(String path) {
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
		    String line=br.readLine();
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
	
	public Libro cargarCamposCsv(){
		return registro.get(0);
	}
	
	public boolean leerCsv() {
		for(Libro libro: registro) {
			System.out.println(libro.toString());
		}
		return true;
	}

	public List<Libro> getRegistro() {
		return registro;
	}

	public void setRegistro(List<Libro> registro) {
		this.registro = registro;
	}
}
