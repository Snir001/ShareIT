package controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Files;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class SignUpHandlerSevlet
 */
@WebServlet("/SignUpHandlerServlet")
public class SignUpHandlerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUpHandlerServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		model.Model mod = (model.Model)getServletContext().getAttribute("model");

		model.Users newUser=new model.Users();
		
		//get new user parameters
		newUser.setUserName(request.getParameter("userName"));
		newUser.setFirstName(request.getParameter("first_name"));
		newUser.setLastName(request.getParameter("last_name"));
		newUser.setPassword(request.getParameter("password"));
		newUser.setGender(request.getParameter("gender"));
		newUser.setMail(request.getParameter("mail"));
		newUser.setCity(request.getParameter("city"));
		newUser.setAddress(request.getParameter("address"));
		newUser.setPhone(request.getParameter("phone"));
		
		//try to create user
		String userId=mod.addUser(newUser);
		
//		
/*
 *<form action="AddItemHandlerServlet" method="post">
User Name: <input type="text" name="user_name"><br>
First Name:<input type="text" name="first_name"><br>
Last Name:<input type="text" name="last_name"><br>
Password:<input type="password" name="password"><br>
Gender: <input type="radio" id="male" name="gender" value="male">
<label for="male">Male</label>
<input type="radio" id="female" name="gender" value="female">
<label for="female">Female</label>
<input type="radio" id="other" name="gender" value="unicorn">
<label for="other">Unicorn</label><br>
E-Mail:<input type="text" name="mail"><br>
City:<input type="text" name="city"><br>
Address:<input type="text" name="address"><br>
Phone:<input type="text" name="phone"><br>
 */
		
		StringBuffer msg=new StringBuffer("<h1>You signed up:</h1><br>");
		if(userId != null) {
			msg.append("your id is :"+userId);
		} else {
			msg.append("somthing went wrong, try different userid"+userId);

		}
		System.out.println(msg);
		request.setAttribute("page","content/FreeMessage.jsp");
		request.setAttribute("message",msg);
		RequestDispatcher rd=request.getRequestDispatcher("template.jsp");  
		rd.forward(request, response); 
		out.close();
	}

}
