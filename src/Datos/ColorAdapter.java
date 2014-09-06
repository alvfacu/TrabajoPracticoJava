package Datos;

import Entidades.Color;

import java.sql.*;
import java.util.ArrayList;

import Connection.DataConnectionManager;

public class ColorAdapter {

	
	public ArrayList<Color> getColores(){
		
		ArrayList<Color> cls= new ArrayList<Color>();
		
		String sql="SELECT id, nombre_color FROM colores";
		Statement sentencia=null;
		ResultSet rs=null;
		
		
		try 
		{			
			sentencia = DataConnectionManager.getInstancia().getConn().createStatement();
			rs = sentencia.executeQuery(sql);
			
			while(rs.next())
			{
				Color color = new Color(rs.getString("nombre_color"));
				color.setId(rs.getInt("id"));
				
				cls.add(color);
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
				
		return cls;
	}
	
		
	public Color getColorByID(int idColor)
	{
		return this.getColorByID(idColor, true);
	}
	
	public Color getColorByID(int idColor, boolean CloseConnection){
		
		
		String sql="SELECT id, nombre_color FROM colores WHERE id=?"; //evitamos que se filtre información y que haya posibilidad de hackeo
	
		PreparedStatement sentencia = null;
		ResultSet rs = null;
		Color c = null;
		
		try 
		{			
			sentencia = DataConnectionManager.getInstancia().getConn().prepareStatement(sql);
			sentencia.setInt(1, idColor);
			rs = sentencia.executeQuery();
			
			if(rs.next())
			{
				c = new Color(rs.getString("nombre_color"));
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
		
	public Color getColorByNombre(String nombreColor)
	{
		return this.getColorByNombre(nombreColor, true);
	}
	
	
	public Color getColorByNombre(String nombreColor, boolean CloseConnection) 
	{
		String sql="SELECT id, nombre_color FROM colores WHERE nombre_color=?"; //evitamos que se filtre información y que haya posibilidad de hackeo
		
		PreparedStatement sentencia = null;
		ResultSet rs = null;
		Color c = null;
		
		try 
		{			
			sentencia = DataConnectionManager.getInstancia().getConn().prepareStatement(sql);
			sentencia.setString(1, nombreColor);
			rs = sentencia.executeQuery();
			
			if(rs.next())
			{
				c = new Color(rs.getString("nombre_color"));
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
	
	
	public void addColor(Color nuevoColor)
	{		
		String sql = "INSERT INTO colores(nombre_color) values (?)";
		PreparedStatement sentencia = null;
		Connection conn = DataConnectionManager.getInstancia().getConn();
		
		try 
		{
			sentencia = conn.prepareStatement(sql);
			sentencia.setString(1, nuevoColor.getNombre());
			sentencia.execute(); 
			
			/*Preguntar: 
			sentencia = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			sentencia.setString(1, nuevoColor.getNombre());
			int filasAfectadas=sentencia.executeUpdate();
			ResultSet cps= sentencia.getGeneratedKeys();
			if(cps.next())
			{
				int locId=cps.getInt(1);
				nuevaLoc.setId(locId);
			}
			*/
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
	
	public void deleteColorByNombre(String nombreColor)
	{
		String sql = "DELETE FROM colores WHERE nombre_color=?";
		
		PreparedStatement sentencia = null;
		ResultSet rs = null;
		
		try 
		{			
			sentencia = DataConnectionManager.getInstancia().getConn().prepareStatement(sql);
			sentencia.setString(1, nombreColor);
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

	
}
