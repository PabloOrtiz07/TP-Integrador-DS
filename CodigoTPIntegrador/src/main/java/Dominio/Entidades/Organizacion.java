package Dominio.Entidades;

import Dominio.Lugares.Espacio;
import Dominio.Medicion.Medicion;
import LectoresArchivo.DataLoader;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.List;

public class Organizacion {
    private String razonSocial;
    private TipoOrganizacion tipoOrganizacion;
    private TipoClasificacion tipoClasificacion;
    private Espacio espacio;
    private List<Area> areas = new ArrayList<>();
    private List<Medicion> mediciones = new ArrayList<>();

    public Organizacion(String razonSocial, TipoOrganizacion tipoOrganizacion, TipoClasificacion tipoClasificacion, Espacio espacio) {
        this.razonSocial = razonSocial;
        this.tipoOrganizacion = tipoOrganizacion;
        this.tipoClasificacion = tipoClasificacion;
        this.espacio = espacio;
    }

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

    public List<Area> getAreas() {
        return areas;
    }

    public void setArea(List<Area> areas) {
        this.areas = areas;
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

    public List<Medicion> getMedicion() {
        return mediciones;
    }

    public void setMedicion(List<Medicion> mediciones) {
        this.mediciones = mediciones;
    }

    public void agregarArea(Area area) throws Exception{
        if(areas.stream().anyMatch(area1 ->area1.getNombreArea().equals(area.getNombreArea())))
            throw new Exception("Ya existe ese area en esta organizacion");
        areas.add(area);
    }

    //con esto cargo las mediciones
    public void cargaMediciones(String path){
        DataLoader dataLoader = new DataLoader();
        setMedicion(dataLoader.cargaDatosDeActividad(path));
    }
}
