<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- CSS only -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">

<!-- JS, Popper.js, and jQuery -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
<title><c:out value="${pregunta.question}"></c:out> </title>
</head>
<body>
    <div class="container-fluid text-center">

        <h1 class="display-4"><c:out value="${pregunta.question}"/></h1>
        <div class="d-flex flex-row">
            <h2>Tags:</h2><h2 class=" bg bg-info text-light ml-5  px-2 py-2 border border-dark"><c:out value="${pregunta.getTags().get(0).getSubject()}"/></h2>
        </div>
        <div class="row">
            <div class="bg bg-dark col-6 jumbotron">
                <h1 class="display-4 text-light">Respuestas</h1>
                <hr class="my-4">
				<c:forEach items="${respuestas}" var="respuestas">
					<p class="lead text-light"> <c:out value="${respuestas.answer}"></c:out> </p>
				</c:forEach>

            </div>


            <div class="col-6 jumbotron">
                <h1 class="display-4">Agrega una respuesta</h1>
				<form:form action="/questions/ver/${pregunta.id}" method="post" modelAttribute="respuesta">
			     	  <div class="form-group">
			     	  <form:input path="question" type="hidden" value ="${pregunta.id }"/>
			          <form:textarea class="form-control" path="answer"/>
			          <small id="helpId" class="form-text text-muted">Trata de ser lo mas claro posible al responder!</small>
					  </div>
			        <input type="submit" class="btn btn-success">
			        <a class="btn btn-info" href="/questions"> volver</a>
			       
      			</form:form>                
                
            </div>
        </div>

    </div>
</body>
</html>