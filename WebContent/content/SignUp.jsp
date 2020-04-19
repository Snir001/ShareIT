<div class="w3-third">
<form action="SignUpHandlerServlet" method="post">
<label>User Name:</label> <input type="text" name="user_name" class="w3-input w3-border"><br>
<label>First Name:</label><input type="text" name="first_name" class="w3-input w3-border"><br>
<label>Last Name:</label><input type="text" name="last_name" class="w3-input w3-border"><br>
<label>Password:</label><input type="password" name="password" class="w3-input w3-border"><br>
<label>Gender: </label>
<lable>
<input type="radio" id="male" name="gender" value="male">
<label for="male">Male</label>
<input type="radio" id="female" name="gender" value="female">
<label for="female">Female</label>
<input type="radio" id="other" name="gender" value="unicorn">
<label for="other">Unicorn</label><br>
</lable><br>

<label>E-Mail:</label><input type="text" name="mail" class="w3-input w3-border"><br>
<label>City:</label><input type="text" name="city" class="w3-input w3-border"><br>
<label>Address:</label><input type="text" name="address" class="w3-input w3-border"><br>
<label>Phone:</label><input type="text" name="phone" class="w3-input w3-border"><br>

<input type="submit" value="submit"> <input type="reset" value="reset">
</form>
</div>
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