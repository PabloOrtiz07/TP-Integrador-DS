package Dominio.Entidades;
import java.util.ArrayList;
import java.util.List;

public class SectorTerritorial {

    private List<Organizacion> organizacionEnSector =  new ArrayList<>() ;

    public List<Organizacion> getOrganizacionEnSector() {
        return organizacionEnSector;
    }

    public void setOrganizacionEnSector(List<Organizacion> organizacionEnSector) {
        this.organizacionEnSector = organizacionEnSector;
    }

}
