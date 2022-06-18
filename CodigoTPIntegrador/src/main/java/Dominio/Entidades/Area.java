package Dominio.Entidades;

import java.util.ArrayList;
import java.util.List;

public class Area {
    private String nombreArea;
    private Organizacion organizacion;

    private List<Miembro> miembrosArea = new ArrayList<>() ;

    public List<Miembro> getMiembrosArea() {
        return miembrosArea;
    }

    public void setMiembrosArea(List<Miembro> miembrosArea) {
        this.miembrosArea = miembrosArea;
    }


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


    public Miembro getMiembroPorDocumento(String documento){
        return miembrosArea.stream().filter(miembro ->miembro.getDocumentoMiembro().equals(documento)).findAny().get();
    }

    public void agregarMiembro(Miembro miembro){
        miembrosArea.add(miembro);
    }

}
