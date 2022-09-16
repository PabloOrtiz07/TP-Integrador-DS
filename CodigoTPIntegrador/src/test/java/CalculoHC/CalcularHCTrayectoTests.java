package CalculoHC;

import Apis.DistanciaApiCalls;
import Apis.dto.DistanciaResponse;
import Dominio.Entidades.*;
import Dominio.Lugares.Espacio;
import Dominio.Lugares.TipoEspacio;
import Dominio.Lugares.Ubicacion;
import Dominio.Medicion.FactorEmision;
import Dominio.Transportes.TipoCombustible;
import Dominio.Transportes.TipoVehiculoParticular;
import Dominio.Transportes.Transporte;
import Dominio.Transportes.TransportePrivado;
import Dominio.Viajes.Tramo;
import Dominio.Viajes.Trayecto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.exceptions.base.MockitoException;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;/*
@ExtendWith(MockitoExtension.class)

public class CalcularHCTrayectoTests {

    Miembro miembroPruebaUno;

    Ubicacion ubicacionInicio;

    Ubicacion ubicacionFin;

    Trayecto trayectoUnoPrueba;

    Tramo    tramoConTransportePrivado;

    FactorEmision factorEmision;
    @Mock

    private DistanciaApiCalls distanciaApiCalls;

    @BeforeEach
    void setup() throws Exception {

        Mockito.when(distanciaApiCalls.calcularDistancia(any(Ubicacion.class),any(Ubicacion.class))).thenReturn( new DistanciaResponse("100.00","KM"));
        ubicacionInicio = generarUbicacionInicioPruebaUno();
        ubicacionFin = generarUbicacionFinPruebaUno();
        Espacio espacioInicio = new Espacio(ubicacionInicio, TipoEspacio.HOGAR);
        Espacio espacioFin = new Espacio(ubicacionFin, TipoEspacio.TRABAJO);
        Organizacion google = generarOrganizacionGoogle(espacioFin.getUbicacion());
        Persona personaUnoPrueba = generarPersonaPruebaUno();
        TransportePrivado transportePrivado = generarTransportePrivado();
        miembroPruebaUno = new Miembro(personaUnoPrueba);
        miembroPruebaUno.enviarSolicitud(google, "marketing");
        google.aceptarSolicitud(miembroPruebaUno);
        List<Miembro> miembrosViaje = new ArrayList<>();
        miembrosViaje.add(miembroPruebaUno);
        tramoConTransportePrivado = generarTramoTransportePrivado(espacioInicio.getUbicacion(),espacioFin.getUbicacion(),transportePrivado,miembrosViaje);
        List<Tramo> tramos = new ArrayList<Tramo>();
        tramos.add(tramoConTransportePrivado);
        List<Trayecto> trayectos = new ArrayList<>();
        trayectoUnoPrueba = generarTrayecto(espacioInicio.getUbicacion(),espacioFin.getUbicacion(),5,5);
        trayectoUnoPrueba.agregarTramo(tramoConTransportePrivado);
        miembroPruebaUno.cargarTrayecto(trayectoUnoPrueba);


    }


    public Organizacion generarOrganizacionGoogle(Ubicacion ubicacionFin) throws Exception {
        Espacio espacioFin = new Espacio(ubicacionFin, TipoEspacio.TRABAJO);
        Organizacion google = new Organizacion("google", TipoOrganizacion.EMPRESA, TipoClasificacion.EMPRESA_DEL_SECTOR_SECUNDARIO, espacioFin,5.00);
        google.agregarContacto(new Contacto("pruebadds@maildrop.cc", "11111111",true,true));
        google.agregarContacto(new Contacto("soloPorEmail@maildrop.cc", "11111111",true,false));
        google.agregarContacto(new Contacto("soloWhatsapp@maildrop.cc", "11111111",false,false));
        Area marketing = new Area("marketing");
        google.agregarArea(marketing);
        marketing.agregarMiembro(new Miembro(new Persona("Nombre", "Apellido", "123", TipoDocumento.DNI)));
        marketing.agregarMiembro(new Miembro(new Persona("OtroSombre", "OtroApellido", "456", TipoDocumento.DNI)));
        return google;
    }

    public Trayecto generarTrayecto(Ubicacion ubicacionInicio, Ubicacion ubicacionFin,Integer diasHabiles, Integer diasDeUsoEnLaSemana){
        Trayecto trayectoUnoPrueba = new Trayecto(ubicacionInicio, ubicacionFin,diasHabiles,diasDeUsoEnLaSemana);
        return  trayectoUnoPrueba;
    }
    public TransportePrivado generarTransportePrivado(){
        factorEmision=generarFactor();
        TransportePrivado transportePrivado = new TransportePrivado(true, "uber", TipoCombustible.GASOIL, TipoVehiculoParticular.AUTO,factorEmision);
        return  transportePrivado;
    }

    public FactorEmision generarFactor(){
        FactorEmision factorEmision = new FactorEmision(100.00,"kg");
        return  factorEmision;
    }

    public Ubicacion generarUbicacionFinPruebaUno() throws Exception {
        Ubicacion ubicacionFin = new Ubicacion("ARGENTINA", "CIUDAD DE BUENOS AIRES", 20, "CIUDAD DE BUENOS AIRES", "AV. 9 DE JULIO", "100");
        return ubicacionFin;
    }

    public Ubicacion generarUbicacionInicioPruebaUno() throws Exception {
        Ubicacion ubicacionInicio = new Ubicacion("Argentina", "Buenos aires", 12, "Almagro", "Medrano","299");
        return ubicacionInicio;
    }

    public Persona generarPersonaPruebaUno() throws Exception {
        Persona persona = new Persona("Nombre", "Apellido", "123", TipoDocumento.DNI);
        return  persona;
    }

    public Tramo  generarTramoTransportePrivado(Ubicacion ubicacionInicio, Ubicacion ubicacionFin, TransportePrivado transportePrivado, List<Miembro> miembrosViaje) throws Exception {
        Tramo tramo = new Tramo(ubicacionInicio, ubicacionFin,transportePrivado,miembrosViaje);
        return  tramo;
    }

    @Test
    public void calcularPorMiembroTransportePrivado() throws Exception {

        Mockito.verify(distanciaApiCalls).calcularDistancia(ubicacionInicio,ubicacionFin);
        System.out.println(tramoConTransportePrivado.calcularHCTramo());
    }
}
*/