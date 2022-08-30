package Repositorios;

import Dominio.Transportes.TransportePublico;
import Seguridad.Usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class RepoTransportePublico{

    private static RepoTransportePublico repoTransportePublico = null;
    private RepoTransportePublico(){
    }
    public static RepoTransportePublico getInstance() {
        if(repoTransportePublico == null) {
            repoTransportePublico = new RepoTransportePublico();
        }
        return repoTransportePublico;
    }

    private List<TransportePublico> transportesPublicos = new ArrayList<>();

    public void agregarTransportePublico(TransportePublico transportesPublico) throws Exception {
        if(repoTransportePublico.existeTransporte(transportesPublico.getLinea()))
            throw new Exception("Ese linea ya esta cargada");
        transportesPublicos.add(transportesPublico);
    }

    public boolean existeTransporte(String nombreTransporte){
        return transportesPublicos.stream().anyMatch(transporteEnRepo ->nombreTransporte.equals(transporteEnRepo.getLinea()));
    }

    public TransportePublico getTransportePorLinea(String linea) throws NoSuchElementException {
        return transportesPublicos.stream().filter(transporte ->transporte.equals(transporte.getLinea())).findAny().get();
    }

    public List<TransportePublico> getTransportesPublicos() {
        return transportesPublicos;
    }
}
