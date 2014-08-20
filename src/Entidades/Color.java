package Entidades;

public class Color {

	String nombre_color;
	
	public String getNombre() {
		return nombre_color;
	}
	
	public void setNombre(String nombre) {
		this.nombre_color = nombre;
	}
	
	public Color(String nombreColor)
	{
		this.nombre_color = nombreColor;
	}
	
}
