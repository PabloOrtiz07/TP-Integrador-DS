package Dominio.Entidades;

import Dominio.Viajes.Trayecto;
import java.util.ArrayList;
import java.util.List;

public class Miembro {
    private Area areaPertenece;
    private Persona persona;

    private List<Trayecto> trayectos = new ArrayList<>();

    public List<Trayecto> getTrayectos() {
        return trayectos;
    }

    public void setTrayectos(List<Trayecto> trayectos) {
        this.trayectos = trayectos;
    }

    public Area getAreaPertenece() {
        return areaPertenece;
    }

    public void setAreaPertenece(Area areaPertenece) {
        this.areaPertenece = areaPertenece;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Miembro(Area areaPertenece) {
        this.areaPertenece = areaPertenece;
    }
}
