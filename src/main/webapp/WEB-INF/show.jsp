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

	<h1><c:out value="${Question.question}"/></h1>
	
	<h2>Tags: </h2>
	
	<c:forEach items="${Questions.tags}" var="tag">
		<c:out value="${tag.subject}"/>
	</c:forEach>
	
	<table>
		<thead>
			<tr>
				<th>Answers</th>
			</tr>		
		</thead>
		
		<tbody>
			<c:forEach items="${Questions.answer}" var="a">
				<tr>
					<td><c:out value="${a.answer}"/></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<h2>Add your answer:</h2>
	
	<form:form action="/addAnswer" method="POST" modelAttribute="answer">
		<p>
			<form:label path="answer">Answer:</form:label>
			<form:input path="answer"/>
			<form:errors path="answer"></form:errors>
		</p>
		
		<input type="submit" value="Answer it!">
	
	</form:form>

</body>
</html>