package com.empresa.sistemas;

public class Main {

    public static void main(String[] args) {

        try {
            // Crear vehículo
            Vehiculo camion = new Vehiculo("1234ABC", "Volvo FH16", 5000);

            // Crear contenedores
            Contenedor c1 = new Contenedor(1500);
            Contenedor c2 = new Contenedor(2000);
            Contenedor c3 = new Contenedor(2000);

            // Cargar contenedores
            camion.cargar(c1);
            System.out.println("Contenedor 1 cargado");

            camion.cargar(c2);
            System.out.println("Contenedor 2 cargado");

            camion.cargar(c3);
            System.out.println("Contenedor 3 cargado");

        } catch (CapacidadExcedidaException e) {
            System.err.println(" Error al cargar: " + e.getMessage());
        }

        // Esto siempre se ejecuta (haya error o no)
        System.out.println("Programa finalizado");
    }
}