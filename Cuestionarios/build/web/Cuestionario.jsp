<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cuestionario</title>
    </head>
    <body class="container center-block" >
        <div class="container center-block">
           <%-- <c:forEach begin="0" end="0" items="${listaOpciones}" var="Opcion">
                <h1>Cuestionario:<c:out value="${Opcion.idPreguntas.idCuestionario.nombreCuestionario}"/></h1>
            </c:forEach>--%>
           <h1>Cuestionario:<c:out value="${NombreCuestionario}"/></h1>
            <p>Conteste las siguinetes preguntas:</p>
            <form  method="GET" action="controladorRegistraEvaluacion">
                <div class="form-row">
                    <c:forEach items="${listaOpciones}" var="Opcion">
                        <label class="my-1 mr-2" for="inlineFormCustomSelectPref"><c:out value="${Opcion.idPreguntas.pregunta}"/>:</label><br>
                        <select name="Respuesta${Opcion.idPreguntas.idPreguntas}" class="custom-select my-1 mr-sm-2" id="inlineFormCustomSelectPref">
                            <option selected>Choose...</option>
                            <option value="${Opcion.opcion1}"><c:out value="${Opcion.opcion1}"/></option>
                            <option value="${Opcion.opcion2}"><c:out value="${Opcion.opcion2}"/></option>
                            <option value="${Opcion.opcion3}"><c:out value="${Opcion.opcion3}"/></option>
                            <option value="${Opcion.opcion4}"><c:out value="${Opcion.opcion4}"/></option>                           
                        </select>
                        <br>
                    </c:forEach>
                   <%-- <c:forEach begin="0" end="0" items="${listaOpciones}" var="Opcion">
                        <input id="Cuestionarioid" name="Cuestionarioid" type="hidden" value="${Opcion.idPreguntas.idCuestionario.idCuestionario}">
                    </c:forEach> --%>  
                   <input id="Cuestionarioid" name="Cuestionarioid" type="hidden" value="${idCuestionario}">
                </div>
                <br>
                <p style="text-align: center"><button type="submit" class="btn btn-primary my-1">Enviar Respuestas</button></p>
            </form>
        </div>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"/>
    </body>
</html>
