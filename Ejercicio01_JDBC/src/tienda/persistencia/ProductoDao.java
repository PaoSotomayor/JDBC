/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tienda.persistencia;

import java.util.ArrayList;
import java.util.HashMap;
import tienda.entidades.Producto;

public class ProductoDao extends DAO {

    //Lista el nombre de todos los productos que hay en la tabla producto.
    public void listarTodosLosProductos(ArrayList<String> nombres) throws Exception {
        try {
            String sql = "SELECT DISTINCT nombre FROM producto";
            consultarDB(sql);

            while (resultado.next()) {
                nombres.add(resultado.getString("nombre"));
            }
            desconectarDB();

        } catch (Exception e) {
            e.printStackTrace();
            desconectarDB();
            throw e;
        }
    }

    public Producto buscarProductoPorCodigo(int codigo) throws Exception {
        try {
            String sql = "SELECT * FROM producto WHERE codigo = " + codigo + "";
            consultarDB(sql);

            Producto producto = null;
            while (resultado.next()) {
                producto = new Producto();
                producto.setCodigo(resultado.getInt("codigo"));
                producto.setNombre(resultado.getString("nombre"));
                producto.setPrecio(resultado.getDouble("precio"));
                producto.setCodigoFabricante(resultado.getInt("codigo_fabricante"));
            }
            desconectarDB();
            return producto;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    //Lista los nombres y los precios de todos los productos de la tabla producto
    public void listarNombresyPreciosProductos(ArrayList<String> listaProd) throws Exception {
        try {

            String sql = "SELECT nombre, precio FROM producto";
            consultarDB(sql);
            while (resultado.next()) {
                listaProd.add(resultado.getString("nombre") + " - $" + resultado.getString("precio"));
            }
            desconectarDB();
        } catch (Exception e) {
            e.printStackTrace();
            desconectarDB();
            throw e;
        }
    }
//Listar aquellos productos que su precio esté entre 120 y 202.

    public void PreciosEntre120y202(ArrayList<String> precioProd) throws Exception {
        try {

            String sql = "SELECT * FROM producto WHERE precio BETWEEN 120 AND 202";
            consultarDB(sql);
            while (resultado.next()) {
                precioProd.add(resultado.getString("nombre") + " - $" + resultado.getString("precio"));
            }
            desconectarDB();
        } catch (Exception e) {
            e.printStackTrace();
            desconectarDB();
            throw e;
        }
    }

    //Buscar y listar todos los Portátiles de la tabla producto
    public void listarPortatiles(ArrayList<String> listPort) throws Exception {
        try {

            String sql = "SELECT * FROM producto WHERE nombre LIKE '%Pórtatil%'";
            consultarDB(sql);
            while (resultado.next()) {
                listPort.add(resultado.getString("nombre"));
            }
            desconectarDB();
        } catch (Exception e) {
            e.printStackTrace();
            desconectarDB();
            throw e;
        }
    }

// Listar el nombre y el precio del producto más barato 
    public void menorPrecio(ArrayList<String> menorPrec) throws Exception {
        try {

            String sql = "SELECT nombre, precio FROM producto WHERE precio = (SELECT MIN(precio) FROM producto)";
            consultarDB(sql);
            while (resultado.next()) {
                menorPrec.add(resultado.getString("nombre") + " - $" + resultado.getDouble("precio"));
            }
            desconectarDB();
        } catch (Exception e) {
            e.printStackTrace();
            desconectarDB();
            throw e;
        }
    }
    //Ingresar un producto a la base de datos

    public void ingresarProducto(Producto producto) throws Exception {

        try {
            if (producto == null) {
                throw new Exception("Debe indicar un producto");
                
            }
            
            String sql = "INSERT INTO producto (codigo,nombre,precio,codigo_fabricante)values('"
                    + producto.getCodigo() + "','" + producto.getNombre() + "','" 
                    + producto.getPrecio() + "','" + producto.getCodigoFabricante()+ "');";

            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;

        }

    }

    public void verProductosTodos() throws Exception {
        try {
            String sql = "SELECT * FROM producto; ";

            consultarDB(sql);
            while (resultado.next()) {
                System.out.println(" | " + resultado.getInt("codigo") + " | " + resultado.getString("nombre") + " | " + " $ " + resultado.getDouble("precio")
                        + resultado.getInt("codigo_fabricante"));
            }

        } catch (Exception e) {
            e.printStackTrace();
            desconectarDB();
            throw new Exception("Error del sistema");
        }
    }
    
    //Editar un producto con datos a elección
    public void editarProductos(String codigoF, String codigo) throws Exception {
        try {
            
            if(codigoF == null || codigo==null){
                throw new Exception("No puede ingresar datos vacios");
            }
            
            String sql = "UPDATE producto SET codigo_fabricante = '" + codigoF + "'where codigo = '" + codigo + "';";
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        }
    }
     public Producto buscarProductoNombre(String nombre) throws Exception {
        try {
            String sql = "SELECT * FROM producto " + "WHERE nombre = '" + nombre + "'";
            consultarDB(sql);

            Producto producto = null;
            while (resultado.next()) {
                producto = new Producto();

                producto.setCodigo(resultado.getInt("codigo"));
                producto.setNombre(resultado.getString("nombre"));
                producto.setPrecio(resultado.getInt("precio"));
                producto.setCodigoFabricante(resultado.getInt("codigo_fabricante"));
            }
            desconectarDB();
            return producto;
        } catch (Exception e) {
            desconectarDB();
            throw e;
        }
    }
//    public void ModificarProductoNombre(String nombre, String nombreNuevo, String precioNuevo, String codigoFabricanteNuevo) throws Exception {
//        try {
//            if (nombre == null || nombre.trim().isEmpty()) {
//                throw new Exception("Indique el nombre del producto");
//            }
//            if (nombreNuevo == null || nombreNuevo.trim().isEmpty()) {
//                throw new Exception("Indique el nuevo nombre del producto");
//            }
//            if (precioNuevo == null || precioNuevo.trim().isEmpty()) {
//                throw new Exception("Indique el precio del producto");
//            }
//            if (codigoFabricanteNuevo == null || codigoFabricanteNuevo.trim().isEmpty()) {
//                throw new Exception("Indique el nuevo codigoFabricante del producto");
//            }
//
//            Producto producto = buscarProductoNombre(nombre);
//            if (!producto.getNombre().equalsIgnoreCase(nombre)) {
//                throw new Exception("No existe el producto que quiere actualizar");
//
//            }
//
//            producto.setNombre(nombreNuevo);
//            producto.setPrecio(Double.parseDouble(precioNuevo));
//            producto.setCodigoFabricante(Integer.parseInt(codigoFabricanteNuevo));
//
//           ModificarPrNombre(producto);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            throw e;
//        }
//    }
//    public void ModificarPrNombre(Producto producto) throws Exception {
//        try {
//            if (producto == null) {
//                throw new Exception("Producto es null");
//            }
//
//            String sql = ("UPDATE Producto SET " + "nombre = '" + producto.getNombre() + "', precio = "
//                    + producto.getPrecio() + ", codigo_fabricante = " + producto.getCodigoFabricante()
//                    + " WHERE codigo = " + producto.getCodigo() + ";");
//            System.out.println("Modificacion Exitosa!!");
//            insertarModificarEliminar(sql);
//        } catch (Exception e) {
//            throw e;
//        }
//    }
//       public void ModificarPrNombre(Producto p) throws Exception {
//        try {
//            String sql = "UPDATE producto SET nombre='"+p.getNombre()+"', precio="+p.getPrecio()+
//                    ", codigo_fabricante="+p.getCodigoFabricante()+ " WHERE codigo = "+p.getCodigo()+";";
//            insertarModificarEliminar(sql);
//        } catch (Exception e) {
//            e.printStackTrace();
//            throw new Exception("Error de sistema");
//        }
//    }
       public void modificarProd2(Integer codigo, String nombre, Double precio, Integer cod_fab) throws Exception{
        try{
            //Validación
            if(codigo == null | codigo < 0){
                throw new Exception("DEBE INGRESAR UN CODIGO");
            }
            
            if(nombre == null | nombre.trim().isEmpty()){
                throw new Exception("DEBE INGRESAR UN NOMBRE");
            }
            
            if(precio == null | precio < 0){
                throw new Exception("DEBE INGRESAR UN PRECIO");
            }
            
            if(cod_fab == null | cod_fab < 0){
                throw new Exception("DEBE INGRESAR UN CODIGO DE FABRICANTE");
            }
            
            Producto p = buscarProductoPorCodigo(codigo);
            
            if(p == null){
                throw new Exception("EL CODIGO INGRESADO NO ESTÁ ASOCIADO A NINGÚN PRODUCTO");
            }
            p.setNombre(nombre);
            p.setPrecio(precio);
            p.setCodigoFabricante(cod_fab);
            
            String sql = "UPDATE producto SET nombre = '" + p.getNombre() + "', "
                    + "precio = '" + p.getPrecio() + "', "
                    + "codigo_fabricante = '" + p.getCodigoFabricante() + "' "
                    + "WHERE codigo = '" + p.getCodigo() + "';";
            
            insertarModificarEliminar(sql);
        }catch(Exception e){
            System.out.println(e.getMessage());
            throw new Exception("ERROR AL MODIFICAR PRODUCTO");
        }
     
        
    }
}




