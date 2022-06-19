package Dominio.Transportes;

import Apis.DistanciaApiCalls;
import Apis.dto.DistanciaResponse;
import Dominio.Lugares.Ubicacion;

public class TransporteEcologico extends Transporte {
    private String tipoTransporteEcologico;

    public String getTipoTransporteEcologico() {
        return tipoTransporteEcologico;
    }

    public void setTipoTransporteEcologico(String tipoTransporteEcologico) {
        this.tipoTransporteEcologico = tipoTransporteEcologico;
    }

    public double distanciaRecorrida(Ubicacion ubicacion1, Ubicacion ubicacion2) throws Exception {
        DistanciaApiCalls calculoDistancia = new DistanciaApiCalls();
        DistanciaResponse distanciaResponse = calculoDistancia.calcularDistancia(ubicacion1,ubicacion2);
        return Double.valueOf(distanciaResponse.getValor());
    }
}
