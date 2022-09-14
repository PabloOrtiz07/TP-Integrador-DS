package Dominio.Entidades;

public class AgenteSectorial {
    private Persona agenteSectorial;
    private  SectorTerritorial sectorTerritorial;

    public Persona getAgenteSectorial() {
        return agenteSectorial;
    }

    public void setAgenteSectorial(Persona agenteSectorial) {
        this.agenteSectorial = agenteSectorial;
    }

    public SectorTerritorial getSectorTerritorial() {
        return sectorTerritorial;
    }

    public void setSectorTerritorial(SectorTerritorial sectorTerritorial) {
        this.sectorTerritorial = sectorTerritorial;
    }
}
