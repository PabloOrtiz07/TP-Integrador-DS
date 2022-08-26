package Dominio.Lugares;

import Apis.dto.AutenticacionRequest;
import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EspacioTest {

    Espacio espacio;

    @BeforeEach

    public void setup() {
        espacio = new Espacio("Argentina", "Buenos Aires", "Caballito", "La Matanza", "Avenida Avellaneda", "4532", TipoEspacio.TRABAJO);
    }

    @Test

    void setAndGetPais() {
        espacio.setPais("France");
        assertEquals( "France",espacio.getPais());
    }

    @Test

    void setAndGetProvincia() {
        espacio.setProvincia("Paris");
        assertEquals("Paris" ,espacio.getProvincia());
    }

    @Test

    void setAndGetLocalidad() {
        espacio.setLocalidad("Louvre");
        assertEquals( "Louvre",espacio.getLocalidad());
    }

    @Test

    void setAndGetMunicipio() {
        espacio.setMunicipio("Bourse");
        assertEquals( "Bourse",espacio.getMunicipio());
    }

    @Test

    void setAndGetCalle() {
        espacio.setCalle("Le Pain");
        assertEquals("Le Pain" ,espacio.getCalle());
    }

    @Test

    void setAndGetAltura() {
        espacio.setAltura("34");
        assertEquals("34" ,espacio.getAltura());
    }
}
