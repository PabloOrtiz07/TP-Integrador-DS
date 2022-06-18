package Dominio.Lugares;

public class Ubicacion {

    private String pais;
    private String provincia;
    private String localidad;
    private String municipio;
    private String calle;
    private String altura;

    public Ubicacion(String[] datosUbicacion) {
        this.pais = datosUbicacion[0];
        this.provincia = datosUbicacion[1];
        this.localidad = datosUbicacion[2];
        this.municipio = datosUbicacion[3];
        this.calle = datosUbicacion[4];
        this.altura = datosUbicacion[5];
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
