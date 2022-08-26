package Dominio.Entidades;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SectorMunicipalTest {

    SectorMunicipal sectorMunicipal;

    @BeforeEach

    public void setup() {
        sectorMunicipal = new SectorMunicipal();
    }

    @Test

    void setAndGetMunicipio() {
        sectorMunicipal.setMunicipio("Andorn");
        assertEquals("Andorn" ,sectorMunicipal.getMunicipio());
    }

}
