package ej5a;

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
	
	public String getPuesto() {
		return "VEND";
	}
	
	Vendedor (String dni, String nombre, String apellido, String email, float sueldoBase, int porcenComision, int totalVentas){
		this.setDni(dni);
		this.setNombre(nombre);
		this.setApellido(apellido);
		this.setEmail(email);
		this.setSueldoBase(sueldoBase);
		this.porcenComision = porcenComision;
		this.totalVentas = totalVentas;
	}
	
	@Override
	public float getSueldoBase() {
		return super.getSueldoBase() + (this.getPorcenComision()*this.getTotalVentas()/100);
	}
	
	@Override
	public String getDatos() {
		return this.getPuesto()+ " " + super.getDatos() + " SUELDO TOTAL: $" + this.getSueldoBase();
	}
}
