/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.com.konecta.dao;

import co.com.konecta.models.Categoria;
import co.com.konecta.models.Producto;
import co.com.konecta.models.Venta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Map;

/**
 *
 * @author esteban gomez
 */
public class CRUDProduct {
    public boolean addProduct( Producto producto) throws ClassNotFoundException
    {
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO `tbl_producto` (`nombre_producto`, `referencia_producto`, `precio_producto`, `peso_producto`, `categoria_prodicto`, "
                + "`fecha_creacion_producto`, `stock_producto`, estado_producto) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, 1);");
        CreateConnection connect = new CreateConnection();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        LocalDate todaysDate = LocalDate.now();

        try{
            conn = connect.abrirConexion();
            ps = conn.prepareStatement(sql.toString());
            ps.setString(1, producto.getNombreProducto());
            ps.setString(2, producto.getReferenciaProducto());
            ps.setInt(3, producto.getPrecioProducto());
            ps.setInt(4, producto.getPesoProducto());
            ps.setString(5, producto.getCategoria());
            ps.setString(6, todaysDate.toString());
            ps.setInt(7, producto.getStock());
            if(ps.executeUpdate() > 0){
                ps.close();
                return true;
            }
        }
        catch(SQLException e){
            System.out.println(e.getErrorCode());
            return false;
        }
        return false;
    }
    
    public ArrayList SearchAllProducts() throws ClassNotFoundException
    {
        ArrayList<Producto> data = new ArrayList<Producto>();
        StringBuilder sql = new StringBuilder();
        sql.append("Select * FROM  `tbl_producto` P JOIN tbl_categorias C ON P.categoria_prodicto = C.id_categoria WHERE P.estado_producto = 1");
        CreateConnection connect = new CreateConnection();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        LocalDate todaysDate = LocalDate.now();

        try{
            conn = connect.abrirConexion();
            ps = conn.prepareStatement(sql.toString());
            rs = ps.executeQuery();
            while (rs.next()) {
                Producto prodcut = new Producto();
                prodcut.setId(rs.getInt("id_producto"));
                prodcut.setNombreProducto(rs.getString("nombre_producto"));
                prodcut.setReferenciaProducto(rs.getString("referencia_producto"));
                prodcut.setPrecioProducto(rs.getInt("precio_producto"));
                prodcut.setPesoProducto(rs.getInt("peso_producto"));
                prodcut.setCategoria(rs.getString("nombre_categoria"));
                prodcut.setFechaCreacion(rs.getDate("fecha_creacion_producto"));
                prodcut.setStock(rs.getInt("stock_producto"));
                data.add(prodcut);
            
            }
        
        }
        catch(SQLException e){
            System.out.println(e.getErrorCode());
           
        }
        return data;
    }
    
