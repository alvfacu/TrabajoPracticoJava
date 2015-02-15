package Entidades;

public class Television extends Electrodomestico {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private double resolucion;
	private boolean sintonizador_TDT;
	
	public double getResolucion() 
	{
		return resolucion;
	}
	
	public boolean isSintonizador_TDT() 
	{
		return sintonizador_TDT;
	}
	
	public Television()
	{
		super();
		this.resolucion = 20 ;
		this.sintonizador_TDT = false;
	}
	
	public Television(double precio, double peso)
	{
		super(precio,peso);
		this.resolucion = 20 ;
		this.sintonizador_TDT = false;
	}
	
	public Television(double precio, double peso, String nombreColor, char letraConsumo, double resol, boolean sinto)
	{
		super(precio,peso,nombreColor,letraConsumo);
		this.resolucion = resol ;
		this.sintonizador_TDT = sinto;		
	}
	
	public double precioFinal()
	{
		double precio_final = super.precioFinal();
		
		if (this.resolucion > 40)
		{
			precio_final += precio_final * 0.3;
		}
		if (this.sintonizador_TDT)
		{
			precio_final += 50;
		}
		
		return precio_final;
	}
	
	public String getTipo()
	{
		return "Television";
	}
	
	public String getTDT()
	{
		if (this.sintonizador_TDT)
		{
			return "Si";
		}
		else
		{
			return "No";
		}
	}
	
	public boolean getSintonizadorTDT()
	{
		return sintonizador_TDT;
	}

}
