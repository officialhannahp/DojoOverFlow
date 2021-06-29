<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/.css">
<title>Insert title here</title>
</head>


<body>

	<h1>What is your question?</h1>
	
	<form:form action="/createQuestion" method="POST" modelAttribute="newQuestion">
		<p>
			<form:label path="question">Question:</form:label>
			<form:input path="question"/>
			<form:errors path="question"></form:errors>
		</p>
		
		<p>
			<form:label path="tagsInput">Tags:</form:label>
			<form:input path="tagsInput"/>
			<form:errors path="tagsInput"></form:errors>		
		</p>
		
		<input type="submit" value="Submit">
	
	</form:form>

</body>
</html>