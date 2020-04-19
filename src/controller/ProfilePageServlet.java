package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ProfilePageServlet
 */
@WebServlet("/ProfilePageServlet")
public class ProfilePageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfilePageServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");  
		PrintWriter out=response.getWriter();  
		request.setAttribute("title","User Info");

		model.Model mod = (model.Model)getServletContext().getAttribute("model");
		HttpSession session=request.getSession(false); 
		request.setAttribute("page","content/LoginFirst.jsp");
		if(session!=null) {
			model.Users user=(model.Users)session.getAttribute("user");
			if(user!=null){	
				String showUserName=request.getParameter("user_name");
				model.Users showUser=mod.getUserByUserName(showUserName);
				if(showUser!=null) {
				request.setAttribute("show_user", showUser);
				request.setAttribute("page","content/ProfilePage.jsp");
				}else {
					request.setAttribute("message","this user does not exist!");
					request.setAttribute("page","content/FreeMessage.jsp");
				}
			}
		}
		RequestDispatcher rd=request.getRequestDispatcher("template.jsp");  
		rd.forward(request, response); 
		out.close(); 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
