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
        this.puedeCompartirse = true;
        this.tipoTransporteEcologico = tipoTransporteEcologico;
        this.calculoDistanciaStrategy = new TransportePrivadoStrategy();
    }
}
