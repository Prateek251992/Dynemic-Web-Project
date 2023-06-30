package in.co.rays.ctl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/SecoundCtl")
public class SecoundCtl extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("Do get");
		String fname = req.getParameter("firstName");
		String lname = req.getParameter("LastName");
		
		System.out.println("fname");
		System.out.println("lname");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		System.out.println("Do post");
		String fname = req.getParameter("firstName");
		String lname = req.getParameter("LastName");
		
		System.out.println(fname);
		System.out.println(lname);
		
		String msg = (String)req.getAttribute("msg");
		System.out.println(msg);
		
		
	}

}
