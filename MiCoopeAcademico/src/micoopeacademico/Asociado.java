// Clase para representar a los asociados que pueden consultar beneficios y realizar solicitudes.
package micoopeacademico;
public class Asociado extends Usuario {
    public Asociado(String nombreUsuario, String contrasena) {
        super(nombreUsuario, contrasena);
    }

    @Override
    public RolUsuario getRol() {
        return RolUsuario.ASOCIADO;
    }
}
