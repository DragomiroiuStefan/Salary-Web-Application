<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add salary</title>
</head>
<body>
	<form action="addSalary" method="POST">
		<label for="position">position: </label>
	    <input type="text" name="position">
	    <br/>
	    <label for="company">company: </label>
	    <input type="text" name="company">
	    <br/>
	    <label for="city">city: </label>
	    <input type="text" name="city">
	    <br/>
	    <label for="salary">salary: </label>
	    <input type="text" name="salary">
	    <br/>
		<input type="submit" value="Add Salary">
	</form>
	<c:out value="${message}"/>
</body>
</html>