/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tienda.servicios;

import java.util.ArrayList;
import java.util.Scanner;
import tienda.entidades.Fabricante;
import tienda.entidades.Producto;
import tienda.persistencia.FabricanteDao;

/**
 *
 * @author user
 */
public class FabricanteServicio {

    Scanner leer = new Scanner(System.in).useDelimiter("\n");
    FabricanteDao DAOF = new FabricanteDao();

    public void listarNombreFabricante() throws Exception {
        ArrayList<String> nombres = new ArrayList();
        DAOF.listarTodosLosFabricantes(nombres);
        for (String aux : nombres) {
            System.out.println(aux);

        }
    }

    public void ingresarFabricante() throws Exception {
        Fabricante fab = new Fabricante();

        System.out.println("Ingrese el codigo de fabricante");
        fab.setCodigo(leer.nextInt());
        System.out.println("Ingrese el nombre del fabricante");
        fab.setNombre(leer.next());
        System.out.println("Nuevo fabricante ingresado a la Base de Datos...");
        System.out.println("Fabricante: (" + fab.getNombre() + ") ");

        DAOF.agregarFabricante(fab);

    }

}
