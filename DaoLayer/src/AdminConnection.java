import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;


public class AdminConnection 
{
	static Connection conn;
	Statement st;
	ResultSet rs;
	PreparedStatement pss;
	
	public AdminConnection ()
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
	public void showUserRecord() throws SQLException
	{
		rs=st.executeQuery("select *from user");
		System.out.println("..................................................................................................................................................");
		System.out.println("user_id"+"\t\t"+"Email"+"\t\t\t"+"first_name"+"\t\t"+"last_name"+"\t\t"+"Gender"+"\t\t"+"Birthday"+"\t\t"+"Password"+"\t\t"+"Date"+"\t\t"+"Statu");
		System.out.println("...................................................................................................................................................");
		while(rs.next())
		{
			int id=rs.getInt(1);
			String email=rs.getString(2);
			String fname=rs.getString(3);
			String lname=rs.getString(4);
			String gender=rs.getString(5);
			String bday=rs.getString(6);
			String pass=rs.getString(7);
			String date=rs.getString(8);
			
			String statu=rs.getString(9);
			
			//Date date=rs.getDate(7);
			//String date=rs.getString(7);
			
			System.out.println(id+"\t||"+email+"\t||\t\t"+fname+"\t||\t\t"+lname+"\t||\t"+gender+"\t||\t"+bday+"\t||\t"+pass+"\t||\t"+date+"\t||\t"+statu);
			
		}
		
	}
	public void UpdateStatu(int t_id) throws SQLException
	{
		
		rs=st.executeQuery("select *from user");
		rs=st.executeQuery("select statu from user where id="+t_id);
		rs.next();
		//System.out.println(rs.getString("statu"));
		int u_statu=0;
		
			if(rs.getString("statu").equalsIgnoreCase("Activated"))
			{
				u_statu=st.executeUpdate("update user set statu='Deactivate' where id="+t_id);
				System.out.println("Admin deActivat..... ");
				
			}
			else
			{
				u_statu=st.executeUpdate("update user set statu='Activated' where id="+t_id);
				System.out.println("user is allready deActivat..... ");
			
			}
		
	}


	public static void main(String[] args) throws SQLException 
	{
		AdminConnection  admin=new AdminConnection();
		admin.showUserRecord();
		admin.UpdateStatu(1);
		System.out.println("with updatation....");
		admin.showUserRecord();
		
		//admin.showUserRecord();
		// TODO Auto-generated method stub

	}

}
