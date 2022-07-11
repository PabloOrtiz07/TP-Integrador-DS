package CalculoHC;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import Dominio.Entidades.Organizacion;
import Dominio.Medicion.Medicion;


public class CalcularHCDatosActividadOtras {

    public double sumaHCOtras(Organizacion organizacion){
        return organizacion.getMediciones().stream().mapToDouble(medicion-> medicion.getValor()* medicion.getFactorEmision()).sum(); // esto estaria mal porque las unidades son diferentes pero para probar ahora me sirve
    }
}
