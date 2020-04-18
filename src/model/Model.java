package model;
import java.sql.*;
import java.util.*;


public class Model {
	Connection myCon;
	String[] users_columns = {"last_name", "first_name", "user_name", "password", "email", "city", "address", "phone", "gender", "privileges"};
	String[] items_columns = {"name", "owner", "category", "item_value", "item_condition", "description", "picture"};
	String[] requests_columns = {"itemID", "owner", "borrower", "period", "date", "response"};
	
	public Model() {
		try {
			// 1. Get a connection to database
			myCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/ShareIT", "root", "");
		}
		catch (Exception  exc){
			exc.printStackTrace();
		}
		
	}
	//##################################################################################################################################################
	public List<Items> itemSearch(String search_query) {
		Items item = new Items();
		String query = "SELECT * FROM items";
		List<Items> itemsList = new ArrayList<Items>();
		try {
			// Create a statement
			Statement myStmt = myCon.createStatement();
			System.out.println("0");
			// Execute SQL query
			ResultSet myRs = myStmt.executeQuery(query);
			// Process the result set
			System.out.println("1");
			while (myRs.next()) {
				System.out.println("2");
				System.out.println(myRs.getString("name").contains(search_query));
				System.out.println(myRs.getString("description").contains(search_query));
				System.out.println("**************************************************************");
				if (myRs.getString("name").contains(search_query) || myRs.getString("description").contains(search_query)) {
					item = new Items();
					item.setItemID(myRs.getString("itemID"));
					item.setName(myRs.getString("name"));
					item.setOwnerID(myRs.getString("owner"));
					item.setCategory(myRs.getString("category"));
					item.setItemValue(myRs.getString("item_value"));
					item.setCondition(myRs.getString("item_condition"));
					item.setDecription(myRs.getString("description"));
					item.setPicture(myRs.getString("picture"));	
					System.out.println("3");
				}
			}
			System.out.println("end");
			return itemsList;
		}
		catch (Exception  exc){
			System.out.println("in exc");
			exc.printStackTrace();
			return null;
		}
	}
	//##################################################################################################################################################
	public Users login(String user_name, String password) { // TODO: check if userName exists
		Users user = new Users();
		try {
			Statement myStmt = myCon.createStatement();	
			String doubleCheck = "SELECT * FROM users WHERE user_name = '" + user_name + "'";
			ResultSet myDoubleRs = myStmt.executeQuery(doubleCheck);
			
			if(myDoubleRs.next()) { // if there is such user name in dataBase
				ResultSet myRs = myStmt.executeQuery("SELECT * FROM users");
				while (myRs.next()) {
					if (myRs.getString("user_name").equals(user_name) && myRs.getString("password").equals(password)){
						user.setUserID(myRs.getString("userID"));
						user.setLastName(myRs.getString("last_name"));
						user.setFirstName(myRs.getString("first_name"));
						user.setUserName(myRs.getString("user_name"));
						user.setPassword(null);
						user.setMail(myRs.getString("email"));
						user.setAddress(myRs.getString("address"));
						user.setPhone(myRs.getString("phone"));
						user.setGender(myRs.getString("gender"));
						user.setPrivileges(myRs.getString("privileges"));
					}
				}
			}
		}
		catch (Exception  exc){
			System.out.println("in catch");
			exc.printStackTrace();
		}
		return user;
	}
	//##################################################################################################################################################
	public String addUser(Users user) {
		String userID = null;
		String[] data = userToList(user);
		try {
			Statement myStmt = myCon.createStatement();
			
			String doubleCheck = "SELECT * FROM users WHERE user_name = '" + user.getUserName() + "'";
			ResultSet myDoubleRs = myStmt.executeQuery(doubleCheck);
			
			if(myDoubleRs.next() == false) { // if no such user name in dataBase
				String query = addQuery("users", users_columns, data);
				System.out.println(query);
				String getID = "SELECT userID FROM users ORDER BY userID DESC LIMIT 1";
				myStmt.executeUpdate(query);
				ResultSet myRs = myStmt.executeQuery(getID);
				while (myRs.next()) {
					userID =  myRs.getString("userID");
				}
				return userID;
			}
			else
				return "-1";
			
		}
		catch (Exception  exc){
			exc.printStackTrace();
			return "-2";
		}
	}
	//##################################################################################################################################################
	public String addItem(Items item) {
		String itemID = null;	
		String[] data = itemToList(item);
		try {
			// Create a statement
			Statement myStmt = myCon.createStatement();
			String query = addQuery("items", items_columns, data);
			System.out.println("preparty");
			String getID = "SELECT itemID FROM items ORDER BY itemID DESC LIMIT 1";
			myStmt.executeUpdate(query);
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
	public String addRequest(Requests request) {
		String requestID = null;
		String[] data = requestToList(request);
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
	public boolean editUser(Users user) {
		String[] data = userToList(user);
		try {
			// Create a statement
			Statement myStmt = myCon.createStatement();
			String query = editQuery("users", "userID", users_columns, data, user.getUserID());
			myStmt.executeQuery(query);
			return true;
		}
		catch (Exception  exc){
			exc.printStackTrace();
			return false;
		}
	}
	//##################################################################################################################################################
	public boolean editItem(Items item) {
		String[] data = itemToList(item);
		try {
			// Create a statement
			Statement myStmt = myCon.createStatement();
			String query = editQuery("items", "itemID", items_columns, data, item.getItemID());
			myStmt.executeQuery(query);
			return true;
		}
		catch (Exception  exc){
			exc.printStackTrace();
			return false;
		}
	}
	//##################################################################################################################################################
	public boolean editRequest(Requests request) {
		String[] data = requestToList(request);
		try {
			// Create a statement
			Statement myStmt = myCon.createStatement();
			String query = editQuery("requests", "requestID", requests_columns, data, request.getRequestID());
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
	public boolean removeUser(String userID) {
		try {
			Statement myStmt = myCon.createStatement();	
			String query = "DELETE FROM users WHERE userID = " + userID;
			myStmt.executeQuery(query);
			return true;
		}
		catch (Exception  exc){
			exc.printStackTrace();
			return false;
		}
	}
	//##################################################################################################################################################
	public boolean removeItem(String itemID) {
		try {
			Statement myStmt = myCon.createStatement();	
			String query = "DELETE FROM items WHERE itemID = " + itemID;
			myStmt.executeQuery(query);
			return true;
		}
		catch (Exception  exc){
			exc.printStackTrace();
			return false;
		}
	}
	//##################################################################################################################################################
	public boolean removeRequest(String requestID) {
		try {
			Statement myStmt = myCon.createStatement();	
			String query = "DELETE FROM requests WHERE requestID = " + requestID;
			myStmt.executeQuery(query);
			return true;
		}
		catch (Exception  exc){
			exc.printStackTrace();
			return false;
		}
	}
	//##################################################################################################################################################
	public List<Users> getAllUsersList() {
		String query = "SELECT * FROM users";
		Users user = new Users();
		List<Users> usersList = new ArrayList<Users>();
		try {
			Statement myStmt = myCon.createStatement();
			ResultSet myRs = myStmt.executeQuery(query);
			
			while (myRs.next()) {
				user = new Users();
				user.setUserID(myRs.getString("userID"));
				user.setLastName(myRs.getString("last_name"));
				user.setFirstName(myRs.getString("first_name"));
				user.setUserName(myRs.getString("user_name"));
				user.setPassword(null);
				user.setMail(myRs.getString("email"));
				user.setAddress(myRs.getString("address"));
				user.setPhone(myRs.getString("phone"));
				user.setGender(myRs.getString("gender"));
				user.setPrivileges(myRs.getString("privileges"));
				usersList.add(user);
			}
			return usersList;
		}
		catch (Exception  exc){
			exc.printStackTrace();
			return null;
		}
	}
	//##################################################################################################################################################
	public List<Items> getAllItemsList() {
		String query = "SELECT * FROM items";
		Items item = new Items();
		List<Items> itemsList = new ArrayList<Items>();
		try {
			Statement myStmt = myCon.createStatement();
			ResultSet myRs = myStmt.executeQuery(query);
			
			while (myRs.next()) {
				item = new Items();
				item.setItemID(myRs.getString("itemID"));
				item.setName(myRs.getString("name"));
				item.setOwnerID(myRs.getString("owner"));
				item.setCategory(myRs.getString("category"));
				item.setItemValue(myRs.getString("item_value"));
				item.setCondition(myRs.getString("item_condition"));
				item.setDecription(myRs.getString("description"));
				item.setPicture(myRs.getString("picture"));
				itemsList.add(item);
			}
			return itemsList;
		}
		catch (Exception  exc){
			exc.printStackTrace();
			return null;
		}
	}
	//##################################################################################################################################################
	public List<Requests> getAllRequestsList() {
		String query = "SELECT * FROM requests";
		Requests request = new Requests();
		List<Requests> requestsList = new ArrayList<Requests>();
		try {
			Statement myStmt = myCon.createStatement();
			ResultSet myRs = myStmt.executeQuery(query);
			
			while (myRs.next()) {
				request = new Requests();
				request.setRequestID(myRs.getString("requestID"));
				request.setItemID(myRs.getString("itemID"));
				request.setOwnerID(myRs.getString("owner"));
				request.setBorrowerID(myRs.getString("borrower"));
				request.setPeriod(myRs.getString("period"));
				request.setDate(myRs.getString("date"));
				request.setResponse(myRs.getString("response"));
				requestsList.add(request);
			}
			return requestsList;
		}
		catch (Exception  exc){
			exc.printStackTrace();
			return null;
		}
	}
	//##################################################################################################################################################
	public Users getUserByID(String userID) {
		String query = "SELECT * FROM users Where userID ='" + userID + "'";
		Users user = new Users();
		try {
			Statement myStmt = myCon.createStatement();
			ResultSet myRs = myStmt.executeQuery(query);
			
			while (myRs.next()) {
				user.setUserID(myRs.getString("userID"));
				user.setLastName(myRs.getString("last_name"));
				user.setFirstName(myRs.getString("first_name"));
				user.setUserName(myRs.getString("user_name"));
				user.setPassword(null);
				user.setMail(myRs.getString("email"));
				user.setAddress(myRs.getString("address"));
				user.setPhone(myRs.getString("phone"));
				user.setGender(myRs.getString("gender"));
				user.setPrivileges(myRs.getString("privileges"));
			}
			return user;
		}
		catch (Exception  exc){
			exc.printStackTrace();
			return null;
		}
	}
	//##################################################################################################################################################
	public Items getItemByID(String itemID) {
		String query = "SELECT * FROM items Where itemID ='" + itemID + "'";
		Items item = new Items();
		try {
			Statement myStmt = myCon.createStatement();
			ResultSet myRs = myStmt.executeQuery(query);
			
			while (myRs.next()) {
				item.setItemID(myRs.getString("itemID"));
				item.setName(myRs.getString("name"));
				item.setOwnerID(myRs.getString("owner"));
				item.setCategory(myRs.getString("category"));
				item.setItemValue(myRs.getString("item_value"));
				item.setCondition(myRs.getString("item_condition"));
				item.setDecription(myRs.getString("description"));
				item.setPicture(myRs.getString("picture"));
			}
			return item;
		}
		catch (Exception  exc){
			exc.printStackTrace();
			return null;
		}
	}
	//##################################################################################################################################################
	public Requests getRequestByID(String requestID) {
		String query = "SELECT * FROM requests Where requestID ='" + requestID + "'";
		Requests request = new Requests();
		try {
			Statement myStmt = myCon.createStatement();
			ResultSet myRs = myStmt.executeQuery(query);
			
			while (myRs.next()) {
				request.setRequestID(myRs.getString("requestID"));
				request.setItemID(myRs.getString("itemID"));
				request.setOwnerID(myRs.getString("owner"));
				request.setBorrowerID(myRs.getString("borrower"));
				request.setPeriod(myRs.getString("period"));
				request.setDate(myRs.getString("date"));
				request.setResponse(myRs.getString("response"));
			}
			return request;
		}
		catch (Exception  exc){
			exc.printStackTrace();
			return null;
		}
	}
	//##################################################################################################################################################
	public List<Items> getItemsByUserID(String userID) {
		String query = "SELECT * FROM items Where owner ='" + userID + "'";
		Items item = new Items();
		List<Items> itemsList = new ArrayList<Items>();
		try {
			Statement myStmt = myCon.createStatement();
			ResultSet myRs = myStmt.executeQuery(query);
			
			while (myRs.next()) {
				item = new Items();
				item.setItemID(myRs.getString("itemID"));
				item.setName(myRs.getString("name"));
				item.setOwnerID(myRs.getString("owner"));
				item.setCategory(myRs.getString("category"));
				item.setItemValue(myRs.getString("item_value"));
				item.setCondition(myRs.getString("item_condition"));
				item.setDecription(myRs.getString("description"));
				item.setPicture(myRs.getString("picture"));
				if (!itemsList.equals(item))
					itemsList.add(item);
			}
			return itemsList;
		}
		catch (Exception  exc){
			exc.printStackTrace();
			return null;
		}
	}
	//##################################################################################################################################################
	public List<Requests> getRecievedRequestsByUserID(String userID) {
		String query = "SELECT * FROM requests Where owner ='" + userID + "'";
		Requests request = new Requests();
		List<Requests> requestsList = new ArrayList<Requests>();
		try {
			Statement myStmt = myCon.createStatement();
			ResultSet myRs = myStmt.executeQuery(query);
			
			while (myRs.next()) {
				request = new Requests();
				request.setRequestID(myRs.getString("requestID"));
				request.setItemID(myRs.getString("itemID"));
				request.setOwnerID(myRs.getString("owner"));
				request.setBorrowerID(myRs.getString("borrower"));
				request.setPeriod(myRs.getString("period"));
				request.setDate(myRs.getString("date"));
				request.setResponse(myRs.getString("response"));
				requestsList.add(request);
			}
			return requestsList;
		}
		catch (Exception  exc){
			exc.printStackTrace();
			return null;
		}
	}
	//##################################################################################################################################################	
	public List<Requests> getSentRequestsByUserID(String userID) {
		String query = "SELECT * FROM requests Where borrower ='" + userID + "'";
		Requests request = new Requests();
		List<Requests> requestsList = new ArrayList<Requests>();
		try {
			Statement myStmt = myCon.createStatement();
			ResultSet myRs = myStmt.executeQuery(query);
			
			while (myRs.next()) {
				request = new Requests();
				request.setRequestID(myRs.getString("requestID"));
				request.setItemID(myRs.getString("itemID"));
				request.setOwnerID(myRs.getString("owner"));
				request.setBorrowerID(myRs.getString("borrower"));
				request.setPeriod(myRs.getString("period"));
				request.setDate(myRs.getString("date"));
				request.setResponse(myRs.getString("response"));
				requestsList.add(request);
			}
			return requestsList;
		}
		catch (Exception  exc){
			exc.printStackTrace();
			return null;
		}
	}
	//##################################################################################################################################################
	private static String addQuery(String TableName, String columns[], String data[]) {
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
	private static String editQuery(String TableName,String TableKey, String columns[], String data[], String index) {// TODO: edit by item/user/req
		String query = "UPDATE `" + TableName + "` SET ";
		int i;
		for (i = 0; i < data.length - 1; i++) {
			query += columns[i] + " = '" + data[i] + "', ";
		}
		query += columns[i] + " = '" + data[i] + "'" + " WHERE " + TableName +"." + TableKey + " = " + index;
		return query;
	}
	//##################################################################################################################################################
	private String[] userToList(Users user) {
		String[] data = {"", "", "", "", "", "", "", "", "", ""}; //{"last_name", "first_name", "user_name", "password", "email", "city", "address", "phone", "gender", "privileges"};
		Object[] functions = {user.getLastName(), user.getFirstName(), user.getUserName(), user.getPassword(), user.getMail(), user.getCity(), user.getAddress(), user.getPhone(), user.getGender(), user.getPrivileges()};
		for (int i = 0; i < data.length; i++) {
			data[i] = (String) functions[i];
		}
		System.out.println("data list: " + data);
		return data;
	}
	//##################################################################################################################################################
	private String[] itemToList(Items item) {
		String[] data = {"", "", "", "", "", "", ""}; //{"name", "owner", "category", "item_value", "item_condition", "description", "picture"};
		Object[] functions = {item.getName(), item.getOwnerID(), item.getCategory(), item.getItemValue(), item.getCondition(), item.getDecription(), item.getPicture()};
		for (int i = 0; i < data.length; i++) {
			data[i] = (String) functions[i];
		}
		return data;
	}
	//##################################################################################################################################################
	private String[] requestToList(Requests request) {
		String[] data = {"", "", "", "", "", ""}; //{"itemID", "owner", "borrower", "period", "date", "response"};
		Object[] functions = {request.getItemID(), request.getOwnerID(), request.getBorrowerID(), request.getPeriod(), request.getDate(), request.getResponse()};
		for (int i = 0; i < data.length; i++) {
			data[i] = (String) functions[i];
		}
		return data;
	}
	//##################################################################################################################################################
}