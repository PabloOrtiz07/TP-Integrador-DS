package Dominio.Transportes;

import Apis.DistanciaApiCalls;
import Apis.dto.DistanciaResponse;
import Dominio.Lugares.Ubicacion;
import Dominio.Medicion.FactorEmision;

public class TransportePrivado extends Transporte{
    private boolean esServicioContratado;
    private String tipoServicio;
    private TipoCombustible tipoDeCombustible;
    private TipoVehiculoParticular tipoTransporteVehiculo;

    public TransportePrivado(boolean esServicioContratado, String tipoServicio, TipoCombustible tipoDeCombustible, TipoVehiculoParticular tipoTransporteVehiculo, FactorEmision factorEmisor) {
        this.esServicioContratado = esServicioContratado;
        this.tipoServicio = tipoServicio;
        this.tipoDeCombustible = tipoDeCombustible;
        this.tipoTransporteVehiculo = tipoTransporteVehiculo;
        this.puedeCompartirse = true;
        this.calculoDistanciaStrategy = new TransportePrivadoStrategy();
        setFactorEmision(factorEmisor);
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

}

