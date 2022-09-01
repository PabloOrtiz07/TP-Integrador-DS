package CalculoHC;

import Dominio.Medicion.Medicion;
import Dominio.Medicion.MedicionLogistica;
import Dominio.Medicion.MedicionOtros;
import Dominio.Viajes.Trayecto;
import LectoresArchivo.LecturaFactor;

import java.util.List;

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

    public double calcularHCOrganizacion(List<Trayecto> trayectos, List<MedicionLogistica> medicionesLogistica, List<MedicionOtros> medicionOtros) throws Exception {
        Double hcTrayectos = calculadoraHCTrayecto.calcularHCTrayectos(trayectos);
        Double hcDatosActividadLogistica = calculadoraHCDatosActividad.calculoHCActividadLogistica(medicionesLogistica,getFactorK());
        Double hcDatosActividadOtros= calculadoraHCDatosActividad.calculoHCActividadOtros(medicionOtros,getFactorK());
        return hcTrayectos + hcDatosActividadLogistica + hcDatosActividadOtros;
    }

    public double calcularHcTrayectos(List<Trayecto> trayectos) throws Exception { // mirar esto
        return calculadoraHCTrayecto.calcularHCTrayectos(trayectos);
    }

    public double calcularHcTrayectosPersonal(List<Trayecto> trayectos) throws Exception {
        return calculadoraHCTrayecto.calcularHCTrayectoPorMes(trayectos);
    }

}