    public ArrayList SearchAllProductsById(int id) throws ClassNotFoundException
    {
        ArrayList<Producto> data = new ArrayList<Producto>();
        StringBuilder sql = new StringBuilder();
        sql.append("Select * FROM  `tbl_producto` WHERE id_producto = ?");
        CreateConnection connect = new CreateConnection();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        LocalDate todaysDate = LocalDate.now();

        try{
            conn = connect.abrirConexion();
            ps = conn.prepareStatement(sql.toString());
             ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                Producto prodcut = new Producto();
                prodcut.setId(rs.getInt("id_producto"));
                prodcut.setNombreProducto(rs.getString("nombre_producto"));
                prodcut.setReferenciaProducto(rs.getString("referencia_producto"));
                prodcut.setPrecioProducto(rs.getInt("precio_producto"));
                prodcut.setPesoProducto(rs.getInt("peso_producto"));
                prodcut.setCategoria(rs.getString("categoria_prodicto"));
                prodcut.setFechaCreacion(rs.getDate("fecha_creacion_producto"));
                prodcut.setStock(rs.getInt("stock_producto"));
                data.add(prodcut);
            
            }
        
        }
        catch(SQLException e){
            System.out.println(e.getErrorCode());
           
        }
        return data;
    }
    public boolean UpdateProduct( Producto producto) throws ClassNotFoundException
    {
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE tbl_producto SET nombre_producto = ?, referencia_producto = ?, precio_producto = ?, peso_producto = ?, categoria_prodicto =?, stock_producto = ? WHERE id_producto = ?");
        CreateConnection connect = new CreateConnection();
        Connection conn = null;
        PreparedStatement ps = null;
       
        try{
            conn = connect.abrirConexion();
            ps = conn.prepareStatement(sql.toString());
            ps.setString(1, producto.getNombreProducto());
            ps.setString(2, producto.getReferenciaProducto());
            ps.setInt(3, producto.getPrecioProducto());
            ps.setInt(4, producto.getPesoProducto());
            ps.setString(5, producto.getCategoria());
            ps.setInt(6, producto.getStock());
            ps.setInt(7, producto.getId());
            if(ps.executeUpdate() > 0){
                ps.close();
                return true;
            }
        }
        catch(SQLException e){
            System.out.println(e.getErrorCode());
            return false;
        }
        return false;
    }
    public boolean DeleteProduct(int id) throws ClassNotFoundException
    {
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE tbl_producto SET  estado_producto = 0 WHERE id_producto = ?");
        CreateConnection connect = new CreateConnection();
        Connection conn = null;
        PreparedStatement ps = null;
       
        try{
            conn = connect.abrirConexion();
            ps = conn.prepareStatement(sql.toString());
            ps.setInt(1, id);
           
            if(ps.executeUpdate() > 0){
                ps.close();
                return true;
            }
        }
        catch(SQLException e){
            System.out.println(e.getErrorCode());
            return false;
        }
        return false;
    }
    
     public ArrayList SearchAllCategories() throws ClassNotFoundException
    {
        ArrayList<Categoria> data = new ArrayList<Categoria>();
        StringBuilder sql = new StringBuilder();
        sql.append("Select * FROM  `tbl_categorias` ");
        CreateConnection connect = new CreateConnection();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try{
            conn = connect.abrirConexion();
            ps = conn.prepareStatement(sql.toString());
            rs = ps.executeQuery();
            while (rs.next()) {
                Categoria categoria = new Categoria();
                categoria.setIdCategoria(rs.getInt("id_categoria"));
                categoria.setNombreCategoria(rs.getString("nombre_categoria"));
                data.add(categoria);
            
            }
        
        }
        catch(SQLException e){
            System.out.println(e.getErrorCode());
           
        }
        return data;
    }
     public ArrayList SearchAllProductsByCategory(int categoria) throws ClassNotFoundException
    {
        ArrayList<Producto> data = new ArrayList<>();
        StringBuilder sql = new StringBuilder();
        sql.append("Select * FROM  `tbl_producto` WHERE categoria_prodicto = ? AND estado_producto = 1");
        CreateConnection connect = new CreateConnection();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        LocalDate todaysDate = LocalDate.now();

        try{
            conn = connect.abrirConexion();
            ps = conn.prepareStatement(sql.toString());
             ps.setInt(1, categoria);
            rs = ps.executeQuery();
            while (rs.next()) {
                Producto prodcut = new Producto();
                prodcut.setId(rs.getInt("id_producto"));
                prodcut.setNombreProducto(rs.getString("nombre_producto"));
                prodcut.setReferenciaProducto(rs.getString("referencia_producto"));
                prodcut.setPrecioProducto(rs.getInt("precio_producto"));
                prodcut.setPesoProducto(rs.getInt("peso_producto"));
                prodcut.setCategoria(rs.getString("categoria_prodicto"));
                prodcut.setFechaCreacion(rs.getDate("fecha_creacion_producto"));
                prodcut.setStock(rs.getInt("stock_producto"));
                data.add(prodcut);
            
            }
        
        }
        catch(SQLException e){
            System.out.println(e.getErrorCode());
           
        }
        return data;
    }
     public boolean UpdateStockProduct( Producto producto) throws ClassNotFoundException
    {
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE tbl_producto SET stock_producto = ? WHERE id_producto = ?");
        CreateConnection connect = new CreateConnection();
        Connection conn = null;
        PreparedStatement ps = null;
       
        try{
            conn = connect.abrirConexion();
            ps = conn.prepareStatement(sql.toString());
            ps.setInt(1, producto.getStock());
            ps.setInt(2, producto.getId());
            if(ps.executeUpdate() > 0){
                ps.close();
                return true;
            }
        }
        catch(SQLException e){
            System.out.println(e.getErrorCode());
            return false;
        }
        return false;
    }
     public boolean addSale(Venta venta) throws ClassNotFoundException
    {
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO `tbl_venta` (`id_producto`, `cantidad_venta`, `total_venta`) VALUES (?, ?, ?);");
        CreateConnection connect = new CreateConnection();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        LocalDate todaysDate = LocalDate.now();

        try{
            conn = connect.abrirConexion();
            ps = conn.prepareStatement(sql.toString());
            ps.setInt(1, venta.getIdProducto());
            ps.setInt(2, venta.getCantidadVenta());
            ps.setInt(3, venta.getTotalVenta());
            if(ps.executeUpdate() > 0){
                ps.close();
                return true;
            }
        }
        catch(SQLException e){
            System.out.println(e.getErrorCode());
            return false;
        }
        return false;
    }
     public ArrayList SearchParamSale(int id_producto) throws ClassNotFoundException
    {
        ArrayList<Venta> data = new ArrayList<>();
        StringBuilder sql = new StringBuilder();
        sql.append("Select * FROM `tbl_producto` P JOIN tbl_categorias C ON P.categoria_prodicto = C.id_categoria WHERE P.id_producto = ?;");
        CreateConnection connect = new CreateConnection();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try{
            conn = connect.abrirConexion();
            ps = conn.prepareStatement(sql.toString());
            ps.setInt(1, id_producto);
            rs = ps.executeQuery();
            while (rs.next()) {
                Venta venta = new Venta();
                venta.setNomProduct(rs.getString("nombre_producto"));
                venta.setNomCategoria(rs.getString("nombre_categoria"));
                venta.setValorUnitario(rs.getInt("precio_producto"));
                data.add(venta);
            
            }
        
        }
        catch(SQLException e){
            System.out.println(e.getErrorCode());
           
        }
        return data;
    }
}
