package p1;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




public class viewaccountant extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	response.setContentType("text/html");
	PrintWriter out=response.getWriter();
		
        List<account> list=loginduo.view();
        out.print("<h1>ACCOUNTANT</h1>");
		
		out.println("<table border='2' style='border-collapse: collapse;'>");
		out.println("<tr><th>Name</th><th>Email</th><th>Password</th><th>Mobile</th><th>Edit</th><th>Delete</th></tr>");
		for(account bean:list){
			out.println("<tr><td>"+bean.getName()+"</td><td>"+bean.getEmail()+"</td><td>"+bean.getPassword()+"</td><td>"+bean.getMobile()+"</td><td><a href='EditaccountnatForm?name="+bean.getName()+"'>Edit</a></td><td><a href='Deleteaccountant?name="+bean.getName()+"'>Delete</a></td></tr>");
			
			
			
		}
		out.println("</table>");
		
		out.println("</div>");
		out.print("<br> <a  href='navigationadmin.html'>Logout</a>");
		
		out.close();
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
