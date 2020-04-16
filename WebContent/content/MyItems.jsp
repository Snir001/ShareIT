 this is list of ${name} items
<div class="w3-row">
	<%
	model.Items[] items=(model.Items[])request.getAttribute("items");
String url=request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath()+"/images/";
String pictureUrl;
for(int i=0;i<items.length;i++){
	if(items[i].getPicture().equals("1")) {
		pictureUrl=url+items[i].getItemID();
	} else{
		pictureUrl=url+"default";
	}
		out.print("<div class='w3-col s12 m4 l3 w3-center w3-card-4' style=''>");
		out.print("<img src='" + pictureUrl + "' class='w3-round w3-padding-16' height='42' width='42'>");
		out.print("<h5>item " + i + "</h5></div>");
	}
%>

</div>
