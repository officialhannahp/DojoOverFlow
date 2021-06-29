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
	<h1>Questions Dashboard</h1>
	
	<table>
		<thead>
			<tr>
				<th>Questions</th>
				<th>Tags</th>
			</tr>		
		</thead>
		
		<tbody>
			<c:forEach items="${Questions}" var="q">
				<tr>
					<td> <a href="/questions/${q.id}">${q.question}</a></td>
						<%-- <c:forEach items="${ }"
							<td><c:out value="${q.tag}"></c:out></td> --%>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<a href="/questions/new">New Questions</a>

</body>
</html>