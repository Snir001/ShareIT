<%@page import="model.Users"%>
<%model.Users u=(model.Users)request.getAttribute("show_user"); %>
User Name: <%out.print(u.getUserName()); %> <br>
First Name:<%out.print(u.getFirstName()); %> <br>
Last Name:<%out.print(u.getLastName()); %> <br>
Email:<%out.print(u.getMail()); %> <br>
City:<%out.print(u.getCity()); %> <br>
Address:<%out.print(u.getAddress()); %> <br>
Phone:<%out.print(u.getPhone()); %> <br>
Gender:<%out.print(u.getGender()); %> <br>


