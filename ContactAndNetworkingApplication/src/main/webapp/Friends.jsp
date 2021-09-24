<%@page import="com.contactandnetworkingapplication.model.User"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table border ="1" width="500" align="center">
         <tr bgcolor="00FF7F">
          <th><b>Friends</b></th>
         </tr>
        <%ArrayList<User> friends = 
            (ArrayList<User>)request.getAttribute("list");
        for(User u:friends){%>
        <%-- Arranging data in tabular form
        --%>
            <tr>
                <td><%=u.getName()%></td>
            </tr>
            <%}%>
        </table> 
	
</body>
</html>