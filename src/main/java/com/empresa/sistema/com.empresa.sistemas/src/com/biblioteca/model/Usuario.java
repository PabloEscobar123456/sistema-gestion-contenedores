package com.biblioteca.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa un usuario de la biblioteca.
 * Un usuario puede tener múltiples préstamos activos (relación 1:N).
 * 
 * @author Desarrollador Senior DAW
 */
public class Usuario {
    private final String id;
    private String nombre;
    private String email;
    private final List<Prestamo> prestamosActivos;
    
    public Usuario(String id, String nombre, String email) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.prestamosActivos = new ArrayList<>();
    }
    
    /**
     * Agrega un préstamo al usuario.
     * 
     * @param prestamo Préstamo a agregar
     */
    public void addPrestamo(Prestamo prestamo) {
        if (prestamo != null) {
            this.prestamosActivos.add(prestamo);
        }
    }
    
    /**
     * Elimina un préstamo de la lista activa.
     * 
     * @param prestamo Préstamo a eliminar
     */
    public void removePrestamo(Prestamo prestamo) {
        this.prestamosActivos.remove(prestamo);
    }
    
    /**
     * Obtiene el número de préstamos activos.
     * 
     * @return cantidad de préstamos
     */
    public int getNumPrestamosActivos() {
        return prestamosActivos.size();
    }
    
    // Getters y setters necesarios
    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public List<Prestamo> getPrestamosActivos() { 
        return new ArrayList<>(prestamosActivos); // Copia defensiva
    }
}