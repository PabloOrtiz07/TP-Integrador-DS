package Dominio.Medicion;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MedicionOtrosTest {
    MedicionOtros medicionOtros;

    @BeforeEach

    public void setup() {
        medicionOtros = new MedicionOtros();
    }

    @Test

    void setAndGetTipoConsumo() {
        medicionOtros.setTipoConsumo("");
        assertEquals( "",medicionOtros.getTipoConsumo());
    }

    @Test

    void setAndGetValor() {
        medicionOtros.setValor(50.5);
        assertEquals( 50.5,medicionOtros.getValor());
    }

    @Test

    void setAndGetUnidad() {
        medicionOtros.setUnidad("Metro");
        assertEquals( "Metro",medicionOtros.getUnidad());
    }

    @Test

    void setAndGetActividad() {
        medicionOtros.setActividad("Medir");
        assertEquals( "Medir",medicionOtros.getActividad());
    }

    @Test

    void setAndGetPeriodicidad() {
        medicionOtros.setPeriodicidad("Cada 30 mimuntos");
        assertEquals( "Cada 30 mimuntos",medicionOtros.getPeriodicidad());
    }

    @Test

    void setAndGetPeriodo() {
        medicionOtros.setPeriodo("5 Vezes");
        assertEquals( "5 Vezes",medicionOtros.getPeriodo());
    }
}
