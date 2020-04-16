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
 * Servlet implementation class ReqestItemServlet
 */
@WebServlet("/ReqestItemServlet")
public class ReqestItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReqestItemServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String itemId=request.getParameter("id");
		model.Model mod = (model.Model)getServletContext().getAttribute("model");
		HttpSession session=request.getSession(false);  
		model.Users user=(model.Users)session.getAttribute("user");
		if(user!=null){
//			"itemID", "owner(userID)", "borrower(userID)", "period", "response"
			String[] data= {itemId,user.getUserID(),"week",""};
			System.out.println("passing :"+data);
			model.Requests req=new  model.Requests();
			req.setBorrowerID(user.getUserID());
			req.setDate(java.time.LocalDate.now().toString());
			req.setItemID(itemId);
			req.setPeriod("week");
			req.setResponse("0");
			mod.addRequest(req);
			
			request.setAttribute("message", "item requested seccesfully!");
			request.setAttribute("title", "Item Requested");
			request.setAttribute("page","content/FreeMessage.jsp");
		} else {
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
