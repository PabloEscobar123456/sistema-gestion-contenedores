package e;

import java.util.ArrayList;
import java.util.List;

public class Empresa {
    private List<Empleado> empleados;  // Relación 1:N

    public Empresa() {
        this.empleados = new ArrayList<>();
    }

    public void añadirEmpleado(Empleado e) {
        empleados.add(e);
    }
}