package CalculoHC;

import Dominio.Entidades.Miembro;
import Dominio.Medicion.MedicionLogistica;
import Dominio.Medicion.MedicionOtros;
import Dominio.Viajes.Trayecto;
import Dominio.Entidades.Organizacion;
import LectoresArchivo.LecturaFactor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CalculadoraHC {

    private  Double factorK;
    private CalculadoraHCDatosActividad calculadoraHCDatosActividad;
    private CalculadoraHCTrayecto calculadoraHCTrayecto;

    public Double getFactorK() {
        return factorK;
    }

    public void setFactorK(Double factorK) {
        this.factorK = factorK;
    }

    public CalculadoraHC() {
        LecturaFactor lecturaFactor= new LecturaFactor();
        setFactorK(lecturaFactor.leerFactorK());
        calculadoraHCDatosActividad = new CalculadoraHCDatosActividad();
        calculadoraHCTrayecto = new CalculadoraHCTrayecto();
    }

    public double calcularHCOrganizacion(Organizacion organizacion, List<MedicionLogistica> medicionesLogistica, List<MedicionOtros> medicionOtros) throws Exception {
        Double hcTrayectos = calcularHcTrayectosOrganizacion(organizacion);
        Double hcDatosActividadLogistica = calculadoraHCDatosActividad.calculoHCActividadLogistica(medicionesLogistica,getFactorK());
        Double hcDatosActividadOtros= calculadoraHCDatosActividad.calculoHCActividadOtros(medicionOtros);
        return hcTrayectos + hcDatosActividadLogistica + hcDatosActividadOtros;
    } // calcula la HC total de la org: act + trayectos

    public double calcularHcTrayectosPersonal(List<Trayecto> trayectos) throws Exception {
        return calculadoraHCTrayecto.calcularHCTrayectoPorMes(trayectos);
    }

    public double calcularHcTrayectosOrganizacion(Organizacion organizacion){
        List<Miembro> miembros = new ArrayList<>();
        miembros.addAll(organizacion.getAreas().stream().flatMap(area -> area.getMiembrosArea().stream()).collect(Collectors.toList()));
        return miembros.stream().mapToDouble(miembro -> {
            try {
                return miembro.calcularHCPersonal();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }).sum();
    }

    public double calcularHCMensual(List<Trayecto> trayectos, List<MedicionLogistica> medicionLogistica, List<MedicionOtros> medicionOtros) throws Exception {
        Double hcTrayectosMensual = calculadoraHCTrayecto.calcularHCTrayectoPorMes(trayectos);
        Double hcActLogistMensual = calculadoraHCDatosActividad.calculoHCActividadLogisticaMensual(medicionLogistica, factorK);
        Double hcActOtros = calculadoraHCDatosActividad.calculoHCActividadOtrosMensual(medicionOtros);
        Double hcActLogistAnual = calculadoraHCDatosActividad.calculoHCActividadLogisticaAnual(medicionLogistica, factorK);
        Double hcActOtrosAnual = calculadoraHCDatosActividad.calculoHCActividadOtrosAnual(medicionOtros);
        return hcTrayectosMensual + hcActLogistMensual + hcActOtros + hcActLogistAnual + hcActOtrosAnual;
    }



}
