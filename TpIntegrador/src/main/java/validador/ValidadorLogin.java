package validador;


import java.time.LocalTime;
import java.util.HashMap;


import static java.lang.Math.pow;

public class ValidadorLogin {
    int cantidadIntentosFallidos =0;
    double segundosBloqueado = 0;
    LocalTime horaDesbloqueo = LocalTime.now();

    HashMap<String, String> userContrasena = new HashMap<String, String>(){{
        put("Usuario1","ContrasenaPrueba1!");
        put("Usuario2","ContrasenaPrueba2?");
        put("Usuario3","ContrasenaPrueba3@");
        put("Usuario4","A5kh4h!crd");
    }}; //implementacion de usuarios temporal solo para pruebas


    //La implementacion es medio rebuscada por no tener la persistencia
    //seteo hora actual sumandole una cantidad de segundos segun cantidad de errores como la hora de desbloqueo
    //luego para saber si esta bloqueado se fija si la hora actual es anterior a la hora de desbloqueo
    public boolean validarLogin(String usuario, String contrasena){

        if(this.estaBloqueado()){
          System.out.println("Se encuentra bloqueado hasta: " + horaDesbloqueo);
          return false;
        }

        else if(userContrasena.containsKey(usuario) && userContrasena.get(usuario).equals(contrasena)) {
                System.out.println("Login exitoso");
                return true;
        }
        else {
            cantidadIntentosFallidos++;
            segundosBloqueado = tiempoBloqueo(cantidadIntentosFallidos);
            horaDesbloqueo = LocalTime.now().plusSeconds((long) segundosBloqueado);
            System.out.println("Datos incorrectos, ha sido bloqueado por: " + segundosBloqueado + " segundos");
            return false;
        }
    }

    private boolean estaBloqueado() {
        return LocalTime.now().isBefore(horaDesbloqueo);
    }

    public double tiempoBloqueo(int cantidadIntentos){
        return (1.0/2.0) * (pow(2,cantidadIntentos) - 1);     //formula: https://community.f5.com/t5/technical-articles/implementing-the-exponential-backoff-algorithm-to-thwart/ta-p/277295
    }
}




