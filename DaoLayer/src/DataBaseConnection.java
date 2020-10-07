import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
public class DataBaseConnection 
{
	public static final String JDBC_DRIVER="com.mysql.cj.jdbc.Driver";
	public static final String JDBC_URL="jdbc:mysql://localhost:3306/todolist";
	//school,sweti2
	public static final String USERNAME="root";
	public static final String PASSWORD="root";
	static Connection conn=null;
	
	public static Connection getConnection()
	{
		try
		{
			Class.forName(JDBC_DRIVER);
			System.out.println("driver loading...");
			conn=DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
			System.out.println("Connecting.....");
		}
		catch (Exception e) 
		{
			System.out.println(e.getMessage());
		}
		return conn;
		
	}

}
