package Entidades;

public class ConsumoEnergetico {
	
	private int id;
	private char letra;
	private double precio;
	
	public char getLetra() {
		return letra;
	}
	
	public void setLetra(char letra) {
		this.letra = letra;
	}
	
	public double getPrecio() {
		return precio;
	}
	
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	public ConsumoEnergetico(char letra, double precio)
	{
		this.letra = letra;
		this.precio = precio;
	}
	
	public ConsumoEnergetico(char letra)
	{
		this.letra = letra;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}
