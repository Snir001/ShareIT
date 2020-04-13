package controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class AddItemHandlerServlet
 */
@WebServlet("/AddItemHandlerServlet")
@MultipartConfig

public class AddItemHandlerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddItemHandlerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
//    used for file saving
    private static String getSubmittedFileName(Part part) {
        for (String cd : part.getHeader("content-disposition").split(";")) {
            if (cd.trim().startsWith("filename")) {
                String fileName = cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
                return fileName.substring(fileName.lastIndexOf('/') + 1).substring(fileName.lastIndexOf('\\') + 1); // MSIE fix.
            }
        }
        return null;
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
		String ItemID=request.getParameter("itemid");
		Part filePart = request.getPart("file"); // Retrieves <input type="file" name="file">

		String ItemOwner= (String) request.getSession().getAttribute("name");
//		String ItemOwnerID= (String) request.getSession().getAttribute("id");
		
		if(filePart != null) {
		 
		    String fileName = getSubmittedFileName(filePart); // MSIE fix.
		    InputStream fileContent = filePart.getInputStream();
		    
	    // ... save the file:
		    
		    //create new folder:
	//	    C:\\Users\\SnirY\\OneDrive\\Documents\\Bar Ilan\\sems5\\Software eng\\ShareIT\\WebContent\\ItemPictures\\
		    String upload_path=getServletContext().getInitParameter("upload_location")+ItemID;
		    System.out.println("upload_path is : " + upload_path);
	
		    new File(upload_path).mkdir();
		    File uploads = new File(upload_path);
		    
		    
		    //save the file
		    File file = new File(uploads, ItemID+".jpg");
		    try (InputStream input = fileContent) {
		        Files.copy(input, file.toPath());
		    }
		    
		    //show list of pictures
		    System.out.println("file path at : " +file.getPath() );
		}
		
		StringBuffer msg=new StringBuffer("<h1>You  added a new item:</h1>");
		msg.append("item Owner: " + ItemOwner+ "<br>");
		msg.append("item name: " + ItemName+ "<br>");
		msg.append("item category: " + ItemCategory+ "<br>");
		msg.append("item value: " + ItemValue+ "<br>");
		msg.append("item condition: " + ItemCondition+ "<br>");
		msg.append("item description: " + ItemDescription+ "<br>");
		msg.append("item picture: " + ItemID + "<br>");
		
		request.setAttribute("page","content/FreeMessage.jsp");
		request.setAttribute("title","Item Added");
		request.setAttribute("message",msg);
		RequestDispatcher rd=request.getRequestDispatcher("template.jsp");  
		rd.forward(request, response); 
		out.close();

	}

}
