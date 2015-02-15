package Entidades;

public class Lavarropas extends Electrodomestico {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private double carga;
	
	public double getCarga() {
		return carga;
	}
	
	public Lavarropas()
	{
		super();
		this.carga = 5;		
	}
	
	public Lavarropas(double precio, double peso)
	{
		super(precio,peso);
		this.carga = 5;
	}
	
	public Lavarropas(double precio, double peso, String nombreColor, char letraConsumo, double carga)
	{
		super(precio,peso,nombreColor,letraConsumo);
		this.carga = carga;		
	}
	
	public double precioFinal()
	{
		double precio_final = super.precioFinal();
		
		if (this.carga > 30)
		{
			precio_final += 50;
		}
		
		return precio_final;
	}
	
	public String getTipo()
	{
		return "Lavarropas";
	}

}
