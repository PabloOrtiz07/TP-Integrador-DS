package Apis.dto;

import Dominio.Lugares.Ubicacion;

public class DistanciaRequest {
    private int localidadOrigenId;
    private String calleOrigen;
    private String alturaOrigen;
    private int localidadDestinoID;
    private String calleDestino;
    private String alturaDestino;

    public DistanciaRequest(int localidadOrigenId, String calleOrigen, String alturaOrigen, int localidadDestinoID, String calleDestino, String alturaDestino) {
        this.localidadOrigenId = localidadOrigenId;
        this.calleOrigen = calleOrigen;
        this.alturaOrigen = alturaOrigen;
        this.localidadDestinoID = localidadDestinoID;
        this.calleDestino = calleDestino;
        this.alturaDestino = alturaDestino;
    }
}
