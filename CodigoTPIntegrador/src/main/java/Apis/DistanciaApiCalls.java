package Apis;


import Apis.dto.*;
import Dominio.Lugares.Ubicacion;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.cxf.jaxrs.client.WebClient;
import javax.ws.rs.core.Response;

public class DistanciaApiCalls {

    WebClient clientUsers;
    ObjectMapper objectMapper;

    public DistanciaApiCalls() {
        this.clientUsers = WebClient.create("https://ddstpa.com.ar/api")
                           .header("accept", "application/json")
                           .header("Authorization", "Bearer uwXOVLFwYklCO5jhr1nhllPns3XHhiq0GmngGSvDiYY="); //por ahora el mismo token siempre
        this.objectMapper = new ObjectMapper()
                            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    public String obtenerToken(String mail) throws Exception {
        AutenticacionRequest autenticacionRequest = new AutenticacionRequest(mail);
        String requestBody = objectMapper.writeValueAsString(autenticacionRequest);

        Response response = clientUsers
                .header("Content-Type", "application/json")
                .path("/users")
                .post(requestBody);

        int status = response.getStatus();
        String responseBody = response.readEntity(String.class);
        if (status == 201) {
            AutenticacionResponse autenticacionResponse = objectMapper.readValue(responseBody, AutenticacionResponse.class);
            return autenticacionResponse.getToken();
        } else {
            throw new Exception("Error en la llamada a /api/user");
        }
    }

    public DistanciaResponse calcularDistancia(Ubicacion ubicacionOrigen, Ubicacion ubicacionFinal) throws Exception {

        Response response = clientUsers
                .replacePath("/distancia")
                .query("localidadOrigenId", ubicacionOrigen.getLocalidad())
                .query("calleOrigen", ubicacionOrigen.getCalle())
                .query("alturaOrigen", ubicacionOrigen.getAltura())
                .query("localidadDestinoId", ubicacionFinal.getLocalidad())
                .query("calleDestino", ubicacionFinal.getCalle())
                .query("alturaDestino", ubicacionFinal.getAltura())
                .get();

        int status = response.getStatus();
        String responseBody = response.readEntity(String.class);
        if (status == 200) {
            DistanciaResponse distanciaResponse = objectMapper.readValue(responseBody, DistanciaResponse.class);
            return distanciaResponse;
        } else {
            throw new Exception("Error en la llamada a /api/distancia");
        }
    }

}