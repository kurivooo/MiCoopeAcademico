// Clase para guardar la información de cada beneficio disponible para los asociados.

package micoopeacademico;
public class Beneficio {
    private final int codigo;
    private final String nombre;
    private final String descripcion;
    public Beneficio(int codigo, String nombre, String descripcion) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
