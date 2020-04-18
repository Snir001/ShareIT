<%@page import="java.util.*"%>
<%@page import="model.Items"%>
<div class='w3-row'>
<%
	List<Items> results=(List<Items>)request.getAttribute("items");
	String url=request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath()+"/images/";
	String pictureUrl;
	Items  item;
	for(int i=0;i<results.size();i++){
		item=results.get(i);
		if(results.get(i).getPicture().equals("1")){
			pictureUrl=url+item.getItemID();
		}else {
			pictureUrl=url+"default";
		}
					out.print("<div class='w3-col s12 m4 l3 w3-center' style=''>");
					out.print("<div class='w3-card-4 w3-margin'>");
					out.print("<div style='height: 80%; width: 100%; object-fit: contain'>");
					out.print("<a href=ItemDetailsServlet?id="+item.getItemID()+"><img src='"+pictureUrl+"' class='w3-round w3-padding-16 ' height='150' width='150' >");
					out.print("</div>");
					out.print("<div style='height: 20%; width: 100%; object-fit: contain'>");
					out.print("<h5>" + item.getName() + "</h5>");
					out.print("</div>");
					out.print("</div>");
					out.print("</div>");
					//style='height: 100%; width: 80%; object-fit: contain'
		}
	%>
</div>