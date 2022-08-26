package Dominio.Entidades;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SectorProvincialTest {
    SectorProvincial sectorProvincial;

    @BeforeEach

    public void setup() {
        sectorProvincial = new SectorProvincial();
    }

    @Test

    void setAndGetMunicipio() {
        sectorProvincial.setProvincia("Buenos Aires");
        assertEquals("Buenos Aires" ,sectorProvincial.getProvincia());
    }

}
