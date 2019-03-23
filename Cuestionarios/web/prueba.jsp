<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
            <c:out value="${Usuario.idUsuario}"/>
            <c:out value="${Usuario.passwordUsuario}"/>
            <c:out value="${Usuario.categoriaUsuario}"/>
            <c:out value="${Usuario.idPersona.nombre}"/>
            <c:out value="${Usuario.idPersona.apellidoPaterno}"/>
            <c:out value="${Usuario.idPersona.apellidoMaterno}"/>
        
    </body>
</html>
