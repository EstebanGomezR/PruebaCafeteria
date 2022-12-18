/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.com.konecta.models;

import java.sql.Date;

/**
 *
 * @author esteban gomez
 */
public class Producto {
    private int id;
    private String nombreProducto;
    private String referenciaProducto;
    private int precioProducto;
    private int pesoProducto;
    private String Categoria;
    private int stock;
    private Date fechaCreacion;
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Producto() {
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getReferenciaProducto() {
        return referenciaProducto;
    }

    public void setReferenciaProducto(String referenciaProducto) {
        this.referenciaProducto = referenciaProducto;
    }

    public int getPrecioProducto() {
        return precioProducto;
    }

    public void setPrecioProducto(int precioProducto) {
        this.precioProducto = precioProducto;
    }

    public int getPesoProducto() {
        return pesoProducto;
    }

    public void setPesoProducto(int pesoProducto) {
        this.pesoProducto = pesoProducto;
    }

    public String getCategoria() {
        return Categoria;
    }

    public void setCategoria(String Categoria) {
        this.Categoria = Categoria;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

  
    
}
