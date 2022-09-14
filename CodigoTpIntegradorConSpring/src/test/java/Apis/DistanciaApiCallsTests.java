package Apis;

import Apis.dto.DistanciaResponse;
import Dominio.Lugares.Espacio;
import Dominio.Lugares.TipoEspacio;
import org.junit.jupiter.api.Test;

public class DistanciaApiCallsTests {
    @Test
    public void calcularDistanciaTest() throws Exception {
       DistanciaApiCalls distanciaApiCalls = new DistanciaApiCalls();
        Espacio ubicacionInicio = new Espacio("Argentina", "Buenos aires", "CABA", "Almagro", "Medrano","299", TipoEspacio.HOGAR);
        Espacio ubicacionFin = new Espacio("Argentina", "Buenos aires", "CABA", "Caballito", "Av. Rivadavia","4900",TipoEspacio.TRABAJO);
       DistanciaResponse distanciaResponse = distanciaApiCalls.calcularDistancia(ubicacionInicio, ubicacionFin);
        System.out.println(distanciaResponse.getValor());
    }
}
