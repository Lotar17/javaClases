package ej5;

public abstract class Empleado {
	private String dni;
	private String nombre;
	private String apellido;
	private String email;
	private float sueldoBase;
	
	
	
	
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	public abstract float getSueldoBase() {
		return sueldoBase;
	}
	public void setSueldoBase(float sueldoBase) {
		this.sueldoBase = sueldoBase;
	}
	
	 // EL METODO getDatos() ESTA DE MAS, DEVOLVER CADA VALOR DE A UNO A LA VEZ
	
	public   String getDatos() {
		return getDni() + " " + getNombre() + " " + getApellido(); 
	}
	
	
}
