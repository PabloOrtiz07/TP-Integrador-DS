package Dominio.Entidades;

import Repositorios.RepositorioOrganizaciones;

import java.util.stream.Collectors;

public class SectorMunicipal extends SectorTerritorial {
    private String municipio;

    public void SectorTerritorial(String municipio){
        this.municipio = municipio;
        this.organizacionEnSector = RepositorioOrganizaciones.getInstance().getOrganizaciones().stream()
                .filter(organizacion -> organizacion.estaEnElMunicipio(municipio)).collect(Collectors.toList());
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }
}
