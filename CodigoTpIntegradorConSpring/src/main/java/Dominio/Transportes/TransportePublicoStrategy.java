package Dominio.Transportes;

import Dominio.Lugares.Parada;
import Dominio.Lugares.Ubicacion;

public class TransportePublicoStrategy extends CalculoDistanciaStrategy {
    @Override
    public double calcularDistancia(Ubicacion ubicacionInicio, Ubicacion ubicacionFinal) throws Exception {
        Parada parada1 = (Parada) ubicacionInicio;
        Parada parada2 = (Parada) ubicacionFinal;
        double distancia = 0;
        Parada paradaAux = parada1;
        while (paradaAux != null) {
            if (paradaAux.equals(parada2))
                return distancia;
            distancia += paradaAux.getDistanciaSiguiente();
            paradaAux = parada1.getParadaSiguiente();
        }
        //Si sale del while sin hacer el return es porque no encontro la parada, reinicio los valores y busco en el otro sentido
        distancia = 0;
        paradaAux = parada1;
        while (paradaAux != null) {
            if (paradaAux.equals(parada2))
                return distancia;
            distancia += paradaAux.getDistanciaAnterior();
            paradaAux = parada1.getParadaAnterior();
        }
        //Si tambien sale de este while la parada destino no se encontro
        throw new Exception("Error en la busqueda de las paradas");
    }
}
