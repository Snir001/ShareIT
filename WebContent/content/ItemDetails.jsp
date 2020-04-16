<%@page import="model.Items"%>
<%  
Items item=(Items)request.getAttribute("item");
out.print("Item ID: "+item.getItemID()+"<br>");
out.print("Item Name: "+item.getName()+"<br>");
out.print("Item Owner: "+item.getOwnerID()+"<br>");
out.print("Item Value: "+item.getItemValue()+"<br>");
out.print("Item Condition: "+item.getCondition()+"<br>");
out.print("Item Category: "+item.getCategory()+"<br>");
String url=request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath()+"/images/";
String pictureUrl;
if(item.getPicture().equals("1")) {
	pictureUrl=url+item.getItemID();
} else{
	pictureUrl=url+"default";
}
out.print("<img src='" + pictureUrl + "' class='w3-round w3-padding-16' height='150' width='150'>");



%>  
<a href="ReqestItemServlet">Request Item</a>