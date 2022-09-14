package Repositorios;

import Dominio.Entidades.*;
import Dominio.Lugares.Espacio;
import Dominio.Lugares.Parada;
import Dominio.Lugares.TipoEspacio;
import Dominio.Transportes.*;
import Dominio.Viajes.Tramo;
import Dominio.Viajes.Trayecto;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class RepositorioMiembrosTests {
    private static RepositorioMiembrosTests repositorioMiembrosTests = null;
    public static RepositorioMiembrosTests getInstance() {
        if (repositorioMiembrosTests == null) {
            repositorioMiembrosTests = new RepositorioMiembrosTests();
        }
        return repositorioMiembrosTests;
    }
    private List<Miembro> miembros = new ArrayList<>();

    //Agrego en el constructor que se inicializen unas organizaciones default;
    private RepositorioMiembrosTests(){
        try {
            RepositorioOrganizacionesTests repositorioOrganizacionesTests = RepositorioOrganizacionesTests.getInstance();
            Organizacion organizacion = repositorioOrganizacionesTests.getOrganizacionPorRazonSocial("google");

            List<Tramo> tramos = new ArrayList<Tramo>();
            Espacio ubicacionInicio = new Espacio("Argentina", "Buenos aires", "CABA", "Almagro", "Medrano","299",TipoEspacio.HOGAR);
            Espacio ubicacionFin = new Espacio("Argentina", "Buenos aires", "CABA", "Caballito", "Av. Rivadavia","4900",TipoEspacio.TRABAJO);
            TransportePrivado transportePrivado = new TransportePrivado(true, "uber", TipoCombustible.GASOIL, TipoVehiculoParticular.AUTO);
            Tramo tramo1 = new Tramo(ubicacionInicio, ubicacionFin,transportePrivado,miembros);
            tramos.add(tramo1);
            List<Trayecto> trayectos = new ArrayList<>();
            Trayecto trayecto1 = new Trayecto(ubicacionInicio, ubicacionFin);
            trayecto1.agregarTramo(tramo1);

            Persona persona1 = new Persona("Nombre", "Apellido", "123", TipoDocumento.DNI);
            Miembro miembro1 = new Miembro(persona1);
            miembro1.enviarSolicitud(organizacion, "marketing");
            organizacion.aceptarSolicitud(miembro1); //siempre acepta
            miembro1.cargarTrayecto(trayecto1);
            miembros.add(miembro1);

            Persona persona2 = new Persona("Nombre2", "Apellido2", "456", TipoDocumento.DNI))
            Miembro miembro2 = new Miembro(persona2);
            miembro1.enviarSolicitud(organizacion, "contable");
            organizacion.aceptarSolicitud(miembro1);

            TransportePublico transportePublico = new TransportePublico(TipoDeTransportePublico.COLECTIVO, "24");
            Tramo tramo2 = new Tramo(inicio, fin, transportePublico, miembro2);
            Espacio inicio =
            miembro2.cargarTrayecto(trayecto2);


        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public Miembro buscarMiembroPorNombre(String nombre){
        return miembros.stream().filter(miembro -> miembro.getPersona().getNombre().equals(nombre)).findAny().get();
    }
}

