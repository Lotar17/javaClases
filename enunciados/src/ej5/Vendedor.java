package ej5;

public class Vendedor extends Empleado {
	private int porcenComision;
	private int totalVentas;
	
	
	public int getPorcenComision() {
		return porcenComision;
	}
	public void setPorcenComision(int porcenComision) {
		this.porcenComision = porcenComision;
	}
	public int getTotalVentas() {
		return totalVentas;
	}
	public void setTotalVentas(int totalVentas) {
		this.totalVentas = totalVentas;
	}
	
	Vendedor (String dni, String nombre, String apellido, String email, float sueldoBase, int porcenComision, int totalVentas){
		this.setNombre(nombre);
		this.setApellido(apellido);
		this.setEmail(email);
		this.setSueldoBase(sueldoBase);
		this.porcenComision = porcenComision;
		this.totalVentas = totalVentas;
	}
}
