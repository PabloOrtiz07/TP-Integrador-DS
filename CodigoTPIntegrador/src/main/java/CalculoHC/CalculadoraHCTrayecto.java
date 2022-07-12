package CalculoHC;

import Dominio.Viajes.Tramo;
import Dominio.Viajes.Trayecto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CalculadoraHCTrayecto {

    public double calcularHCTrayectos(List<Trayecto> trayectos) throws Exception{
        Set<Tramo> tramos = new HashSet<>(); // Uso set para que si lo pide una organizacion y hay tramos compartidos los guarde una unica vez
        tramos.addAll(trayectos.stream().flatMap(trayecto -> trayecto.getTramosTrayecto().stream()).collect(Collectors.toList()));
        return tramos.stream().mapToDouble(tramo -> tramo.HcTramo()).sum();
    }
}
