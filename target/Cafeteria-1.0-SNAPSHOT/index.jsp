<%-- 
    Document   : index
    Created on : 17/12/2022, 09:29:01 AM
    Author     : esteban gomez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% 
    //co.com.konecta.dao.CreateConnection Conctar = new co.com.konecta.dao.CreateConnection();
   // Conctar.abrirConexion();

%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <!-- CSS only -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
        <!-- JavaScript Bundle with Popper -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
        <link href="css/Style.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
       
        <div class="container mt-3">
            <nav class="nav nav-pills nav-justified mb-3">
                <a class="nav-link active" href="#">Inicio</a>
                <a class="nav-link" aria-current="page" href="ListProductServlet">Ver Productos</a>
                <a class="nav-link" href="crearProducto.jsp">Crear Producto</a>
                <a class="nav-link" href="ListCategoriesServlet">Vender Producto</a>
            </nav>
            <div id="carouselExampleControls " class="carousel slide" data-bs-ride="carousel">
                <div class="carousel-inner">
                  <div class="carousel-item active">
                    <img src="/Cafeteria/images/cafe1.jpg" class="d-block w-100" alt="...">
                  </div>
                  <div class="carousel-item">
                    <img src="/Cafeteria/images/cafe1.jpg" class="d-block w-100" alt="...">
                  </div>
                  <div class="carousel-item">
                    <img src="/Cafeteria/images/cafe1.jpg" class="d-block w-100" alt="...">
                  </div>
                </div>
                <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleControls" data-bs-slide="prev">
                  <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                  <span class="visually-hidden">Previous</span>
                </button>
                <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleControls" data-bs-slide="next">
                  <span class="carousel-control-next-icon" aria-hidden="true"></span>
                  <span class="visually-hidden">Next</span>
                </button>
            </div>
        </div>
    </body>
</html>
