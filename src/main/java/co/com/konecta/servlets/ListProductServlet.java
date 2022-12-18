/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package co.com.konecta.servlets;

import co.com.konecta.dao.CRUDProduct;
import co.com.konecta.models.Categoria;
import co.com.konecta.models.Producto;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author esteban gomez
 */
@WebServlet(name = "ListProductServlet", urlPatterns = {"/ListProductServlet"})
public class ListProductServlet extends HttpServlet {

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
        String id = request.getParameter("id");
        if(id != null){
            
            Producto producto = null;
            CRUDProduct sqlEvent = new CRUDProduct();
            ArrayList<Producto> productos = new ArrayList<>();
            ArrayList<Categoria> categorias = new ArrayList<>();
            try {
                ListCategoriesServlet categoriesServlet = new ListCategoriesServlet();
                categorias = categoriesServlet.obtainCategories();
                productos = sqlEvent.SearchAllProductsById(Integer.parseInt(id));
                producto = productos.get(0);
                for(int i =0 ; i<categorias.size(); i++){
                    categorias.get(i).setIsSelected(producto.getCategoria().equals(categorias.get(i).getIdCategoria())); 
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ListProductServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            request.setAttribute("productos", producto);
            request.setAttribute("categorias", categorias);
            //realizamos un forward a la página JSP donde mostraremos los resultados
            request.getRequestDispatcher("modificarProducto.jsp").forward(request, response);
        }
        else{
            CRUDProduct sqlEvent = new CRUDProduct();
            ArrayList<Producto> productos = new ArrayList<>();
            try {
                productos = sqlEvent.SearchAllProducts();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ListProductServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            request.setAttribute("productos", productos);
            //realizamos un forward a la página JSP donde mostraremos los resultados
            request.getRequestDispatcher("listarProductos.jsp").forward(request, response);
        }
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
        String categoria = request.getParameter("categoria");
        CRUDProduct sqlEvent = new CRUDProduct();
        ArrayList<Producto> productos = new ArrayList<>();
        JSONArray ja = new JSONArray();
        try {
           productos = sqlEvent.SearchAllProductsByCategory(Integer.parseInt(categoria));
           
        for(int i=0; i< productos.size();i++)
        {
            JSONObject jo = new JSONObject();
            jo.put("id", String.valueOf(productos.get(i).getId()));
            jo.put("value", productos.get(i).getNombreProducto());
            jo.put("precio", String.valueOf(productos.get(i).getPrecioProducto()));
            jo.put("stock", String.valueOf(productos.get(i).getStock()));
            ja.put(i,jo);
        }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ListProductServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        response.setContentType("text/html");
        
        PrintWriter out = response.getWriter();
        out.append(ja.toString());
        out.close();
        
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
