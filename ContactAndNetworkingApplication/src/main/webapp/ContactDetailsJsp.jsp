<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%-- <%@page import="net.javaguides.jsp.jdbc.database.*"%> --%>
<%@page import="com.codefury.dao.ContactDAOImpl" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ContatcDetails</title>
</head>
<body>

 <jsp:useBean id="contact" class="com.codefury.beans.Contacts" />
  

 <jsp:setProperty property="*" name="contact" />
 
</body>
</html>
    