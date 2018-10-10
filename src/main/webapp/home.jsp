<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% response.setHeader("Cache-Control", "private, no-store, no-cache, must-revalidate"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Salary App</title>
</head>
<body>
	<h1> Salary Application </h1>
	
	<c:choose>
		<c:when test="${username!=null}">
			<p>Welcome, <c:out value="${username}"/></p>
			<form action="logout" method="POST">
		    	<input type="submit" value="Logout">
		    </form>
		    <br>
			<form action="addSalaryPage" method="POST">
				<input type="submit" value="Add Salary">
			</form>
			<br>
		</c:when>
		<c:otherwise>
			<p>Want to add a salary? 
				<a href="loginPage">Login<a> /
				<a href="registerPage">Register<a>
			</p>
		</c:otherwise>
	</c:choose>
	
	<!-- Search salaries form -->
	<form action="searchSalary" method="POST">	
	    <label for="position">position: </label>
	    <input type="text" name="position">
	    
	    <!-- Drop down menu with all companies -->
	    <label for="company">company: </label>
	    <select name="company">
		  <option value="all">all</option>
		  <c:forEach var="company" items="${companies}">
		  	<option value=${company.companyName}> 
		  		<c:out value="${company.companyName}"/> 
		  	</option>
		  </c:forEach>
		</select>
		
		<!-- Drop down menu with all cities -->
		<label for="city">city: </label>
	    <select name="city">
		  <option value="all">all</option>
		  <c:forEach var="city" items="${cities}">
		  	<option value=${city.city}> 
		  		<c:out value="${city.city}"/> 
		  	</option>
		  </c:forEach>
		</select>
	    <input type="submit" value="Search">	                
    </form>
    
    <!-- Salaries result table -->
    <table>
            <tr>
                <th>Position</th>
                <th>Company</th>
                <th>City</th>
                <th>Salary</th>
            </tr>
            <c:forEach var="salaryEntry" items="${salaryEntries}">
                <tr>
                    <td><c:out value="${salaryEntry.position}"/></td>
                    <td><c:out value="${salaryEntry.company.companyName}"/></td> 
                    <td><c:out value="${salaryEntry.city.city}"/></td>
                    <td><c:out value="${salaryEntry.salary}"/></td>
                </tr>
            </c:forEach>
        </table>
	
</body>
</html>