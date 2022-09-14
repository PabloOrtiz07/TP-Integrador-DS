package Dominio.Lugares;

public class Espacio extends Ubicacion{
    private TipoEspacio tipoEspacio;
    public Espacio(String pais, String provincia, String localidad, String municipio, String calle, String altura, TipoEspacio tipoEspacio) {
        super(pais,provincia,localidad,municipio,calle,altura);
        this.tipoEspacio = tipoEspacio;
    }


}
