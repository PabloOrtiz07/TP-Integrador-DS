package CalculoHC;

import Dominio.Medicion.Medicion;
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

    public double calcularHCOrganizacion(List<Trayecto> trayectos, List<Medicion> mediciones) throws Exception {
        Double hcTrayectos = calculadoraHCTrayecto.calcularHCTrayectos(trayectos);
        Double hcDatosActividad = calculadoraHCDatosActividad.calculoHCActividad(mediciones,getFactorK());
        return hcTrayectos + hcDatosActividad;
    }

    public double calcularHcTrayectos(List<Trayecto> trayectos) throws Exception {
        return calculadoraHCTrayecto.calcularHCTrayectos(trayectos);
    }

}
