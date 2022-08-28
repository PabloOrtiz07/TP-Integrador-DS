package LectoresArchivo;

import java.time.LocalDate;

public class DatoLeidoExcel {
    private String actividad;
    private String tipoDeConsumo;
    private Double consumo;
    private LocalDate periodoDeImputacion;

    public DatoLeidoExcel(String actividad, String tipoDeConsumo, Double consumo, LocalDate periodoDeImputacion) {
        this.actividad = actividad;
        this.tipoDeConsumo = tipoDeConsumo;
        this.consumo = consumo;
        this.periodoDeImputacion = periodoDeImputacion;
    }

    public String getActividad() {
        return actividad;
    }


}
