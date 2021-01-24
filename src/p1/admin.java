package p1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class admin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		
		
		if(name.equals("admin") && password.equals("admin"))
		{
			RequestDispatcher rd=request.getRequestDispatcher("navigationadmin.html");
			rd.include(request, response);
		}
		else
		{
			out.print("WRONG USERNAME AND PASSWORD");
            RequestDispatcher rd=request.getRequestDispatcher("index.html");
			rd.include(request, response);
		}
		
		
		
		
	}

}
