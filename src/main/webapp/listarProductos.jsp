<%-- 
    Document   : listarProductos.jsp
    Created on : 17/12/2022, 01:40:50 PM
    Author     : esteban gomez
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="co.com.konecta.models.Producto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<% 
    
   ArrayList<Producto> data = (ArrayList<Producto>) request.getAttribute("productos");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listar Productos</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
        <!-- JavaScript Bundle with Popper -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
        <link href="css/Style.css" rel="stylesheet" type="text/css"/>
        <script src="https://code.jquery.com/jquery-3.6.2.js" integrity="sha256-pkn2CUZmheSeyssYw3vMp1+xyub4m+e+QK4sQskvuo4=" crossorigin="anonymous"></script>
        <script>
            function editar(id){
                console.log(id);
            }
        </script>
    </head>
    <body>
        <div class="container mt-3">
            <nav class="nav nav-pills nav-justified mb-3">
                <a class="nav-link " href="index.jsp">Inicio</a>
                <a class="nav-link active" aria-current="page" href="#">Ver Productos</a>
                <a class="nav-link" href="crearProducto.jsp">Crear Producto</a>
                <a class="nav-link" href="ListCategoriesServlet">Vender Producto</a>
            </nav>
            <table class="table table-secondary">
                <thead>
                  <tr>
                    <th scope="col">Nombre del producto</th>
                    <th scope="col">Referencia</th>
                    <th scope="col">Precio</th>
                    <th scope="col">Peso</th>
                    <th scope="col">Categoria</th>
                    <th scope="col">Stock</th>
                    <th scope="col">Fecha de creacion</th>
                    <th scope="col"></th>
                  </tr>
                </thead>
                <tbody>
                    <c:forEach items="${productos}" var="producto">
                        <tr class="table-light">
                            <td>${producto.nombreProducto}</td>
                            <td>${producto.referenciaProducto}</td>
                            <td>${producto.precioProducto}</td>
                            <td>${producto.pesoProducto}</td>
                            <td>${producto.categoria}</td>
                            <td>${producto.stock}</td>
                            <td>${producto.fechaCreacion}</td>
                            <td>
                                <a type="button" class="btn btn-primary btn-sm" href="ListProductServlet?id=${producto.id}">Editar</a>
                                <a type="button" class="btn btn-danger btn-sm" href="DeleteProductServlet?idDelete=${producto.id}">Eliminar</a>
                            </td>
                        </tr>
                    </c:forEach>
                  </tr>
                </tbody>
              </table>
            
            
           
        </div>
    </body>
</html>
