package Dominio.Entidades;

import Dominio.Lugares.Ubicacion;
import Dominio.Transportes.Transporte;
import Dominio.Viajes.Tramo;
import Dominio.Viajes.Trayecto;
import java.util.ArrayList;
import java.util.List;

public class Miembro {
    private Area areaPertenece = null;
    private Persona persona;
    private List<Tramo> tramos = new ArrayList<>();
    private List<Trayecto> trayectos = new ArrayList<>();

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
    public void cargarTrayecto(Ubicacion ubicacionInicio, Ubicacion ubicacionFinal) {
        Trayecto trayecto = new Trayecto(ubicacionInicio, ubicacionFinal);
        trayectos.add(trayecto);
    }
    public void cargarTramoATrayecto(Ubicacion ubicacionInicio, Ubicacion ubicacionFinal, Trayecto trayecto, Transporte transporte, List<Miembro> miembros) throws Exception {
        Tramo tramo = new Tramo(ubicacionInicio, ubicacionFinal, trayecto, transporte, miembros);
        trayecto.agregarTramo(tramo);
        for(Miembro miembro : miembros)
            miembro.agregarTramo(tramo);
    }

    public void agregarTramo(Tramo tramo){
        tramos.add(tramo);
    }

    public String getDatosPersonales(){
        return persona.getNombre() + " " + persona.getApellido();
    }
}
