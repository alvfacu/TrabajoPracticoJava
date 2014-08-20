package Entidades;

public class Peso {
	
	private double tama�oMax;
	private double tama�oMin;
	private double precio;
	
	public double getTama�oMax() {
		return tama�oMax;
	}
	
	public void setTama�oMax(double tama�oMax) {
		this.tama�oMax = tama�oMax;
	}
	
	public double getTama�oMin() {
		return tama�oMin;
	}
	
	public void setTama�oMin(double tama�oMin) {
		this.tama�oMin = tama�oMin;
	}
	
	public double getPrecio() {
		return precio;
	}
	
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	public Peso(double minimo, double mayor, double precio)
	{
		this.tama�oMin = minimo;
		this.tama�oMax = mayor;
		this.precio = precio;
	}
}
