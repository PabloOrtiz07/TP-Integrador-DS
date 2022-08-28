package CalculoHC;
import Dominio.Medicion.Medicion;
import Dominio.Medicion.MedicionLogistica;
import Dominio.Medicion.MedicionOtros;

import java.util.List;


public class CalculadoraHCDatosActividad {

    public double calculoHCActividadOtros(List<MedicionOtros>  mediciones, Double k){
        return mediciones.stream().mapToDouble(medicion -> medicion.hcMedicion(k)).sum();
    }

    public double calculoHCActividadLogistica(List<MedicionLogistica>  mediciones, Double k){
        return mediciones.stream().mapToDouble(medicion -> medicion.hcMedicion(k)).sum();
    }

}
