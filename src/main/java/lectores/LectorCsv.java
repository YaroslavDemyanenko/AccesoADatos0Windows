package lectores;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LectorCsv {

	private List<List<String>> records;
	private List<String> campos;
	
	public LectorCsv() {
		records = new ArrayList<>();
	}
	
	public List<List<String>> leerCsv(String path) {
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
		    String line;
		    while ((line = br.readLine()) != null) {
		        String[] values = line.split(",");
		        records.add(Arrays.asList(values));
		    }
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return records;
	}

	public void resumenLectura() {
		campos=records.get(0);
		StringBuilder builder=new StringBuilder();
		builder.append("Se han leido "+(records.size()-1)+" lineas\nLos campos son: ");
		for (int i=0;campos.size()>i;i++) {
			builder.append(campos.get(i)+", ");
		}
		builder.delete(builder.length()-2, builder.length());
		System.out.println(builder.toString());
	}
	
	public String leerPosicion(int numero) {
		StringBuilder builder=new StringBuilder();
		for(int i=0;i<campos.size();i++) {
			builder.append(campos.get(i)+": "+records.get(5).get(i)+"\n");
		}
		return builder.toString();
	}
	
	
	public List<List<String>> getRecords() {
		return records;
	}

	public void setRecords(List<List<String>> records) {
		this.records = records;
	}
}
