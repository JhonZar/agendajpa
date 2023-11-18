<%@ page import="java.util.List" %>
<%@ page import="com.emergentes.entidades.Contacto" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    List<Contacto> lista = (List<Contacto>) request.getAttribute("contactos");
%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

    </head>
    <body>
        <div class="container mt-4">
            <h1 class="display-4">Listado de Contactos</h1>
            <p><a class="btn btn-success" href="MainController?action=add">Nuevo</a></p>

            <table class="table table-bordered table-striped">
                <thead class="thead-dark">
                    <tr>
                        <th>ID</th>
                        <th>Nombre</th>
                        <th>Teléfono</th>
                        <th>Correo</th>
                        <th></th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    <% for (Contacto item : lista) {%>
                    <tr>
                        <td><%= item.getId()%></td>
                        <td><%= item.getNombre()%></td>
                        <td><%= item.getTelefono()%></td>
                        <td><%= item.getCorreo()%></td>
                        <td><a class="btn btn-warning" href="MainController?action=edit&id=<%= item.getId()%>">Editar</a></td>
                        <td>
                            <a class="btn btn-danger" href="MainController?action=delete&id=<%= item.getId()%>"
                               onclick="return confirm('¿Está seguro?')">Eliminar</a>
                        </td>
                    </tr>
                    <% }%>
                </tbody>
            </table>
        </div>

    </body>
</html>
