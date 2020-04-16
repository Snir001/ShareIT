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
 * Servlet implementation class DenyRequestServlet
 */
@WebServlet("/DenyRequestServlet")
public class DenyRequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DenyRequestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");  
		PrintWriter out=response.getWriter();  
		
		request.setAttribute("title","Request Approve");
		
		model.Model mod = (model.Model)getServletContext().getAttribute("model");
		model.Requests req=mod.getRequestById(request.getParameter("req_id"));
		HttpSession session=request.getSession(false); 
		if(session==null){
			request.setAttribute("page","content/LoginFirst.jsp");
		}  
		else 
		{  
			model.Users user=(model.Users)session.getAttribute("user");
			if(user==null) {
				request.setAttribute("page","content/Login.jsp");
			} else {
				String name=(String)session.getAttribute("name");  
				request.setAttribute("name",name);
				if(req.getOwnerID().equals(user.getUserID())) {
					req.setResponse("2");
					mod.editRequest(req);
					request.setAttribute("message", "request denyed!");
				} else {
					request.setAttribute("message", "you are not the owner! go away!");
				}
				request.setAttribute("page","content/FreeMessage.jsp");
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
