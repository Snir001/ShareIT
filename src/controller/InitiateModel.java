package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InitiateModel
 */
@WebServlet("/InitiateModel")
@SuppressWarnings("serial")
public class InitiateModel extends HttpServlet {
	private static final long serialVersionUID = 1L;


	public void init() throws ServletException
	{
		System.out.println("---------- Reloading Content ----------");
		model.Model myModel=new model.Model();
		getServletContext().setAttribute("model", myModel);
	}
}
