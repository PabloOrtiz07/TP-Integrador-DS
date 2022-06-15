package Dominio.Entidades;

import Dominio.Viajes.Trayecto;
//TODO: Viendo como tenemos el diagrama ahora creo que un miembro no podria tener trayectos, solo Tramos
// supongo que juntando los tramos que pertenecen a un mismo traytecto se puede armar la lista de trayectos pero es bastante quilombo
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
}
