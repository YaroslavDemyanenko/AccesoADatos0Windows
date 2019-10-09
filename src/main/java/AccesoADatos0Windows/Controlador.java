package AccesoADatos0Windows;

import java.util.InputMismatchException;
import java.util.Scanner;
import buscador.Buscador;
import lectores.EditorCsv;
import lectores.LectorTxt;
import lectores.LectorXml;
import objetos.Libro;

public class Controlador {
	private Scanner lector;
	private Buscador buscador;
	private Libro metodo;
	private EditorCsv lectorCsv;
	private LectorTxt lectorTxt;
	private LectorXml lectorXml;

	public Controlador() {
		lector = new Scanner(System.in);
		lectorCsv = new EditorCsv();
		lectorTxt = new LectorTxt();
		lectorXml = new LectorXml();
		buscador = new Buscador();
		metodo = new Libro();
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
					if (num < 0 || num > 3) {
						System.out.println("Introduce un numero entre 0 y 3");
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

	public boolean escribirEleccion(Scanner reader) {
		String respuesta = null;
		reader.nextLine();
		while (true) {
			System.out.println("¿Quieres añadir un libro a este documento? (SI/NO)");
			respuesta=reader.nextLine();
			if (respuesta.toLowerCase().equals("s") || respuesta.toLowerCase().equals("si")) {
				return true;
			} else if (respuesta.toLowerCase().equals("n") || respuesta.toLowerCase().equals("no")) {
				return false;
			} else {
				continue;
			}
		}
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
				lectorTxt.cargarTxt(path,metodo);
				lectorTxt.leerTxt();
				break;
			case 2:
				sufijo = ".csv";
				buscador.verArchivos(null, sufijo);
				while (!validarPath(path)) {
					nombre = elegirArchivo(sufijo, lector);
					path = buscador.buscarArchivo(null, nombre, sufijo);
				}
				lectorCsv.setRegistro(lectorCsv.cargarCsv2(path));
				lectorCsv.leerCsv();
				if(escribirEleccion(lector)) {
					lectorCsv.getRegistro().add(metodo.registrarLibro(lector));
					lectorCsv.escribirCsv();
				}
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
			numero = leerEleccion(lector);
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
