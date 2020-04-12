package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddItemHandlerServlet
 */
@WebServlet("/AddItemHandlerServlet")
public class AddItemHandlerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddItemHandlerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();

		String ItemName=request.getParameter("name");
		String ItemCategory=request.getParameter("category");
		String ItemValue=request.getParameter("value");
		String ItemCondition=request.getParameter("condition");
		String ItemDescription=request.getParameter("description");
		String ItemPictureUrl=request.getParameter("picture");

		String ItemOwner= (String) request.getSession().getAttribute("name");
//		String ItemOwnerID= (String) request.getSession().getAttribute("id");
		
		StringBuffer msg=new StringBuffer("<h1>You  added a new item:</h1>");
		msg.append("item Owner: " + ItemOwner+ "<br>");
		msg.append("item name: " + ItemName+ "<br>");
		msg.append("item category: " + ItemCategory+ "<br>");
		msg.append("item value: " + ItemValue+ "<br>");
		msg.append("item condition: " + ItemCondition+ "<br>");
		msg.append("item description: " + ItemDescription+ "<br>");
		msg.append("item picture: " + ItemPictureUrl+ "<br>");
		
		request.setAttribute("page","content/FreeMessage.jsp");
		request.setAttribute("title","Item Added");
		request.setAttribute("message",msg);
		RequestDispatcher rd=request.getRequestDispatcher("template.jsp");  
		rd.forward(request, response); 
		out.close();

	}

}
