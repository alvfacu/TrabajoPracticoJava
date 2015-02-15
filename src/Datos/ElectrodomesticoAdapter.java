package Datos;

import java.util.ArrayList;

import Connection.DataConnectionManager;
import Entidades.Color;
import Entidades.ConsumoEnergetico;
import Entidades.Electrodomestico;
import Entidades.Lavarropas;
import Entidades.Television;
import Datos.ColorAdapter;

import java.io.Serializable;
import java.sql.*;

public class ElectrodomesticoAdapter implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ElectrodomesticoAdapter()
	{
	}
		
	public ArrayList<Electrodomestico> getTodosElectrodomesticos()
	{
		ArrayList<Electrodomestico> electros = new ArrayList<Electrodomestico>();
		
		String sql="SELECT id, precio_base, peso, idColor, idConsumo, carga, resolucion, tdt FROM electrodomesticos";
		Statement sentencia = null;
		ResultSet rs = null;
				
		try 
		{			
			sentencia = DataConnectionManager.getInstancia().getConn().createStatement();
			rs = sentencia.executeQuery(sql);
			
			while(rs.next())
			{
				Electrodomestico el;
				
				Color clr = new ColorAdapter().getColorByID(rs.getInt("idColor"),false);
				ConsumoEnergetico consu = new ConsumoAdapter().getConsumoPorID(rs.getInt("idConsumo"),false);
				
				if(rs.getDouble("carga") == 0)
				{					
					el = new Television(rs.getDouble("precio_base"),rs.getDouble("peso"), clr.getNombre(), consu.getLetra(), rs.getDouble("resolucion"), rs.getBoolean("tdt"));
				}
				else
				{
					el = new Lavarropas(rs.getDouble("precio_base"),rs.getDouble("peso"), clr.getNombre(), consu.getLetra(), rs.getDouble("carga"));					
				}
				el.setId(rs.getInt("id"));
				electros.add(el);
				
			}					
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if(rs!=null)
				{
					rs.close();
				}
				if(sentencia!=null && !sentencia.isClosed())
				{
					sentencia.close();
				}
				DataConnectionManager.getInstancia().CloseConn();
			}
			catch (SQLException sqle)
			{
				sqle.printStackTrace();
			}
		}		
		return electros;
	}
	
    public void deleteElectrodomestico(Electrodomestico electro)
    {
    	String sql = "DELETE FROM electrodomesticos WHERE id=?";
		
		PreparedStatement sentencia = null;
		ResultSet rs = null;
		
		try 
		{			
			sentencia = DataConnectionManager.getInstancia().getConn().prepareStatement(sql);
			sentencia.setInt(1, electro.getId());
			sentencia.executeUpdate();					
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if (rs!=null)
				{
					rs.close();
				}
				if (sentencia!=null && !sentencia.isClosed())
				{
					sentencia.close();
				}
				DataConnectionManager.getInstancia().CloseConn();
			}
			catch (SQLException sqle)
			{
				sqle.printStackTrace();
			}
		}
    }
    
    public void addElectrodomestico(Electrodomestico nuevoElectrodomestico)
	{		
		String sql = "INSERT INTO electrodomesticos(precio_base,peso,idColor,idConsumo,carga,resolucion,tdt) values (?,?,?,?,?,?,?)";
		PreparedStatement sentencia = null;
		Connection conn = DataConnectionManager.getInstancia().getConn();
		
		try 
		{
			sentencia = conn.prepareStatement(sql);
			sentencia.setDouble(1, nuevoElectrodomestico.getPrecio());
			sentencia.setDouble(2, nuevoElectrodomestico.getPeso());
			
			Color clr = new ColorAdapter().getColorByNombre(nuevoElectrodomestico.getColor().getNombre(),false);
			ConsumoEnergetico consu = new ConsumoAdapter().getConsumoPorLetra(nuevoElectrodomestico.getConsumo().getLetra(), false);
			
			sentencia.setInt(3,clr.getId());
			sentencia.setInt(4, consu.getId());
			if(nuevoElectrodomestico instanceof Lavarropas)
			{
				sentencia.setDouble(5,((Lavarropas)nuevoElectrodomestico).getCarga());
			}
			else
			{
				sentencia.setObject(5, null);
			}
			if(nuevoElectrodomestico instanceof Television)
			{
				sentencia.setDouble(6,((Television)nuevoElectrodomestico).getResolucion());
				sentencia.setBoolean(7,((Television)nuevoElectrodomestico).getSintonizadorTDT());
			}
			else
			{
				sentencia.setObject(6, null);
				sentencia.setObject(7, null);
			}
			sentencia.execute(); 

		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if(sentencia!=null && !sentencia.isClosed())
				{
					sentencia.close();
				}
				DataConnectionManager.getInstancia().CloseConn();
			}
			catch (SQLException sqle)
			{
				sqle.printStackTrace();
			}			
		}		
	}

	public void deleteElectrodomestico(int id) {
		
		String sql = "DELETE FROM electrodomesticos WHERE id=?";
		
		PreparedStatement sentencia = null;
		ResultSet rs = null;
		
		try 
		{			
			sentencia = DataConnectionManager.getInstancia().getConn().prepareStatement(sql);
			sentencia.setInt(1, id);
			sentencia.executeUpdate();					
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if (rs!=null)
				{
					rs.close();
				}
				if (sentencia!=null && !sentencia.isClosed())
				{
					sentencia.close();
				}
				DataConnectionManager.getInstancia().CloseConn();
			}
			catch (SQLException sqle)
			{
				sqle.printStackTrace();
			}
		}
    }

	public Electrodomestico getElectrodomesticoByID(int id) {
		
		Electrodomestico electroActual = null;
		ArrayList<Electrodomestico> electros = this.getTodosElectrodomesticos();
		for(Electrodomestico el : electros)
		{
			if(el.getId() == id)
			{
				electroActual = el;
			}
		}		
		return electroActual;
	}

}
