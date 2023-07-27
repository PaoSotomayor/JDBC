package tienda1;

import java.util.Scanner;
import tienda.entidades.Fabricante;
import tienda.entidades.Producto;
import tienda.persistencia.ProductoDao;
import tienda.servicios.FabricanteServicio;
import tienda.servicios.ProductoServicio;

public class Ejercicio01_JDBC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        //Scanner leer = new Scanner(System.in).useDelimiter("/n");
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        ProductoServicio servicioP = new ProductoServicio();
        FabricanteServicio servicioF = new FabricanteServicio();

        String op;

        do {
            System.out.println("---------------------------Menu---------------------------");
            System.out.println("A- Nombre de productos");
            System.out.println("B- Nombres y precios de productos");
            System.out.println("C- Listar productos con precio entre 120 y 202");
            System.out.println("D- Buscar y listar todos los Portátiles de la tabla producto");
            System.out.println("E- Listar el nombre y el precio del producto más barato");
            System.out.println("F- Ingresar un producto a la base de datos");
            System.out.println("G- Ingresar un fabricante a la base de datos");
            System.out.println("H- Editar un producto con datos a elección");
            System.out.println("I- Salir");
            System.out.println("---------------------------@@@---------------------------");
            op = leer.next();

            switch (op.toUpperCase()) {
                case "A":
                    System.out.println("Productos en la lista: ");
                    servicioP.listarNombreProducto();
                    break;

                case "B": 
                    System.out.println("Productos y precios: ");
                    servicioP.nombreyprecio();
                    break;
                    
                    case "C": 
                        System.out.println("Productos entre $120 y $202: ");
                    servicioP.entreprecios();
                    break;
                    
                    case "D":  
                        System.out.println("Listado de portátiles: ");
                    servicioP.listaPortatiles();
                    break;
                    
                    case "E":  
                        System.out.println("Productos más baratos: ");
                    servicioP.menorPr();
                    break;
                    
                    case "F":                 
                     System.out.println("Ingresar nuevo producto de un fabricante ya existente en la DB");                                                        
                     servicioP.ingresarPR();
                              
                              
                    break;
                    case "G":                 
                        System.out.println("Ingresar nuevo fabricante");
                        servicioF.ingresarFabricante();
                    break;
                    
                    case "H":  
                        System.out.println("Modificar productos:");
                    servicioP.modificarProd();
                    break;
                    
                case "I":
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opción inválida");
            }

        } while (!(op.equalsIgnoreCase("I")));
    }

}
