package p1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class user
 */
public class user extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		
		
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		
		try
		{
		Connection con=loginduo.getConnection();
		PreparedStatement pst=con.prepareStatement("select * from account1 where email=? and password=?");
		pst.setString(1, email);
		pst.setString(2, password);
		ResultSet rs=pst.executeQuery();
		if(rs.next())
		{
		  out.print("WELCOME");
	      RequestDispatcher rd=request.getRequestDispatcher("navigation.html");
	      rd.include(request, response);
		}
		else
		{
			out.print("WRONG USERNAME AND PASSWORD");
			RequestDispatcher rd=request.getRequestDispatcher("index.html");
		  rd.include(request, response);
			
		}
		
		
			 
			}catch(Exception ee)
			{
				ee.printStackTrace();
			}
			
			
			
		}
		

}
