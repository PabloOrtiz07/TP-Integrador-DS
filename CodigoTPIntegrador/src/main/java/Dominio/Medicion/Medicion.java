package Dominio.Medicion;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public abstract class Medicion {
    private String actividad;
    private String periodoDeImputacion;
    private String periodo;

    private LocalDate fecha;

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


    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Double mesCerrado() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String fechaString =  fecha.format(formatter);
        Double mes = Double.parseDouble(fechaString.substring(3,4));
        return mes - 1;
    }
}
