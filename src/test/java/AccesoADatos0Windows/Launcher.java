package AccesoADatos0Windows;

import lectores.LectorCsv;

public class Launcher {

	public static void main(String[] args) {
		LectorCsv lectorPrueba=new LectorCsv();
		lectorPrueba.leerCsv("C:/Users/IN1DM3B_03/Desktop/reto/MOCK_DATA.csv");
		lectorPrueba.resumenLectura();
		System.out.println(lectorPrueba.leerPosicion(5));
	}

}
