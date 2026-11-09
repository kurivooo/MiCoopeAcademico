// Esta clase administra los usuarios, los beneficios disponibles
// y las solicitudes que realizan cada uno de los asociados.

package micoopeacademico;
import java.util.ArrayList;
public class SistemaBeneficios {
    private final ArrayList<Usuario> usuarios = new ArrayList<>();
    private final ArrayList<Beneficio> beneficios = new ArrayList<>();
    private final ArrayList<Solicitud> solicitudes = new ArrayList<>();
    private Usuario usuarioActual;
    private int siguienteNumeroSolicitud = 1;

    //Usuarios de ejemplo para ambos perfiles.
    public SistemaBeneficios() {
        usuarios.add(new Asociado("asociado01", "asociado123"));
        usuarios.add(new Agente("agente01", "agente123"));

        //Catálogo de beneficios disponibles para los asociados que tendra nuestra cooperativa.
        beneficios.add(new Beneficio(1, "Beneficio Odontológico",
                "Apoyo económico para procedimientos odontológicos, exclusivos para asociados."));
        beneficios.add(new Beneficio(2, "Beneficio Oftalmológico",
                "Apoyo económico para procedimientos oftalmológicos, exclusivos para asociados."));
        beneficios.add(new Beneficio(3, "Ultrasonido General",
                "Apoyo económico para procedimientos de un ultrasonido general, exclusivos para asociados."));
    }

    public boolean iniciarSesion(String nombreUsuario, String contrasena) {
        usuarioActual = null;
        if (nombreUsuario == null || nombreUsuario.trim().isEmpty()
                || contrasena == null || contrasena.trim().isEmpty()) {
            throw new IllegalArgumentException("Ingrese su usuario y contraseña para ingresar.");
        }

        String nombreIngresado = nombreUsuario.trim();
        for (Usuario usuario : usuarios) {
            if (usuario.getNombreUsuario().equals(nombreIngresado)
                    && usuario.validarContrasena(contrasena)) {
                usuarioActual = usuario;
                return true;
            }
        }
        return false;
    }

    public Usuario getUsuarioActual() {
        return usuarioActual;
    }

    public ArrayList<Beneficio> consultarBeneficios() {
        verificarAsociado();
        return new ArrayList<>(beneficios);
    }

    public Solicitud registrarSolicitud(int codigoBeneficio, String motivo) {
        verificarAsociado();
        if (motivo == null || motivo.trim().isEmpty()) {
            throw new IllegalArgumentException("Indique el procedimiento realizado.");
        }

        for (Beneficio beneficio : beneficios) {
            if (beneficio.getCodigo() == codigoBeneficio) {
                Solicitud solicitud = new Solicitud(siguienteNumeroSolicitud,
                        usuarioActual, beneficio, motivo.trim());
                solicitudes.add(solicitud);
                siguienteNumeroSolicitud++;
                return solicitud;
            }
        }
        throw new IllegalArgumentException("Seleccione un beneficio disponible.");
    }

    private void verificarAsociado() {
        if (usuarioActual == null || usuarioActual.getRol() != RolUsuario.ASOCIADO) {
            throw new IllegalStateException("Debe iniciar sesión como asociado.");
        }
    }
}
