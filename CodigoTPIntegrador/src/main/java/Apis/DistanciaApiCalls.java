package Apis;


import Apis.dto.AutenticacionRequest;
import Apis.dto.AutenticacionResponse;
import Apis.dto.DistanciaRequest;
import Apis.dto.DistanciaResponse;
import Dominio.Lugares.Ubicacion;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.cxf.jaxrs.client.WebClient;

import javax.ws.rs.core.Response;

public class DistanciaApiCalls {

    public String obtenerToken(String mail) throws Exception {
        //TODO: Esto del WebClient era lo que nos explico en la clase que no podia estar en otras clases,
        // no que no se podia usar la api desde otra clases, hay que agregar todas las clases relacionadas a la API en el diagrama
        WebClient clientUsers = WebClient.create("https://ddstpa.com.ar/api/user");

        AutenticacionRequest autenticacionRequest = new AutenticacionRequest(mail);
        ObjectMapper objectMapper = new ObjectMapper();
        String requestBody = objectMapper.writeValueAsString(autenticacionRequest);

        Response response = clientUsers
                .header("Content-Type", "application/json")
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

    public DistanciaResponse calcularDistancia(/*Ubicacion ubicacion1, Ubicacion ubicacion2*/) throws Exception {
        //Por ahora siempre la misma consulta hay que ver como pasar de nuestro objetos Ubicaciones a la request
        WebClient clientUsers = WebClient.create("https://ddstpa.com.ar/api/distancia?localidadOrigenId=1&calleOrigen=maipu&alturaOrigen=100&localidadDestinoId=457&calleDestino=O%27Higgins&alturaDestino=200");
        ObjectMapper objectMapper = new ObjectMapper();

        Response response = clientUsers
                .header("accept", "application/json")
                .header("Authorization", "Bearer uwXOVLFwYklCO5jhr1nhllPns3XHhiq0GmngGSvDiYY=") //por ahora el mismo token siempre
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