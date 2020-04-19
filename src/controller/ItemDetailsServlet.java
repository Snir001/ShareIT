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
@WebServlet("/ItemDetailsServlet")
public class ItemDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ItemDetailsServlet() {
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
		model.Items item=(model.Items)mod.getItemByID(itemId);
		if(item.getCategory()!=null) {
			request.setAttribute("item", mod.getItemByID(itemId));
			request.setAttribute("message", "you are in the item page");
			request.setAttribute("page","content/ItemDetails.jsp");

		} else {
			request.setAttribute("message", "Item didnt found");
			request.setAttribute("page","content/FreeMessage.jsp");

		}

		request.setAttribute("title", "Item Page");

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
