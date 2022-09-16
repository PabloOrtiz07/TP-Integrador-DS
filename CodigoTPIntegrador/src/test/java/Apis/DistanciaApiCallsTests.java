package Apis;

import Apis.dto.DistanciaResponse;
import Dominio.Lugares.Espacio;
import Dominio.Lugares.TipoEspacio;
import Dominio.Lugares.Ubicacion;
import Dominio.Medicion.FactorEmision;
import Dominio.Transportes.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class DistanciaApiCallsTests {

    private DistanciaApiCalls distanciaApiCalls;

    @BeforeEach
    public void setup() throws Exception {
        String json = "{ \"valor\" : \"10\", \"unidad\" : \"KM\" }";
        ObjectMapper objectMapper = new ObjectMapper();
        DistanciaResponse distanciaResponseMockeado = objectMapper.readValue(json,DistanciaResponse.class);
        distanciaApiCalls = mock(DistanciaApiCalls.class);
        when(distanciaApiCalls.calcularDistancia(any(Ubicacion.class),any(Ubicacion.class))).thenReturn(distanciaResponseMockeado);
    }
    @Test
    public void calcularDistanciaTest() throws Exception {
        Ubicacion ubicacionInicio = new Ubicacion("Argentina", "Buenos aires", 12, "Almagro", "Medrano","299");
        Espacio espacioInicio = new Espacio(ubicacionInicio, TipoEspacio.HOGAR);
        Ubicacion ubicacionFin = new Ubicacion("Argentina", "Buenos aires", 15, "Caballito", "Avenida Rivadavia","4900");
        Espacio espacioFin = new Espacio(ubicacionFin,TipoEspacio.TRABAJO);
        DistanciaResponse distanciaResponse = distanciaApiCalls.calcularDistancia(ubicacionInicio,ubicacionFin);
        System.out.println(distanciaResponse.getValor());

    }
}
