package Entidades;

public class Electrodomestico implements Comparable<Electrodomestico>{
	
	private double precio_base;
	private Color color;
	private double peso;
	private ConsumoEnergetico consumo;
	
	public Electrodomestico()
	{
		this.precio_base = 100;
		this.peso = 5;
		this.color = new Color("Blanco");
		this.consumo = new ConsumoEnergetico('F');
	}
	
	public Electrodomestico(double precio, double peso)
	{
		this.precio_base = precio;
		this.peso = peso;
		this.color = new Color("Blanco");
		this.consumo = new ConsumoEnergetico('F'); 
	}
	
	public Electrodomestico(double precio, double peso, String nombreColor, char letraConsumo)
	{
		this.precio_base = precio;
		this.peso = peso;
		if (this.comprobarConsumoEnergetico(letraConsumo))
		{
			this.consumo = new ConsumoEnergetico(letraConsumo);
		}
		else
		{
			this.consumo = new ConsumoEnergetico('F');
		}
		if (this.comprobarColor(nombreColor))
		{
			nombreColor = transformar(nombreColor);
			this.color = new Color(nombreColor);
		}
		else
		{
			this.color = new Color("Blanco");
		}		
	}
		
	public double getPrecio()
	{
		return precio_base;
	}
	
	public Color getColor()
	{
		return color;
	}
	
	public double getPeso()
	{
		return peso;
	}
	
	public ConsumoEnergetico getConsumo()
	{
		return consumo;
	}
	
	private boolean comprobarConsumoEnergetico(char letra)
	{
		char[] letras = {'A','B','C','D','E','F'};
		letra = Character.toUpperCase(letra);
		boolean estado = false;
		for(int i = 0; i < 6 ; i++)
		{
			if (letras[i] == letra)
			{
				estado = true;
				break;
			}
		}
		if (estado == true)
		{
			return estado;
		}
		else 
		{
			return false;
		}
	}
	
	private boolean comprobarColor(String color)
	{
		String[] colores = {"blanco","negro","rojo","azul","gris"};
		boolean estado = false;
		for(int i = 0; i < 5 ; i++)
		{
			if (color.compareToIgnoreCase(colores[i]) == 0)
			{
				estado = true;
				break;
			}
		}
		if (estado == true)
		{
			return estado;
		}
		else 
		{
			return false;
		}
	}
	
	public double precioFinal()
	{
		double precio_final = 0;
		
		precio_final += this.getPrecio();
		
		if((this.peso > 0) && (this.peso <= 19)) 
		{
			precio_final += 10;
		}
		else if ((this.peso > 19) && (this.peso <= 49))
		{
			precio_final += 50;
		}
		else if ((this.peso > 49) && (this.peso <= 79))
		{
			precio_final += 80;
		}
		else if (this.peso > 79)
		{
			precio_final += 100;
		}
		
		switch((this.consumo).getLetra()) //PREGUNTAR SI ESTO SE PUEDE 
		{
			case('A'): 
			{
				precio_final += 100;
				break;
			}
			case('B'): 
			{
				precio_final += 80;
				break;
			}
			case('C'): 
			{
				precio_final += 60;
				break;
			}
			case('D'): 
			{
				precio_final += 50;
				break;
			}
			case('E'): 
			{
				precio_final += 30;
				break;
			}
			case('F'): 
			{
				precio_final += 10;
				break;
			}
		}
		
		return precio_final; 
	}

	private String transformar(String color)
	{
		char[] caracteres = color.toCharArray();
		
		for (int i = 0; i < color.length(); i++)
		{
			if (i == 0)
			{
				caracteres[i] = Character.toUpperCase(caracteres[i]);
			}
			else
			{
				caracteres[i] = Character.toLowerCase(caracteres[i]);
			}
		}
		
		return new String(caracteres);
	}
	
	public String getTipo()
	{
		return "Electrodomestico";
	}

	@Override
	public int compareTo(Electrodomestico o) 
	{
		int res = this.getTipo().compareTo(o.getTipo());
		if (res == 0)
		{
			res = Double.compare(o.precioFinal(),this.precioFinal());
		}
		return res;

	}
}
