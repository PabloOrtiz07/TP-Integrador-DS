package LectoresArchivo;

import java.time.LocalDate;

public class DatoLeidoExcel {
    private String actividad;
    private String tipoDeConsumo;
    private Double consumo;
    private LocalDate periodoDeImputacion;
    private String perioicidad;

    public DatoLeidoExcel(String actividad, String tipoDeConsumo, Double consumo,String perioicidad, LocalDate periodoDeImputacion) {
        this.actividad = actividad;
        this.tipoDeConsumo = tipoDeConsumo;
        this.consumo = consumo;
        this.perioicidad = perioicidad;
        this.periodoDeImputacion = periodoDeImputacion;
    }


    public String getActividad() {
        return actividad;
    }

    public void setActividad(String actividad) {
        this.actividad = actividad;
    }

    public String getTipoDeConsumo() {
        return tipoDeConsumo;
    }

    public void setTipoDeConsumo(String tipoDeConsumo) {
        this.tipoDeConsumo = tipoDeConsumo;
    }

    public Double getConsumo() {
        return consumo;
    }

    public void setConsumo(Double consumo) {
        this.consumo = consumo;
    }

    public LocalDate getPeriodoDeImputacion() {
        return periodoDeImputacion;
    }

    public void setPeriodoDeImputacion(LocalDate periodoDeImputacion) {
        this.periodoDeImputacion = periodoDeImputacion;
    }

    public String getPerioicidad() {
        return perioicidad;
    }

    public void setPerioicidad(String perioicidad) {
        this.perioicidad = perioicidad;
    }
}
