package Dominio.Entidades;
import java.util.ArrayList;
import java.util.List;


public abstract class SectorTerritorial {

    protected List<Organizacion> organizacionEnSector =  new ArrayList<>() ;

    public List<Organizacion> getOrganizacionEnSector() {
        return organizacionEnSector;
    }

    public Double calculoHCTotal(){
        return organizacionEnSector.stream().mapToDouble(org -> org.calcularHC()).sum();
    }

}
