<form action="AddItemHandlerServlet" method="post" enctype="multipart/form-data">
<div class="w3-third">
<label>Name:<input type="text" name="name" class="w3-input w3-border">
</label>
<label>Category:</label>
<select class="w3-select w3-border" name="category">
  <option value="" disabled selected>Choose your option</option>
  <option value="work">Work</option>
  <option value="kitchen">Kitchen</option>
  <option value="unicorns">Unicorns</option>
</select> 
<label>Item Value:</label>
<input type="text" name="value" class="w3-input w3-border">
<label>Condition:</label>
<select class="w3-select w3-border" name="condition">
  <option value="" disabled selected>Choose your option</option>
  <option value="new">As new</option>
  <option value="good">Good</option>
  <option value="used">Used</option>
  <option value="bad">Bad</option>
</select>
<label>Description:</label><input type="text" name="description" class="w3-input w3-border"><br>
<input type="file" name="file" value="explore" />
<br>
<input type="submit" value="submit"> <input type="reset" value="reset">
</div>
</form>