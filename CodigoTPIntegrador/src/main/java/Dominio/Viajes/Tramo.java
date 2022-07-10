package Dominio.Viajes;

import Dominio.Entidades.Miembro;
import Dominio.Transportes.CalculoDistanciaStrategy;
import Dominio.Viajes.Trayecto;
import Dominio.Lugares.Ubicacion;
import Dominio.Transportes.Transporte;
import java.util.*;

public class Tramo {

    public Tramo(Ubicacion ubicacionInicio, Ubicacion ubicacionFinal, Trayecto trayecto, Transporte medioTransporte, List<Miembro> miembros) {
        if(!medioTransporte.puedeCompartirse() && miembros.size()>1) throw new RuntimeException("El medio de transporte de este tramo no puede ser compartido");

        this.ubicacionInicio = ubicacionInicio;
        this.ubicacionFinal = ubicacionFinal;
        this.trayecto = trayecto;
        this.medioTransporte = medioTransporte;
        this.miembrosTramo = miembros;
    }
    private List<Miembro> miembrosTramo = new ArrayList<>();
    private Ubicacion ubicacionInicio;
    private Ubicacion ubicacionFinal;
    private Trayecto trayecto;
    private Transporte medioTransporte;
    
    public List<Miembro> getMiembrosTramo() {
        return miembrosTramo;
    }

    public void setMiembrosTramo(List<Miembro> miembrosTramo) {
        this.miembrosTramo = miembrosTramo;
    }

    public Ubicacion getUbicacionInicio() {
        return ubicacionInicio;
    }

    public void setUbicacionInicio(Ubicacion ubicacionInicio) {
        this.ubicacionInicio = ubicacionInicio;
    }

    public Ubicacion getUbicacionFinal() {
        return ubicacionFinal;
    }

    public void setUbicacionFinal(Ubicacion ubicacionFinal) {
        this.ubicacionFinal = ubicacionFinal;
    }

    public Trayecto getTrayecto() {
        return trayecto;
    }

    public void setTrayecto(Trayecto trayecto) {
        this.trayecto = trayecto;
    }

    public Transporte getMedioTransporte() {
        return medioTransporte;
    }

    public void setMedioTransporte(Transporte medioTransporte) {
        this.medioTransporte = medioTransporte;
    }

    public double distanciaTramo()throws Exception{
       return this.medioTransporte.distanciaRecorrida(this.ubicacionInicio, this.ubicacionFinal);
    }
}
