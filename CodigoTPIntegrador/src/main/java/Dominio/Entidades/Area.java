package Dominio.Entidades;

public class Area {
    private String nombreArea;
    private Organizacion organizacion;
    private Miembro[] miembrosArea;

    public Area(String nombre, Organizacion organizacion){
        this.nombreArea = nombre;
        this.organizacion = organizacion;
    }

    public String getNombreArea() {
        return nombreArea;
    }

    public void setNombreArea(String nombreArea) {
        this.nombreArea = nombreArea;
    }

    public Organizacion getOrganizacion() {
        return organizacion;
    }

    public void setOrganizacion(Organizacion organizacion) {
        this.organizacion = organizacion;
    }

    public Miembro[] getMiembrosArea() {
        return miembrosArea;
    }

    public void setMiembrosArea(Miembro[] miembrosArea) {
        this.miembrosArea = miembrosArea;
    }
}
