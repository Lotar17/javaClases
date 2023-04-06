package ej5;

public class Administrativo extends Empleado{
	private int hsExtra;
	private int hsMes;
	
	
	public int getHsExtra() {
		return hsExtra;
	}
	public void setHsExtra(int hsExtra) {
		this.hsExtra = hsExtra;
	}
	public int getHsMes() {
		return hsMes;
	}
	public void setHsMes(int hsMes) {
		this.hsMes = hsMes;
	}
	
	Administrativo (String dni, String nombre, String apellido, String email, float sueldoBase, int hsExtra, int hsMes){
		this.setNombre(nombre);
		this.setApellido(apellido);
		this.setEmail(email);
		this.setSueldoBase(sueldoBase);
		this.hsExtra = hsExtra;
		this.hsMes = hsMes;
	}
}
