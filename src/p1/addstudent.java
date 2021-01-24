package p1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class addstudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String course=request.getParameter("Course");
		String fee=request.getParameter("fee");
		String paid=request.getParameter("paid");
		String due=request.getParameter("due");
		
		account a=new account();
		a.setName(name);
		a.setEmail(email);
		a.setCourse(course);
		a.setFee(fee);
		a.setPaid(paid);
		a.setDue(due);
		
		int status=studentduo.save(a);
		
		
		if(status>0)
		{
			out.print("SUCCESSFULLY SAVE");
			RequestDispatcher rd=request.getRequestDispatcher("addstudent.html");
			rd.include(request, response);
		}
		else
		{
			out.print("FAIL INSERT");
			RequestDispatcher rd=request.getRequestDispatcher("addstudent.html");
			rd.include(request, response);
		}
		
		
		
		
		
		
	}

}
