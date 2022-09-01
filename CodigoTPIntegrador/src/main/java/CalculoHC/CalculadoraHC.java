package CalculoHC;

import Dominio.Entidades.Miembro;
import Dominio.Medicion.Medicion;
import Dominio.Medicion.MedicionLogistica;
import Dominio.Medicion.MedicionOtros;
import Dominio.Viajes.Trayecto;
import Dominio.Entidades.Organizacion;
import LectoresArchivo.LecturaFactor;

import java.util.List;
import java.util.Set;

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
        Double hcDatosActividadOtros= calculadoraHCDatosActividad.calculoHCActividadOtros(medicionOtros,getFactorK());
        return hcTrayectos + hcDatosActividadLogistica + hcDatosActividadOtros;
    }

    public double calcularHcTrayectosPersonal(List<Trayecto> trayectos) throws Exception {
        return calculadoraHCTrayecto.calcularHCTrayectoPorMes(trayectos);
    }

    public double calcularHcTrayectosOrganizacion(Organizacion organizacion){
        organizacion.getAreas().stream().map(area -> miembros = area.getMiembrosArea());
        return miembros.stream().map(miembro -> miembro.calcularHCPersonal()).sum();
    }

}
