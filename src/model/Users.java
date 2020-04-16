package model;


public class Users extends User {
	private String userID;
	private String lastName;
	private String firstName;
	private String userName;
	private String password;
	private String mail;
	private String city;
	private String address;
	private String phone;
	private String gender;
	private String privileges;
	
	public Users() {
		userID = null;
		lastName = null;
		firstName = null;
		userName = null;
		password = null;
		mail = null;
		city = null;
		address = null;
		phone = null;
		gender = null;
		privileges = null;
	}
	
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String last_name) {
		this.lastName = last_name;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String first_name) {
		this.firstName = first_name;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPrivileges() {
		return privileges;
	}
	public void setPrivileges(String privileges) {
		this.privileges = privileges;
	}
	public String printUser() {
		String details = this.getUserID();
		details += "\n" + this.getLastName();
		details += "\n" + this.getFirstName();
		details += "\n" + this.getUserName();
		details += "\n" + this.getPassword();
		details += "\n" + this.getMail();
		details += "\n" + this.getCity();
		details += "\n" + this.getAddress();
		details += "\n" + this.getPhone();
		details += "\n" + this.getGender();
		details += "\n" + this.getPrivileges();
		System.out.println(details);
		return details;
	}
	
}
