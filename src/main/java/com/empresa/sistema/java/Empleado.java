package e;

/**
 * Representa un empleado genérico de la empresa.
 * Esta clase sirve como base para empleados con distintos roles (Gerente, Técnico, etc.).
 * 
 * @author TuNombre
 * @version 1.0
 */
public class Empleado {
    
    // Atributos privados (encapsulamiento)
    private int id;
    private String nombre;
    private double salarioBase;
    
    /**
     * Constructor completo para inicializar un empleado.
     * 
     * @param id          Identificador único del empleado (debe ser positivo).
     * @param nombre      Nombre completo del empleado (no puede ser nulo o vacío).
     * @param salarioBase Salario base mensual en euros (debe ser mayor que 0).
     * @throws IllegalArgumentException si algún parámetro no cumple las condiciones.
     */
    public Empleado(int id, String nombre, double salarioBase) {
        if (id <= 0) {
            throw new IllegalArgumentException("El ID debe ser positivo");
        }
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }
        if (salarioBase <= 0) {
            throw new IllegalArgumentException("El salario base debe ser mayor que 0");
        }
        this.id = id;
        this.nombre = nombre;
        this.salarioBase = salarioBase;
    }
    
    /**
     * Obtiene el identificador del empleado.
     * @return el ID (siempre positivo).
     */
    public int getId() {
        return id;
    }
    
    /**
     * Obtiene el nombre del empleado.
     * @return el nombre completo (nunca nulo ni vacío).
     */
    public String getNombre() {
        return nombre;
    }
    
    /**
     * Cambia el nombre del empleado.
     * @param nombre nuevo nombre (no puede ser nulo o vacío).
     * @throws IllegalArgumentException si el nombre no es válido.
     */
    public void setNombre(String nombre) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }
        this.nombre = nombre;
    }
    
    /**
     * Obtiene el salario base del empleado.
     * @return salario base en euros.
     */
    public double getSalarioBase() {
        return salarioBase;
    }
    
    /**
     * Establece un nuevo salario base.
     * @param salarioBase debe ser mayor que 0.
     * @throws IllegalArgumentException si el salario no es positivo.
     */
    public void setSalarioBase(double salarioBase) {
        if (salarioBase <= 0) {
            throw new IllegalArgumentException("El salario base debe ser mayor que 0");
        }
        this.salarioBase = salarioBase;
    }
    
    /**
     * Calcula el salario total del empleado (incluye posibles bonos, horas extra, etc.).
     * Este método debe ser sobrescrito por las subclases (Gerente, Vendedor, etc.).
     * 
     * @return salario total calculado.
     * @throws UnsupportedOperationException si la clase hija no implementa este método.
     */
    public double calcularSalarioTotal() {
        // Stub: método pendiente de implementar en clases hijas
        throw new UnsupportedOperationException("TODO: implementar en subclase según tipo de empleado");
    }
    
    /**
     * Representación textual del empleado.
     * @return cadena con el ID y nombre del empleado.
     */
    @Override
    public String toString() {
        return String.format("Empleado{id=%d, nombre='%s', salarioBase=%.2f}", 
                             id, nombre, salarioBase);
    }
    
    /**
     * Dos empleados se consideran iguales si tienen el mismo ID.
     * @param obj objeto a comparar.
     * @return true si tienen el mismo id.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Empleado empleado = (Empleado) obj;
        return id == empleado.id;
    }
    
    @Override
    public int hashCode() {
        return Integer.hashCode(id);
    }
}