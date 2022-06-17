package Dominio.Entidades;


import java.time.LocalDate;

public class Actividad {
    private String tipoDeActividad;
    private String tipoDeConsumo;
    private Double valor;
    private String periodicidad;
    private LocalDate periodo;

    public String getTipoDeActividad() {
        return tipoDeActividad;
    }

    public void setTipoDeActividad(String tipoDeActividad) {
        this.tipoDeActividad = tipoDeActividad;
    }

    public String getTipoDeConsumo() {
        return tipoDeConsumo;
    }

    public void setTipoDeConsumo(String tipoDeConsumo) {
        this.tipoDeConsumo = tipoDeConsumo;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getPeriodicidad() {
        return periodicidad;
    }

    public void setPeriodicidad(String periodicidad) {
        this.periodicidad = periodicidad;
    }

    public LocalDate getPeriodo() {
        return periodo;
    }

    public void setPeriodo(LocalDate periodo) {
        this.periodo = periodo;
    }

    public Actividad(String tipoDeActividad, String tipoDeConsumo, Double valor, String periodicidad, LocalDate periodo) {
        this.tipoDeActividad = tipoDeActividad;
        this.tipoDeConsumo = tipoDeConsumo;
        this.valor = valor;
        this.periodicidad = periodicidad;
        this.periodo = periodo;
    }

    public Actividad() {

    }
}
