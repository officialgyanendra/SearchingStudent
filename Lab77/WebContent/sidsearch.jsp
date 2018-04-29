<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body><center>
<br><h1>Java Learning Center<br/>
<h2>Student Search Form</h2>
<form:form action="searchStudent.jlc" method="post" commandName="sidSearchCommand">
<table>
<tr><td><p>Enter Student ID:</td>
<td><form:input path="sid"/></td>
<td><font color="red" size="5"><form:errors path="sid"/>${msg}</font></td></tr>
<tr><td align="center" colspan="3"><input type="submit" value="Search"/></td></tr>

</table>
</form:form>
</center>
</body>
</html>