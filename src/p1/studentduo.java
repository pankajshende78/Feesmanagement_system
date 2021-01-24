package p1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class studentduo {
	
	
		
		
		public static int save(account a)
		{
			int status=0;
			Connection con=loginduo.getConnection();
			
			try
			{
				PreparedStatement ps=con.prepareStatement("insert into account2(name,email,Course,fee,paid,due)values(?,?,?,?,?,?)");
				ps.setString(1, a.getName());
				ps.setString(2, a.getEmail());
				ps.setString(3, a.getCourse());
				ps.setString(4, a.getFee());
				ps.setString(5, a.getPaid());
				ps.setString(6, a.getDue());
				
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
				PreparedStatement ps=con.prepareStatement("select * from account2");
				ResultSet rs=ps.executeQuery();
				while(rs.next()){
					account bean=new account();
					
					bean.setName(rs.getString("name"));
					bean.setEmail(rs.getString("email"));
				    bean.setCourse(rs.getString("Course"));
				    bean.setFee(rs.getString("fee"));
				    bean.setPaid(rs.getString("paid"));
				    bean.setDue(rs.getString("due"));
					list.add(bean);
				}
				con.close();
				
			}catch(Exception e){System.out.println(e);}
			
			return list;
		}
		
		
		public static List<account> due(){
			List<account> list=new ArrayList<account>();
			try{
				Connection con =loginduo.getConnection();
				PreparedStatement ps=con.prepareStatement("select * from account2 where due>0");
				ResultSet rs=ps.executeQuery();
				while(rs.next()){
					account bean=new account();
					
					bean.setName(rs.getString("name"));
					bean.setEmail(rs.getString("email"));
				    bean.setCourse(rs.getString("Course"));
				    bean.setFee(rs.getString("fee"));
				    bean.setPaid(rs.getString("paid"));
				    bean.setDue(rs.getString("due"));
					list.add(bean);
				}
				con.close();
				
			}catch(Exception e){System.out.println(e);}
			
			return list;
		}
		
		

}
