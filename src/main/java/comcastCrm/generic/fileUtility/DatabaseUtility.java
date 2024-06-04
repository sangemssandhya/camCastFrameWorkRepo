package comcastCrm.generic.fileUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class DatabaseUtility {
	Connection conn;
	public void getDbconnection(String url,String username,String password)
	{
		try {
			Driver driver=new Driver();
			DriverManager.registerDriver(driver);
			 conn=DriverManager.getConnection(url, username, password);
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	public void getDbconnection()
	{
		try {
			Driver driver=new Driver();
			DriverManager.registerDriver(driver);
			 conn=DriverManager.getConnection("jdbc:mysql://106.51.90.215:3333/projects","root@%","root");
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	
	
	public void closeDbconnection() throws SQLException
	{
		try {
			conn.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	public ResultSet executeNonSelectQuery(String query) throws Throwable 
	{
		ResultSet result=null;
		try {
			Statement state=conn.createStatement();
		 result=state.executeQuery(query);
			
			
		} catch (Exception e) {
		
			
		}
		return result;
		
	}
	public int executeNonSelectQueryUpadte(String query) throws SQLException
	
	{
		int result=0;
		try {
			Statement state=conn.createStatement();
			result=state.executeUpdate(query);
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}return result;
	}	
		
		
		
		
		
	

}
