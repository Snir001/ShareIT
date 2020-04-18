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
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import model.Items;

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
    private String nullToString(String  s) {
    	if(s == null) {
    		s="";
    	}
    	return s;
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath()).append("\nshould be post method!");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();

		
		model.Model mod = (model.Model)getServletContext().getAttribute("model");
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
				String ItemName=request.getParameter("name");
				String ItemCategory=request.getParameter("category");
				String ItemValue=request.getParameter("value");
				String ItemCondition=request.getParameter("condition");
				String ItemDescription=request.getParameter("description");
//				String ItemID=request.getParameter("itemid");
				Part filePart = request.getPart("file"); // Retrieves <input type="file" name="file">
				String picture;
				if(filePart.getSize() != 0) { picture="1";} else {picture ="0";}
				//		"name", "owner(userID)", "category", "item_value", "item_condition", "description", "picture"
//				String[] data= {ItemName,user.getUserID(),ItemCategory,ItemValue,ItemCondition,ItemDescription,picture};
				model.Items newItem=new model.Items();
				newItem.setName(nullToString(ItemName));
				newItem.setOwnerID(nullToString(user.getUserID()));
				newItem.setCategory(nullToString(ItemCategory));
				newItem.setItemValue(nullToString(ItemValue));
				newItem.setCondition(nullToString(ItemCondition));
				newItem.setDecription(nullToString(ItemDescription));
				newItem.setPicture(nullToString(picture));
				String ItemID=mod.addItem(newItem);
				//TODO: check if all fields have the right type
				
				
				if(picture.equals("1")) {
					System.out.println("we have file");
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
				
				StringBuffer msg=new StringBuffer("<h1>You added a new item:</h1>");
				msg.append("item Owner: " + user.getUserName()+ "<br>");
				msg.append("item name: " + ItemName+ "<br>");
				msg.append("item category: " + ItemCategory+ "<br>");
				msg.append("item value: " + ItemValue+ "<br>");
				msg.append("item condition: " + ItemCondition+ "<br>");
				msg.append("item description: " + ItemDescription+ "<br>");
				msg.append("item ID: " + ItemID + "<br>");
				
				request.setAttribute("page","content/FreeMessage.jsp");
				request.setAttribute("title","Item Added");
				request.setAttribute("message",msg);
			}

		}  
		
		
		
		RequestDispatcher rd=request.getRequestDispatcher("template.jsp");  
		rd.forward(request, response); 
		out.close();

	}

}
