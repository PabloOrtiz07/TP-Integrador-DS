package Dominio.Medicion;

import java.time.LocalDate;

public abstract class Medicion {
    private String actividad;
    private String periodicidad;
    private String periodo;

    public String getActividad() {
        return actividad;
    }

    public void setActividad(String actividad) {
        this.actividad = actividad;
    }
    public String getPeriodicidad() {
        return periodicidad;
    }

    public void setPeriodicidad(String periodicidad) {
        this.periodicidad = periodicidad;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public abstract double hcMedicion(double k);



}