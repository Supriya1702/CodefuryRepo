<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Main page</title>
</head>
<body>
	<div align="right">
	<input type="button" value = "Profile" />
	<input type="button" value = "Logout" />
	</div>
	<div>
		<h1>Name<input type="text" value=""></h1><br/>
		E-mail<input type="text" value=""><br/>
		Phone<input type="number" value="">
	<br/>
	</div>
	<br/><br/><br/><br/>
	<table>
	<tr>
	<div class="cards">
		<td>
		<div class="card">
			<img src="https://cdn0.iconfinder.com/data/icons/business-dual-color-glyph-set-2/128/Address_book-512.png" style="width:20%","height:20%" class="card_image">
			<div class="content">
				<a href="#">View Contacts</a>
			</div>
		</div>
		</td>

		<td>
		<div class="card">
			<img src="https://cdn2.iconfinder.com/data/icons/bussiness-management-supersolid/24/add_add_contact_create_new_person_user_add_friend-512.png" style="width:25%","height:10%" class="card_image">
			<div class="content">
				<a href="#">Add New Contact</a>
			</div>
		</div>
		</td>

		<td>
		<img src="https://library.kissclipart.com/20180829/ike/kissclipart-search-user-icon-clipart-computer-icons-user-761033d83b6b74f8.png" style="width:20%","height:10%" class="card_image">

<form action="SearchServlet" method="post">  
   <input type="text" name="search"> 
   <select name="select" id="select">
  <option value="city">City</option>
  <option value="state">State</option>
  <option value="company">Company</option>
</select>
 <input type="submit" value=Submit>
</form>
		</td>
	</tr>

	<tr>

		<td>
		<div class="card">
			<img src="https://icon-library.com/images/connect-icon-png/connect-icon-png-18.jpg" style="width:20%","height:20%" class="card_image">
			<div class="content">
				<a href="#">View Friends</a>
			</div>
		</div>
		</td>

		<td>
		<div class="card">
			<img src="https://static.thenounproject.com/png/2714894-200.png" style="width:20%","height:20%" class="card_image">
			<div class="content">
				<a href="#">View Friend Requests</a>
			</div>
		</div>
		</td>

		<td>
		<div class="card">
			<img src="https://cdn.iconscout.com/icon/premium/png-512-thumb/block-person-1446662-1222337.png" style="width:20%","height:20%" class="card_image">
			<div class="content">
				<a href="#">Blocked Users</a>
			</div>
		</div>
		</td>

	</tr>

	</div>

	</table>

</body>
</html> 