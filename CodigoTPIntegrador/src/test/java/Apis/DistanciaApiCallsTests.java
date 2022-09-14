package Apis;

import Apis.dto.DistanciaResponse;
import Dominio.Lugares.Espacio;
import Dominio.Lugares.TipoEspacio;
import Dominio.Lugares.Ubicacion;
import org.junit.jupiter.api.Test;

public class DistanciaApiCallsTests {
    @Test
    public void calcularDistanciaTest() throws Exception {
        DistanciaApiCalls distanciaApiCalls = new DistanciaApiCalls();
        Ubicacion ubicacionInicio = new Ubicacion("Argentina", "Buenos aires", 12, "Almagro", "Medrano","299");
        Espacio espacioInicio = new Espacio(ubicacionInicio, TipoEspacio.HOGAR);
        Ubicacion ubicacionFin = new Ubicacion("Argentina", "Buenos aires", 15, "Caballito", "Avenida Rivadavia","4900");
        Espacio espacioFin = new Espacio(ubicacionFin,TipoEspacio.TRABAJO);
        DistanciaResponse distanciaResponse = distanciaApiCalls.calcularDistancia(espacioInicio.getUbicacion(),espacioFin.getUbicacion());
        System.out.println(distanciaResponse.getValor());
    }
}
