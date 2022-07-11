package CalculoHC;

import Dominio.Entidades.Miembro;
import Dominio.Viajes.Tramo;
import Dominio.Entidades.Organizacion;

import java.util.List;

public class CalcularHCTrayectoPorMiembro {

    public double sumaHCMiembroIndividuales(Organizacion organizacion){

        return organizacion.getAreas().forEach(area -> sumaPorMiembroArea(area.getMiembrosArea()) // me falta sumar
    }

    public int sumaPorMiembroArea(List<Miembro> miembros){

        miembros.stream().forEach(miembro -> miembro.getTramos()); // me falta por cada miembro del area el tramo

        return 0;
    }
}
