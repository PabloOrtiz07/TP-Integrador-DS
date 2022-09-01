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


}
