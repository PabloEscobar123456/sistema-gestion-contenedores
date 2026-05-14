package com.biblioteca.service;

import com.biblioteca.model.*;
import java.util.*;

/**
 * Servicio principal de la biblioteca.
 * TODO: Implementar persistencia con base de datos
 * 
 * @author Desarrollador Senior DAW
 */
public class BibliotecaService {
    private final Map<String, Libro> catalogo;
    private final Map<String, Usuario> usuarios;
    private final List<Prestamo> prestamosHistoricos;
    
    public BibliotecaService() {
        this.catalogo = new HashMap<>();
        this.usuarios = new HashMap<>();
        this.prestamosHistoricos = new ArrayList<>();
    }
    
    /**
     * Registra un nuevo préstamo.
     * TODO: Validar límite de préstamos por usuario
     * 
     * @param isbn ISBN del libro
     * @param usuarioId ID del usuario
     * @return Préstamo creado
     * @throws IllegalStateException si el libro no está disponible
     */
    public Prestamo realizarPrestamo(String isbn, String usuarioId) {
        // TODO: Implementar validación de límite (máx 3 préstamos)
        throw new UnsupportedOperationException("Método no implementado aún");
    }
    
    /**
     * Procesa la devolución de un libro.
     * TODO: Calcular multas automáticamente
     */
    public void devolverLibro(String prestamoId) {
        // TODO: Implementar cálculo de multas por retraso
        throw new UnsupportedOperationException("Método no implementado aún");
    }
    
    /**
     * Busca libros por título o autor.
     * 
     * @param criterio Texto a buscar
     * @return Lista de libros que coinciden
     */
    public List<Libro> buscarLibros(String criterio) {
        // TODO: Implementar búsqueda eficiente con índices
        throw new UnsupportedOperationException("Método no implementado aún");
    }
}