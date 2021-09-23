/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.sql.PreparedStatement;


/**
 *
 * @author gerar
 */
public class Productos {
    
    private String producto;
    private String Descripcion;
    private float precio_costo;
    private float precio_venta;
    private int id_marca,existencia;
    private Conexion cn;
    
    
    
    public Productos(){
    }

    public Productos(String producto, int id_marca, String Descripcion, float precio_costo, float precio_venta, int existencia) {
        this.producto = producto;
        this.Descripcion = Descripcion;
        this.precio_costo = precio_costo;
        this.precio_venta = precio_venta;
        this.existencia = existencia;
        this.id_marca = id_marca;
    }

    public int getId_marca() {
        return id_marca;
    }

    public void setId_marca(int id) {
        this.id_marca = id_marca;
    }
    
    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public float getPrecio_costo() {
        return precio_costo;
    }

    public void setPrecio_costo(float precio_costo) {
        this.precio_costo = precio_costo;
    }

    public float getPrecio_venta() {
        return precio_venta;
    }

    public void setPrecio_venta(float precio_venta) {
        this.precio_venta = precio_venta;
    }

    public int getExistencia() {
        return existencia;
    }

    public void setExistencia(int existencia) {
        this.existencia = existencia;
    }
    
    
    
    public int agregar(){
        int retorno = 0;
        try{
            PreparedStatement parametro;
            cn = new Conexion();
            String query = "INSERT INTO productos(producto,idMarca,Descripcion,precio_costo,precio_venta,existencia) VALUES (?,?,?,?,?,?);";
            cn.abrir_conexion();
            parametro = (PreparedStatement)cn.conexion_db.prepareStatement(query);
            parametro.setString(1, getProducto());
            parametro.setInt(2, getId_marca());
            parametro.setString(3, getDescripcion());
            parametro.setFloat(4, getPrecio_costo());
            parametro.setFloat(5, getPrecio_venta());
            parametro.setInt(6, getExistencia());
            
            retorno = parametro.executeUpdate();
            cn.cerrar_conexion();
            
        }
        catch(SQLException ex){
            System.out.println(ex.getMessage());
            retorno = 0;
        }
        return retorno;
    }

    
    
    
    
    
    
}
