package Dominio.Entidades;

import CalculoHC.CalculadoraHC;
import Dominio.Lugares.Espacio;
import Dominio.Lugares.Ubicacion;
import Dominio.Medicion.Medicion;
import Dominio.Viajes.Trayecto;
import LectoresArchivo.LeerExcel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class Organizacion {
    private String razonSocial;
    private TipoOrganizacion tipoOrganizacion;
    private TipoClasificacion tipoClasificacion;
    private Espacio espacio;
    private List<Area> areas = new ArrayList<>();
    private List<Medicion> mediciones = new ArrayList<>();

    private List<Contacto> contactos = new ArrayList<>();
    private  HashMap<Miembro, Area> solicitudes = new HashMap<Miembro, Area>();

    private CalculadoraHC calculadoraHC = new CalculadoraHC();

    public Organizacion(String razonSocial, TipoOrganizacion tipoOrganizacion, TipoClasificacion tipoClasificacion, Espacio espacio) {
        this.razonSocial = razonSocial;
        this.tipoOrganizacion = tipoOrganizacion;
        this.tipoClasificacion = tipoClasificacion;
        this.espacio = espacio;
    }

    public String getRazonSocial() {
        return razonSocial;
    }
    public TipoOrganizacion getTipoOrganizacion() {
        return tipoOrganizacion;
    }

    public List<Area> getAreas() {
        return areas;
    }
    public TipoClasificacion getTipoClasificacion() {
        return tipoClasificacion;
    }

    public List<Medicion> getMediciones() {
        return mediciones;
    }

    public void agregarArea(Area area) throws Exception{
        if(areas.stream().anyMatch(area1 ->area1.getNombreArea().equals(area.getNombreArea())))
            throw new Exception("Ya existe ese area en esta organizacion");
        area.setOrganizacion(this);
        areas.add(area);
    }

    public Area getAreaPorNombre(String nombreArea){
       return areas.stream().filter(area -> area.getNombreArea().equals(nombreArea)).findAny().get();
    }
    public List<Miembro> getMiembros(){
        return areas.stream().flatMap(area -> area.getMiembrosArea().stream()).collect(Collectors.toList());
    }
    public Miembro getMiembroPorDocumento(String documento){
       return areas.stream().map(area -> area.getMiembroPorDocumento(documento)).findAny().get();
    }

    public void recibirSolicitud(Miembro miembro, String nombreArea) throws NoSuchElementException{
        Area area = getAreaPorNombre(nombreArea);
        solicitudes.put(miembro, area);
    }
    public void aceptarSolicitud(Miembro miembro) throws NoSuchElementException{
        Area area = solicitudes.get(miembro);
        area.agregarMiembro(miembro);
        solicitudes.remove(miembro);
    }

    public void agregarContacto(Contacto contacto){
        contactos.add(contacto);
    }

    public List<Contacto> getContactos(){
        return contactos;
    }

    public void cargarMediciones(String path){
        LeerExcel leerExcel = new LeerExcel();
        mediciones.addAll(leerExcel.cargaDatosDeActividad(path));
    }

    public double calcularHC(){
        try {
            return calculadoraHC.calcularHCOrganizacion(this.getTrayectosOrganizacion(), this.mediciones, 20.0); //preguntar lo del K
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Boolean estaEnLaProvincia(String provincia){
        return espacio.getProvincia().equals(provincia);
    }

    public Boolean estaEnElMunicipio(String municipio){
        return espacio.getMunicipio().equals(municipio);
    }

    public List<Trayecto> getTrayectosOrganizacion(){
        return areas.stream().flatMap(area -> area.getTrayectosMiembrosArea().stream()).collect(Collectors.toList());
    }
    public Ubicacion getUbicacion(){
        return this.espacio;
    }


}
