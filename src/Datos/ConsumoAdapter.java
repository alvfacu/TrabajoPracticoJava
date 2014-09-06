package Datos;

import java.sql.*;
import java.util.ArrayList;
import Entidades.ConsumoEnergetico;

import Connection.DataConnectionManager;

public class ConsumoAdapter {

	public ArrayList<ConsumoEnergetico> getConsumos(){
		
		ArrayList<ConsumoEnergetico> consus = new ArrayList<ConsumoEnergetico>();
		
		String sql="SELECT id, letra, precio FROM consumos_energeticos";
		Statement sentencia=null;
		ResultSet rs=null;
				
		try 
		{			
			sentencia = DataConnectionManager.getInstancia().getConn().createStatement();
			rs = sentencia.executeQuery(sql);
			
			while(rs.next())
			{
				ConsumoEnergetico con = new ConsumoEnergetico(rs.getString("letra").charAt(0),rs.getDouble("precio"));
				con.setId(rs.getInt("id"));
				consus.add(con);
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
				
		return consus;
	}
	
	public ConsumoEnergetico getConsumoPorLetra(char letra)
	{
		return this.getConsumoPorLetra(letra, true);
	}
	
	public ConsumoEnergetico getConsumoPorLetra(char letra, boolean CloseConnection){
		
		
		String sql="SELECT id, letra, precio FROM consumos_energeticos WHERE letra=?"; //evitamos que se filtre información y que haya posibilidad de hackeo
	
		PreparedStatement sentencia = null;
		ResultSet rs = null;
		ConsumoEnergetico c = null;
		
		try 
		{			
			sentencia = DataConnectionManager.getInstancia().getConn().prepareStatement(sql);
			sentencia.setString(1,String.valueOf(letra));
			rs = sentencia.executeQuery();
			
			if(rs.next())
			{
				c = new ConsumoEnergetico(rs.getString("letra").charAt(0),rs.getDouble("precio"));
				c.setId(rs.getInt("id"));				
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
				if (rs!=null)
				{
					rs.close();
				}
				if (sentencia!=null && !sentencia.isClosed())
				{
					sentencia.close();
				}
				if(CloseConnection){
					DataConnectionManager.getInstancia().CloseConn();
				}
			}
			catch (SQLException sqle)
			{
				sqle.printStackTrace();
			}
		}
				
		return c;
	}

	public ConsumoEnergetico getConsumoPorID(int idConsumo)
	{
		return this.getConsumoPorID(idConsumo, true);
	}
	
	public ConsumoEnergetico getConsumoPorID(int idConsumo, Boolean CloseConnection)
	{
		String sql="SELECT id, letra, precio FROM consumos_energeticos WHERE id=?"; //evitamos que se filtre información y que haya posibilidad de hackeo
	
		PreparedStatement sentencia = null;
		ResultSet rs = null;
		ConsumoEnergetico c = null;
		
		try 
		{			
			sentencia = DataConnectionManager.getInstancia().getConn().prepareStatement(sql);
			sentencia.setInt(1, idConsumo);
			rs = sentencia.executeQuery();
			
			if(rs.next())
			{
				c = new ConsumoEnergetico(rs.getString("letra").charAt(0),rs.getDouble("precio"));
				c.setId(rs.getInt("id"));			
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
				if (rs!=null)
				{
					rs.close();
				}
				if (sentencia!=null && !sentencia.isClosed())
				{
					sentencia.close();
				}
				if(CloseConnection){
					DataConnectionManager.getInstancia().CloseConn();
				}
			}
			catch (SQLException sqle)
			{
				sqle.printStackTrace();
			}
		}
				
		return c;
	}
	
	
	public Character[] getLetras()
	{
		ArrayList<Character> letrasConsumo = new ArrayList<Character>();
		
		letrasConsumo.add(' ');
				
		String sql="SELECT id, letra, precio FROM consumos_energeticos";
		Statement sentencia=null;
		ResultSet rs=null;
				
		try 
		{			
			sentencia = DataConnectionManager.getInstancia().getConn().createStatement();
			rs = sentencia.executeQuery(sql);
			
			while(rs.next())
			{
				letrasConsumo.add(rs.getString("letra").charAt(0));
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
		
		Character[] letras = letrasConsumo.toArray(new Character[letrasConsumo.size()]);		
		
		return letras;
	}
	
//	public void addColor(Color nuevoColor)
//	{		
//		String sql = "INSERT INTO colores(nombre_color) values (?)";
//		PreparedStatement sentencia = null;
//		Connection conn = DataConnectionManager.getInstancia().getConn();
//		
//		try 
//		{
//			sentencia = conn.prepareStatement(sql);
//			sentencia.setString(1, nuevoColor.getNombre());
//			sentencia.execute(); 
//			
//			/*Preguntar: 
//			sentencia = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
//			sentencia.setString(1, nuevoColor.getNombre());
//			int filasAfectadas=sentencia.executeUpdate();
//			ResultSet cps= sentencia.getGeneratedKeys();
//			if(cps.next())
//			{
//				int locId=cps.getInt(1);
//				nuevaLoc.setId(locId);
//			}
//			*/
//		} 
//		catch (SQLException e) 
//		{
//			e.printStackTrace();
//		}
//		finally
//		{
//			try
//			{
//				if(sentencia!=null && !sentencia.isClosed())
//				{
//					sentencia.close();
//				}
//				DataConnectionManager.getInstancia().CloseConn();
//			}
//			catch (SQLException sqle)
//			{
//				sqle.printStackTrace();
//			}			
//		}		
//	}

}
