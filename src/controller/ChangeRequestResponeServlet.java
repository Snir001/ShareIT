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
 * Servlet implementation class ChangeRequestResponeServlet
 */
@WebServlet("/ChangeRequestResponeServlet")
public class ChangeRequestResponeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangeRequestResponeServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");  
		PrintWriter out=response.getWriter();  
		
		request.setAttribute("title","Request Approve");
		
		model.Model mod = (model.Model)getServletContext().getAttribute("model");
		model.Requests req=mod.getRequestByID(request.getParameter("req_id"));
		String newResp=request.getParameter("new_resp");
		HttpSession session=request.getSession(false); 
		if(session==null){
			request.setAttribute("page","content/LoginFirst.jsp");
		}  
		else 
		{  
			model.Users user=(model.Users)session.getAttribute("user");
			if(user==null) {
				request.setAttribute("page","content/LoginFirst.jsp");
			} else {
				String name=(String)session.getAttribute("name");  
				request.setAttribute("name",name);
				if(req.getOwnerID().equals(user.getUserID())) {
					//TODO:check if owner to aprove and deny and dnoe. check if borower if cancel
					//TODO:add user details page
					req.setResponse(newResp);
					mod.editRequest(req);
					String msg;
					if(newResp.equals("1")) {msg="request approved";}
					if(newResp.equals("2")) {msg="request Denyed";}
					if(newResp.equals("3")) {msg="request Done";}
					if(newResp.equals("4")) {msg="request Canceled";}
					else {msg="Unknown request status";}
					
					request.setAttribute("message", msg);
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
		doGet(request, response);
	}

}
