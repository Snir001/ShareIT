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
 * Servlet implementation class SignUpServlet
 */
@WebServlet("/SignUpServlet")
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUpServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");  
		PrintWriter out=response.getWriter();  
		
		request.setAttribute("title","SignUp");

		model.Model mod = (model.Model)getServletContext().getAttribute("model");
		HttpSession session=request.getSession(false);  
		model.Users user=(model.Users)session.getAttribute("user");
		if(user!=null){
			

			String name=(String)session.getAttribute("name");  
			request.setAttribute("name",name);
			request.setAttribute("good","yes");
			request.setAttribute("page","ProfileDet.jsp");
			
			StringBuffer msg=new StringBuffer("<h1>You already sign in.</h1><br>");
			msg.append("You need to logout first!");
			
			request.setAttribute("page","content/FreeMessage.jsp");
			request.setAttribute("message",msg);
		}  
		else 
		{  
			request.setAttribute("page","content/SignUp.jsp");

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
