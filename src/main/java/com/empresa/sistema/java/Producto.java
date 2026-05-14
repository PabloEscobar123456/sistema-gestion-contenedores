package e;


/**
 * Representa un producto disponible para la venta en el sistema de pedidos.
 * Cada producto tiene un identificador único, nombre, descripción, precio unitario y stock.
 * 
 * @author TuNombre
 * @version 1.0
 */
public class Producto {
    
    // Atributos privados (encapsulamiento)
    private int id;
    private String nombre;
    private String descripcion;
    private double precioUnitario;
    private int stock;
    
    /**
     * Constructor completo para inicializar un producto.
     * 
     * @param id             Identificador único del producto (debe ser positivo).
     * @param nombre         Nombre del producto (no puede ser nulo o vacío).
     * @param descripcion    Descripción breve (puede ser vacía pero no nula).
     * @param precioUnitario Precio en euros (debe ser mayor o igual a 0).
     * @param stock          Cantidad disponible en inventario (debe ser mayor o igual a 0).
     * @throws IllegalArgumentException si algún parámetro no cumple las condiciones.
     */
    public Producto(int id, String nombre, String descripcion, double precioUnitario, int stock) {
        if (id <= 0) {
            throw new IllegalArgumentException("El ID debe ser positivo");
        }
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }
        if (descripcion == null) {
            throw new IllegalArgumentException("La descripción no puede ser nula (use cadena vacía si no hay)");
        }
        if (precioUnitario < 0) {
            throw new IllegalArgumentException("El precio unitario no puede ser negativo");
        }
        if (stock < 0) {
            throw new IllegalArgumentException("El stock no puede ser negativo");
        }
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precioUnitario = precioUnitario;
        this.stock = stock;
    }
    
    /**
     * Constructor simplificado (sin descripción y stock = 0).
     * 
     * @param id             Identificador único del producto.
     * @param nombre         Nombre del producto.
     * @param precioUnitario Precio en euros.
     */
    public Producto(int id, String nombre, double precioUnitario) {
        this(id, nombre, "", precioUnitario, 0);
    }
    
    // Getters (solo lectura para atributos que no deben cambiar después de crear el producto)
    
    /**
     * Obtiene el identificador del producto.
     * @return ID único (positivo).
     */
    public int getId() {
        return id;
    }
    
    /**
     * Obtiene el nombre del producto.
     * @return nombre (nunca nulo ni vacío).
     */
    public String getNombre() {
        return nombre;
    }
    
    /**
     * Obtiene la descripción del producto.
     * @return descripción (puede ser vacía, nunca nula).
     */
    public String getDescripcion() {
        return descripcion;
    }
    
    /**
     * Obtiene el precio unitario actual.
     * @return precio en euros (>= 0).
     */
    public double getPrecioUnitario() {
        return precioUnitario;
    }
    
    /**
     * Obtiene la cantidad disponible en stock.
     * @return stock actual (>= 0).
     */
    public int getStock() {
        return stock;
    }
    
    // Setters (solo para atributos que pueden modificarse después de la creación)
    
    /**
     * Cambia el nombre del producto.
     * @param nombre nuevo nombre (no nulo ni vacío).
     * @throws IllegalArgumentException si el nombre no es válido.
     */
    public void setNombre(String nombre) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }
        this.nombre = nombre;
    }
    
    /**
     * Cambia la descripción del producto.
     * @param descripcion nueva descripción (puede ser vacía, pero no nula).
     * @throws IllegalArgumentException si la descripción es nula.
     */
    public void setDescripcion(String descripcion) {
        if (descripcion == null) {
            throw new IllegalArgumentException("La descripción no puede ser nula");
        }
        this.descripcion = descripcion;
    }
    
    /**
     * Establece un nuevo precio unitario.
     * @param precioUnitario nuevo precio (>= 0).
     * @throws IllegalArgumentException si el precio es negativo.
     */
    public void setPrecioUnitario(double precioUnitario) {
        if (precioUnitario < 0) {
            throw new IllegalArgumentException("El precio unitario no puede ser negativo");
        }
        this.precioUnitario = precioUnitario;
    }
    
    /**
     * Ajusta el stock del producto (para compras, ventas o reposiciones).
     * @param nuevoStock nueva cantidad disponible (>= 0).
     * @throws IllegalArgumentException si el stock es negativo.
     */
    public void setStock(int nuevoStock) {
        if (nuevoStock < 0) {
            throw new IllegalArgumentException("El stock no puede ser negativo");
        }
        this.stock = nuevoStock;
    }
    
    /**
     * Reduce el stock en una cantidad específica (para cuando se realiza un pedido).
     * @param cantidad cantidad a restar (debe ser positiva y no superar el stock actual).
     * @return true si se pudo reducir el stock, false si no hay suficiente stock.
     * @throws IllegalArgumentException si la cantidad es negativa.
     */
    public boolean reducirStock(int cantidad) {
        if (cantidad < 0) {
            throw new IllegalArgumentException("La cantidad a reducir no puede ser negativa");
        }
        if (cantidad > this.stock) {
            return false;
        }
        this.stock -= cantidad;
        return true;
    }
    
    /**
     * Aumenta el stock (para reposiciones o devoluciones).
     * @param cantidad cantidad a añadir (debe ser positiva).
     * @throws IllegalArgumentException si la cantidad es negativa.
     */
    public void aumentarStock(int cantidad) {
        if (cantidad < 0) {
            throw new IllegalArgumentException("La cantidad a aumentar no puede ser negativa");
        }
        this.stock += cantidad;
    }
    
    /**
     * Calcula el precio total para una cantidad determinada (sin aplicar descuentos).
     * Este método es un stub base. En el futuro se podría extender para aplicar
     * descuentos por cantidad, etc.
     * 
     * @param cantidad número de unidades (debe ser > 0).
     * @return precio total = cantidad * precioUnitario.
     * @throws IllegalArgumentException si cantidad <= 0.
     */
    public double calcularPrecioTotal(int cantidad) {
        if (cantidad <= 0) {
            throw new IllegalArgumentException("La cantidad debe ser mayor que 0");
        }
        // TODO: implementar lógica de descuentos progresivos si se requiere
        return cantidad * this.precioUnitario;
    }
    
    /**
     * Representación textual del producto.
     * @return cadena con ID, nombre, precio y stock.
     */
    @Override
    public String toString() {
        return String.format("Producto{id=%d, nombre='%s', precio=%.2f€, stock=%d}", 
                             id, nombre, precioUnitario, stock);
    }
    
    /**
     * Dos productos se consideran iguales si tienen el mismo ID.
     * @param obj objeto a comparar.
     * @return true si tienen el mismo id.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Producto producto = (Producto) obj;
        return id == producto.id;
    }
    
    @Override
    public int hashCode() {
        return Integer.hashCode(id);
    }
}

