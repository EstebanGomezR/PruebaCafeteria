<%-- 
    Document   : modificarProducto
    Created on : 17/12/2022, 03:42:02 PM
    Author     : esteban gomez
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="co.com.konecta.models.Categoria"%>
<%@page import="co.com.konecta.models.Producto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<% 
    
   Producto dataProducto = (Producto) request.getAttribute("productos");
   ArrayList<Categoria> dataCategorias = (ArrayList<Categoria>) request.getAttribute("categorias");
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
         <script src="https://code.jquery.com/jquery-3.6.2.js" integrity="sha256-pkn2CUZmheSeyssYw3vMp1+xyub4m+e+QK4sQskvuo4=" crossorigin="anonymous"></script>
         <script>
             
         </script>
    </head>
    <body>
        <div class="container mt-3"> 
            <nav class="nav nav-pills nav-justified mb-3">
                <a class="nav-link " href="index.jsp">Inicio</a>
                <a class="nav-link" aria-current="page" href="ListProductServlet">Ver Productos</a>
                <a class="nav-link" href="#">Crear Producto</a>
                <a class="nav-link" href="ListCategoriesServlet">Vender Producto</a>
            </nav>
            <form action="UpdateProductServlet" method="post">
                <div class="mb-3">
                  <label  class="form-label">Nombre del producto</label>
                  <input type="text" class="form-control" id="nombreProducto" name="nombreProducto" value="<%=dataProducto.getNombreProducto()%>">
                </div>
                <div class="mb-3">
                  <label  class="form-label">Referencia del producto</label>
                  <input type="text" class="form-control" id="nombreProducto" name="referenciaProducto" value="<%=dataProducto.getReferenciaProducto()%>">
                </div>
                <div class="mb-3">
                  <label  class="form-label">Precio del producto</label>
                  <input type="number" class="form-control" id="nombreProducto" name="precioProducto" value="<%=dataProducto.getPrecioProducto()%>">
                </div>
                <div class="mb-3">
                  <label  class="form-label">Peso del producto</label>
                  <input type="number" class="form-control" id="nombreProducto" name="pesoProducto" value="<%=dataProducto.getPesoProducto()%>">
                </div>
                <div class="mb-3">
                  <label  class="form-label">Categoria del producto</label>
                  <select class="form-select form-select" aria-label=".form-select-sm example" name="categoriaProducto" value="<%=dataProducto.getCategoria()%>">
                      <option >Seleccione la categoria</option>
                      <c:forEach items="${categorias}" var="categoria">
                          <option  value="${categoria.idCategoria}" selected="${categoria.isSelected}">${categoria.nombreCategoria}</option>
                      </c:forEach>
                    
                  </select>
                </div>
                <div class="mb-3">
                  <label  class="form-label">Stock del producto</label>
                  <input type="number" class="form-control" id="nombreProducto" name="stockProducto" value="<%=dataProducto.getStock()%>">
                </div>
                  <input type="number" class="form-control" id="nombreProducto" name="idProducto" hidden value="<%=dataProducto.getId()%>">
                <button type="submit" class="btn btn-primary">Submit</button>
            </form>
        </div>
    </body>
</html>
