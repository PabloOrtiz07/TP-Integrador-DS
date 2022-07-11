package Dominio.Transportes;

import Dominio.Lugares.Ubicacion;

public abstract class Transporte {
    protected boolean puedeCompartirse;
    protected  CalculoDistanciaStrategy calculoDistanciaStrategy;
    public boolean puedeCompartirse() {
        return puedeCompartirse;
    }
    private int factorEmision;

    public int getFactorEmision() {
        return factorEmision;
    }

    public void setFactorEmision(int factorEmision) {
        this.factorEmision = factorEmision;
    }


    public double distanciaRecorrida(Ubicacion ubicaionOrigen, Ubicacion ubicacionFinal) throws Exception{
        return calculoDistanciaStrategy.calcularDistancia(ubicaionOrigen, ubicacionFinal);
    }



}
