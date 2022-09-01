package Dominio.Transportes;

import Dominio.Lugares.Ubicacion;
import Dominio.Medicion.FactorEmision;

public abstract class Transporte {
    protected boolean puedeCompartirse;
    protected  CalculoDistanciaStrategy calculoDistanciaStrategy;
    public boolean puedeCompartirse() {
        return puedeCompartirse;
    }
    private FactorEmision factorEmision;

    public FactorEmision getFactorEmision() {
        return factorEmision;
    }

    public void setFactorEmision(FactorEmision factorEmision) {
        this.factorEmision = factorEmision;
    }

/* public double distanciaRecorrida(Ubicacion ubicaionOrigen, Ubicacion ubicacionFinal) throws Exception{
        return calculoDistanciaStrategy.calcularDistancia(ubicaionOrigen, ubicacionFinal);
    }*/ // estaba mal



}
