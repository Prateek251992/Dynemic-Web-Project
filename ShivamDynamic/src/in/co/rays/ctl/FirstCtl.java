package in.co.rays.ctl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/FirstCtl")
public class FirstCtl extends HttpServlet {
	
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
		
		System.out.println("Do Post");
		
		String fname = req.getParameter("firstNamne");
		String lname = req.getParameter("LastName");
		
		System.out.println(fname);
		System.out.println(lname);
		
		req.setAttribute("msg", "Hello do post");
				
		RequestDispatcher rd = req.getRequestDispatcher("SecoundCtl");
		rd.forward(req, resp);
		
		
		
	}

}
