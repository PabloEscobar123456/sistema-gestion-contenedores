package com.empresa.sistemas;

import java.util.ArrayList;
import java.util.List;

public class Vehiculo {

    private String matricula;
    private String modelo;
    private int capacidadMaxima;
    private List<Contenedor> contenedoresCargados;

    // Constructor
    public Vehiculo(String matricula, String modelo, int capacidadMaxima) {
        this.matricula = matricula;
        this.modelo = modelo;
        this.capacidadMaxima = capacidadMaxima;
        this.contenedoresCargados = new ArrayList<>();
    }

    /**
     * Carga un contenedor en el vehículo.
     */
    public void cargar(Contenedor c) throws CapacidadExcedidaException {

        if (contenedoresCargados.size() >= capacidadMaxima) {

            throw new CapacidadExcedidaException(
                "Capacidad máxima alcanzada"
            );
        }

        contenedoresCargados.add(c);
    }

    /**
     * Calcula el peso total.
     */
    public double calcularPesoTotal() {

        double total = 0;

        for (Contenedor c : contenedoresCargados) {
            total += c.getPeso();
        }

        return total;
    }

    // GETTERS Y SETTERS

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }

    public void setCapacidadMaxima(int capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
    }

    public List<Contenedor> getContenedoresCargados() {
        return contenedoresCargados;
    }

    public void setContenedoresCargados(List<Contenedor> contenedoresCargados) {
        this.contenedoresCargados = contenedoresCargados;
    }
}