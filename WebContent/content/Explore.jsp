
<a href="ProfileServlet"> users only!</a>
<a href="ExploreServlet"> Explore Page </a>
<!-- Items -->
<h3 class="w3-margin">New Items!</h3>
<div class='w3-row'>
	<%
				for (int i = 0; i < 4; i++) {
					out.print("<div class='w3-col s12 m4 l3 w3-center w3-card-4' style=''>");
					out.print("<a href=ItemDetails?id="+i+"><img src='photos/ladder.jpg' class='w3-round w3-padding-16' height='150' width='150'>");
					out.print("<h5>item " + i + "</h5>");
					out.print("</div>");

				}
	%>

</div>
<!--
<div class="w3-row">
  <div class="w3-col m1 w3-center w3-grey">1</div>
  <div class="w3-col m1 w3-center">2</div>
  <div class="w3-col m1 w3-center w3-grey">3</div>
  <div class="w3-col m1 w3-center">4</div>
  <div class="w3-col m1 w3-center w3-grey">5</div>
  <div class="w3-col m1 w3-center">6</div>
  <div class="w3-col m1 w3-center w3-grey">7</div>
  <div class="w3-col m1 w3-center">8</div>
  <div class="w3-col m1 w3-center w3-grey">9</div>
  <div class="w3-col m1 w3-center">10</div>
  <div class="w3-col m1 w3-center w3-grey">11</div>
  <div class="w3-col m1 w3-center">12</div>
</div>
-->


