package Dominio.Medicion;

import java.time.LocalDate;

public class MedicionLogistica extends Medicion{
    String categoriaProducto;
    TransporteLogistico medioTransporte;
    Double distanciaRecorrida;
    Double pesoTotal;

    FactorEmision factorEmision;

    public MedicionLogistica(String actividad, String periodicidad, String periodo, LocalDate fecha) {
        super(actividad, periodicidad, periodo);
    }

    public String getCategoriaProducto() {
        return categoriaProducto;
    }

    public void setCategoriaProducto(String categoriaProducto) {
        this.categoriaProducto = categoriaProducto;
    }

    public TransporteLogistico getMedioTransporte() {
        return medioTransporte;
    }

    public void setMedioTransporte(TransporteLogistico medioTransporte) {
        this.medioTransporte = medioTransporte;
    }

    public Double getDistanciaRecorrida() {
        return distanciaRecorrida;
    }

    public void setDistanciaRecorrida(Double distanciaRecorrida) {
        this.distanciaRecorrida = distanciaRecorrida;
    }

    public Double getPesoTotal() {
        return pesoTotal;
    }

    public void setPesoTotal(Double pesoTotal) {
        this.pesoTotal = pesoTotal;
    }

    public double hcMedicion(double k){
        return this.distanciaRecorrida * this.pesoTotal * k * this.getMedioTransporte().getFactorEmision().getValor();

    }
}
