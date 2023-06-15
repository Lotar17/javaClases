package ui;



import java.util.Scanner;

import entities.*;
import logic.Login;

public class Menu {
	Scanner s=null;
	Login ctrlLogin = new Login();

	public void start() {
		s = new Scanner(System.in);
		Persona p=login();
		System.out.println("Bienvenido "+p.getNombre()+" "+p.getApellido());
		System.out.println();
		
		String command;
		do {
			command=getCommand();
			executeCommand(command);
			System.out.println();
			
		}while(!command.equalsIgnoreCase("exit"));
		
		s.close();
	}

	private void executeCommand(String command) {
		switch (command) {
		case "list":
			System.out.println(ctrlLogin.getAll());
			break;
		case "find":
			System.out.println(find());
			break;
		case "search":
			System.out.println();
			System.out.println("INGRESE EL APELLIDO DE LA PERSONA:");
			System.out.println(ctrlLogin.getByApellido(s.nextLine()));
			
	
			break;
		case "new":
			System.out.println(newPersona());			
			break;
		case "edit":
			System.out.println(edit());
			
			break;
		case "delete":
			System.out.println(delete());
			
			break;
		default:
			break;
		}
	}

	private String getCommand() {
		System.out.println("Ingrese el comando según la opción que desee realizar");
		System.out.println("list\t\tlistar todos");
		System.out.println("find\t\tbuscar por tipo y nro de documento"); //solo debe devolver 1
		System.out.println("search\t\tlistar por apellido"); //puede devolver varios
		System.out.println("new\t\tcrea una nueva persona y asigna un rol existente");
		System.out.println("edit\t\tbusca por tipo y nro de documento y actualiza todos los datos");
		System.out.println("delete\t\tborra por tipo y nro de documento");
		System.out.println();
		System.out.print("comando: ");
		return s.nextLine();
	}
	
	public Persona login() {
		Persona p=new Persona();
		
		System.out.print("Email: ");
		p.setEmail(s.nextLine());

		System.out.print("password: ");
		p.setPassword(s.nextLine());
		
		p=ctrlLogin.validate(p);
		
		return p;
		
	}
	
	private Persona find() {
		System.out.println();
		Persona p=new Persona();
		Documento d=new Documento();
		p.setDocumento(d);
		System.out.print("Tipo doc: ");
		d.setTipo(s.nextLine());

		System.out.print("Nro doc: ");
		d.setNro(s.nextLine());
		
		return ctrlLogin.getByDocumento(p);
	}
	
	private String newPersona() {
		Persona p = new Persona();
		Documento d = new Documento();
		Rol r = new Rol();
		System.out.println("INGRESE EL TIPO DE DOCUMENTO DE LA PERSONA");
		d.setTipo(s.nextLine());
		System.out.println("INGRESE EL NRO DE DOCUMENTO DE LA PERSONA");
		d.setNro(s.nextLine());
		p.setDocumento(d);
		System.out.println("INGRESE EL NOMBRE DE LA PERSONA:");
		p.setNombre(s.nextLine());
		System.out.println("INGRESE EL APELLIDO DE LA PERSONA");
		p.setApellido(s.nextLine());
		System.out.println("INGRESE EL TELEFONO DE LA PERSONA");
		p.setTel(s.nextLine());
		System.out.println("INGRESE SI LA PERSONA ESTA HABILITADA O NO (si O no):");
		if (s.nextLine().equalsIgnoreCase("si")) {
			p.setHabilitado(true);
		}
		else {
			p.setHabilitado(false);
		}
		System.out.println("INGRESE EL ROL DE LA PERSONA (admin O user)");
		if (s.nextLine().equalsIgnoreCase("admin")) {
			r.setId(1);
			r.setDescripcion("admin");
		}
		else {
			r.setId(2);
			r.setDescripcion("user");
		}
		p.addRol(r);
		System.out.println("INGRESE EL EMAIL DE LA PERSONA");
		p.setEmail(s.nextLine());
		System.out.println("INGRESE LA CONTRASEÑA DE LA PERSONA");
		p.setPassword(s.nextLine());
		ctrlLogin.addPersona(p);
		return "Persona agregada con exito";
	}
	
	private String edit() {
		Persona p = new Persona();
		Documento d = new Documento();
		Rol r = new Rol();
		System.out.println("INGRESE EL TIPO DE DOCUMENTO DE LA PERSONA");
		d.setTipo(s.nextLine());
		System.out.println("INGRESE EL NRO DE DOCUMENTO DE LA PERSONA");
		d.setNro(s.nextLine());
		p.setDocumento(d);
		p = ctrlLogin.getByDocumento(p);
		System.out.println("INGRESE EL NOMBRE DE LA PERSONA:");
		p.setNombre(s.nextLine());
		System.out.println("INGRESE EL APELLIDO DE LA PERSONA");
		p.setApellido(s.nextLine());
		System.out.println("INGRESE EL TELEFONO DE LA PERSONA");
		p.setTel(s.nextLine());
		System.out.println("INGRESE SI LA PERSONA ESTA HABILITADA O NO (si O no):");
		if (s.nextLine().equalsIgnoreCase("si")) {
			p.setHabilitado(true);
		}
		else {
			p.setHabilitado(false);
		}
		System.out.println("INGRESE EL ROL DE LA PERSONA (admin O user)");
		if (s.nextLine().equalsIgnoreCase("admin")) {
			r.setId(1);
			r.setDescripcion("admin");
		}
		else {
			r.setId(2);
			r.setDescripcion("user");
		}
		p.addRol(r);
		System.out.println("INGRESE EL EMAIL DE LA PERSONA");
		p.setEmail(s.nextLine());
		System.out.println("INGRESE LA CONTRASEÑA DE LA PERSONA");
		p.setPassword(s.nextLine());
		ctrlLogin.updatePersona(p);
		return "PERSONA EDITADA CON EXITO";
		
		
	}
	
	private String delete() {
		Persona p = new Persona();
		Documento d = new Documento();
		System.out.println("INGRESE EL TIPO DE DOCUMENTO DE LA PERSONA");
		d.setTipo(s.nextLine());
		System.out.println("INGRESE EL NRO DE DOCUMENTO DE LA PERSONA");
		d.setNro(s.nextLine());
		p.setDocumento(d);
		ctrlLogin.deleteByDocumento(p);
		return "Persona borrada con exito";
		
	}
	
	


}