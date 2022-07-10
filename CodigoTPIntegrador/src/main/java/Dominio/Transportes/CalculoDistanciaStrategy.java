package Dominio.Transportes;

import Dominio.Lugares.Ubicacion;

public abstract class CalculoDistanciaStrategy {
    public abstract double calcularDistancia(Ubicacion ubicacionInicio, Ubicacion ubicacionFinal) throws Exception;
}
