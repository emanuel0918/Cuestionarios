<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Evaluaciones</title>
    </head>
    <body class="container center-block" >
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <a class="navbar-brand" href="#">
                <img src="user.png" width="30" height="30" class="d-inline-block align-top" alt="">
                <c:out value="${User.idPersona.nombre}"/> <c:out value="${User.idPersona.apellidoPaterno}"/>
            </a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
                <div class="navbar-nav">
                    <a class="nav-item nav-link active" href="homeAlumno.jsp">Home<span class="sr-only">(current)</span></a>
                    <a class="nav-item nav-link" href="controladorMaterias">Cuestionarios</a>
                    <a class="nav-item nav-link" href="#">Pricing</a>
                    <a class="nav-item nav-link disabled" href="#">Disabled</a>
                </div>
            </div>
        </nav>
        <div class="container center-block">
            <div class="row">
                <h1>Lista de Evaluaciones</h1>
                <table class="table table-bordered table-striped table-hover">
                    <thead>
                        <tr>
                            <th>Cuestionario</th>
                            <th>Calificaion</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${listaEvaluaciones}" var="Evaluacion">
                            <tr>
                                <td><c:out value="${Evaluacion.idCuestionario.nombreCuestionario}" /></td>
                                    <td><c:out value="${Evaluacion.calificacionEvaluacion}" /></td>                               
                            </tr>                           
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>   
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    </body>
</html>
