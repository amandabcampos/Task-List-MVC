<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<link rel="stylesheet" href="/style.css"/>
</head>
<body>


<%@ include file="partials/header.jsp"%>
	
	<table class="table">
		<thead>
			<tr>
				<th scope="col">Description</th>
				<th scope="col">Due Date</th>
				<th scope="col">Completion</th>
<!-- 				<th scope="col">Edit Completion</th>
				<th scope="col">Delete Task</th> -->
			</tr>
		</thead>
		<tbody>
			<c:forEach var="thetask" items="${tasks}">
				<tr>
					<th scope="row">${thetask.description}</th>
					<td>${thetask.dueDate}</td>
					<td>${thetask.completion ? "Complete" : "Incomplete"}</td>
<%-- 					<td><a href="${user.id}/task/${thetask.id}/editcompletion">Edit</a></td>
					<td><a href="${user.id}/task/${thetask.id}/delete">Delete</a></td> --%>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<button><a href="/user/${user.id}">All Tasks</a></button>
	

</body>
</html>