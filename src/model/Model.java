package model;
import java.sql.*;


public class Model {
	Connection myCon;
	String[] users_columns = {"last_name", "first_name", "user_name", "password", "email", "city", "address", "phone", "gender", "privileges"};
	String[] items_columns = {"name", "owner(userID)", "category", "item_value", "item_condition", "description", "picture"};
	String[] requests_columns = {"itemID", "owner(userID)", "borrower(userID)", "period", "response"};
	
	public Model() {
		try {
			// 1. Get a connection to database
			myCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/ShareIT", "root", "");
		}
		catch (Exception  exc){
			exc.printStackTrace();
		}
		
	}
	// TODO: Items itemSearch(string)
	//##################################################################################################################################################
	//
	//##################################################################################################################################################
	public Users login(String user_name, String password) {
		Users user = new Users();
		try {
			// Create a statement
			Statement myStmt = myCon.createStatement();
			// Execute SQL query
			ResultSet myRs = myStmt.executeQuery("SELECT * FROM users WHERE user_name ='" + user_name + "' AND password = '" + password +"'");
			// Process the result set
			while (myRs.next()) {
				user.setUserID(myRs.getString("userID"));
				user.setLast_name(myRs.getString("last_name"));
				user.setFirst_name(myRs.getString("first_name"));
				user.setUserName(myRs.getString("user_name"));
				user.setPassword(myRs.getString("password"));
				user.setMail(myRs.getString("email"));
				user.setAddress(myRs.getString("address"));
				user.setPhone(myRs.getString("phone"));
				user.setGender(myRs.getString("gender"));
				user.setPrivileges(myRs.getString("privileges"));
			}	
		}
		catch (Exception  exc){
			exc.printStackTrace();
		}
		return user;
	}

	//##################################################################################################################################################
	public String signUp(String data[]) {
		String userID = null;
		try {
			Statement myStmt = myCon.createStatement();
			String query = addQuery("users", users_columns, data);
			String getID = "SELECT userID FROM items ORDER BY userID DESC LIMIT 1";
			myStmt.executeUpdate(query);
			ResultSet myRs = myStmt.executeQuery(getID);
			while (myRs.next()) {
				userID =  myRs.getString("userID");
			}
			return userID;
		}
		catch (Exception  exc){
			exc.printStackTrace();
			return "0";
		}
	}
	//##################################################################################################################################################
	public String addItem(String data[]) {
		String itemID = null;
		try {
			// Create a statement
			Statement myStmt = myCon.createStatement();
			String query = addQuery("items", items_columns, data);
			String getID = "SELECT itemID FROM items ORDER BY itemID DESC LIMIT 1";
			myStmt.executeQuery(query);
			ResultSet myRs = myStmt.executeQuery(getID);
			while (myRs.next()) {
				itemID =  myRs.getString("itemID");
			}
			return itemID;
		}
		catch (Exception  exc){
			exc.printStackTrace();
			return "0";
		}
	}
	//##################################################################################################################################################
	public String addRequest(String data[]) {
		String requestID = null;
		try {
			// Create a statement
			Statement myStmt = myCon.createStatement();
			String query = addQuery("requests", requests_columns, data);
			String getID = "SELECT requestID FROM items ORDER BY requestID DESC LIMIT 1";
			myStmt.executeQuery(query);
			ResultSet myRs = myStmt.executeQuery(getID);
			while (myRs.next()) {
				requestID =  myRs.getString("requestID");
			}
			return requestID;
		}
		catch (Exception  exc){
			exc.printStackTrace();
			return "0";
		}
	}
	//##################################################################################################################################################
	public boolean editUser(String columns[], String data[], String userID) {
		try {
			// Create a statement
			Statement myStmt = myCon.createStatement();
			String query = editQuery("users", "userID", columns, data, userID);
			myStmt.executeQuery(query);
			return true;
		}
		catch (Exception  exc){
			exc.printStackTrace();
			return false;
		}
	}
	//##################################################################################################################################################
	public boolean editItem(String columns[], String data[], String itemID) {
		try {
			// Create a statement
			Statement myStmt = myCon.createStatement();
			String query = editQuery("items", "itemID", columns, data, itemID);
			myStmt.executeQuery(query);
			return true;
		}
		catch (Exception  exc){
			exc.printStackTrace();
			return false;
		}
	}
	//##################################################################################################################################################
	public boolean editRequest(String columns[], String data[], String requestID) {
		try {
			// Create a statement
			Statement myStmt = myCon.createStatement();
			String query = editQuery("requests", "requestID", columns, data, requestID);
			myStmt.executeQuery(query);
			return true;
		}
		catch (Exception  exc){
			exc.printStackTrace();
			return false;
		}
	}
	//##################################################################################################################################################
	public boolean responseRequest(String requestID, String response) {
		try {
			// Create a statement
			String[] columns = {"response"};
			String[] data = {response};
			Statement myStmt = myCon.createStatement();
			String query = editQuery("requests", "requestID", columns, data, requestID);
			myStmt.executeQuery(query);
			return true;
		}
		catch (Exception  exc){
			exc.printStackTrace();
			return false;
		}
	}
	//##################################################################################################################################################
	// input: 
	// output:
	//##################################################################################################################################################
	public static String addQuery(String TableName, String columns[], String data[]) {
		String queryA = "INSERT INTO `" + TableName + "` (";
		int i, j;
		for (i = 0; i < columns.length - 1; i++) {
			queryA += columns[i] + ", ";
		}
		queryA += columns[i] + ") VALUES (";
		for (j = 0; j < data.length - 1; j++) {
			queryA += "'"+ data[j] + "', ";
		}
		queryA += "'"+ data[i] + "'";
		queryA += ")";
		return queryA;
	}
	//##################################################################################################################################################
	public static String editQuery(String TableName,String TableKey, String columns[], String data[], String index) {
		String query = "UPDATE `" + TableName + "` SET ";
		int i;
		for (i = 0; i < data.length - 1; i++) {
			query += columns[i] + " = '" + data[i] + "', ";
		}
		query += columns[i] + " = '" + data[i] + "'" + " WHERE " + TableName +"." + TableKey + " = " + index;
		return query;
	}
	// TODO: String removeQuery(String index)
	//##################################################################################################################################################
	//
	// TODO: String getListQuery(String Table)
	//##################################################################################################################################################
	//
	// TODO: boolean removeUser(String userID)
	//##################################################################################################################################################
	//
	// TODO: boolean removeItem(String itemID)
	//##################################################################################################################################################
	//
	// TODO: boolean removeRequest(String requestID)
	//##################################################################################################################################################
	//
	// TODO: Users[] getUserList(String userID)
	//##################################################################################################################################################
	//
	// TODO: Items[] getItemsList(String itemID)
	//##################################################################################################################################################
	//
	// TODO: Requests[] getRequestsList(String requestID)
	//##################################################################################################################################################
	//
	//##################################################################################################################################################	
}