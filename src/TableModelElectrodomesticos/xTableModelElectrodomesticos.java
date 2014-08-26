package TableModelElectrodomesticos;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import Entidades.Electrodomestico;
import Negocio.ElectrodomesticoLogic;

public class xTableModelElectrodomesticos extends AbstractTableModel {

	private static final long serialVersionUID = 1L;
	
	private ArrayList<Electrodomestico> dataSource;
	
	public ArrayList<Electrodomestico> getDataSource() {
		return dataSource;
	}

	public void setDataSource(ArrayList<Electrodomestico> dataSource) {
		this.dataSource = dataSource;
	}
	
	public int getColumnCount() {
		return 8;
	}
	
	public int getRowCount() {
		return dataSource.size();
	}
	
	public xTableModelElectrodomesticos(String min, String max, char letra)
	{
			
		ArrayList<Electrodomestico> electros = new ElectrodomesticoLogic().GetAll();
		ArrayList<Electrodomestico> elecSeleccionados = new ArrayList<Electrodomestico>();
		
		for(int i = 0; i < electros.size(); i++)
		{
			if (!(letra == ' '))
			{
				if((min.isEmpty()) && (max.isEmpty()))
				{
					if(electros.get(i).getConsumo().getLetra() == letra)
					{
						if (electros.get(i) instanceof Entidades.Television)
						{
							elecSeleccionados.add(electros.get(i));
						}
						else if (electros.get(i) instanceof Entidades.Lavarropas)
						{
							elecSeleccionados.add(electros.get(i));
						}
					}
				}
				else if (!(min.isEmpty()) && !(max.isEmpty()))
				{
					if(electros.get(i).getConsumo().getLetra() == letra && (electros.get(i).precioFinal() > Double.parseDouble(min) && (electros.get(i).precioFinal() < Double.parseDouble(max))))
					{
						if (electros.get(i) instanceof Entidades.Television)
						{
							elecSeleccionados.add(electros.get(i));
						}
						else if (electros.get(i) instanceof Entidades.Lavarropas)
						{
							elecSeleccionados.add(electros.get(i));
						}
					}
				}
			}
			else if(!(min.isEmpty()) && !(max.isEmpty()))
			{
				if((electros.get(i).precioFinal() > Double.parseDouble(min)) && (electros.get(i).precioFinal() < Double.parseDouble(max)))
				{
					if (electros.get(i) instanceof Entidades.Television)
					{
						elecSeleccionados.add(electros.get(i));
					}
					else if (electros.get(i) instanceof Entidades.Lavarropas)
					{
						elecSeleccionados.add(electros.get(i));
					}
				}
			}
		}
		
		this.setDataSource(elecSeleccionados);
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Entidades.Electrodomestico b = dataSource.get(rowIndex);
		Object o;
		switch (columnIndex) {
		case 0:
			o=b.getTipo();
			break;
		case 1:
			o=b.precioFinal();
			break;
		case 2:
			o=b.getColor().getNombre();
			break;
		case 3:
			o=b.getPeso();
			break;
		case 4:
			o=b.getConsumo().getLetra();
			break;
		case 5:
			if (b instanceof Entidades.Lavarropas)
			{
				o = ((Entidades.Lavarropas)b).getCarga();
			}
			else
			{
				o = "";
			};
			break;
		case 6:
			if (b instanceof Entidades.Television)
			{
				o = ((Entidades.Television)b).getResolucion();
			}
			else
			{
				o = "";
			};
			break;
		case 7:
			if (b instanceof Entidades.Television)
			{
				o = ((Entidades.Television)b).getTDT();
			}
			else
			{
				o = "";
			};
			break;
		default:
			o=null;
			break;
		}
		return o;
	}
	
	public String getColumnName(int column)
	{
		String nom="";
		switch (column) {
		case 0:
			nom="Descripción";
			break;
		case 1:
			nom="Precio (U$S)";
			break;
		case 2:
			nom="Color";
			break;
		case 3:
			nom="Peso (kg)";
			break;
		case 4:
			nom="Consumo";
			break;
		case 5:
			nom="Carga (kg)";
			break;
		case 6:
			nom="Resol. (in)";
			break;
		case 7:
			nom="TDT";
			break;
		default:
			nom="";
			break;
		}
		return nom;		
	}


}
