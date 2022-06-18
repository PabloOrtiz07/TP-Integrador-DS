package Dominio.Entidades;

import Dominio.Viajes.Trayecto;

public class Miembro {
    private Area areaPertenece;
    private Persona persona;
    private Trayecto[] trayectos;




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

    public Trayecto[] getTrayectos() {
        return trayectos;
    }

    public void setTrayectos(Trayecto[] trayectos) {
        this.trayectos = trayectos;
    }

    public Miembro(Area areaPertenece) {
        this.areaPertenece = areaPertenece;
    }
}
