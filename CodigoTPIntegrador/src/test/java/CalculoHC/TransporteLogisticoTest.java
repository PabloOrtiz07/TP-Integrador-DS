package Dominio.Medicion;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TransporteLogisticoTest {

    TransporteLogistico transporteLogistico;

    @BeforeEach

    public void setup() {
        transporteLogistico = new TransporteLogistico();
    }

    @Test

    void setAndGetNombre() {
        transporteLogistico.setNombre("Bus");
        assertEquals("Bus" ,transporteLogistico.getNombre());
    }

    @Test

    void setAndGetUnidad() {
        FactorEmision factorEmision = new FactorEmision();
        transporteLogistico.setFactorEmision(factorEmision);
        assertEquals(factorEmision ,transporteLogistico.getFactorEmision());
    }
}
