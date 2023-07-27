/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tienda.servicios;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import tienda.entidades.Fabricante;
import tienda.entidades.Producto;
import tienda.persistencia.FabricanteDao;

import tienda.persistencia.ProductoDao;

public class ProductoServicio {

    Scanner leer = new Scanner(System.in).useDelimiter("\n");
    ProductoDao DAOP = new ProductoDao();
    FabricanteDao DAOF = new FabricanteDao();

    public void listarNombreProducto() throws Exception {
        ArrayList<String> nombres = new ArrayList();
        DAOP.listarTodosLosProductos(nombres);
        for (String aux : nombres) {
            System.out.println(aux);

        }
    }

    public void nombreyprecio() throws Exception {
        ArrayList<String> listaProd = new ArrayList();
        DAOP.listarNombresyPreciosProductos(listaProd);
        for (String aux : listaProd) {
            System.out.println(aux);

        }
    }

    public void entreprecios() throws Exception {
        ArrayList<String> entrePrec = new ArrayList();
        DAOP.PreciosEntre120y202(entrePrec);
        for (String aux : entrePrec) {
            System.out.println(aux);

        }
    }

    public void listaPortatiles() throws Exception {
        ArrayList<String> lPort = new ArrayList();
        DAOP.listarPortatiles(lPort);
        for (String aux : lPort) {
            System.out.println(aux);

        }
    }

    public void menorPr() throws Exception {
        ArrayList<String> mPrec = new ArrayList();
        DAOP.menorPrecio(mPrec);
        for (String aux : mPrec) {
            System.out.println(aux);

        }
    }

    public void listarNombreFabricante() throws Exception {
        ArrayList<String> nombres = new ArrayList();
        DAOF.listarTodosLosFabricantes(nombres);
        for (String aux : nombres) {
            System.out.println(aux);

        }
    }

    public void ingresarPR() throws Exception {
        Producto prod = new Producto();

        System.out.println("Ingrese el código del producto:");
        prod.setCodigo(leer.nextInt());
        System.out.println("Ingrese el nombre del producto:");
        prod.setNombre(leer.next());
        System.out.println("Ingrese el precio del producto:");
        prod.setPrecio(leer.nextDouble());
        System.out.println("Ingrese el código del fabricante:");
        prod.setCodigoFabricante(leer.nextInt());
        System.out.println("El producto (" + prod.getNombre() + ") ha sido añadido a la base!");

        DAOP.ingresarProducto(prod);

    }
//    public void editarPr() throws Exception {
//       
//         System.out.println("Ingresa el nombre del Producto");
//                    String nombre = leer.next();
//                    System.out.println("Ingresa el nuevo nombre del Producto");
//                    String nombre2 = leer.next();
//                    System.out.println("Ingresa el nuevo precio del Producto");
//                    int precio = leer.nextInt();
//                    System.out.println("Ingresa el nuevo codigo del fabricante del Producto");
//                    int codigoP = leer.nextInt();
//                   //DAOP.ModificarProductoNombre(nombre, nombre2, precio, codigoP);
//                  DAOP.ModificarProductoNombre(nombre, nombre2, nombre2, nombre2);
//    }
     public void modificarProd()throws Exception {
       
            System.out.println("INGRESE CODIGO: ");
            int codigo = leer.nextInt();

            System.out.println("INGRESE NOMBRE: ");
            String nombre = leer.next();

            System.out.println("INGRESE PRECIO: ");
            double precio = leer.nextDouble();

            System.out.println("INGRESE CODIGO DE FABRICANTE: ");
            int cod_fab = leer.nextInt();

            //prodServ.modificarProd(codigo, nombre, precio, cod_fab);
            DAOP.modificarProd2(codigo, nombre, precio, cod_fab);
        
        }
        
}
