package Dominio.Entidades;

import CalculoHC.CalculadoraHC;
import Dominio.Lugares.Ubicacion;
import Dominio.Viajes.Trayecto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Area {
    private String nombreArea;
    private Organizacion organizacion;

    private List<Miembro> miembrosArea = new ArrayList<>() ;

    public List<Miembro> getMiembrosArea() {
        return miembrosArea;
    }

    public CalculadoraHC calculadoraHc = new CalculadoraHC();

    public void setMiembrosArea(List<Miembro> miembrosArea) {
        this.miembrosArea = miembrosArea;
    }


    public Area(String nombre){
        this.nombreArea = nombre;
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
        miembro.asociarAArea(this);
    }
    public List<Trayecto> getTrayectosMiembrosArea(){
        return miembrosArea.stream().flatMap(miembro -> miembro.getTrayectos().stream()).filter(trayecto -> trayecto.getUbicacionFinal().equals(this.getUbicacion())).collect(Collectors.toList());
    }
    public double promedioHCPorMiembroArea(){
        try {
            return miembrosArea.stream().mapToDouble(miembroArea-> {
                try {
                    return miembroArea.calcularHCPersonal();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }).sum() / (double) this.miembrosArea.size() ;
        } catch (Exception e) {
            throw new RuntimeException(e);

        }
    }
    private Ubicacion getUbicacion(){
        return this.organizacion.getUbicacion();
    }

}
