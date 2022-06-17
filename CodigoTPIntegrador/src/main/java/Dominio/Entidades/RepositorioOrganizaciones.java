package Dominio.Entidades;

import Seguridad.RepositorioUsuario;
import Seguridad.Usuario;

import java.util.ArrayList;
import java.util.List;

public class RepositorioOrganizaciones {
    private static RepositorioOrganizaciones repositorioOrganizaciones = null;
    private List<Organizacion> organizaciones = new ArrayList<>();
    //como este metodo es privado y no tengo acceso, se puede instanciar por unica vez
    private RepositorioOrganizaciones(){
    }
    public static RepositorioOrganizaciones getInstance(){
        if(repositorioOrganizaciones == null) {
            repositorioOrganizaciones = new RepositorioOrganizaciones();
        }
        return repositorioOrganizaciones;
    }

    public void agregarOrganizacion(Organizacion organizacion) throws Exception {
        if(repositorioOrganizaciones.existeOrganizacionConRazonSocial(organizacion.getRazonSocial()))
            throw new Exception("No se pudo crear la organizacion. Ya existe una con esa misma razon social");
        organizaciones.add(organizacion);
    }

    public Boolean existeOrganizacionConRazonSocial(String razonSocialOrg){
        return organizaciones.stream().anyMatch(orgEnRepo ->orgEnRepo.getRazonSocial().equals(razonSocialOrg));
    }

    public Organizacion getOrganizacionPorRazonSocial(String razonSocial){
        if(existeOrganizacionConRazonSocial(razonSocial))
            return organizaciones.stream().filter(orgEnRepo ->razonSocial.equals(orgEnRepo.getRazonSocial())).findAny().get();
        return null;
    }

    public List<Organizacion> getOrganizaciones() {
        return organizaciones;
    }
}
