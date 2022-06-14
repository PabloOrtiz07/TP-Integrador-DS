package Dominio.Transportes;

import Dominio.Transportes.TipoCombustible;
import Dominio.Transportes.TipoVehicuoParticular;

public class TransportePrivado extends Transporte{
    private boolean esServicioContratado;
    private String tipoServicio;
    private TipoCombustible tipoDeCombustible;
    private TipoVehicuoParticular tipoTransporteVehiculo;

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

