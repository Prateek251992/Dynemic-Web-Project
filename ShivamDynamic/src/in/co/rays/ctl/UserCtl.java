package in.co.rays.ctl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.co.rays.bean.UserBean;
import in.co.rays.model.UserModel;

@WebServlet("/UserCtl.do")

public class UserCtl extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		UserModel model = new UserModel();
		try {
			UserBean bean = model.findById(Integer.parseInt(id));
			req.setAttribute("bean", bean);
			RequestDispatcher rd = req.getRequestDispatcher("Update.jsp");
			rd.forward(req, resp);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String op = req.getParameter("Operation");
		String id = req.getParameter("id");
		String fname = req.getParameter("firstName");
		String lname = req.getParameter("LastName");
		String login = req.getParameter("loginId");
		String pass = req.getParameter("password");
		String add = req.getParameter("Address");

		UserBean bean = new UserBean();
		bean.setFirstName(fname);
		bean.setLastName(lname);
		bean.setLoginId(login);
		bean.setPassword(pass);
		bean.setAddress(add);

		UserModel model = new UserModel();

		if (op.equals("Registration")) {

			try {
				model.add(bean);

			} catch (Exception e) {
				e.printStackTrace();

			}
		}
		if (op.equalsIgnoreCase("Update")) {
			bean.setId(Integer.parseInt(id));
			try {
				model.update(bean);
				resp.sendRedirect("UserListCtl.do");

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
}
