package Dominio.Viajes;

import Dominio.Entidades.Miembro;
import Dominio.Viajes.Trayecto;
import Dominio.Lugares.Ubicacion;
import Dominio.Transportes.Transporte;

public class Tramo {
    private Ubicacion ubicacionInicio;
    private Ubicacion ubicacionFinal;
    private Trayecto trayecto;
    private Transporte medioTransporte;
    private Miembro[] miembrosTramo;
}
