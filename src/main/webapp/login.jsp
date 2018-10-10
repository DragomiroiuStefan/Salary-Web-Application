<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<% response.setHeader("Cache-Control", "private, no-store, no-cache, must-revalidate"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	<form action="login" method="POST">
	    <label for="username">username: </label>
	    <input type="text" name="username"><br>
	    <label for="password">password: </label>
	    <input type="password" name="password"><br>
	    <input type="submit" value="Login">	                
    </form>
    <c:out value="${message}"/>
</body>
</html>