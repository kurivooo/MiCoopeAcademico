// Clase que guarda la información de cada solicitud realizada por un asociado,
// incluyendo el beneficio seleccionado y su estado.

package micoopeacademico;
public class Solicitud {
    private final int numero;
    private final Usuario asociado;
    private final Beneficio beneficio;
    private final String motivo;
    private final EstadoSolicitud estado;
    Solicitud(int numero, Usuario asociado, Beneficio beneficio, String motivo) {
        this.numero = numero;
        this.asociado = asociado;
        this.beneficio = beneficio;
        this.motivo = motivo;
        estado = EstadoSolicitud.PENDIENTE;
    }

    public int getNumero() {
        return numero;
    }

    public Usuario getAsociado() {
        return asociado;
    }

    public Beneficio getBeneficio() {
        return beneficio;
    }

    public String getMotivo() {
        return motivo;
    }

    public EstadoSolicitud getEstado() {
        return estado;
    }
}
