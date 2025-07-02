
package co.uniminuto.principal;

import co.uniminuto.dao.ProductoDAO;
import co.uniminuto.modelo.Producto;

public class Main {
    public static void main(String[] args) {
        ProductoDAO dao = new ProductoDAO();

        // Crear productos
        Producto prod1 = new Producto("P001", "Laptop", "Laptop i5 8GB RAM", 500.00, 650.00, "Computadoras", 10);
        dao.agregarProducto(prod1);

        // Leer producto
        Producto buscado = dao.obtenerProductoPorCodigo("P001");
        if (buscado != null) {
            System.out.println("Producto encontrado: " + buscado.getNombre());
        }

        // Actualizar producto
        dao.actualizarProducto("P001", "Laptop", "Laptop i5 16GB RAM", 500.00, 700.00, "Computadoras", 8);

        // Eliminar producto (eliminación lógica)
        dao.eliminarProducto("P001");
        
        // Intentar leer después de eliminación
        Producto eliminado = dao.obtenerProductoPorCodigo("P001");
        if (eliminado == null) {
            System.out.println("Producto no encontrado o inactivo.");
        }
    }
}
