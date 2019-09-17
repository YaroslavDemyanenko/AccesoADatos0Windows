package AccesoADatos0Windows;

import java.util.Scanner;

public class LectorStandard {
	
	public String entradaTeclado = null;
		
	public  String LectorStandard(){
		
		//String entradaTeclado = null;
		
		Scanner entradaEscaner = new Scanner (System.in);
		System.out.println("Por favor intriduzca texto");
		
		try {
			
		    entradaTeclado = entradaEscaner.nextLine();
		    System.out.println("Correcto");
			
		} catch (Exception e) {
			System.out.print(e);
		}
		
		entradaEscaner.close();
		
		return entradaTeclado;
	}
	
}
