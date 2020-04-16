<form action="AddItemHandlerServlet" method="post">
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

<input type="submit" value="submit"> <input type="reset" value="reset">
</form>
<% 
/*
private String userID;
private String last_name;
private String first_name;
private String userName;
private String password;
private String mail;
private String city;
private String address;
private String phone;
private String gender;
*/
%>