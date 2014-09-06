package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataConnectionManager {

	private static DataConnectionManager instancia;
	
	public static DataConnectionManager getInstancia(){ //Metodo para obtener la única instancia
		if(instancia==null){
			instancia=new DataConnectionManager();
		}
		return instancia;
	}
	
	private static String dbUrl="jdbc:mysql://localhost:3306/tp_java";
	private static String dbUser="java";
	private static String dbPassword="java123";
		
	private DataConnectionManager(){}
	
	private Connection conn;
	
	public Connection getConn(){
		try {
			if(conn==null || !conn.isValid(3)){
				Class.forName("com.mysql.jdbc.Driver").newInstance();
				conn=DriverManager.getConnection(dbUrl,dbUser,dbPassword);	
			}
			
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return conn;
	}
	
	public void CloseConn(){
		try {
			if(conn!=null && !conn.isClosed()){
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
