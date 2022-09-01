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
        return tramos.stream().mapToDouble(tramo -> tramo.calcularHCTramo()).sum();
    }

    public double calcularHCTrayectoPorDia(Trayecto trayecto) throws Exception{
        return trayecto.getTramosTrayecto().stream().mapToDouble(tramo -> tramo.calcularHCTramo()).sum();
    }

    public double calcularHCTrayectoPorSemana(List<Trayecto> trayectos) throws Exception{
        return trayectos.stream().mapToDouble(trayecto-> {
            try {
                return calcularHCTrayectoPorDia(trayecto)*trayecto.getPesoTrayecto();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }).sum();
    }
    public double calcularHCTrayectoPorMes(List<Trayecto> trayectos) throws Exception{
        return calcularHCTrayectoPorSemana(trayectos)*4.5;
    }
}
