package Apis;


import Apis.dto.*;
import Dominio.Lugares.Ubicacion;
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

        int localidadOrigenId = obtenerIdLocalidad(ubicacionOrigen);
        int localidadFinalId = obtenerIdLocalidad(ubicacionFinal);

        Response response = clientUsers
                .replacePath("/distancia")
                .query("localidadOrigenId", localidadOrigenId)
                .query("calleOrigen", ubicacionOrigen.getCalle())
                .query("alturaOrigen", ubicacionOrigen.getAltura())
                .query("localidadDestinoId", localidadFinalId)
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


    private int obtenerIdLocalidad(Ubicacion ubicacion) throws Exception {
        clientUsers.replacePath("/paises");
        int paisId = busquedaIdGenerico(ubicacion.getPais());

        clientUsers.replacePath("/provincias")
                   .replaceQueryParam("paisId", paisId);
        int provinciaId = busquedaIdGenerico(ubicacion.getProvincia());

        clientUsers.replacePath("/municipios")
                   .replaceQueryParam("provinciaId", provinciaId);
        int municipioId = busquedaIdGenerico(ubicacion.getMunicipio());

        clientUsers.replacePath("/localidades")
                   .replaceQueryParam("municipioId", municipioId);
        return busquedaIdGenerico(ubicacion.getLocalidad());
    }

    private int busquedaIdGenerico(String nombre) throws Exception {

        int offset = 1;
        while (true){
            Response response = clientUsers.replaceQueryParam("offset", offset).get();

            String responseBody = response.readEntity(String.class);
            ApiDatosUbicacionResponse[] datosUbicacion = objectMapper.readValue(responseBody, ApiDatosUbicacionResponse[].class);
            if(datosUbicacion.length == 0) break;

            for (int i = 0; i < datosUbicacion.length; i++)
                if (datosUbicacion[i].getNombre().equals(nombre)) return datosUbicacion[i].getId();
            offset++;
        }
        throw new Exception("No se encontro el dato");
    }
}