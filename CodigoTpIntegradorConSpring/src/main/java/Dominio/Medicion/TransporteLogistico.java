package Dominio.Medicion;

public class TransporteLogistico {
    FactorEmision factorEmision;
    String nombre;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public FactorEmision getFactorEmision() {
        return factorEmision;
    }

    public void setFactorEmision(FactorEmision factorEmision) {
        this.factorEmision = factorEmision;
    }
}
