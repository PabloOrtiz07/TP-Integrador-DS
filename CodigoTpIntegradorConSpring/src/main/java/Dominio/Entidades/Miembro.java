package Dominio.Entidades;

import CalculoHC.CalculadoraHC;
import Dominio.Transportes.Transporte;
import Dominio.Viajes.Tramo;
import Dominio.Viajes.Trayecto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Miembro {
    private Area areaPertenece = null;
    private Persona persona;
    private List<Tramo> tramos = new ArrayList<>();
    private List<Trayecto> trayectos = new ArrayList<>();
    private CalculadoraHC calculadoraHC = new CalculadoraHC();

    public LocalDate getFechaDeIngreso() {
        return fechaDeIngreso;
    }

    public void setFechaDeIngreso(LocalDate fechaDeIngreso) {
        this.fechaDeIngreso = fechaDeIngreso;
    }

    private LocalDate fechaDeIngreso;


    public List<Tramo> getTramos() {
        return tramos;
    }

    public void setTramos(List<Tramo> tramos) {
        this.tramos = tramos;
    }

    public Miembro(Persona persona) {
        this.persona = persona;
    }

    public List<Trayecto> getTrayectos() {
        return trayectos;
    }

    public void setTrayectos(List<Trayecto> trayectos) {
        this.trayectos = trayectos;
    }

    public Area getAreaPertenece() {
        return areaPertenece;
    }


    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public String getDocumentoMiembro(){
        return persona.getNumeroDocumento();
    }

    public void enviarSolicitud(Organizacion organizacion, String nombreArea){
        organizacion.recibirSolicitud(this, nombreArea);
    }

    public void asociarAArea(Area area){
        this.areaPertenece = area;
    }
    public void cargarTrayecto(Trayecto trayecto) {
        trayectos.add(trayecto);
    }
    public void agregarTramoATrayecto(Tramo tramo, Trayecto trayecto, Transporte transporte) throws Exception {
        if(!trayectos.contains(trayecto))
            throw new Exception("El miembro no tiene ese trayecto cargado");
        trayecto.agregarTramo(tramo);
        tramo.setTrayecto(trayecto);
    }

    public void agregarTramo(Tramo tramo){
        tramos.add(tramo);
    }

    public String getDatosPersonales(){
        return persona.getNombre() + " " + persona.getApellido();
    }

    public double calcularHCPersonal() throws Exception {
        return calculadoraHC.calcularHcTrayectosPersonal(this.trayectos);
    }

    public double impactoMiembroEnHCOrg() throws Exception {
        return this.calcularHCPersonal() * 100 / this.areaPertenece.getOrganizacion().calcularHC();
    }

    /**/
}
