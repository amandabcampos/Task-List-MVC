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

<div class="card" style="width: 18rem;">
  <div class="card-header">
    ${user.name}
  </div>
  <ul class="list-group list-group-flush">
    <li class="list-group-item">${user.email}</li>
  </ul>
  <ul class="list-group list-group-flush">
    <li class="list-group-item"><a class="btn btn-danger" href="/logout">Logout</a></li>
  </ul>  
</div>



<br/>




</body>
</html>