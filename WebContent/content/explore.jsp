	
		<form method="get" action="displayName">
			<input type="text" name="name" /> <br> <input type="submit"
				value="Send" />
		</form>
		<a href="ProfileServlet"> users only!</a>
		<a href="ExploreServlet"> Explore Page </a>
		<!-- Items -->
		<h3 class="w3-margin">New Items!</h3>
		<div class='w3-row-padding'>
			<%
				for (int i = 0; i < 4; i++) {
					out.print("<div class='w3-col w3-center w3-card-4 w3-margin s12 m6 l4' style=''>");
					out.print("<img src='photos/ladder.jpg' class='w3-round w3-padding-16'>");
					out.print("<h5>item " + i + "</h5></div>");
				}
			%>


		</div>


