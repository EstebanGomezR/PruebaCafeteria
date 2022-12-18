/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package co.com.konecta.servlets;

import co.com.konecta.dao.CRUDProduct;
import co.com.konecta.models.Producto;
import co.com.konecta.models.Venta;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author esteban gomez
 */
@WebServlet(name = "UpdateProductServlet", urlPatterns = {"/UpdateProductServlet"})
public class UpdateProductServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        processRequest(request, response);
        CRUDProduct sqlEvent = new CRUDProduct();
        if(request.getParameter("cantidadVenta") != null && request.getParameter("stockDisponible") != null && request.getParameter("idProducto")!=null){
            Producto producto = new Producto();
            Venta venta = new Venta();
            int cantidadVenta = Integer.parseInt(String.valueOf(request.getParameter("cantidadVenta")));
            int stockDisponible = Integer.parseInt(String.valueOf(request.getParameter("stockDisponible")));
            int newStock = stockDisponible - cantidadVenta;
            int valorTotal = cantidadVenta * Integer.parseInt(String.valueOf(request.getParameter("valorUnitario")));
            producto.setId(Integer.parseInt(request.getParameter("idProducto")));
            producto.setStock(newStock);
            venta.setIdProducto(Integer.parseInt(request.getParameter("idProducto")));
            venta.setCantidadVenta(cantidadVenta);
            venta.setTotalVenta(valorTotal);
            Venta ventaData = new Venta();
            
            
            
            try {
                sqlEvent.UpdateStockProduct(producto);
                sqlEvent.addSale(venta);
                ventaData = (Venta) sqlEvent.SearchParamSale(Integer.parseInt(request.getParameter("idProducto"))).get(0);
                
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(UpdateProductServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            request.setAttribute("venta", venta);
            request.setAttribute("ventaData", ventaData);
            //realizamos un forward a la página JSP donde mostraremos los resultados
            request.getRequestDispatcher("ventaRealizada.jsp").forward(request, response);
           
        }
        else{
           Producto producto = new Producto();
           producto.setId(Integer.parseInt(request.getParameter("idProducto")));
           producto.setNombreProducto(request.getParameter("nombreProducto"));
           producto.setReferenciaProducto(request.getParameter("referenciaProducto"));
           producto.setPrecioProducto(Integer.parseInt(request.getParameter("precioProducto")));
           producto.setPesoProducto(Integer.parseInt(request.getParameter("pesoProducto")));
           producto.setCategoria(request.getParameter("categoriaProducto"));
           producto.setStock(Integer.parseInt(request.getParameter("stockProducto")));
           ListProductServlet listServlet = new ListProductServlet();
     
                listServlet.doGet(request, response);
           try {
               if(sqlEvent.UpdateProduct(producto))
                   listServlet.doGet(request, response);
               else
                    response.sendRedirect("index.jsp?error='Error al instertar'");
           } catch (ClassNotFoundException ex) {
               Logger.getLogger(AddProductServlet.class.getName()).log(Level.SEVERE, null, ex);
           }
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
