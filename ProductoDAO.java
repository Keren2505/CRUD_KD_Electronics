
package co.uniminuto.dao;

import co.uniminuto.modelo.Producto;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAO {
    private final List<Producto> inventario;

    public ProductoDAO() {
        inventario = new ArrayList<>();
    }

    // CREATE
    public void agregarProducto(Producto producto) {
        inventario.add(producto);
    }

    // READ
    public Producto obtenerProductoPorCodigo(String codigo) {
        for (Producto p : inventario) {
            if (p.getCodigoProducto().equals(codigo) && p.isActivo()) {
                return p;
            }
        }
        return null;
    }
    // UPDATE
    public boolean actualizarProducto(String codigo, String nombre, String descripcion, 
                                      double precioBase, double precioVenta, String categoria, int cantidadDisponible) {
        Producto p = obtenerProductoPorCodigo(codigo);
        if (p != null) {
            p.setNombre(nombre);
            p.setDescripcion(descripcion);
            p.setPrecioBase(precioBase);
            p.setPrecioVenta(precioVenta);
            p.setCategoria(categoria);
            p.setCantidadDisponible(cantidadDisponible);
            return true;
        }
        return false;
    }
    // DELETE (eliminación lógica)
    public boolean eliminarProducto(String codigo) {
        Producto p = obtenerProductoPorCodigo(codigo);
        if (p != null) {
            p.setActivo(false);
            return true;
        }
        return false;
    }

    // Método extra para listar productos activos (opcional)
    public List<Producto> listarProductosActivos() {
        List<Producto> activos = new ArrayList<>();
        for (Producto p : inventario) {
            if (p.isActivo()) {
                activos.add(p);
            }
        }
        return activos;
    }
}
