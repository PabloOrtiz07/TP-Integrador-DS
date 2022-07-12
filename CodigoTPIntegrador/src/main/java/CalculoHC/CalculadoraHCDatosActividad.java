package CalculoHC;
import Dominio.Medicion.Medicion;

import java.util.List;


public class CalculadoraHCDatosActividad {

    public double calculoHCActividad(List<Medicion> mediciones, Double k){
        return mediciones.stream().mapToDouble(medicion -> medicion.hcMedicion(k)).sum();
    }

}
