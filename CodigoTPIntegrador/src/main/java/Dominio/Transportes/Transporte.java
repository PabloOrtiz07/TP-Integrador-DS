package Dominio.Transportes;

import Dominio.Lugares.Ubicacion;

public abstract class Transporte {
    protected boolean puedeCompartirse;
    protected  CalculoDistanciaStrategy calculoDistanciaStrategy;
    public boolean puedeCompartirse() {
        return puedeCompartirse;
    }

    public double distanciaRecorrida(Ubicacion ubicaionOrigen, Ubicacion ubicacionFinal) throws Exception{
        return calculoDistanciaStrategy.calcularDistancia(ubicaionOrigen, ubicacionFinal);
    }



}
