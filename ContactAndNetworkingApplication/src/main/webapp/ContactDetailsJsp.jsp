<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%-- <%@page import="net.javaguides.jsp.jdbc.database.*"%> --%>
<%@page import="com.codefury.dao.ContactDAOImpl" %>
<%@page import="com.codefury.beans.Contacts" %>
<%@page import="java.util.List" %>
<%@page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ContatcDetails</title>
</head>
<body>

 <jsp:useBean id="contact" class="com.codefury.beans.Contacts" />
  <%
  	ContactDAOImpl contactdaoImpl = new ContactDAOImpl();
  List<Contacts> contactList = new ArrayList<>();
  contactList= contactdaoImpl.getContacts();
  out.println("<H3>My Contact List</h3>");
  for (Contacts c :contactList){
	  System.out.println(c.getFullName());
	  out.print(c.getFullName()+" - "+c.getEmail()+"<br>");
  }
  	%>

 <jsp:setProperty property="*" name="contact" />
 
</body>
</html>
    