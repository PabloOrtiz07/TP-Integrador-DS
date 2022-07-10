package Dominio.Entidades;

import java.util.stream.Collectors;

public class SectorProvincial  extends SectorTerritorial{

    private String provincia;

    public void SectorTerritorial(String provincia){
        this.provincia = provincia;
        this.organizacionEnSector = RepositorioOrganizaciones.getInstance().getOrganizaciones().stream()
                                    .filter(organizacion -> organizacion.estaEnLaProvincia(provincia)).collect(Collectors.toList());
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

}
