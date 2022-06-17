package Dominio.Lugares;

public class Ubicacion {

    //TODO: En el diagrama por alguna razon falto cambiar que pais y provincia tambien sean string como el resto de los campos, por ahi algun ctrl z malvado
    private String pais;
    private String provincia;
    private String localidad;
    private String municipio;
    private String calle;
    private String altura;

    public Ubicacion(String pais, String provincia, String localidad, String municipio, String calle, String altura) {
        this.pais = pais;
        this.provincia = provincia;
        this.localidad = localidad;
        this.municipio = municipio;
        this.calle = calle;
        this.altura = altura;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getAltura() {
        return altura;
    }

    public void setAltura(String altura) {
        this.altura = altura;
    }
}
