package AccesoADatos0Windows;

import java.io.IOException;

import lectores.LectorCsv;
import lectores.LectorTxt;

public class Launcher {

	public static void main(String[] args) {
		
		//YAROS
		LectorCsv lectorPrueba=new LectorCsv();
		lectorPrueba.leerCsv("C:/Users/IN1DM3B_03/Desktop/reto/MOCK_DATA.csv");
		lectorPrueba.resumenLectura();
		System.out.println(lectorPrueba.leerPosicion(5));
		
		//USTA
		LectorTxt ltxt = new LectorTxt(); 
		try {
			ltxt.Comprobacion();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

}
