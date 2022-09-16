package CalculoHC;
import Dominio.Medicion.Medicion;
import Dominio.Medicion.MedicionLogistica;
import Dominio.Medicion.MedicionOtros;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class CalculadoraHCDatosActividad {

    public double calculoHCActividadOtros(List<MedicionOtros>  medicionesOtros){
        Double hcActOtrosMensual = calculoHCActividadOtrosMensual(ActividadOtrosMensual(medicionesOtros));
        Double hcActOtrosAnual = calculoHCActividadOtrosAnual(ActividadOtrosAnual(medicionesOtros));

        return hcActOtrosMensual + hcActOtrosAnual;
    }

    public List<MedicionOtros> ActividadOtrosMensual(List<MedicionOtros>  medicionesOtros){
        return medicionesOtros.stream().filter(medicionOtros->medicionOtros.getPeriodicidad().equals("mensual")).collect(Collectors.toList());
    } // obtiene todas las actividades otros mensuales y las pone en una lista
    public List<MedicionOtros> ActividadOtrosAnual(List<MedicionOtros>  medicionesOtros){
        return medicionesOtros.stream().filter(medicionOtros->medicionOtros.getPeriodicidad().equals("anual")).collect(Collectors.toList());
    } // obtiene todas las actividades otros anuales y las pone en una lista

    public double calculoHCActividadOtrosMensual(List<MedicionOtros>  medicionesOtros){
        return medicionesOtros.stream().mapToDouble(medicionOtros->medicionOtros.getValor()*medicionOtros.getFactorEmision().getValor()).sum();
    } // realiza el calculo de las actividades otros solo mensuales
    public double calculoHCActividadOtrosAnual(List<MedicionOtros>  medicionesOtros){
        return medicionesOtros.stream().mapToDouble(medicionOtros->medicionOtros.getValor()*medicionOtros.getFactorEmision().getValor()/medicionOtros.mesCerrado()).sum();
    } // realiza el calculo de las actividades otros solo anuales


    public double calculoHCActividadLogistica(List<MedicionLogistica> medicionesLogisticas, Double k){
        Double hcActLogMensual = calculoHCActividadLogisticaMensual(ActividadLogisticaMensual(medicionesLogisticas), k);
        Double hcActLogAnual = calculoHCActividadLogisticaMensual(ActividadLogisticaAnual(medicionesLogisticas), k);

        return hcActLogMensual + hcActLogAnual;
    }

    public List<MedicionLogistica> ActividadLogisticaMensual(List<MedicionLogistica>  medicionesLogistica){
        return medicionesLogistica.stream().filter(medicionLogistica->medicionLogistica.getPeriodicidad().equals("mensual")).collect(Collectors.toList());
    } // obtiene todas las actividades logist mensuales y las pone en una lista
    public List<MedicionLogistica> ActividadLogisticaAnual(List<MedicionLogistica>  medicionesLogistica){
        return medicionesLogistica.stream().filter(medicionLogistica->medicionLogistica.getPeriodicidad().equals("anual")).collect(Collectors.toList());
    } // obtiene todas las actividades logist anuales y las pone en una lista


    public double calculoHCActividadLogisticaMensual(List<MedicionLogistica> medicionesLogistica, Double k){
        return medicionesLogistica.stream().mapToDouble(medicionLogistica->medicionLogistica.getDistanciaRecorrida()*medicionLogistica.getPesoTotal()*medicionLogistica.getMedioTransporte().getFactorEmision().getValor()*k).sum();
    }// realiza el calculo de las actividades logist solo mensuales
    public double calculoHCActividadLogisticaAnual(List<MedicionLogistica>  medicionesLogistica, Double k){
        return medicionesLogistica.stream().mapToDouble(medicionLogistica->medicionLogistica.getDistanciaRecorrida()*medicionLogistica.getPesoTotal()*medicionLogistica.getMedioTransporte().getFactorEmision().getValor()*k/medicionLogistica.mesCerrado()).sum();
    } // realiza el calculo de las actividades otros solo anuales

}
