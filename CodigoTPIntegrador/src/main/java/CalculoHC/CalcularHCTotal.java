package CalculoHC;

import Dominio.Entidades.Organizacion;

public class CalcularHCTotal {
    private  CalcularHCDatosActividadOtras calcularHCDatosActividadOtras;
    private CalcularHCTrayectoPorMiembro calcularHCTrayectoPorMiembro;
    private CalcularHCDatosActividadPorViajeCompartido calcularHCDatosActividadPorViajeCompartido;

    public CalcularHCTotal() {
         calcularHCDatosActividadOtras = new CalcularHCDatosActividadOtras();
         calcularHCTrayectoPorMiembro = new CalcularHCTrayectoPorMiembro();
         calcularHCDatosActividadPorViajeCompartido = new CalcularHCDatosActividadPorViajeCompartido();

    }

    public double sumatoriaHCTotal(Organizacion organizacion){
        return calcularHCDatosActividadOtras.sumaHCOtras(organizacion)+
                calcularHCDatosActividadPorViajeCompartido.sumaHCMiembroCompartido(organizacion)+
                calcularHCTrayectoPorMiembro.sumaHCMiembroIndividual(organizacion);
    }
}
