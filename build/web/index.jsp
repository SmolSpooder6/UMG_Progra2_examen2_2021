<%-- 
    Document   : index
    Created on : 22/09/2021, 19:34:59
    Author     : gerar
--%>
<%@page import="Modelo.Marcas"%>
<%@page import="java.util.HashMap"%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Examen2</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
    </head>
    <body>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ" crossorigin="anonymous"></script>
        <h1>formulario Productos</h1>
        <div class="container">
            <form action="sr_productos" method="post" class="form-group" >
                <label for="lbl_producto"><b>Producto:</b></label>
                 <input type="text" name="txt_producto" id="txt_producto" class="form-control" placeholder="Producto" required>
                 
                 <label for="lbl_marca"><b>Marca:</b></label>
                 <select name="drop_marca" id="drop_marca" class="form-control")>
                         <%
                         Marcas marcas = new Marcas();
                         HashMap<String,String> drop = marcas.drop_marca();
                         for (String i: drop.keySet()){
                            out.println("<option value =\"" + i + "\" >" + drop.get(i) + "</option>");
                         }
                         
                         
                         %>
                             
                 </select>
                         
                 <label for="lbl_producto"><b>Descripcion:</b></label>
                 <input type="text" name="txt_descripcion" id="txt_descripcion" class="form-control" placeholder="Descripcion" required>
                 <label for="lbl_precio_costo"><b>Precio Costo:</b></label>
                 <input type="number" name="txt_precio_costo" id="txt_precio_costo" class="form-control" placeholder="99.99" required>
                 <label for="lbl_precio_venta"><b>Precio Venta:</b></label>
                 <input type="number" name="txt_precio_venta" id="txt_precio_venta" class="form-control" placeholder="99.99" required>
                 <label for="lbl_existencia"><b>Existencia:</b></label>
                 <input type="number" name="txt_existencia" id="txt_existencia" class="form-control" placeholder="10" required>
                 <br>
                 <button name="btn_agregar" id="btn_agregar" value="agregar" class="btn btn-primary">Agregar</button>
            
            
            </form>
                
        </div>
    </body>
</html>
