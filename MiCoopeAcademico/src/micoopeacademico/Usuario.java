// Clase base que guarda los datos de acceso de los usuarios
// y permite identificar si son asociados o agentes.

package micoopeacademico;
public abstract class Usuario {
    private final String nombreUsuario;
    private final String contrasena;
    protected Usuario(String nombreUsuario, String contrasena) {
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public boolean validarContrasena(String contrasenaIngresada) {
        return contrasena.equals(contrasenaIngresada);
    }

    public abstract RolUsuario getRol();
}
