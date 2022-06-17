package Seguridad;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class RepositorioUsuario {
    private static RepositorioUsuario repoUsuario = null;

    private RepositorioUsuario() {
    }

    public static RepositorioUsuario getInstance() {
        if(repoUsuario == null) {
            repoUsuario = new RepositorioUsuario();
        }
        return repoUsuario;
    }

    private List<Usuario> usuarios = new ArrayList<>();

    public void agregarUsuario(Usuario usuario) throws Exception {
        if(repoUsuario.existeUsuarioConNombre(usuario.getNombre()))
            throw new Exception("Ya existe usuario con ese nombre");
        usuarios.add(usuario);
    }

    public boolean existeUsuarioConNombre(String nombreUsuario){
        return usuarios.stream().anyMatch(usuarioEnRepo ->nombreUsuario.equals(usuarioEnRepo.getNombre()));
    }

    public Usuario getUsuarioPorNombre(String nombre) throws NoSuchElementException {
        return usuarios.stream().filter(usuarioEnRepo ->nombre.equals(usuarioEnRepo.getNombre())).findAny().get();
    }
}
