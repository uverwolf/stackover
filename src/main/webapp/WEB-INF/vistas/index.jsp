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
<title>Dashboard</title>
</head>
<body>
    <div class="container-fluid ">
        <h1 class="display-4">Preguntas</h1>
        <table class="table table-dark">
            <thead class="thead-light">
                <tr>
                    <th>Pregunta</th>
                    <th>Temas</th>
                   
                </tr>
            </thead>
            <tbody>
            <c:forEach items="${preguntas}" var="preguntas">
         
              <tr>   
                    <td><a href="questions/ver/<c:out value="${preguntas.id}"/>"><c:out value="${preguntas.question}"/> </a></td>
                     <td><c:out value="${preguntas.getTags().get(0).getSubject()}"/> </td>
                     
              </tr>
            </c:forEach>

            </tbody>
        </table>
        <a class="btn btn-success" href="/questions/new">Crear pregunta</a>
    </div>
</body>
</html>