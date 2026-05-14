package com.biblioteca.model;

import java.time.LocalDate;

/**
 * Representa el préstamo de un libro a un usuario dentro del sistema
 * de biblioteca.
 * <p>
 * La clase gestiona la información relacionada con el préstamo,
 * incluyendo fechas de préstamo y devolución, así como la relación
 * entre {@link Libro} y {@link Usuario}.
 * </p>
 * <p>
 * Al crear un préstamo, el libro pasa automáticamente a estado
 * no disponible.
 * </p>
 *
 * @author Desarrollador Senior DAW
 * @version 1.0
 */
public class Prestamo {

    /** Identificador único del préstamo. */
    private final String id;

    /** Fecha en la que se realiza el préstamo. */
    private final LocalDate fechaPrestamo;

    /** Fecha límite prevista para la devolución del libro. */
    private LocalDate fechaDevolucionPrevista;

    /** Fecha real en la que el usuario devuelve el libro. */
    private LocalDate fechaDevolucionReal;

    /** Libro asociado al préstamo. */
    private final Libro libro;

    /** Usuario que realiza el préstamo. */
    private final Usuario usuario;

    /**
     * Crea un nuevo préstamo para un libro y un usuario.
     * <p>
     * La fecha de préstamo se establece automáticamente con la fecha actual
     * y la devolución prevista se calcula a 14 días desde dicha fecha.
     * </p>
     *
     * @param libro   libro que se desea prestar; no puede ser {@code null}
     * @param usuario usuario que recibe el préstamo; no puede ser {@code null}
     *
     * @throws IllegalArgumentException si {@code libro} o {@code usuario}
     *                                  son {@code null}
     */
    public Prestamo(Libro libro, Usuario usuario) {
        if (libro == null || usuario == null) {
            throw new IllegalArgumentException(
                "Libro y usuario no pueden ser null"
            );
        }

        this.id = java.util.UUID.randomUUID().toString();
        this.libro = libro;
        this.usuario = usuario;
        this.fechaPrestamo = LocalDate.now();
        this.fechaDevolucionPrevista = fechaPrestamo.plusDays(14);
        this.fechaDevolucionReal = null;

        // Actualizar disponibilidad del libro
        this.libro.setDisponible(false);
    }

    /**
     * Registra la devolución del libro prestado.
     * <p>
     * La devolución actualiza la fecha real de devolución,
     * marca el libro como disponible y elimina el préstamo
     * de la lista de préstamos del usuario.
     * </p>
     * <p>
     * Pendiente de implementación:
     * cálculo de multas por retraso.
     * </p>
     */
    public void devolver() {
        this.fechaDevolucionReal = LocalDate.now();
        this.libro.setDisponible(true);
        this.usuario.removePrestamo(this);
    }

    /**
     * Comprueba si el préstamo se encuentra vencido.
     * <p>
     * Un préstamo se considera vencido cuando no ha sido devuelto
     * y la fecha actual supera la fecha prevista de devolución.
     * </p>
     *
     * @return {@code true} si el préstamo está vencido;
     *         {@code false} en caso contrario
     */
    public boolean estaVencido() {
        return fechaDevolucionReal == null
                && LocalDate.now().isAfter(fechaDevolucionPrevista);
    }

    /**
     * Devuelve el identificador único del préstamo.
     *
     * @return identificador del préstamo
     */
    public String getId() {
        return id;
    }

    /**
     * Devuelve el libro asociado al préstamo.
     *
     * @return libro prestado
     */
    public Libro getLibro() {
        return libro;
    }

    /**
     * Devuelve el usuario asociado al préstamo.
     *
     * @return usuario del préstamo
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * Devuelve la fecha en la que se realizó el préstamo.
     *
     * @return fecha de préstamo
     */
    public LocalDate getFechaPrestamo() {
        return fechaPrestamo;
    }

    /**
     * Devuelve la fecha real de devolución del libro.
     *
     * @return fecha de devolución real o {@code null}
     *         si aún no se ha devuelto
     */
    public LocalDate getFechaDevolucionReal() {
        return fechaDevolucionReal;
    }
}