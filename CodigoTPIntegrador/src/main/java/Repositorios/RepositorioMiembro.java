package Repositorios;

public class RepositorioMiembro {
    private static RepositorioMiembro repoMiembro = null;

    private RepositorioMiembro() {
    }

    public static RepositorioMiembro getInstance() {
        if (repoMiembro == null) {
            repoMiembro = new RepositorioMiembro();
        }
        return repoMiembro;
    }
}

