package Entidades;

import Datos.ElectrodomesticoAdapter;

public class MostrarContenido {

	public static void main(String[] args) {
	
//		ArrayList<Color> colores = new ArrayList<Color>();
//		colores = new ColorAdapter().getColores();
//		
// 		ColorAdapter catColor = new ColorAdapter();	
//		
//		for(Color cl : colores)
//		{
//			System.out.println(cl.id+"\t\t"+cl.nombre_color);
//		}
//		
//		Color clr = nuevoColor();
//		catColor.addColor(clr);
//		
//		for(Color cl : colores)
//		{
//			System.out.println(cl.id+"\t\t"+cl.nombre_color);
//		}		
//		
//		//Eliminado
//		catColor.deleteColorByNombre("Violeta");
//		
//		for(Color cl : new ColorAdapter().getColores())
//		{
//			System.out.println(cl.id+"\t\t"+cl.nombre_color);
//		}		
//		
//		Color cl = new ColorAdapter().getColorByNombre("Gris");
//		
//		if (cl!=null)
//		{
//			System.out.println(cl.getNombre());
//		}
//		else
//		{
//			System.out.println("Color no existe");
//		}
//		
//		cl = new ColorAdapter().getColorByNombre("Celeste");
//		
//		if (cl!=null)
//		{
//			System.out.println(cl.getNombre());
//		}
//		else
//		{
//			System.out.println("Color no existe");
//		}
//		
//		Color clr = nuevoColor();
//		System.out.println("id: "+Integer.toString(clr.getId()));
//		catColor.addColor(clr);
//		System.out.println("id: "+Integer.toString(clr.getId()));
//		
//		colores = new ColorAdapter().getColores();
//		
//		for(Color c : colores)
//		{
//			System.out.println(c.id+"\t\t"+c.nombre_color);
//		}
		
//		for(ConsumoEnergetico ce : new ConsumoAdapter().getConsumos())
//		{
//			System.out.println(ce.getId()+"\t\t"+ce.getLetra()+"\t\t"+ce.getPrecio());
//		}
//		
//		ConsumoEnergetico ce = new ConsumoAdapter().getConsumoPorLetra('d');
//		
//		if (ce!=null)
//		{
//			System.out.println(ce.getPrecio());
//		}
//		else
//		{
//			System.out.println("Letra no existe");
//		}
//		
//		ce = new ConsumoAdapter().getConsumoPorLetra('n');
//		
//		if (ce!=null)
//		{
//			System.out.println(ce.getPrecio());
//		}
//		else
//		{
//			System.out.println("Letra no existe");
//		}
		
		System.out.println("ID\tPESO\tPRECIO\tLETRA\tCOLOR\tCARGA\tRESOLUCION\tTDT");
		
		for(Electrodomestico el : new ElectrodomesticoAdapter().getTodosElectrodomesticos()) 
		{
			String carga;
			String resolucion;
			String tdt;
			
			if(el instanceof Television)
			{
				carga = "";
				resolucion = String.valueOf(((Television)el).getResolucion());
				tdt = ((Television)el).getTDT();
			}
			else
			{
				carga = String.valueOf(((Lavarropas)el).getCarga());
				resolucion = "";
				tdt = "";
			}
			
			System.out.println(el.getId()+"\t"+el.getPeso()+"\t"+el.getPrecio()+"\t"+el.getConsumo().getLetra()+"\t"+el.getColor().getNombre()+"\t"+carga+"\t"+resolucion+"\t\t"+tdt);
		}
		
		
	}
	
//	private static Color nuevoColor()
//	{
//		Color c = new Color();
//		c.setNombre("Violeta");
//		return c;
//	}
}
