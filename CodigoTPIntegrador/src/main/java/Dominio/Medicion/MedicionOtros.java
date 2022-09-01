package Dominio.Medicion;

import java.time.LocalDate;

public class MedicionOtros extends Medicion {
    String tipoConsumo;
    Double valor;
    String unidad;

    FactorEmision factorEmision;

    public FactorEmision getFactorEmision() {
        return factorEmision;
    }

    public void setFactorEmision(FactorEmision factorEmision) {
        this.factorEmision = factorEmision;
    }

    public MedicionOtros(String actividad, String periodicidad, String periodo, String tipoConsumo, Double valor) {
        super(actividad, periodicidad, periodo);
        this.tipoConsumo = tipoConsumo;
        this.valor = valor;
    }

    public String getTipoConsumo() {
        return tipoConsumo;
    }

    public void setTipoConsumo(String tipoConsumo) {
        this.tipoConsumo = tipoConsumo;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    public double hcMedicion(double k){
        return this.valor * this.factorEmision.getValor();

    }
}
