package Dominio.Transportes;

import Dominio.Lugares.TipoEspacio;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import Dominio.Lugares.Parada;

import static org.junit.jupiter.api.Assertions.*;

class TransportePublicoTest {

    TransportePublico transportePublico;

    @BeforeEach

    public void setup() {
        transportePublico = new TransportePublico(TipoDeTransportePublico.COLECTIVO, "Linea A");
    }

    @Test

    void averiguarLinea() {
        assertEquals("Linea A", transportePublico.getLinea());
    }

    @Test

    void averiguarTipoTransportePublico() {
        assertEquals(TipoDeTransportePublico.COLECTIVO, transportePublico.getTipoTransportePublico());
    }

    @Test

    void verSiParadasEstaVacioAntesDeAgregarUnoNuevo() {
        Parada paradaNuevo = new Parada("Argentina", "Buenos Aires", "Caballito", "La Matanza", "Avenida Avellaneda", "4532",500);
        transportePublico.agregarParada(paradaNuevo);
        assertEquals(null, paradaNuevo.getParadaAnterior());
    }

    @Test

    void agregarParada() {
        Parada paradaNuevo = new Parada("Argentina", "Buenos Aires", "Caballito", "La Matanza", "Avenida Avellaneda", "4532",500);
        transportePublico.agregarParada(paradaNuevo);
        assertTrue(transportePublico.getParadas().contains(paradaNuevo));
    }

    @Test

    void setAndGetFactorEmission() {
        transportePublico.setFactorEmision(55);
        assertEquals( 55,transportePublico.getFactorEmision());
    }

    @Test

    void calcularDistanciaRecorrida() throws Exception {
        Parada parada = new Parada("Bretania", "London", "Springfield", "Maple", "Baker", "50",200);
        Parada paradaIni = new Parada("Argentina", "Buenos Aires", "Caballito", "La Matanza", "Avenida Avellaneda", "4532", 300);
        Parada paradaFin = new Parada("France", "Paris", "Louvre", "Bourse", "le Pain", "34", 500);
        paradaIni.setParadaSiguiente(parada);
        paradaFin.setParadaAnterior(parada);
        assertEquals(0, transportePublico.distanciaRecorrida(paradaIni, paradaFin));
    }
    // calcularDistanciaRecorrida = Test doesnt end 

}
