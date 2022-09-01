package CalculoHC;
import java.util.*;

import Dominio.Entidades.Miembro;
import Dominio.Entidades.Persona;
import Dominio.Entidades.TipoDocumento;
import Dominio.Lugares.Ubicacion;
import Dominio.Transportes.TransporteEcologico;
import Dominio.Viajes.Tramo;
import Dominio.Lugares.*;
import Dominio.Viajes.Trayecto;
import org.jboss.com.sun.corba.se.impl.ior.ObjectReferenceTemplateImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
public class CalcularHCTrayectoTests {



    @Test
    public void calculoOrganizacion_pruebaValores() throws Exception {
        Persona persona = new Persona("Pablo", "Ortiz","39459106", TipoDocumento.DNI);
        Miembro miembro = new Miembro(persona);
        TransporteEcologico transporteEcologico = new TransporteEcologico();
        Espacio ubicacionInicio = new Espacio("Argentina", "Buenos aires", "CABA", "Munipcio8", "Uspallata","2020",TipoEspacio.HOGAR);
        Espacio ubicacionFin = new Espacio("Argentina", "Buenos aires", "CABA", "Munipcio8", "Uspallata","1010",TipoEspacio.TRABAJO);
        List<Trayecto> trayectos = new ArrayList<Trayecto>();
        Trayecto trayecto = new Trayecto(ubicacionInicio,ubicacionFin);
        List<Tramo> tramos = new ArrayList<Tramo>();
        List<Miembro> miembros = new ArrayList<Miembro>();
        miembros.add(miembro);
        Tramo tramoUno = new Tramo(ubicacionInicio,ubicacionFin,transporteEcologico,miembros);
        tramos.add(tramoUno);
        trayecto.setTramosTrayecto(tramos);

        CalculadoraHCTrayecto calculadoraHCTrayecto = new CalculadoraHCTrayecto();
        double resultado = calculadoraHCTrayecto.calcularHCTrayectoPorMes(trayectos);
        Assertions.assertEquals(0,resultado); // tiene sentido que de 0

    }
}
