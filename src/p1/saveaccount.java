package p1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class saveaccount
 */
public class saveaccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		String mobile=request.getParameter("mobile");
		
		account a=new account();
		a.setName(name);
		a.setEmail(email);
		a.setPassword(password);
		a.setMobile(mobile);
		
		int status=loginduo.save(a);
		
		if(status>0)
		{
			
			out.print("SUCCESFULLY ADD");
			RequestDispatcher rd=request.getRequestDispatcher("add.html");
			rd.include(request, response);
		}
		else
		{
			
			out.print(" FAIL INSERT");
			RequestDispatcher rd=request.getRequestDispatcher("add.html");
			rd.include(request, response);
			
		}
		
		
		
		
		
		
		
	}

}
