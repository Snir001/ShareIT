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
 * Servlet implementation class ItenDetailsServlet
 */
@WebServlet("/ItenDetailsServlet")
public class ItenDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ItenDetailsServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		model.Model mod = (model.Model)getServletContext().getAttribute("model");

		String itemId=request.getParameter("id");
		request.setAttribute("item", mod.getItemById(itemId));
		
		request.setAttribute("title", "Item Page");
		request.setAttribute("page","content/Results.jsp");

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
