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
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		System.out.println("loginServlet");
		model.Model mod = (model.Model)getServletContext().getAttribute("model");
		

		String id=request.getParameter("userid");
		String password=request.getParameter("password");
		
		
		
		model.Users user = mod.login(id, password);
		System.out.println("user = "+id);
		System.out.println("password = "+password);
		System.out.println("userID = "+user.getUserID());
		if(user.getUserID() != null) {
//		if(password.equals("1234")) {
			
			//associate the session to the user
			HttpSession session=request.getSession();
			//set the user of the session (can have object)
			session.setAttribute("user",user); //change the second arg to the user class
			session.setAttribute("name",user.getUserName()); //change the second arg to the user class
			if(id.equals("admin")) { session.setAttribute("privilege","admin");}
			
			request.setAttribute("title", "MainPage");
			request.setAttribute("page","content/Explore.jsp");

		}
		else{
			request.setAttribute("title", "Login Error");
			request.setAttribute("page","content/LoginFirst.jsp");
		}
		RequestDispatcher rd=request.getRequestDispatcher("template.jsp");  
		rd.forward(request, response); 


		out.close();
	}

}
