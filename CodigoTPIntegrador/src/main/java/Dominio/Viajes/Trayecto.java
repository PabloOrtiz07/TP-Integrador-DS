package Dominio.Viajes;

import Dominio.Entidades.Miembro;
import Dominio.Lugares.Ubicacion;
import java.util.*;


public class Trayecto {
    private Ubicacion ubicacionInicio;
    private Ubicacion ubicacionFinal;
    private List<Tramo> tramosTrayecto = new ArrayList<>();

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
}
