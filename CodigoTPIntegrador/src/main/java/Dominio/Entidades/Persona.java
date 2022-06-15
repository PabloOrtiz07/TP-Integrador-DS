package Dominio.Entidades;

//TODO: Agregar persona al paquete entidades en el diagrama
public class Persona {
    private String nombre;
    private String apellido;
    private String numeroDocumento;
    private String tipoDocumento;

    private Miembro[] miembros;

    public Miembro[] getMiembros() {
        return miembros;
    }

    public void setMiembros(Miembro[] miembros) {
        this.miembros = miembros;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }
}
