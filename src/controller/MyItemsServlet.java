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
 * Servlet implementation class MyItemsServlet
 */
@WebServlet("/MyItemsServlet")
public class MyItemsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyItemsServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");  
		PrintWriter out=response.getWriter();  
		request.setAttribute("title","My Items");
		model.Model mod = (model.Model)getServletContext().getAttribute("model");
		HttpSession session=request.getSession(false);  
		model.Users user=(model.Users)session.getAttribute("user");
		if(user!=null){
			
			String name=user.getUserName();  
			request.setAttribute("items", mod.getItemsByUserId(user.getUserID()));
			request.setAttribute("name",name);
			request.setAttribute("page","content/MyItems.jsp");
		}  
		else{  
			request.setAttribute("page","content/LoginFirst.jsp");
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
