package com.biblioteca.model;

/**
 * Representa un libro en el sistema de biblioteca.
 * Un libro puede ser prestado y pertenece a una categoría.
 * 
 * @author Desarrollador Senior DAW
 * @version 1.0
 */
public class Libro {
    private String isbn;
    private String titulo;
    private String autor;
    private int anioPublicacion;
    private boolean disponible;
    
    /**
     * Constructor para crear un nuevo libro.
     * Por defecto, el libro está disponible.
     * 
     * @param isbn Identificador único del libro
     * @param titulo Título del libro
     * @param autor Nombre del autor
     * @param anioPublicacion Año de publicación
     */
    public Libro(String isbn, String titulo, String autor, int anioPublicacion) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.anioPublicacion = anioPublicacion;
        this.disponible = true;
    }
    
    // Getters y Setters (solo donde es necesario)
    public String getIsbn() { return isbn; }
    
    public void setIsbn(String isbn) { 
        if (isbn == null || isbn.trim().isEmpty()) {
            throw new IllegalArgumentException("ISBN no puede estar vacío");
        }
        this.isbn = isbn; 
    }
    
    public String getTitulo() { return titulo; }
    
    public String getAutor() { return autor; }
    
    public boolean isDisponible() { return disponible; }
    
    public void setDisponible(boolean disponible) { 
        this.disponible = disponible; 
    }
    
    @Override
    public String toString() {
        return String.format("%s - %s (%d)", titulo, autor, anioPublicacion);
    }
}