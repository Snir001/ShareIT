<form action="AddItemHandlerServlet" method="post" enctype="multipart/form-data">
Name:<input type="text" name="name"><br>
Category:
<select class="" name="category">
  <option value="" disabled selected>Choose your option</option>
  <option value="work">Work</option>
  <option value="kitchen">Kitchen</option>
  <option value="unicorns">Unicorns</option>
</select> <br>
Item Value:<input type="text" name="value"><br>
Condition:<select class="" name="condition">
  <option value="" disabled selected>Choose your option</option>
  <option value="new">As new</option>
  <option value="good">Good</option>
  <option value="used">Used</option>
  <option value="bad">Bad</option>
</select><br>
Description:<input type="text" name="description"><br>
<input type="file" name="file" value="explore" />
ItemId:<input type="text" name="itemid"><br>
<input type="submit" value="submit"> <input type="reset" value="reset">
</form>