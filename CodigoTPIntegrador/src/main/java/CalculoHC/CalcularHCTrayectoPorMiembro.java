package CalculoHC;

import Dominio.Entidades.Miembro;
import Dominio.Viajes.Tramo;
import Dominio.Entidades.Organizacion;

import java.util.List;

public class CalcularHCTrayectoPorMiembro {

    public double sumaHCMiembroIndividuales(Organizacion organizacion){

        return organizacion.getAreas().stream().mapToDouble(area -> sumaPorMiembroArea(area.getMiembrosArea())).sum(); // me falta sumar
    }

    public double sumaPorMiembroArea(List<Miembro> miembros){

       return miembros.stream().mapToDouble(miembro -> sumaTramosMiembro(miembro)).sum(); // me falta por cada miembro del area el tramo
    }

    public  double sumaTramosMiembro(Miembro miembro){
        return miembro.getTramos().stream()
                .filter(tramo -> tramo.getMedioTransporte().puedeCompartirse()==false)
                .mapToDouble(tramo -> {
                    try {
                        return tramo.distanciaTramo()*tramo.getMedioTransporte().getFactorEmision();
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                })
                .sum();
}
