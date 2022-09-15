package Dominio.Medicion;

public class FactorEmision {
    private Double valor;
    private String unidad;

    public FactorEmision(Double valor, String unidad) {
        this.valor = valor;
        this.unidad = unidad;
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


}
