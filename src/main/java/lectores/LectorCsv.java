package lectores;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LectorCsv {

	private List<List<String>> registro;
	private List<String> campos;
	
	public LectorCsv() {
		registro = new ArrayList<>();
	}
	
	public List<List<String>> cargarCsv(String path) {
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
		    String line;
		    while ((line = br.readLine()) != null) {
		        String[] values = line.split(",");
		        registro.add(Arrays.asList(values));
		    }
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return registro;
	}
	
	public List<String> cargarCamposCsv(){
		return registro.get(0);
	}
	
	public void leerCsv() {
		for(List<String> linea: registro) {
			System.out.println(linea.toString());
		}
	}

	public void resumenLectura() {
		StringBuilder builder=new StringBuilder();
		builder.append("Se han leido "+(registro.size()-1)+" lineas\nLos campos son: ");
		for (int i=0;campos.size()>i;i++) {
			builder.append(campos.get(i)+", ");
		}
		builder.delete(builder.length()-2, builder.length());
		System.out.println(builder.toString());
	}
	
	public String leerPosicion(int numero) {
		StringBuilder builder=new StringBuilder();
		for(int i=0;i<campos.size();i++) {
			builder.append(campos.get(i)+": "+registro.get(numero).get(i)+"\n");
		}
		return builder.toString();
	}
	
	
	public List<List<String>> getRegistro() {
		return registro;
	}

	public void setRegistro(List<List<String>> records) {
		this.registro = records;
	}

	public List<String> getCampos() {
		return campos;
	}

	public void setCampos(List<String> campos) {
		this.campos = campos;
	}
}
