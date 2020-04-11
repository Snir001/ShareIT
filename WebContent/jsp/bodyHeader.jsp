<!-- title -->
	<div class="w3-teal">

		<div class="w3-container">
			<h1>My Page ${param.title} </h1>
		</div>
	</div>


	<!--  Horizontal bar -->
	<div class="w3-bar w3-black">

		<a class="w3-bar-item w3-button w3-mobile w3-hide-large"
			onclick="toggle_menu()">&#9776;</a> <a href="#"
			class="w3-bar-item w3-button w3-mobile w3-hover-green">Search</a> <a
			href="#" class="w3-bar-item w3-button w3-mobile">Explore</a> <a
			href="#" class="w3-bar-item w3-button w3-mobile">Help</a>
		<%
			//TODO: add page search!
		%>
		<%
			//TODO: add page explore!
		%>
		<%
			//TODO: add page Help!
		%>

		<%
			if (session.getAttribute("name") != null)
				out.print("<a href='#' class='w3-bar-item w3-button w3-mobile w3-right'> Welcome "
						+ session.getAttribute("name") + " </a>");
			else
				out.print("<a href='login.html' class='w3-bar-item w3-button w3-mobile w3-right'> Login </a>");
		%>
		


	</div>



	<!-- Navigation bar -->
	<%
		//TODO: navigation bar dot have top whcn scrolling down
	%>
	<div
		class="w3-sidebar w3-bar-block w3-collapse w3-card w3-animate-left"
		style="width: 250px;" id="mySidebar">
		<!--<button class="w3-bar-item w3-button w3-large w3-hide-large"
				onclick="w3_close()">Close &times;</button>  -->
		<!-- 	<form action="ControllerServlet" method="post">
				Name:<input type="text" name="name"><br> Password:<input
				type="password" name="password"><br> <input
				type="submit" value="login">
				</form>
			-->
		<a href="#" class="w3-bar-item w3-button">Add Item</a>
		 <a href="#" class="w3-bar-item w3-button">My Items</a> <a href="#"
			class="w3-bar-item w3-button">Requests</a>
			 <a href="#" class="w3-bar-item w3-button">Offers</a>
			  <a href="LogoutServlet"	class="w3-bar-item w3-button"> Logout </a>
		<%//TODO: add page Add Item!%>
		<%//TODO: add page Requests!%>
		<%//TODO: add page offers!%>
		<%//TODO: add page my items!%>


	</div>
	<script>
		function w3_open() {
			document.getElementById("mySidebar").style.display = "block";
		}

		function w3_close() {
			document.getElementById("mySidebar").style.display = "none";
		}

		function toggle_menu() {
			if (document.getElementById("mySidebar").style.display
					.localeCompare("block") == 0) {
				document.getElementById("mySidebar").style.display = "none";
				return;
			} else {
				//if not defined yet or none, make it block
				document.getElementById("mySidebar").style.display = "block";
				return;
			}
		}
	</script>
	
	
