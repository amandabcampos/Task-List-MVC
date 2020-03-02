<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<link rel="stylesheet" href="/style.css" />
</head>
<body>

	<%@ include file="partials/header.jsp"%>



	<form method="post">
		<div class="form-group">
			<label for="exampleInputEmail1">Description</label> <input
				type="text" class="form-control" id="exampleInputEmail1"
				aria-describedby="emailHelp" name="description">
		</div>
		<div class="form-group">
			<label for="exampleInputPassword1">Due Date</label> <input
				type="date" class="form-control" id="exampleInputPassword1"
				name="dueDate">
		</div>

		<div class="form-check">
			<input class="form-check-input" type="radio" name="completion"
				id="exampleRadios1" value="false" checked> <label
				class="form-check-label" for="exampleRadios1"> Incomplete </label>
		</div>
		<div class="form-check">
			<input class="form-check-input" type="radio" name="completion"
				id="exampleRadios2" value="true"> <label
				class="form-check-label" for="exampleRadios2"> Complete </label>
		</div>

		<input type="hidden" value="${user.id}" name="userId" /> <input
			type="hidden" value="${user.email}" name="email" /> <br />
		<button type="submit" class="btn btn-primary">Submit</button>
	</form>


	<%-- 


<form method="post">

<label>Description: </label>
<input type="text" name="description"/>
<label>Due date: </label>
<input type="date" name="dueDate"/>        <!--  maybe problem -->
<label>Completion: </label>
<p>Complete<input type="radio" name="completion" value="true"/></p>
<p>Incomplete<input type="radio" name="completion" value="false"/></p>
<input type="hidden" value="${user.id}" name="userId"/>
<input type="hidden" value="${user.email}" name="email"/>

<button type="submit">Submit</button>

</form>  --%>




</body>
</html>