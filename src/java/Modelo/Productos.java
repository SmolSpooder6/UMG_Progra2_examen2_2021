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
import javax.swing.table.DefaultTableModel;


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
    
    
    public DefaultTableModel leer(){
        DefaultTableModel tabla = new DefaultTableModel();
        try{
            cn= new Conexion();
            cn.abrir_conexion();
            String query = "SELECT p.idProductos AS id,p.Producto,m.marca,m.idMarca,p.Descripcion,p.precio_costo,p.precio_venta,p.existencia FROM productos as p INNER JOIN marca AS m ON p.idMarca = m.idMarca;";
            ResultSet consulta = cn.conexion_db.createStatement().executeQuery(query);
            String encabezado[] = {"id", "Producto", "Marca", "Id Marca", "Descripcion", "Precio Costo", "Precio Venta", "Existencia"  };
            tabla.setColumnIdentifiers(encabezado);
            String datos[] = new String[8];
            while(consulta.next()){
                datos[0] = consulta.getString("id");
                datos[1] = consulta.getString("Producto");
                datos[2] = consulta.getString("marca");
                datos[3] = consulta.getString("idMarca");
                datos[4] = consulta.getString("Descripcion");
                datos[5] = consulta.getString("precio_costo");
                datos[6] = consulta.getString("precio_venta");
                datos[7] = consulta.getString("existencia");
                
                tabla.addRow(datos);
            }
            
            
            cn.cerrar_conexion();
        }
        catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        
        return tabla;
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
