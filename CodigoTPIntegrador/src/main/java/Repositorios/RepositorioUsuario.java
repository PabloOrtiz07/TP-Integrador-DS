package Repositorios;

import Dominio.Entidades.Miembro;
import Dominio.Entidades.Persona;
import Seguridad.Usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class RepositorioUsuario {
    private static RepositorioUsuario repoUsuario = null;
    private List<Usuario> usuarios = new ArrayList<>();


    //Algunos usuarios default
    private RepositorioUsuario() {
       Usuario usuario1 = new Usuario("Usuario1", "1ContraseniaSegura!");
       usuario1.setMiembroAsociado(RepositorioOrganizaciones.getInstance().getOrganizacionPorRazonSocial("Google").getMiembroPorDocumento("123"));
       usuarios.add(usuario1);

       Usuario usuario2 = new Usuario("Usuario2", "2ContraseniaSegura!");
       usuario2.setMiembroAsociado(RepositorioOrganizaciones.getInstance().getOrganizacionPorRazonSocial("Google").getMiembroPorDocumento("456"));
       usuarios.add(usuario2);
    }

    public static RepositorioUsuario getInstance() {
        if(repoUsuario == null) {
            repoUsuario = new RepositorioUsuario();
        }
        return repoUsuario;
    }

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
