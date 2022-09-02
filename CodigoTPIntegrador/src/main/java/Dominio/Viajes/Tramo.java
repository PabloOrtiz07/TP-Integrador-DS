package Dominio.Viajes;

import Dominio.Entidades.Miembro;
import Dominio.Transportes.*;
import Dominio.Viajes.Trayecto;
import Dominio.Lugares.Ubicacion;

import java.util.*;

public class Tramo {
    protected  CalculoDistanciaStrategy calculoDistanciaStrategy;
    public void setCalculoDistanciaStrategy(CalculoDistanciaStrategy calculoDistanciaStrategy) {
        this.calculoDistanciaStrategy = calculoDistanciaStrategy;
    }
    public Tramo(Ubicacion ubicacionInicio, Ubicacion ubicacionFinal, Transporte medioTransporte, List<Miembro> miembros) throws Exception {
        if(!medioTransporte.puedeCompartirse() && miembros.size()>1) throw new RuntimeException("El medio de transporte de este tramo no puede ser compartido");

        this.ubicacionInicio = ubicacionInicio;
        this.ubicacionFinal = ubicacionFinal;
        this.medioTransporte = medioTransporte;
        this.miembrosTramo = miembros;
        this.distanciaTramo=this.calcularDistanciaTramo(ubicacionInicio,ubicacionFinal);
    }


    private List<Miembro> miembrosTramo = new ArrayList<>();
    private Ubicacion ubicacionInicio;
    private Ubicacion ubicacionFinal;
    private Trayecto trayecto;
    private Transporte medioTransporte;

    private Double distanciaTramo;

    public Double getDistanciaTramo() {
        return distanciaTramo;
    }

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

    public double calcularDistanciaTramo(Ubicacion ubicacionOrigen, Ubicacion ubicacionFinal) throws Exception{
        if (this.getMedioTransporte() instanceof TransportePrivado){
            this.setCalculoDistanciaStrategy(new TransportePrivadoStrategy());
            return calculoDistanciaStrategy.calcularDistancia(ubicacionOrigen, ubicacionFinal);
        }
        else {
            this.setCalculoDistanciaStrategy(new TransportePublicoStrategy());
            return calculoDistanciaStrategy.calcularDistancia(ubicacionOrigen, ubicacionFinal);
        }
    }

    public double calcularHCTramo(){
        try {
            return (this.getDistanciaTramo() * this.medioTransporte.getFactorEmision().getValor())/miembrosTramo.size();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean equals(Tramo that){
        return this.ubicacionInicio.equals(this.ubicacionInicio)
                && this.ubicacionFinal.equals(this.ubicacionFinal)
                && this.miembrosTramo.equals(this.miembrosTramo)
                && this.medioTransporte.equals(this.medioTransporte);
    }
}
