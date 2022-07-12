package Dominio.Medicion;

public class MedicionOtros extends Medicion {
    String tipoConsumo;
    Double valor;
    FactorEmision factorEmision;
    String unidad;

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
