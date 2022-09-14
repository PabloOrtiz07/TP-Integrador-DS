package Repositorios;

public class RepoTransportePrivado{
    private static RepoTransportePrivado repoTransportePrivado = null;
    private RepoTransportePrivado(){
    }
    public static RepoTransportePrivado getInstance() {
        if(repoTransportePrivado == null) {
            repoTransportePrivado = new RepoTransportePrivado();
        }
        return repoTransportePrivado;
    }

}
