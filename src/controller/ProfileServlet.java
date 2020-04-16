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
 * Servlet implementation class ProfileServlet
 */
@WebServlet("/ProfileServlet")
public class ProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    	public ProfileServlet() {
        	super();
    	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");  
		PrintWriter out=response.getWriter();  
		
		request.setAttribute("title","Profile");

		model.Model mod = (model.Model)getServletContext().getAttribute("model");
		HttpSession session=request.getSession(false);  
		model.Users user=(model.Users)session.getAttribute("user");
		if(user!=null){
			

			String name=(String)session.getAttribute("name");  
			request.setAttribute("name",name);
			request.setAttribute("good","yes");
			request.setAttribute("page","ProfileDet.jsp");
			
			System.out.println("Hello, "+name+" Welcome to Profile");
			System.out.println("id is: " + session.getId());
		}  
		else 
		{  
			request.setAttribute("page","content/Login.jsp");

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
