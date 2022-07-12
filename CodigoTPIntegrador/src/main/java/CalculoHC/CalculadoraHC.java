package CalculoHC;

import Dominio.Medicion.Medicion;
import Dominio.Viajes.Trayecto;

import java.util.List;

public class CalculadoraHC {
    private CalculadoraHCDatosActividad calculadoraHCDatosActividad;
    private CalculadoraHCTrayecto calculadoraHCTrayecto;


    public CalculadoraHC() {
         calculadoraHCDatosActividad = new CalculadoraHCDatosActividad();
         calculadoraHCTrayecto = new CalculadoraHCTrayecto();
    }

    public double calcularHCOrganizacion(List<Trayecto> trayectos, List<Medicion> mediciones, Double k) throws Exception {
        Double hcTrayectos = calculadoraHCTrayecto.calcularHCTrayectos(trayectos);
        Double hcDatosActividad = calculadoraHCDatosActividad.calculoHCActividad(mediciones, k);
        return hcTrayectos + hcDatosActividad;
    }

    public double calcularHcTrayectos(List<Trayecto> trayectos) throws Exception {
        return calculadoraHCTrayecto.calcularHCTrayectos(trayectos);
    }

}
