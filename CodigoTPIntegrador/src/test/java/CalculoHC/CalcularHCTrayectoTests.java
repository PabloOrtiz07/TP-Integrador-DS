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
import Repositorios.RepositorioMiembro;
import Repositorios.RepositorioMiembrosTests;
import org.jboss.com.sun.corba.se.impl.ior.ObjectReferenceTemplateImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
public class CalcularHCTrayectoTests {

    @Test
    public void calcularPorMiembro() throws Exception {
        RepositorioMiembrosTests repositorioMiembrosTests = RepositorioMiembrosTests.getInstance();
        Miembro miembro1 = repositorioMiembrosTests.buscarMiembroPorNombre("Nombre");

    }
}
