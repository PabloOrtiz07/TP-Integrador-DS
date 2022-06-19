package Dominio.Transportes;

import Dominio.Lugares.Ubicacion;

public abstract class Transporte {
    protected boolean esCompartido;

    public boolean getEsCompartido() {
        return esCompartido;
    }

    public void setEsCompartido(boolean esCompartido) {
        this.esCompartido = esCompartido;
    }

    public abstract double distanciaRecorrida(Ubicacion ubicaionOrigen, Ubicacion ubicacionFinal) throws Exception;

}
