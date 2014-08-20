package Entidades;

public class Peso {
	
	private double tamañoMax;
	private double tamañoMin;
	private double precio;
	
	public double getTamañoMax() {
		return tamañoMax;
	}
	
	public void setTamañoMax(double tamañoMax) {
		this.tamañoMax = tamañoMax;
	}
	
	public double getTamañoMin() {
		return tamañoMin;
	}
	
	public void setTamañoMin(double tamañoMin) {
		this.tamañoMin = tamañoMin;
	}
	
	public double getPrecio() {
		return precio;
	}
	
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	public Peso(double minimo, double mayor, double precio)
	{
		this.tamañoMin = minimo;
		this.tamañoMax = mayor;
		this.precio = precio;
	}
}
