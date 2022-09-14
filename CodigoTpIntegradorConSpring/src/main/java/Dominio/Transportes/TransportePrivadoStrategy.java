package Dominio.Transportes;

import Apis.DistanciaApiCalls;
import Apis.dto.DistanciaResponse;
import Dominio.Lugares.Ubicacion;

public class TransportePrivadoStrategy extends CalculoDistanciaStrategy{

    @Override
    public double calcularDistancia(Ubicacion ubicacionInicio, Ubicacion ubicacionFinal) throws Exception {
        DistanciaApiCalls calculoDistancia = new DistanciaApiCalls();
        DistanciaResponse distanciaResponse = calculoDistancia.calcularDistancia(ubicacionInicio,ubicacionFinal);
        return Double.valueOf(distanciaResponse.getValor());
    }


}
