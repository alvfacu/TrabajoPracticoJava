package Entidades;

public class Peso {
	
	private double tamMax;
	private double tamMin;
	private double precio;
	
	public double getTamañoMax() {
		return tamMax;
	}
	
	public void setTamañoMax(double tamañoMax) {
		this.tamMax = tamañoMax;
	}
	
	public double getTamañoMin() {
		return tamMin;
	}
	
	public void setTamañoMin(double tamañoMin) {
		this.tamMin = tamañoMin;
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
