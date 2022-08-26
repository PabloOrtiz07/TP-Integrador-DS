package Dominio.Lugares;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParadaTest {
    Parada parada;

    @BeforeEach

    public void setup() {
        parada = new Parada("Argentina", "Buenos Aires", "Caballito", "La Matanza", "Avenida Avellaneda", "4532",500);
    }

    @Test

    void setAndGetPais() {
        parada.setPais("France");
        assertEquals( "France",parada.getPais());
    }

    @Test

    void setAndGetProvincia() {
        parada.setProvincia("Paris");
        assertEquals("Paris" ,parada.getProvincia());
    }

    @Test

    void setAndGetLocalidad() {
        parada.setLocalidad("Louvre");
        assertEquals( "Louvre",parada.getLocalidad());
    }

    @Test

    void setAndGetMunicipio() {
        parada.setMunicipio("Bourse");
        assertEquals( "Bourse",parada.getMunicipio());
    }

    @Test

    void setAndGetCalle() {
        parada.setCalle("Le Pain");
        assertEquals("Le Pain" ,parada.getCalle());
    }

    @Test

    void setAndGetAltura() {
        parada.setAltura("34");
        assertEquals("34" ,parada.getAltura());
    }

    @Test

    void setAndGetParadaSiguiente() {
        Parada paradaSiguiente = new Parada("France", "Paris", "Louvre", "Bourse", "le Pain", "34",500);
        parada.setParadaSiguiente(paradaSiguiente);
        assertEquals(paradaSiguiente ,parada.getParadaSiguiente());
    }

    @Test

    void setAndGetParadaAnterior() {
        Parada paradaAnterior = new Parada("Bretania", "London", "Springfield", "Maple", "Baker", "50",200);
        parada.setParadaAnterior(paradaAnterior);
        assertEquals(paradaAnterior ,parada.getParadaAnterior());
    }

    @Test

    void setAndGetDistanciaSiguiente() {
        parada.setDistanciaSiguiente(1000);
        assertEquals(1000 ,parada.getDistanciaSiguiente());
    }

    @Test

    void setAndGetDistanciaAnterior() {
        parada.setDistanciaAnterior(300);
        assertEquals(300 ,parada.getDistanciaAnterior());
    }

}
