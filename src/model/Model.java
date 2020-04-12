package model;
import java.sql.*;

public class Model {
	Connection myCon;
	
	public Model() {
		try {
			// 1. Get a connection to database
			myCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/ShareIT", "root", "");
		}
		catch (Exception  exc){
			exc.printStackTrace();
		}
		
	}

	public Users login(String user_name, String password) {
		Users user = new Users();
		try {
			// 2. Create a statement
			Statement myStmt = myCon.createStatement();
			// 3. Execute SQL query
			ResultSet myRs = myStmt.executeQuery("SELECT * FROM users WHERE user_name ='" + user_name + "' AND password = '" + password +"'");
			// Process the result set
			while (myRs.next()) {
				user.setUserID(myRs.getString("userID"));
				System.out.println(myRs.getString("userID"));
				user.setLast_name(myRs.getString("userID"));
				System.out.println(myRs.getString("last_name"));
				user.setFirst_name(myRs.getString("fisrt_name"));
				System.out.println(myRs.getString("fisrt_name"));
				user.setUserName(myRs.getString("user_name"));
				System.out.println(myRs.getString("user_name"));
				user.setUserName(myRs.getString("password"));
				System.out.println(myRs.getString("password"));
				user.setUserName(myRs.getString("email"));
				System.out.println(myRs.getString("email"));
				user.setUserName(myRs.getString("address"));
				System.out.println(myRs.getString("address"));
				user.setUserName(myRs.getString("phone"));
				System.out.println(myRs.getString("phone"));
				user.setUserName(myRs.getString("gender"));
				System.out.println(myRs.getString("gender"));
				user.setUserName(myRs.getString("privileges"));
				System.out.println(myRs.getString("privileges"));
				user.setUserName(myRs.getString("last_name"));
				System.out.println(myRs.getString("last_name"));
			}	
		}
		catch (Exception  exc){
			exc.printStackTrace();
		}
		return user;
	}
}

////2. Create a statement
//		Statement myStmt = myCon.createStatement();
//		// 3. Execute SQL query
//		ResultSet myRs = myStmt.executeQuery("select * from users");
//		// Process the result set
//		while (myRs.next()) {
//			System.out.println(myRs.getString("last_name") + ", " + myRs.getString("first_name"));
//		}