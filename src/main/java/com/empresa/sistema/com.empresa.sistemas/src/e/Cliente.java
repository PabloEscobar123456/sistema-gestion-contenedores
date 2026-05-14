package e;

/**
 * Representa un cliente del sistema.
 * @author TuNombre
 * @version 1.0
 */
public class Cliente {
    private String email;

    /**
     * Obtiene el correo electrónico del cliente.
     * @return el email nunca es nulo
     */
    public String getEmail() {
        return email;
    }

    /**
     * Cambia el correo electrónico.
     * @param nuevoEmail debe tener formato válido (no validado en este método)
     * @throws IllegalArgumentException si nuevoEmail es null o vacío
     */
    public void setEmail(String nuevoEmail) {
        if (nuevoEmail == null || nuevoEmail.isBlank()) {
            throw new IllegalArgumentException("Email no puede estar vacío");
        }
        this.email = nuevoEmail;
    }
}