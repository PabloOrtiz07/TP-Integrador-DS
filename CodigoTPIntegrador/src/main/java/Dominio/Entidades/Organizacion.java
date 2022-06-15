package Dominio.Entidades;

import Dominio.Lugares.Espacio;

import Dominio.Medicion;

public class Organizacion {
    private String razonSocial;
    private TipoOrganizacion tipoOrganizacion;
    private Area area;
    private TipoClasificacion tipoClasificacion;
    private Espacio espacio;
    private Medicion medicion;

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public TipoOrganizacion getTipoOrganizacion() {
        return tipoOrganizacion;
    }

    public void setTipoOrganizacion(TipoOrganizacion tipoOrganizacion) {
        this.tipoOrganizacion = tipoOrganizacion;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public TipoClasificacion getTipoClasificacion() {
        return tipoClasificacion;
    }

    public void setTipoClasificacion(TipoClasificacion tipoClasificacion) {
        this.tipoClasificacion = tipoClasificacion;
    }

    public Espacio getEspacio() {
        return espacio;
    }

    public void setEspacio(Espacio espacio) {
        this.espacio = espacio;
    }

    public Medicion getMedicion() {
        return medicion;
    }

    public void setMedicion(Medicion medicion) {
        this.medicion = medicion;
    }
}
