package controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class upload
 */
@WebServlet("/upload")
@MultipartConfig

public class upload extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public upload() {
        super();
        // TODO Auto-generated constructor stub
    }
    
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
		String description = request.getParameter("description"); // Retrieves <input type="text" name="description">
	    Part filePart = request.getPart("file"); // Retrieves <input type="file" name="file">
	    String fileName = getSubmittedFileName(filePart); // MSIE fix.
	    InputStream fileContent = filePart.getInputStream();
	    
    // ... save the file:
	    
	    //create new folder:
//	    C:\\Users\\SnirY\\OneDrive\\Documents\\Bar Ilan\\sems5\\Software eng\\ShareIT\\WebContent\\ItemPictures\\
	    String upload_path=getServletContext().getInitParameter("upload_location")+description;
	    System.out.println("upload_path is : " + upload_path);

	    new File(upload_path).mkdir();
	    File uploads = new File(upload_path);
	    
	    
	    //save the file
	    File file = new File(uploads, description+".jpg");
	    try (InputStream input = fileContent) {
	        Files.copy(input, file.toPath());
	    }
	    
	    //show list of pictures
	    Path currentRelativePath = Paths.get("");
	    String s = currentRelativePath.toAbsolutePath().toString();
	    System.out.println("Current relative path is: " + s);
	    response.getWriter().append("Served at: ").append(request.getContextPath()).append("file uploaded ").append("file at "+uploads.getPath()).append("Current relative path is: " + s);
	}

}
