package validador;

import static java.lang.Math.pow;

public class ValidadorLogin {
    //De aca sale la formula:
    // https://community.f5.com/t5/technical-articles/implementing-the-exponential-backoff-algorithm-to-thwart/ta-p/277295
    int cantidadIntentos = 0;
    double segundoBloqueo = (1/2 * (pow(2,cantidadIntentos) - 1));

    private boolean esValidoUsuarioYContrasenia(String usuario, String contrasenia){


    }

}
