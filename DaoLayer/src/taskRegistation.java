import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class taskRegistation 
{
	static Connection conn;
	Statement st;
	ResultSet rs;
	PreparedStatement pss;
	Scanner keybord=new Scanner(System.in);
	
	public taskRegistation ()
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
	
	public void enterTask()
	{
		System.out.println("enter the Task Name");
		String task=keybord.nextLine();
		System.out.println();
		
		System.out.println("enter the Task Description");
		String des=keybord.nextLine();
		System.out.println();
		
		Date dt = new Date();  
	    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");  
	    String strDate= formatter.format(dt);
	    System.out.println("enter the user_id");
		int id=keybord.nextInt();
		
		
		int n=0;
		try
		{
		
		
		st.executeUpdate("insert into task(task_name,description,date,statu,user_id) values('"+task+"','"+des+"','"+strDate+"','panding'"+id+")");
		
		}
		
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		System.out.println("Record insert successfully...");
		//return n;
	}

	public int UpdateRecord(String t_name,String des,int t_id) throws SQLException
	{
		pss=conn.prepareStatement("update task set task_name=?,description=? where task_id=?");
		
		pss.setString(1, t_name);
		pss.setString(2, des);
		pss.setInt(3, t_id);
		
		
		int n=pss.executeUpdate();
		System.out.println("number of row updated"+n);
		return n;
	}
	
	
	public int DeleteRecord(int did) throws SQLException
	{
		pss=conn.prepareStatement("delete from task  where task_id=?");
		
		pss.setInt(1, did);
		int n=pss.executeUpdate();
		System.out.println("the record deleted successfully.......");
		
		return n;
		
	}
	public void UpdateTaskStatu(int t_id) throws SQLException
	{
		
		rs=st.executeQuery("select *from user");
		rs=st.executeQuery("select statu from task where task_id="+t_id);
		rs.next();
		System.out.println(rs.getString("statu"));
		
		int u_statu=0;
		
			if(rs.getString("statu").equalsIgnoreCase("pending"))
			{
				u_statu=st.executeUpdate("update task set statu='Completed' where task_id="+t_id);
				System.out.println("statu change from pending to completed..... ");
				
			}
			else
			{
				u_statu=st.executeUpdate("update task set statu='pending' where task_id="+t_id);
				System.out.println("statu is still pending you have to finished it first..... ");
			
			}
		
	}
	
	
	
	

	public static void main(String[] args) throws SQLException 
	{
		taskRegistation  task=new taskRegistation();
//		task.enterTask();
//		task.DeleteRecord(3);
//		
//		task.UpdateRecord("sleeping","Good night.....",2);
		task.UpdateTaskStatu(1);
		
	}

}
