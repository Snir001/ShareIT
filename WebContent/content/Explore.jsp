<%@page import="java.util.List"%>

<a href="ProfileServlet"> users only!</a>
<a href="ExploreServlet"> Explore Page </a>
<!-- Items -->
<h3 class="w3-margin">New Items!</h3>
	<%
    model.Model mod = (model.Model)getServletContext().getAttribute("model");
	List<model.Items> items=mod.getAllItemsList();
	request.setAttribute("items", items);
	%>
	<jsp:include page="ShowItems.jsp">
	<jsp:param value="${items}" name="items"/>
	</jsp:include>
	<%/*
	String url=request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath()+"/images/";
	String pictureUrl;

				for (int i = 0; i < 4; i++) {
					pictureUrl=url+"default";
					out.print("<div class='w3-col s12 m4 l3 w3-center' style=''>");
					out.print("<div class='w3-card-4 w3-margin'>");
					out.print("<div style='height: 80%; width: 100%; object-fit: contain'>");
					out.print("<a href=ItemDetailsServlet?id="+i+"><img src='"+pictureUrl+"' class='w3-round w3-padding-16' style='height: 100%; width: 80%; object-fit: contain'>");
					out.print("</div>");
					out.print("<div style='height: 20%; width: 100%; object-fit: contain'>");
					out.print("<h5>item " + i + "</h5>");
					out.print("</div>");
					out.print("</div>");
					out.print("</div>");

				}
				*/
	%>


