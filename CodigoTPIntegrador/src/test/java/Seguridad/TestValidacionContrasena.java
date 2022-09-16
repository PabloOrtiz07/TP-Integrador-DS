package Seguridad;

import Seguridad.Usuario;
import Seguridad.ValidadorContrasenaSegura;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TestValidacionContrasena {

    List<Boolean> expected;
    ValidadorContrasenaSegura validadorContrasenaSegura;

    @BeforeEach

    public void setup() {
        validadorContrasenaSegura = new ValidadorContrasenaSegura();
        expected = new ArrayList<>();
        Collections.addAll(expected,true,true,true,true,true,true,true,true);
    }

    @Test

    void validacionContrasenaDeUsuario() throws IOException {
        Usuario usuario = new Usuario("Lee", "Lewislee0920!");
        expected.clear();
        Collections.addAll(expected,false,false,false,false,false,false,false,false);
        assertEquals(expected, validadorContrasenaSegura.esContrasenaValida(usuario.getContrasena(), usuario.getNombre()));
    }

    @Test

    void validarSiEsUnContrasenaMenorAlongitudMinima() throws IOException {
        Usuario usuario = new Usuario("Juan", "aBeq");
        assertEquals(expected.get(0), validadorContrasenaSegura.esContrasenaValida(usuario.getContrasena(), usuario.getNombre()).get(0));
    }

    @Test

    void validarSiContrasenaEsIgualAlNombreDeUsuario() throws IOException {
        Usuario usuario = new Usuario("Ariel", "Ariel");
        assertEquals(expected.get(1), validadorContrasenaSegura.esContrasenaValida(usuario.getContrasena(), usuario.getNombre()).get(1));
    }

    @Test

    void validarSiContrasenaEstaEnTop10000MasInseguras() throws IOException {
        Usuario usuario = new Usuario("Franco", "mustang");
        assertEquals(expected.get(2), validadorContrasenaSegura.esContrasenaValida(usuario.getContrasena(), usuario.getNombre()).get(2));
    }

    @Test

    void validarSiContrasenaTieneRepeticionDeCaracteres() throws IOException {
        Usuario usuario = new Usuario("Pedro", "!!??!!!!");
        assertEquals(expected.get(3), validadorContrasenaSegura.esContrasenaValida(usuario.getContrasena(), usuario.getNombre()).get(3));
    }

    @Test

    void validarSiFlagsTieneMayusculaMinusculaNumeroYEspeciales() throws IOException {
        Usuario usuario = new Usuario("Ferry", "Alfajor123");
        assertTrue(
                expected.get(4) == validadorContrasenaSegura.esContrasenaValida(usuario.getContrasena(), usuario.getNombre()).get(4)
                || expected.get(5) == validadorContrasenaSegura.esContrasenaValida(usuario.getContrasena(), usuario.getNombre()).get(5)
                || expected.get(6) == validadorContrasenaSegura.esContrasenaValida(usuario.getContrasena(), usuario.getNombre()).get(6)
                || expected.get(7) == validadorContrasenaSegura.esContrasenaValida(usuario.getContrasena(), usuario.getNombre()).get(7)
        ) ;
    }

}
