<%-- 
    Document   : graciasCompra
    Created on : 18/12/2022, 01:08:57 AM
    Author     : esteban gomez
--%>

<%@page import="co.com.konecta.models.Venta"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% 
    
   Venta dataVenta = (Venta) request.getAttribute("venta");
   Venta dataVenta2 = (Venta) request.getAttribute("ventaData");
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
        <script>
            $( document ).ready(function() {
                console.log( "ready!" );
             });
        </script>
    </head>
    <body>
        <div class="container mt-3">
            <nav class="nav nav-pills nav-justified mb-3">
                <a class="nav-link " href="index.jsp">Inicio</a>
                <a class="nav-link" aria-current="page" href="ListProductServlet">Ver Productos</a>
                <a class="nav-link " href="#">Crear Producto</a>
                <a class="nav-link" href="ListCategoriesServlet">Vender Producto</a>
            </nav>
            <div class="card">
                <div class="card-header">
                  <h3>Producto vendido exitosamente</h3>
                </div>
                <div class="card-body">
                  <div class="mb-3">
                    <label  class="form-label">Categoria del producto:</label>
                    <label  class="form-label"><%=dataVenta2.getNomCategoria()%></label>
                    </div>
                    <div class="mb-3">
                      <label  class="form-label">Producto:</label>
                      <label  class="form-label"><%=dataVenta2.getNomProduct()%></label>
                    </div>
                    <div class="mb-3">
                      <label  class="form-label">Cantidad:</label>
                      <label  class="form-label"><%=dataVenta.getCantidadVenta()%></label>
                    </div>
                    <div class="mb-3">
                      <label  class="form-label">Valor Unitario:</label>
                      <label  class="form-label"><%=dataVenta2.getValorUnitario()%></label>
                    </div>

                    <div class="mb-3">
                      <label  class="form-label">Valor Total:</label>
                      <label  class="form-label"><%=dataVenta.getTotalVenta()%></label>
                    </div>
                      <a href="index.jsp" class="btn btn-danger">Cerrar</a>
                </div>
            </div>
             

            
        </div>
    </body>
</html>
