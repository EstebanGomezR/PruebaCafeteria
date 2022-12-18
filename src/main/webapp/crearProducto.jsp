<%-- 
    Document   : crearProducto.jsp
    Created on : 17/12/2022, 11:29:05 AM
    Author     : esteban gomez
--%>

<%@page import="co.com.konecta.models.Categoria"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.ArrayList"%>
<%@page import="co.com.konecta.servlets.ListCategoriesServlet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% co.com.konecta.servlets.ListCategoriesServlet categoriesServlet = new ListCategoriesServlet();
    ArrayList<Categoria> categorias = categoriesServlet.obtainCategories();

%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
        <!-- JavaScript Bundle with Popper -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
        <link href="css/Style.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="container mt-3">
            <nav class="nav nav-pills nav-justified mb-3">
                <a class="nav-link " href="index.jsp">Inicio</a>
                <a class="nav-link" aria-current="page" href="ListProductServlet">Ver Productos</a>
                <a class="nav-link active" href="#">Crear Producto</a>
                <a class="nav-link" href="ListCategoriesServlet">Vender Producto</a>
            </nav>
            
            <form action="AddProductServlet" method="post">
                <div class="mb-3">
                  <label  class="form-label">Nombre del producto</label>
                  <input type="text" class="form-control" id="nombreProducto" name="nombreProducto">
                </div>
                <div class="mb-3">
                  <label  class="form-label">Referencia del producto</label>
                  <input type="text" class="form-control" id="nombreProducto" name="referenciaProducto">
                </div>
                <div class="mb-3">
                  <label  class="form-label">Precio del producto</label>
                  <input type="number" class="form-control" id="nombreProducto" name="precioProducto">
                </div>
                <div class="mb-3">
                  <label  class="form-label">Peso del producto</label>
                  <input type="number" class="form-control" id="nombreProducto" name="pesoProducto">
                </div>
                <div class="mb-3">
                  <label  class="form-label">Categoria del producto</label>
                  <select class="form-select form-select" aria-label=".form-select-sm example" name="categoriaProducto">
                    <option selected>Seleccione la categoria</option>
                    <%
                        for(int i=0; i<categorias.size(); i++){%>
                        <option  value="<%=categorias.get(i).getIdCategoria()%>"><%=categorias.get(i).getNombreCategoria()%></option>
                        <%}
                    %>
                    
                  </select>
                </div>
                <div class="mb-3">
                  <label  class="form-label">Stock del producto</label>
                  <input type="number" class="form-control" id="nombreProducto" name="stockProducto">
                </div>
                <button type="submit" class="btn btn-primary">Submit</button>
            </form>
        </div>
    </body>
</html>
