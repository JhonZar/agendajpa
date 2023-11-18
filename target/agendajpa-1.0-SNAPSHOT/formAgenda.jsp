<%@ page import="com.emergentes.entidades.Contacto" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Contacto contacto = (Contacto) request.getAttribute("contacto");
%>
<html>
    <head>
        <!-- Agrega tus enlaces a Bootstrap aquí si es necesario -->
        <title>Editar Contacto</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    </head>
    <body>


        <div class="container mt-3">
            <h1 class="display-4">Editar Contacto</h1>
            <form class="mt-4" action="MainController" method="post">
                <input type="hidden" name="id" value="<%= contacto.getId()%>">

                <div class="form-group">
                    <label for="nombre">Nombre:</label>
                    <input type="text" class="form-control" name="nombre" value="<%= contacto.getNombre()%>" required>
                </div>

                <div class="form-group">
                    <label for="telefono">Teléfono:</label>
                    <input type="text" class="form-control" name="telefono" value="<%= contacto.getTelefono()%>" required>
                </div>

                <div class="form-group">
                    <label for="correo">Correo:</label>
                    <input type="text" class="form-control" name="correo" value="<%= contacto.getCorreo()%>" required>
                </div>

                <button type="submit" class="btn btn-primary">Guardar</button>
            </form>
        </div>

    </body>
</html>
