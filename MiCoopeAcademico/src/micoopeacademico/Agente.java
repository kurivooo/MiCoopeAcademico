// Clase que representa a los agentes encargados de revisar y gestionar las solicitudes de beneficios entrantes.
package micoopeacademico;
public class Agente extends Usuario {
    public Agente(String nombreUsuario, String contrasena) {
        super(nombreUsuario, contrasena);
    }

    @Override
    public RolUsuario getRol() {
        return RolUsuario.AGENTE;
    }
}
