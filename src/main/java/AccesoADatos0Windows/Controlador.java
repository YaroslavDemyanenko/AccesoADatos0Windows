package AccesoADatos0Windows;

import java.util.InputMismatchException;
import java.util.Scanner;

import escritores.EscritorXml;
import lectores.LectorTxt;

public class Controlador {
	private Scanner lector;
	private LectorTxt lectorTxt;
	private EscritorXml escritorXml;

	public Controlador() {
		lector = new Scanner(System.in);
		lectorTxt = new LectorTxt();
		escritorXml = new EscritorXml();
		menu();
	}

	public void menu() {
		System.out.println(menuString());
		ejecutar(leerEleccion(lector));
	}

	public String menuString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Formatear datos\n");
		builder.append("Selecciona una opcion\n");
		builder.append("1. Cargar archivo de datos\n");
		builder.append("2. Crear xml con datos cargados\n");
		builder.append("0. Salir\n");
		return builder.toString();
	}

	public int leerEleccion(Scanner reader) {
		int num = 0;
		while (true) {
			try {
				while (true) {
					num = reader.nextInt();
					if (num < 0 || num > 2) {
						System.out.println("Introduce un numero entre 0 y 2");
						continue;
					} else
						break;
				}
				break;
			} catch (InputMismatchException e) {
				System.out.println("Opcion invalida, introduce el numero otra vez");
				reader.nextLine();
				continue;
			}
		}
		return num;
	}

	public boolean ejecutar(int numero) {
		
		while (true) {
			switch (numero) {
			case 0:
				System.exit(0);
				break;
			case 1:
				
				break;
			case 2:
				
				break;
			}
			numero = leerEleccion(lector);
		}
	}
}
