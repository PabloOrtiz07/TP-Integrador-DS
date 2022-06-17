package Dominio.Viajes;

import Dominio.Entidades.Miembro;
import Dominio.Viajes.Trayecto;
import Dominio.Lugares.Ubicacion;
import Dominio.Transportes.Transporte;

public class Tramo {
    private Ubicacion ubicacionInicio;
    private Ubicacion ubicacionFinal;
    private Trayecto trayecto;
    private Transporte medioTransporte;
    private Miembro[] miembrosTramo;

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

    public Miembro[] getMiembrosTramo() {
        return miembrosTramo;
    }

    public void setMiembrosTramo(Miembro[] miembrosTramo) {
        this.miembrosTramo = miembrosTramo;
    }
}
