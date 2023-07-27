
package tienda.persistencia;

import java.util.ArrayList;
import java.util.Collection;
import tienda.entidades.Fabricante;

    public final class FabricanteDao extends DAO {

//Ingresar un fabricante a la base de datos
    public void agregarFabricante(Fabricante fab) throws Exception {
        try {
            if (fab == null) {
                throw new Exception("Debe indicar el nombre y código del fabricante");
            }
 String sql = "INSERT INTO fabricante (codigo,nombre) values ('" + fab.getCodigo() + "','" + fab.getNombre() + "');";
            System.out.println(sql);
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarDB();
        }
    }

    //Lista el nombre de todos los productos que hay en la tabla producto.
    public void listarTodosLosFabricantes(ArrayList<String> nombres) throws Exception {
        try {
            String sql = "SELECT DISTINCT nombre FROM fabricante";
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
}
    
