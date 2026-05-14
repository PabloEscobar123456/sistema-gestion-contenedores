package e;

public class Pedido extends Empresa {
    private int id;                 // privado
    private double total;           // privado

    // Getter público porque necesitamos leer el total
    public double getTotal() {
        return total;
    }

    // NO setter para total (el total se calcula internamente)
    public void añadirProducto(Producto p) {
        this.total += p.getPrecioUnitario();
    }
}