package Dominio.Transportes;

import Dominio.Transportes.TipoDeTransportePublico;
import Dominio.Lugares.Parada;

public class TransportePublico extends Transporte {
    private TipoDeTransportePublico tipoTransportePublico;
    private Parada[] paradas;
    private String linea;

    public String getLinea() {
        return linea;
    }

    public void setLinea() {
        this.linea = linea;
    }
}
