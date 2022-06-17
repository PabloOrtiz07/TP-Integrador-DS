package Dominio.Transportes;

import Dominio.Lugares.Ubicacion;
import Dominio.Transportes.TipoDeTransportePublico;
import Dominio.Lugares.Parada;

import java.util.ArrayList;
import java.util.List;

public class TransportePublico extends Transporte {


    private TipoDeTransportePublico tipoTransportePublico;
    private List<Parada> paradas = new ArrayList<>();
    private String linea;

    public TransportePublico(TipoDeTransportePublico tipoTransportePublico, String linea){
        this.tipoTransportePublico = tipoTransportePublico;
        this.linea = linea;
        this.esCompartido = false;
    }

    public String getLinea() {
        return linea;
    }

    public TipoDeTransportePublico getTipoTransportePublico() {
        return tipoTransportePublico;
    }

    public void agregarParada(Parada parada){
        if(paradas.isEmpty())
            parada.setDistanciaAnterior(0);
        else {
            Parada paradaAnterior = paradas.get(paradas.size()-1);
            parada.setDistanciaAnterior(paradaAnterior.getDistanciaSiguiente());
        }
        paradas.add(parada);
    }
}
