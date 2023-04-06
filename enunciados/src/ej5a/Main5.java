package ej5a;

import java.util.Scanner;

public class Main5 {

	public static void main(String[] args) {
		
		String res,dni,nombre,apellido,email;
		int a,b,i=0;
		float sueldoBase ;
		Empleado[] emp = new Empleado[20];
		Scanner scan = new Scanner(System.in);
		System.out.print("INGRESE SI DESEA CARGAR UN VENDEDOR (V) O UN ADMINISTRATIVO (A) (0 PARA SALIR)");
		System.out.println();
		res = scan.next();
		while (res.equals("0") == false){
			System.out.print("INGRESE EL DNI DEL EMPLEADO");
			System.out.println();
			dni = scan.next();
			System.out.print("INGRESE EL NOMBRE DEL EMPLEADO");
			System.out.println();
			nombre = scan.next();
			System.out.print("INGRESE EL APELLIDO DEL EMPLEADO");
			System.out.println();
			apellido = scan.next();
			System.out.print("INGRESE EL EMAIL DEL EMPLEADO");
			System.out.println();
			email = scan.next();
			System.out.print("INGRESE EL SUELDO BASE DEL EMPLEADO");
			System.out.println();
			sueldoBase = scan.nextFloat();
			if (res.equalsIgnoreCase("V") == true) {
				System.out.print("INGRESE EL PORCENTAJE DE COMISION DEL VENDEDOR");
				System.out.println();
				a = scan.nextInt();
				System.out.print("INGRESE EL TOTAL DE VENTAS DEL VENDEDOR");
				System.out.println();
				b = scan.nextInt();
				emp[i] = new Vendedor(dni,nombre,apellido,email,sueldoBase,a,b);
				}
			else {
				System.out.print("INGRESE LAS HORAS EXTRAS DEL ADMINISTRATIVO");
				System.out.println();
				a = scan.nextInt();
				System.out.print("INGRESE LAS HORAS MES DEL ADMINISTRATIVO");
				System.out.println();
				b = scan.nextInt();
				emp[i] = new Administrativo(dni,nombre,apellido,email,sueldoBase,a,b);
			}
			i++;
			System.out.println();
			System.out.println();
			System.out.print("INGRESE SI DESEA CARGAR UN VENDEDOR (V) O UN ADMINISTRATIVO (A) (0 PARA SALIR)");
			System.out.println();
			res = scan.next();			
		}
		System.out.println();
		if (emp.length != 0) {
			for(int j=0;j<i;j++) {
				System.out.println(emp[j].getDatos());
			}
		}
		System.out.println();
		System.out.println("FIN DEL PROGRAMA");
		scan.close();
	}

}
