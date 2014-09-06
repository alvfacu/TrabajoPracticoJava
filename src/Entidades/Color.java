package Entidades;

public class Color {

	int id;
	String nombre_color;
	
	public String getNombre() {
		return nombre_color;
	}
	
	public void setNombre(String nombre) {
		this.nombre_color = nombre;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public Color(String nombreColor)
	{
		this.nombre_color = nombreColor;
	}	
	
}
