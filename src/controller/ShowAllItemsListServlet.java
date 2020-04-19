package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ShowAllItemsListServlet
 */
@WebServlet("/ShowAllItemsListServlet")
public class ShowAllItemsListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowAllItemsListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");  
		PrintWriter out=response.getWriter();  
		request.setAttribute("title","All Users");

		model.Model mod = (model.Model)getServletContext().getAttribute("model");
		HttpSession session=request.getSession(false); 
		request.setAttribute("page","content/LoginFirst.jsp");
		if(session!=null) {
			model.Users user=(model.Users)session.getAttribute("user");
			if(user!=null){
				if(user.getPrivileges().equals("0")) {
					String name=(String)session.getAttribute("name");  
					List<model.Items> items=mod.getAllItemsList();
					request.setAttribute("name",name);

					request.setAttribute("items",items);
					request.setAttribute("page","content/AllItems.jsp");
				}else {
					request.setAttribute("message","you are not alowed to see this!");
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
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
