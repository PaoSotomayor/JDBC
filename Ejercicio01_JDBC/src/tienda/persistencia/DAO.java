/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tienda.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author user
 */
public abstract class DAO {
    protected Connection conexion;
    protected ResultSet resultado;
    protected Statement sentencia;
    
    private final String USER = "root";
    private final String PASSWORD = "root";
    private final String DATABASE = "tienda";
    private final String DRIVER = "com.mysql.cj.jdbc.Driver";
//     private final String URL = "jdbc:mysql://localhost:3306/";

    protected void conectarDB() throws ClassNotFoundException, SQLException {
        try {
         Class.forName(DRIVER);
         String urlBaseDeDatos = "jdbc:mysql://localhost:3306/"+ DATABASE +"?useSSL=false";
         conexion = DriverManager.getConnection(urlBaseDeDatos, USER, PASSWORD);
      } catch (ClassNotFoundException | SQLException ex) {
         throw ex;
      
        }
    }

    protected void desconectarDB() throws Exception {
        try {
            if (resultado != null) {
                resultado.close();
            }
            if (sentencia != null) {
                sentencia.close();
            }
            if (conexion != null) {
                conexion.close();
            }
        } catch (Exception ex) {
            throw ex;
        }
    }
     protected void consultarDB(String sql) throws Exception {
        try {
            conectarDB();
            sentencia = conexion.createStatement();
            resultado = sentencia.executeQuery(sql);
        } catch (Exception ex) {
            throw ex;
        }
    }

    protected void insertarModificarEliminar(String sql) throws Exception {
        try {
            conectarDB();
            sentencia = conexion.createStatement();
            sentencia.executeUpdate(sql);
        } catch (ClassNotFoundException | SQLException exception) {
            throw exception;
        } finally {
            desconectarDB();
        }
    }

   
}
    

