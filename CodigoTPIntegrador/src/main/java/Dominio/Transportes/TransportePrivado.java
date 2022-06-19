package Dominio.Transportes;

import Apis.DistanciaApiCalls;
import Apis.dto.DistanciaResponse;
import Dominio.Lugares.Ubicacion;

public class TransportePrivado extends Transporte{
    private boolean esServicioContratado;
    private String tipoServicio;
    private TipoCombustible tipoDeCombustible;
    private TipoVehiculoParticular tipoTransporteVehiculo;

    public TransportePrivado(boolean esServicioContratado, String tipoServicio, TipoCombustible tipoDeCombustible, TipoVehiculoParticular tipoTransporteVehiculo) {
        this.esServicioContratado = esServicioContratado;
        this.tipoServicio = tipoServicio;
        this.tipoDeCombustible = tipoDeCombustible;
        this.tipoTransporteVehiculo = tipoTransporteVehiculo;
    }

    public boolean getEsServicioContratado() {
        return esServicioContratado;
    }

    public void setEsServicioContratado(boolean esServicioContratado) {
        this.esServicioContratado = esServicioContratado;
    }

    public String getTipoServicio() {
        return tipoServicio;
    }

    public void setTipoServicio() {
        this.tipoServicio = tipoServicio;
    }

    public double distanciaRecorrida(Ubicacion ubicacion1, Ubicacion ubicacion2)throws Exception{
        DistanciaApiCalls calculoDistancia = new DistanciaApiCalls();
        DistanciaResponse distanciaResponse = calculoDistancia.calcularDistancia(ubicacion1,ubicacion2);
        return Double.valueOf(distanciaResponse.getValor());
    }
}

