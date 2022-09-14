package Dominio.Medicion;

import java.time.LocalDate;

public abstract class Medicion {
    private String actividad;
    private String periodoDeImputacion;
    private String periodo;

    public String getActividad() {
        return actividad;
    }

    public void setActividad(String actividad) {
        this.actividad = actividad;
    }
    public String getPeriodicidad() {
        return periodoDeImputacion;
    }

    public void setPeriodicidad(String periodicidad) {
        this.periodoDeImputacion = periodicidad;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public Medicion(String actividad, String periodicidad, String periodo) {
        this.actividad = actividad;
        this.periodoDeImputacion = periodicidad;
        this.periodo = periodo;
    }

    public abstract double hcMedicion(double k);



}