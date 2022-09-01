package Dominio.Medicion;

import java.time.LocalDate;

public abstract class Medicion {
    private String actividad;
    private LocalDate periodoDeImputacion;
    private String periodo;

    public String getActividad() {
        return actividad;
    }

    public void setActividad(String actividad) {
        this.actividad = actividad;
    }
    public LocalDate getPeriodicidad() {
        return periodoDeImputacion;
    }

    public void setPeriodicidad(LocalDate periodicidad) {
        this.periodoDeImputacion = periodicidad;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public Medicion(String actividad, LocalDate periodicidad, String periodo) {
        this.actividad = actividad;
        this.periodoDeImputacion = periodicidad;
        this.periodo = periodo;
    }

    public abstract double hcMedicion(double k);



}