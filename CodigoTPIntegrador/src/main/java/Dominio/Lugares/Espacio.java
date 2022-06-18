package Dominio.Lugares;

public class Espacio extends Ubicacion{
    private TipoEspacio tipoEspacio;
    public Espacio(String[] datosUbicacion, TipoEspacio tipoEspacio) {
        super(datosUbicacion);
        this.tipoEspacio = tipoEspacio;
    }
}
