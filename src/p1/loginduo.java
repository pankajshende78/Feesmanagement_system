package p1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;





public class loginduo {
	
	public static Connection getConnection()
	{
		Connection con=null;
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
		    con=DriverManager.getConnection("jdbc:mysql://localhost:3306/pankaj","root","root");
		 
		 
		 
		}catch(Exception ee)
		{
			
			ee.printStackTrace();
			
		}
	return con;
		
	}
	
	public static int save(account a)
	{
		int status=0;
		Connection con=loginduo.getConnection();
		
		try
		{
			PreparedStatement ps=con.prepareStatement("insert into account1(name,email,password,mobile)values(?,?,?,?)");
			ps.setString(1, a.getName());
			ps.setString(2, a.getEmail());
			ps.setString(3, a.getPassword());
			ps.setString(4, a.getMobile());
			
			status=ps.executeUpdate();
			
			con.close();
			
		}
		catch(Exception ee)
		{
		   ee.printStackTrace();	
		}
		
		return status;
		
	}
	public static List<account> view(){
		List<account> list=new ArrayList<account>();
		try{
			Connection con =loginduo.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from account1");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				account bean=new account();
				
				bean.setName(rs.getString("name"));
				bean.setEmail(rs.getString("email"));
				bean.setPassword(rs.getString("password"));
				bean.setMobile(rs.getString("mobile"));
				list.add(bean);
			}
			con.close();
			
		}catch(Exception e){System.out.println(e);}
		
		return list;
	}
	
	
	

}
