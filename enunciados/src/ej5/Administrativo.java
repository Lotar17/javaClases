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
	
	public String getPuesto() {
		return "ADMIN";
	}
	
	Administrativo (String dni, String nombre, String apellido, String email, float sueldoBase, int hsExtra, int hsMes){
		this.setDni(dni);
		this.setNombre(nombre);
		this.setApellido(apellido);
		this.setEmail(email);
		this.setSueldoBase(sueldoBase);
		this.hsExtra = hsExtra;
		this.hsMes = hsMes;
	}
	
	@Override
	public float getSueldoBase(){
		return (float) (super.getSueldoBase() * ((this.hsExtra * 1.5) + this.hsMes) / this.hsMes);
	} 
	
	 // EL METODO getDatos() ESTA DE MAS, DEVOLVER CADA VALOR DE A UNO A LA VEZ
	
	@Override     
	public String getDatos() {
		return this.getPuesto()+ " " + super.getDatos() + " SUELDO TOTAL: $" + this.getSueldoBase();
	}
}
