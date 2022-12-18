<%-- 
    Document   : venderProducto
    Created on : 17/12/2022, 07:47:25 PM
    Author     : esteban gomez
--%>

<%@page import="co.com.konecta.models.Producto"%>
<%@page import="co.com.konecta.models.Categoria"%>
<%@page import="co.com.konecta.models.Categoria"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<% 
    
   ArrayList<Categoria> data = (ArrayList<Categoria>) request.getAttribute("categorias");
   //ArrayList<Producto> dataProducto = (ArrayList<Producto>) request.getAttribute("productos");

%>
<!D
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
            var dataProducto
            function categorias(){
                $("#sltProductos option").each(function() {
                    $(this).remove();
                    
                });
                $.post('ListProductServlet', {
                        categoria : document.getElementById("sltCategoria").value
                        
			}, function(responseText) {
                                $("#sltProductos").append("<option selected>Seleccione el producto</option>");
				dataProducto = JSON.parse(responseText);
                                for (var i = 0; i < dataProducto.length; i++) {
                                    $("#sltProductos").append("<option value="+dataProducto[i].id+">"+dataProducto[i].value+"</option>")
                                }
                                
			});
               
            }
            function cargarData(){
                productoFiltrado = dataProducto.filter(x=>x.id == document.getElementById("sltProductos").value)
                $("#stockDisponible").val(productoFiltrado[0].stock)
                $("#valorUnitario").val(productoFiltrado[0].precio)
                $("#stockDisponible1").val(productoFiltrado[0].stock)
                $("#valorUnitario1").val(productoFiltrado[0].precio)
                $("#idProducto").val(productoFiltrado[0].id)
                $("#cantidadVenta").attr("max", productoFiltrado[0].stock)
                
               
            }
            function validarCampos(){
                if($("#cantidadVenta").val() === ""){
                    alert("Debe diligenciar la cantidad");
                    return;
                }
                if(parseInt($("#cantidadVenta").val()) > productoFiltrado[0].stock){
                    alert("No tenemos stock suficiente para realizar la operacion");
                    return;
                }
                if(parseInt($("#cantidadVenta").val()) <= 0 ){
                    alert("La cantidad no puede ser menor a 0");
                    return;
                }
                $("#cantidadVenta").submit();
                
            }
        </script>
    </head>
    <body>
        <div class="container mt-3">
            <nav class="nav nav-pills nav-justified mb-3">
                <a class="nav-link " href="index.jsp">Inicio</a>
                <a class="nav-link" aria-current="page" href="ListProductServlet">Ver Productos</a>
                <a class="nav-link " href="crearProducto.jsp">Crear Producto</a>
                <a class="nav-link active" href="#" >Vender Producto</a>
            </nav>
            
            <form action="UpdateProductServlet" method="post" id="formVente" name="formVenta">
                 
                <div class="mb-3">
                  <label  class="form-label">Categoria del producto</label>
                  <select class="form-select form-select" aria-label=".form-select-sm example"  id="sltCategoria" name="sltCategoria" onchange="categorias()">
                    <option selected>Seleccione la categoria</option>
                    <c:forEach items="${categorias}" var="categoria">
                        <option  value="${categoria.idCategoria}">${categoria.nombreCategoria}</option>
                    </c:forEach>
                  </select>
                </div>
                <div class="mb-3">
                  <label  class="form-label">Seleccione el producto</label>
                  <select class="form-select form-select" aria-label=".form-select-sm example" id="sltProductos" name="sltProductos" onchange="cargarData()"> 
                    <option selected>Seleccione el producto</option>
                    
                  </select>
                </div>
                <div class="mb-3">
                  <label  class="form-label">Stock disponible</label>
                  <input type="number" class="form-control" id="stockDisponible1"  disabled="true">
                </div>
                <div class="mb-3">
                  <label  class="form-label">Valor Unitario</label>
                  <input type="number" class="form-control" id="valorUnitario1"  disabled="true">
                </div>
 
                  <input type="number" class="form-control" id="stockDisponible" name="stockDisponible" hidden>
                  <input type="number" class="form-control" id="valorUnitario" name="valorUnitario" hidden>
                <div class="mb-3">
                  <label  class="form-label">Cantidad a vender</label>
                  <input type="number" class="form-control" name="cantidadVenta" id="cantidadVenta" >
                </div>
                <input type="number" class="form-control" name="idProducto" id="idProducto" hidden >
                <button  class="btn btn-primary" onclick="validarCampos()">Aceptar</button>
            </form>
            
        </div>
    </body>
</html>
