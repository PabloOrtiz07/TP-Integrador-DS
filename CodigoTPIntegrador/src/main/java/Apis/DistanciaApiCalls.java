package Apis;


import Apis.dto.*;
import Dominio.Lugares.Espacio;
import Dominio.Lugares.TipoEspacio;
import Dominio.Lugares.Ubicacion;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.cxf.jaxrs.client.WebClient;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DistanciaApiCalls {

    WebClient clientUsers;
    ObjectMapper objectMapper;

    public DistanciaApiCalls() {
        this.clientUsers = WebClient.create("https://ddstpa.com.ar/api")
                .header("accept", "application/json")
                .header("Authorization", "Bearer uwXOVLFwYklCO5jhr1nhllPns3XHhiq0GmngGSvDiYY="); //por ahora el mismo token siempre
        this.objectMapper = new ObjectMapper();
        this.objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
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

        int paisOrigenId = obtenerIdPais(ubicacionOrigen.getPais());
        int paisFinalId = obtenerIdPais(ubicacionFinal.getPais());

        int provinciaOrigenID = obtenerIdProvincia(paisOrigenId, ubicacionOrigen.getProvincia());
        int provinciaFinalId = obtenerIdProvincia(paisFinalId, ubicacionFinal.getProvincia());

        int municipioOrigenId = obtenerIdMunicipio(provinciaOrigenID, ubicacionOrigen.getMunicipio());
        int municipioFinalId = obtenerIdMunicipio(provinciaFinalId, ubicacionFinal.getMunicipio());

        int localidadOrigenId = obtenerLocalidadId(municipioOrigenId, ubicacionOrigen.getLocalidad());
        int localidadFinalId = obtenerLocalidadId(municipioFinalId, ubicacionFinal.getLocalidad());

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


    private int obtenerIdPais(String pais) throws Exception {
        int offset = 1;
        clientUsers.replacePath("/paises");

        boolean llegoMaxOffset = false;
        while (!llegoMaxOffset) {
            Response response = clientUsers.replaceQueryParam("offset", offset).get();

            String responseBody = response.readEntity(String.class);
            PaisResponse[] paisesRespuesta = objectMapper.readValue(responseBody, PaisResponse[].class);

           if (paisesRespuesta.length == 0){
               llegoMaxOffset = true;
               break;
           }

            for (int i = 0; i < paisesRespuesta.length; i++)
                if (paisesRespuesta[i].getNombre().equals(pais)) {
                    return paisesRespuesta[i].getId();
                }
            offset++;
            clientUsers.replaceQueryParam("offset", offset);
        }
        throw new Exception("No se encontro el pais");
    }

    private int obtenerIdProvincia(int paisId, String provincia) throws Exception{

        int offset = 1;
        clientUsers.replacePath("/provincias")
                .replaceQueryParam("paisId", paisId);

        boolean llegoMaxOffset = false;
        while (!llegoMaxOffset){
            Response response = clientUsers.replaceQueryParam("offset", offset).get();

            String responseBody = response.readEntity(String.class);
            ProviniciaResponse[] provinciasRespuesta = objectMapper.readValue(responseBody, ProviniciaResponse[].class);
            if(provinciasRespuesta.length == 0){
                llegoMaxOffset = true;
                break;
            }

            for (int i = 0; i < provinciasRespuesta.length; i++)
                if (provinciasRespuesta[i].getNombre().equals(provincia)) {
                    return provinciasRespuesta[i].getId();
                }
            offset++;
            clientUsers.replaceQueryParam("offset", offset);
        }
        throw new Exception("No se encontro el pais");
    }

    private int obtenerIdMunicipio(int provinciaId, String municipio) throws Exception {

        int offset = 1;
        clientUsers.replacePath("/municipios")
                .replaceQueryParam("provinciaId", provinciaId);

        boolean llegoMaxOffset = false;
        while (!llegoMaxOffset){
            Response response = clientUsers.replaceQueryParam("offset", offset).get();

            String responseBody = response.readEntity(String.class);
            MunicipioResponse[] municipioRespuestas = objectMapper.readValue(responseBody, MunicipioResponse[].class);
            if(municipioRespuestas.length == 0){
                llegoMaxOffset = true;
                break;
            }

            for (int i = 0; i < municipioRespuestas.length; i++)
                if (municipioRespuestas[i].getNombre().equals(municipio)) {
                    return municipioRespuestas[i].getId();
                }

            offset++;
            clientUsers.replaceQueryParam("offset", offset);
        }
        throw new Exception("No se encontro el pais");
    }

    private int obtenerLocalidadId(int municipioId, String localidad) throws Exception {
        int offset = 1;
        clientUsers.replacePath("/localidades")
                .replaceQueryParam("municipioId", municipioId);

        boolean llegoMaxOffset = false;
        while (!llegoMaxOffset) {
            Response response = clientUsers.replaceQueryParam("offset", offset).get();

            String responseBody = response.readEntity(String.class);
            LocalidadResponse[] localidadesRespuestas = objectMapper.readValue(responseBody, LocalidadResponse[].class);
            if (localidadesRespuestas.length == 0){
                llegoMaxOffset = true;
                break;
            }

            for (int i = 0; i < localidadesRespuestas.length; i++)
                if (localidadesRespuestas[i].getNombre().equals(localidad)) {
                    return localidadesRespuestas[i].getId();
                }

            offset++;
        }
        throw new Exception("No se encontro el pais");
    }
}