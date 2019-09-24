package AccesoADatos0Windows;

import java.util.InputMismatchException;
import java.util.Scanner;

import buscador.Buscador;
import lectores.LectorCsv;
import lectores.LectorTxt;
import lectores.LectorXml;

public class Controlador {
	private Scanner lector;
	private Buscador buscador;
	private LectorCsv lectorCsv;
	private LectorTxt lectorTxt;
	private LectorXml lectorXml;

	public Controlador() {
		lector = new Scanner(System.in);
		lectorCsv = new LectorCsv();
		lectorTxt = new LectorTxt();
		lectorXml = new LectorXml();
		buscador = new Buscador();

		menu();
	}

	public void menu() {
		System.out.println(menuString());
		ejecutar(leerEleccion(lector));
	}

	public String menuString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Lector de datos - Sprint 1\n");
		builder.append("Selecciona una opcion\n");
		builder.append("1. Leer TXT\n");
		builder.append("2. Leer CSV\n");
		builder.append("3. Leer XML\n");
		builder.append("0. Salir\n");
		return builder.toString();
	}

	public int leerEleccion(Scanner reader) {
		int num = 0;
		while (true) {
			try {
				while (true) {
					num = reader.nextInt();
					if (num < 0 && num > 3) {
						System.out.println("Introduce un numero entre 0 y 3");
						continue;
					} else
						break;
				}
				break;
			} catch (InputMismatchException e) {
				System.out.println("Opcion invalida, introduce el numero otra vez");
				continue;
			}
		}
		return num;
	}

	public boolean ejecutar(int numero) {
		String path = null;
		String sufijo;
		String nombre;
		while (true) {
			switch (numero) {
			case 0:
				System.exit(0);
				break;
			case 1:
				sufijo = ".txt";
				buscador.verArchivos(null, sufijo);
				while (!validarPath(path)) {
					nombre = elegirArchivo(sufijo, lector);
					path = buscador.buscarArchivo(null, nombre, sufijo);
				}
				lectorTxt.leer(path);
				break;
			case 2:
				sufijo = ".csv";
				buscador.verArchivos(null, sufijo);
				while (!validarPath(path)) {
					nombre = elegirArchivo(sufijo, lector);
					path = buscador.buscarArchivo(null, nombre, sufijo);
				}
				lectorCsv.setRegistro(lectorCsv.cargarCsv(path));
				lectorCsv.leerCsv();
				break;
			case 3:
				sufijo = ".xml";
				buscador.verArchivos(null, sufijo);
				while (!validarPath(path)) {
					nombre = elegirArchivo(sufijo, lector);
					path = buscador.buscarArchivo(null, nombre, sufijo);
				}
				lectorXml.leerXml(path);
				break;
			}
			numero=leerEleccion(lector);
		}
	}

	public boolean validarPath(String path) {
		if (path == null) {
			return false;
		} else
			return true;
	}

	public String elegirArchivo(String sufijo, Scanner reader) {
		System.out.println("Introduce el nombre del archivo que quieres leer");
		String nombre = reader.next();
		return nombre;
	}

}
