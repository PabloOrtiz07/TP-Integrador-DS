package Repositorios;

import Dominio.Entidades.*;
import Dominio.Lugares.Espacio;
import Dominio.Lugares.TipoEspacio;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class RepositorioOrganizacionesTests {
    private static RepositorioOrganizacionesTests repositorioOrganizacionesTests = null;
    public static RepositorioOrganizacionesTests getInstance(){
        if(repositorioOrganizacionesTests == null) {
            repositorioOrganizacionesTests = new RepositorioOrganizacionesTests();
        }
        return repositorioOrganizacionesTests;
    }
    private List<Organizacion> organizaciones = new ArrayList<>();

    //Agrego en el constructor que se inicializen unas organizaciones default;
    private RepositorioOrganizacionesTests(){
        try {
            Espacio unEspacio = new Espacio("ARGENTINA", "CIUDAD DE BUENOS AIRES", "RETIRO", "CIUDAD DE BUENOS AIRES", "AV. 9 DE JULIO", "100", TipoEspacio.TRABAJO);
            Organizacion google = new Organizacion("google", TipoOrganizacion.EMPRESA, TipoClasificacion.EMPRESA_DEL_SECTOR_SECUNDARIO, unEspacio,5.00);
            google.agregarContacto(new Contacto("pruebadds@maildrop.cc", "11111111",true,true));
            google.agregarContacto(new Contacto("soloPorEmail@maildrop.cc", "11111111",true,false));
            google.agregarContacto(new Contacto("soloWhatsapp@maildrop.cc", "11111111",false,false));
            Area marketing = new Area("marketing");
            google.agregarArea(marketing);
            marketing.agregarMiembro(new Miembro(new Persona("Nombre", "Apellido", "123", TipoDocumento.DNI)));
            marketing.agregarMiembro(new Miembro(new Persona("OtroNombre", "OtroApellido", "456", TipoDocumento.DNI)));
            organizaciones.add(google);

            Espacio otroEspacio = new Espacio("ARGENTINA", "CIUDAD DE BUENOS AIRES", "CIUDAD DE BUENOS AIRES", "RETIRO", "AV. 9 DE JULIO", "100", TipoEspacio.TRABAJO);
            Organizacion utn = new Organizacion("utn", TipoOrganizacion.EMPRESA, TipoClasificacion.EMPRESA_DEL_SECTOR_SECUNDARIO, otroEspacio,4.00);
            google.agregarContacto(new Contacto("pruebadds@maildrop.cc", "11111111",true,true));
            Area sistemas = new Area("marketing");
            utn.agregarArea(sistemas);
            marketing.agregarMiembro(new Miembro(new Persona("Nombre", "Apellido", "123", TipoDocumento.DNI)));
            marketing.agregarMiembro(new Miembro(new Persona("OtroNombre", "OtroApellido", "456", TipoDocumento.DNI)));
            organizaciones.add(utn);
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public void agregarOrganizacion(Organizacion organizacion) throws Exception {
        if(repositorioOrganizacionesTests.existeOrganizacionConRazonSocial(organizacion.getRazonSocial()))
            throw new Exception("No se pudo crear la organizacion. Ya existe una con esa misma razon social");
        organizaciones.add(organizacion);
    }

    public Boolean existeOrganizacionConRazonSocial(String razonSocialOrg){
        return organizaciones.stream().anyMatch(orgEnRepo ->orgEnRepo.getRazonSocial().equals(razonSocialOrg));
    }

    public Organizacion getOrganizacionPorRazonSocial(String razonSocial) throws NoSuchElementException {
        return organizaciones.stream().filter(orgEnRepo ->razonSocial.equals(orgEnRepo.getRazonSocial())).findAny().get();
    }

    public List<Organizacion> getOrganizaciones() {
        return organizaciones;
    }
}


