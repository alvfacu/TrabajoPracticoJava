package Entidades;

public class ConsumoEnergetico {
	
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
	
	public void setPrecio(float precio) {
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
	
}
