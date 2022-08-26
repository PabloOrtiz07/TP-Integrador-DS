package Dominio.Medicion;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FactorEmisionTest {

    FactorEmision factorEmision;

    @BeforeEach

    public void setup() {
        factorEmision = new FactorEmision();
    }

    @Test

    void setAndGetValor() {
        factorEmision.setValor(4.13);
        assertEquals(4.13 ,factorEmision.getValor());
    }

    @Test

    void setAndGetUnidad() {
        factorEmision.setUnidad("Metro");
        assertEquals("Metro" ,factorEmision.getUnidad());
    }
}
