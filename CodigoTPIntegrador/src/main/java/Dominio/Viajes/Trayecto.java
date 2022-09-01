package Dominio.Viajes;

import Dominio.Entidades.Miembro;
import Dominio.Lugares.Ubicacion;
import java.util.*;
import java.util.List;


public class Trayecto {
    private Ubicacion ubicacionInicio;
    private Ubicacion ubicacionFinal;

    private Integer diasDeUsoEnLaSemana; // por pantalla porque no tenemos idea cuando se setea

    public Integer getDiasDeUsoEnLaSemana() {
        return diasDeUsoEnLaSemana;
    }

    public void setDiasDeUsoEnLaSemana(Integer diasDeUsoEnLaSemana) {
        this.diasDeUsoEnLaSemana = diasDeUsoEnLaSemana;
    }

    private Double pesoTrayecto;

    public Double getPesoTrayecto() {
        return pesoTrayecto;
    }

    public void setPesoTrayecto(Double pesoTrayecto,Integer diasHabiles) {
        this.pesoTrayecto = calcularPesoTrayecto(diasHabiles);
    }

    private List<Tramo> tramosTrayecto = new ArrayList<>();

    public Trayecto(Ubicacion ubicacionInicio, Ubicacion ubicacionFinal){
        this.ubicacionInicio = ubicacionInicio;
        this.ubicacionFinal = ubicacionFinal;
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

    public List<Tramo> getTramosTrayecto() {
        return tramosTrayecto;
    }

    public void setTramosTrayecto(List<Tramo> tramosTrayecto) {
        this.tramosTrayecto = tramosTrayecto;
    }

    public void agregarTramo(Tramo tramo)throws Exception{
        if(tramosTrayecto.isEmpty()){
            if(!tramo.getUbicacionInicio().equals(this.ubicacionInicio))
                throw new Exception("El inicio del primer tramo debe coincidir con el inicio del trayecto");
        }
        else if(!tramo.getUbicacionInicio().equals(tramosTrayecto.get(tramosTrayecto.size() - 1).getUbicacionFinal()))
            throw new Exception("El inicio del tramo debe coincidir con el final del tramo anterior");
        tramosTrayecto.add(tramo);
    }

    public double distanciaTotal() throws Exception{
       return tramosTrayecto.stream().mapToDouble(trayecto -> {
           try {
               return trayecto.distanciaTramo();
           } catch (Exception e) {
               throw new RuntimeException(e);
           }
       }).sum();
    }

    public double calcularPesoTrayecto(Integer diasHabiles){
        return this.diasDeUsoEnLaSemana/diasHabiles;
    }

}
