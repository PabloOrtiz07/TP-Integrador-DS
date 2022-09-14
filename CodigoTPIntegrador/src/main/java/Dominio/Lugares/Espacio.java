package Dominio.Lugares;

public class Espacio {
    private TipoEspacio tipoEspacio;
    private Ubicacion ubicacion;
    public Espacio(Ubicacion ubicacion, TipoEspacio tipoEspacio) {
        this.ubicacion=ubicacion;
        this.tipoEspacio = tipoEspacio;
    }

    public Ubicacion getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(Ubicacion ubicacion) {
        this.ubicacion = ubicacion;
    }
}
