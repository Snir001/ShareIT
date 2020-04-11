<!-- title -->
	<div class="w3-teal">

		<div class="w3-container">
			<h1>${param.title}</h1>
		</div>
	</div>


	<!--  Horizontal bar -->
	<div class="w3-bar w3-black">

		<a class="w3-bar-item w3-button w3-mobile w3-hide-large"
			onclick="toggle_menu()">&#9776;</a> 
			<a href="SearchServlet"	class="w3-bar-item w3-button w3-mobile w3-hover-green">Search</a> <a
			href="ExploreServlet" class="w3-bar-item w3-button w3-mobile">Explore</a> <a
			href="HelpServlet" class="w3-bar-item w3-button w3-mobile">Help</a>
			<a href='ProfileServlet' class='w3-bar-item w3-button w3-mobile w3-right'>
				<%
					if (session.getAttribute("name") != null)
						out.print(session.getAttribute("name") + "'s Profile");
					else
						out.print("Login ");
				%>
			</a>
		


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
		<a href="AddItemServlet" class="w3-bar-item w3-button">Add Item</a>
		<a href="MyItemsServlet" class="w3-bar-item w3-button">My Items</a> 
		<a href="RequestsServlet"	class="w3-bar-item w3-button">Requests</a>
		<a href="OffersServlet" class="w3-bar-item w3-button">Offers</a>
		<a href="LogoutServlet" class="w3-bar-item w3-button"> Logout </a>
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
	
	
