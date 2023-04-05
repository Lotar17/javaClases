package ej1;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		/* INICIO EJERCICIO 1 
		for (int i=1;i<=10;i++) {
			System.out.print(i);
			System.out.print(" , ");
		}
		System.out.println();
		for (int i=1;i<=19;i=i+2) {
			System.out.print(i);
			System.out.print(" , ");
		}
		
		FIN EJERCICIO 1 */
		
		// ################################################## 
		
		/* INICIO EJERCICIO 2
		String[] palabras = new String[10];
		Scanner scanner = new Scanner(System.in);
		for(int i=0;i<10;i++) {
			System.out.print("Ingrese la siguiente palabra:");
			System.out.println();
			palabras[i] = scanner.next();
			System.out.println();
		}
		System.out.println();
		for(int i=9;i>=0;i--) {
			System.out.print(palabras[i]);
			System.out.println();
		}
		scanner.close();
		
		FIN EJERCICIO 2 */
		
		// #########################################################
		
		Scanner scanner = new Scanner(System.in);
		String[] palabras = new String[10];
		String palabra = new String();
		int encontro = 0;
		for (int i =0;i<10;i++) {
			System.out.print("ESCRIBA UNA PALABRA:\n");
			palabras[i] = scanner.next();		
		}
		System.out.println();
		System.out.print("INGRESE UNA PALABRA");
		System.out.println();
		palabra = scanner.next();
		System.out.println();
		for(int i =0;i<10;i++) {
			if (palabras[i].equals(palabra) == true){
				encontro = 1;
			}
		}
		if (encontro == 1) {
			System.out.print("LA PALABRA INGRESADA SE ENCUENTRA EN LA LISTA DE 10 PALABRAS");
		}
		else {
			System.out.print("LA PALABRA INGRESADA NO SE ENCUENTRA EN LA LISTA DE 10 PALABRAS");
		}
		scanner.close();
	}

}
