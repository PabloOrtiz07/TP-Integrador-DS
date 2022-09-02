package CalculoHC;
import Dominio.Medicion.Medicion;
import Dominio.Medicion.MedicionLogistica;
import Dominio.Medicion.MedicionOtros;

import java.util.List;
import java.util.stream.Collectors;


public class CalculadoraHCDatosActividad {

    public double calculoHCActividadOtrosMensual(List<MedicionOtros>  medicionesOtros){
        return calculoHCActividadOtros(ActividadOtrosMensual(medicionesOtros));
    }

    public double calculoHCActividadOtrosAnual(List<MedicionOtros>  medicionesOtros){
        return calculoHCActividadOtros(ActividadOtrosAnual(medicionesOtros));
    }

    public double calculoHCActividadLogisticaMensual(List<MedicionLogistica>  medicionLogisticas,Double k){
        return calculoHCActividadLogistica(ActividadLogisticaMensual(medicionLogisticas),k);
    }
    public double calculoHCActividadLogisticaAnual(List<MedicionLogistica>  medicionLogisticas,Double k){
        return calculoHCActividadLogistica(ActividadLogisticaAnual(medicionLogisticas),k);
    }
    public double calculoHCActividadOtros(List<MedicionOtros>  medicionesOtros){
        return medicionesOtros.stream().mapToDouble(medicionOtros->medicionOtros.getValor()*medicionOtros.getFactorEmision().getValor()).sum();
    }

    public List<MedicionOtros> ActividadOtrosMensual(List<MedicionOtros>  medicionesOtros){
        return medicionesOtros.stream().filter(medicionOtros->medicionOtros.getPeriodicidad().equals("mensual")).collect(Collectors.toList());
    }
    public List<MedicionOtros> ActividadOtrosAnual(List<MedicionOtros>  medicionesOtros){
        return medicionesOtros.stream().filter(medicionOtros->medicionOtros.getPeriodicidad().equals("anual")).collect(Collectors.toList());
    }

    public List<MedicionLogistica> ActividadLogisticaAnual(List<MedicionLogistica>  medicionesLogistica){
        return medicionesLogistica.stream().filter(medicionLogistica->medicionLogistica.getPeriodicidad().equals("anual")).collect(Collectors.toList());
    }

    public List<MedicionLogistica> ActividadLogisticaMensual(List<MedicionLogistica>  medicionesLogistica){
        return medicionesLogistica.stream().filter(medicionLogistica->medicionLogistica.getPeriodicidad().equals("mensual")).collect(Collectors.toList());
    }
    public double calculoHCActividadLogistica(List<MedicionLogistica>  medicionesLogistica, Double k){
        return medicionesLogistica.stream().mapToDouble(medicionLogistica->medicionLogistica.getDistanciaRecorrida()* medicionLogistica.getPesoTotal()*medicionLogistica.getFactorEmision().getValor()*k).sum();
    }

}
