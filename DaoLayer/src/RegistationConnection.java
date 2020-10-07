import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.Date;



public class RegistationConnection 
{
	static Connection conn;
	Statement st;
	ResultSet rs;
	PreparedStatement pss;
	Scanner keybord=new Scanner(System.in);
	public RegistationConnection ()
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
	public void userRegister()
	{
		/*System.out.println("enter the User_id");
		int id=keybord.nextInt();
		keybord.nextLine();*/
		
		//System.out.println();
		System.out.println("enter the Email");
		String email=keybord.nextLine();
		System.out.println();
		System.out.println("enter the Frist_name");
		String f_name=keybord.nextLine();
		System.out.println();
		System.out.println("enter the Last_name");
		String l_name=keybord.nextLine();
		System.out.println();
		System.out.println("enter the Gender");
		String gen=keybord.nextLine();
		System.out.println();
		System.out.println("enter the DateOfBirth");
		String date=keybord.nextLine();
		System.out.println();
		System.out.println("enter the Password");
		String pass=keybord.nextLine();
		//System.out.println();
		  
		 
		  
		  Date dt = new Date();  
		    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");  
		    String strDate= formatter.format(dt);
		
		 
		
			//st.executeUpdate("insert into user(TaskName,description,status) values('"+task+"','"+desc+"','"+status+"')");

		int n=0;
		
		try
		{
			st.executeUpdate("insert into user(email,f_name,l_name,gender,birthdate,password,date,statu) values('"+email+"','"+f_name+"','"+l_name+"','"+gen+"','"+date+"','"+pass+"','"+strDate+"','Activated')");
					
		/*pss=conn.prepareStatement("insert into user values(?,?,?,?,?,?)");
		//pss.setInt(1, id);
		pss.setString(2, email);
		pss.setString(3,f_name);
		pss.setString(4,l_name);
		pss.setString(5, gen);
		pss.setString(6,date);
		pss.setString(7, pass);
		n=pss.executeUpdate();*/
		
		}
		
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		System.out.println("Record insert successfully...");
		//return n;
		
		
		
	}

	
		
	public static void main(String[] args) 
	{
		RegistationConnection  regis=new RegistationConnection();
		regis.userRegister();
		

	}

}
