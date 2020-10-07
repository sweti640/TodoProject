import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class LoginConnection 

{
	static Connection conn;
	Statement st;
	ResultSet rs;
	PreparedStatement pss;
	
	public LoginConnection()
	{
		try
		{
		conn=DataBaseConnection.getConnection();
		System.out.println("COnnection is done");
		st=conn.createStatement();
		}
		catch (Exception e) 
		{
		e.printStackTrace();
		}
	}
	
	public void checkLogin(String mail,String pass)
	{
		try
		{
		rs=st.executeQuery("select*from user ");
		
		while(rs.next())
		{
		//System.out.println(rs.getInt(1)+"\t\t"+rs.getString(2)+"\t\t"+rs.getString(3)+"\t\t"
		//+rs.getString(4)+"\t\t"+rs.getString(5)+"\t\t"+rs.getString(6)+"\t\t"+rs.getString(7));
			if(rs.getString(2).equals(mail) && rs.getString(7).equals(pass))
			{
				//System.out.println(rs.getString(2));
				//System.out.println(rs.getString(7));
				System.out.println("login successfuuly...");
				break;
			}
			else if ("admin@gmail.com".equals(mail) && "admin@123".equals(pass)) {
				
				System.out.println("Admin login successfuuly...");
				break;
				
			}
			else {
				System.out.println("check you mail and id ");
			}
		
		}
		}
		
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
	}

	public static void main(String[] args) 
	{
		LoginConnection  login=new LoginConnection();
		login.checkLogin("sweti@123", "1234");
		

	}

}
