package Dominio.Medicion;

import Dominio.Transportes.Transporte;

public class MedicionLogistica extends Medicion{
    String categoriaProducto;
    TransporteLogistico medioTransporte;
    Double distanciaRecorrida;
    Double pesoTotal;

    public MedicionLogistica(String actividad) {
        super();
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
