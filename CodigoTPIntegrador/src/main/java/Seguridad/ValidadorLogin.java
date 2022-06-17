package Seguridad;

import java.time.LocalTime;
import static java.lang.Math.pow;

public class ValidadorLogin{
    public boolean validarLogin(String nombre, String contrasena) throws Exception {
        RepositorioUsuario repoUsuario = RepositorioUsuario.getInstance();
        Usuario usuarioEnRepo = repoUsuario.getUsuarioPorNombre(nombre);

        if(usuarioEnRepo.estaBloqueado())
            throw new Exception("El usuario esta bloqueado hasta: " + usuarioEnRepo.getHoraDesbloqueo());

        if(usuarioEnRepo.contrasenaCorrecta(contrasena)){
            usuarioEnRepo.loginExitoso();
            return true;
        }
        else {
            usuarioEnRepo.agregarIntentoFallido();
            int intentosFallidos = usuarioEnRepo.getCantidadIntentosFallidos();
            double tiempoBloqueo = tiempoBloqueo(intentosFallidos);
            LocalTime horaDesbloqueo = LocalTime.now().plusSeconds((long) tiempoBloqueo);
            usuarioEnRepo.bloquearHasta(horaDesbloqueo);
            return false;
        }
    }

    public double tiempoBloqueo(int cantidadIntentos){
        return (pow(2,cantidadIntentos) - 1) / 2;     //formula: https://community.f5.com/t5/technical-articles/implementing-the-exponential-backoff-algorithm-to-thwart/ta-p/277295
    }
}




