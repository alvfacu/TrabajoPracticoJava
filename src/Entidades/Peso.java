package Entidades;

public class Peso {
	
	private double tamMax;
	private double tamMin;
	private double precio;
	
	public double getTama�oMax() {
		return tamMax;
	}
	
	public void setTama�oMax(double tama�oMax) {
		this.tamMax = tama�oMax;
	}
	
	public double getTama�oMin() {
		return tamMin;
	}
	
	public void setTama�oMin(double tama�oMin) {
		this.tamMin = tama�oMin;
	}
	
	public double getPrecio() {
		return precio;
	}
	
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	public Peso(double minimo, double mayor, double precio)
	{
		this.tamMin = minimo;
		this.tamMax = mayor;
		this.precio = precio;
	}
}
