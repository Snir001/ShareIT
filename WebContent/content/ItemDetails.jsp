<%@page import="model.Users"%>
<%@page import="model.Items"%>
<%  
model.Model mod = (model.Model)getServletContext().getAttribute("model");

Items item=(Items)request.getAttribute("item");
out.print("Item ID: "+item.getItemID()+"<br>");
out.print("Item Name: "+item.getName()+"<br>");
out.print("Item Owner: <a href='ProfilePageServlet?user_name="+mod.getUserByID(item.getOwnerID()).getUserName()+"'>"+mod.getUserByID(item.getOwnerID()).getUserName()+"</a><br>"
);
out.print("Item Value: "+item.getItemValue()+"$<br>");
out.print("Item Condition: "+item.getCondition()+"<br>");
out.print("Item Category: "+item.getCategory()+"<br>");
out.print("Item Description: "+item.getDecription()+"<br>");

String url=request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath()+"/images/";
String pictureUrl;
if(item.getPicture().equals("1")) {
	pictureUrl=url+item.getItemID();
} else{
	pictureUrl=url+"default";
}
out.print("<img src='" + pictureUrl + "' class='w3-round w3-padding-16' height='150' width='150'><br>");

if(session!=null) {
	Users user=(Users)session.getAttribute("user");
	if(user!=null) {
		if(user.getPrivileges().equals("0")||user.getUserID().equals(item.getOwnerID())){
			out.print("<a href='RemoveItemServlet?item_id="+item.getItemID()+"'><button class='w3-button w3-border w3-hover-red'>Remove Item</button></a><br>");
		}
		if(!user.getUserID().equals(item.getOwnerID())){
			out.print("<a href='ReqestItemServlet?id="+item.getItemID()+"'><button class='w3-button w3-border w3-hover-purple'>Request Item</button></a><br>");
		}
						
	}
}
//TODO: add option to delete for the owner
%>  
