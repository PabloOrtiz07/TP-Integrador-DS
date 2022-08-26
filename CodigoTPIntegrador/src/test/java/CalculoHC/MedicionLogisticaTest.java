package Dominio.Medicion;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MedicionLogisticaTest {
    MedicionLogistica medicionLogistica;

    @BeforeEach

    public void setup() {
        medicionLogistica = new MedicionLogistica();
    }

    @Test

    void setAndGetCategoriaProducto() {
        medicionLogistica.setCategoriaProducto("Bebida");
        assertEquals( "Bebida",medicionLogistica.getCategoriaProducto());
    }

    @Test

    void setAndGetDistanciaRecorrida() {
        medicionLogistica.setDistanciaRecorrida(77.7);
        assertEquals( 77.7,medicionLogistica.getDistanciaRecorrida());
    }

    @Test

    void setAndGetPesoTotal() {
        medicionLogistica.setPesoTotal(100.00);
        assertEquals(100,medicionLogistica.getPesoTotal());
    }

    @Test

    void setAndGetMedioTransporte() {
        TransporteLogistico medioTransporte = new TransporteLogistico();
        medicionLogistica.setMedioTransporte(medioTransporte);
        assertEquals( medioTransporte,medicionLogistica.getMedioTransporte());
    }

    @Test

    void setAndGetActividad() {
        medicionLogistica.setActividad("Medir");
        assertEquals( "Medir",medicionLogistica.getActividad());
    }

    @Test

    void setAndGetPeriodicidad() {
        medicionLogistica.setPeriodicidad("Cada 30 mimuntos");
        assertEquals( "Cada 30 mimuntos",medicionLogistica.getPeriodicidad());
    }

    @Test

    void setAndGetPeriodo() {
        medicionLogistica.setPeriodo("5 Vezes");
        assertEquals( "5 Vezes",medicionLogistica.getPeriodo());
    }
}
