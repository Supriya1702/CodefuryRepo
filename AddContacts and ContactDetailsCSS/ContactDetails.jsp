<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%-- <%@page import="net.javaguides.jsp.jdbc.database.*"%> --%>
<%@page import="com.contactandnetworkingapplication.dao.ContactDAOImpl" %>
<%@page import="com.contactandnetworkingapplication.model.Contacts" %>
<%@page import="java.util.List" %>
<%@page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ContatcDetails</title>
<link href="conDetailscss.css" rel="stylesheet"></link> 
</head>

<body>


 <jsp:useBean id="contact" class="com.contactandnetworkingapplication.model.Contacts" />
  <%
    //HttpSession session = request.getSession(true);
	int id=(int) session.getAttribute("id");
	//User u = new User();
	//u.setId(id);
	System.out.println("user id a "+ id);
	
  	ContactDAOImpl contactdaoImpl = new ContactDAOImpl();
  List<Contacts> contactList = new ArrayList<>();
  contactList= contactdaoImpl.getContacts(id);
  //out.println("<H3>My Contact List</h3>");
  %>
  
  <c:url var="delContacts" value="AddContact">
  						<c:param name="option" value="delete"></c:param>
  						<c:param id= "listContact" name="listContact" ></c:param>
				</c:url>
	
  <H3>My Contact List</h3>
  <table>
  <tr>
  		
  		<th>Name</th>
  		<th>Email</th>
  		<th>Select</th>
  		<!-- <th>View</th> -->
  	</tr>
  	
  <% 
  
  for (Contacts c :contactList){
	 // System.out.println(c.getFullName());
	 String butId="but"+c.getContact_id();
	  %>
	  <tr>
	  		<td><%= c.getFullName()%></td>
	  		<td><%=c.getEmail()%></td>
	  		
	  		<td><input type="checkbox" id ="chbox" class ="selectedContact" value=<%=  c.getContact_id() %>></td>
	  		<td><button id="<%= butId %>" onclick="showDetails(<%= c.getContact_id() %>)">View Details</button></td>
	  	</tr>	
	  	<tr  colspan=4 style="display:none" id=<%= c.getContact_id() %>>
	  		<td></td>
			<td >
			<ul >
			<li><B>Phone No: </B><%= c.getPhone_no()%></li>
	  		<li><B>gender: </B><%=c.getGender()%></li>
	  		<li><B>dateOfBirth: </B><%=c.getDateOfBirth()%></li>
	  		<li><B>Address: </B><%=c.getAddress()%></li>
	  		<li><B>city: </B><%=c.getCity()%></li>
	  		<li><B>state: </B><%=c.getState()%></li>
	  		<li><B>country: </B><%=c.getCountry()%></li>
	  		<li><B>company: </B><%=c.getCompany()%></li>
	  		</ul>
	  		</td>
	  		<%-- <td><B>contactImage: </B><%=c.getContactImage()%></td> --%>
	  		
	  		
	  	</tr>
	  	
	  <% 
	  //out.print(c.getFullName()+ " - "+c.getEmail()+"<br>");
  }
  	%>
  	<button onclick="dt()">D T</button>
  	
  	</table>
  	<button  onclick="deleteContact()" window.location.href='${delContacts}'>Delete Selected</button>

 <jsp:setProperty property="*" name="contact" />
 
 <script> function showDetails(contact_id){
	console.log("in showDetails");
	if(document.getElementById(contact_id).style.display=="none"){
		document.getElementById(contact_id).style.display="block";
		//this.value="Hide Details";
		document.getElementById("but"+contact_id).innerText="Hide Details";
	}
	else if(document.getElementById(contact_id).style.display=="block"){
		document.getElementById(contact_id).style.display="none";
		document.getElementById("but"+contact_id).innerText="View Details";
	}
}
 
 function deleteContact(){
	// while(document.getElementById())
	var list = document.getElementsByClassName("selectedContact");
	var deleteContacts = [];
	var delCon = "";
	//console.log(list)
	for (var i =0; i<list.length; i++){
		if(list[i].checked==true){
			delCon = delCon + list[i].value + ", " ;
			deleteContacts.push(list[i].value)
			console.log(list[i].value)
		}
	}
	if(deleteContacts != null){
		console.log(deleteContacts);
	document.getElementById("listContact").value = deleteContacts;
	return true;
	}
	else{return false;}
	console.log(delCon);
	
 }

 </script>

</body>
</html>
    