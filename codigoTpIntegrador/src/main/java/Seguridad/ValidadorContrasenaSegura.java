package Seguridad;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.*;

import LectoresArchivo.LectorArchivo;

//Requerimientos que menciona Guia NIST 800-63
//Memorized secrets SHALL be at least 8 characters in length if chosen by the subscriber
//Compare the prospective secrets against a list that contains values known to be commonly-used:
    //Passwords obtained from previous breach corpuses.
    //Repetitive or sequential characters (e.g. ‘aaaaaa’, ‘1234abcd’).
    //Context-specific words, such as the name of the service, the username, and derivatives thereof.

public class ValidadorContrasenaSegura {

    public static int minimoCaracteres() {
        return MINIMO_CARACTERES;
    }

    static int MINIMO_CARACTERES = 8;
    public  List<Boolean> esContrasenaValida(String contrasena, String nombreUsuario) throws IOException {

        List<Boolean> flagsErrores = new ArrayList<>();
        Boolean esMenorALongitudMinima = this.noCumpleLongitudMinima(contrasena);
        Boolean esIgualAlNombreDeUsuario = this.esIgualAlNombreDeUsuario(contrasena, nombreUsuario);
        Boolean estaEnTop10000MasInseguras = this.estaEnTop10000MasInseguras(contrasena);
        Boolean tieneRepeticionDeCaracteres = this.tieneRepeticionesDeCaracteres(contrasena);
        Collections.addAll(flagsErrores,esMenorALongitudMinima,esIgualAlNombreDeUsuario, estaEnTop10000MasInseguras, tieneRepeticionDeCaracteres);

        flagsErrores.addAll(this.flagsTieneMayusculaMinusculaNumeroYEspeciales(contrasena));

        return flagsErrores;
    }

    private Boolean noCumpleLongitudMinima(String contrasena) {
        return contrasena.length() < MINIMO_CARACTERES;
    }

    private Boolean esIgualAlNombreDeUsuario(String contrasena, String usuario){
       return contrasena.equals(usuario);
    }

    private Boolean estaEnTop10000MasInseguras(String contrasena) throws IOException {
        LectorArchivo lector = new LectorArchivo();
        return lector.estaEnArchivo(contrasena, "10000ContrasenasMasInseguras.txt");
    }

    private Boolean tieneRepeticionesDeCaracteres(String contrasena)
    {
        //Usando regex queda mucho mas simple el codigo pero no se si es lo mejor
        // La regex matchea con cualquier caracter (menos espacios en blanco) que se repite 3 o mas veces seguidas
        // Aca hay pruebas hechas en la pestaña de test unitarios: https://regex101.com/r/Ar0SpV/4
        String regex = "(\\S)\\1\\1+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher= pattern.matcher(contrasena);

        //find devuelve true si alguna parte de la cadena matchea con la regex
        return matcher.find();
    }

    private List<Boolean> flagsTieneMayusculaMinusculaNumeroYEspeciales(String contrasena){
            boolean flagSinNumero = true;
            boolean flagSinMayuscula = true;
            boolean flagSinMinuscula = true;
            boolean flagSinCaracterEspecial = true;

            List<Boolean> flagCaracteres = new ArrayList<>();

            for(int i=0;i < contrasena.length();i++) {
                char caracterActual = contrasena.charAt(i);
                if (Character.isDigit(caracterActual))
                    flagSinNumero = false;
                else if (Character.isUpperCase(caracterActual))
                    flagSinMayuscula = false;
                else if (Character.isLowerCase(caracterActual))
                    flagSinMinuscula = false;
                else if (!Character.isWhitespace(caracterActual)) //si no es niguno de los anteriores y tampoco es un espacio en blanco debe ser un caracter especial
                    flagSinCaracterEspecial = false;

                if (!flagSinNumero && !flagSinMayuscula && !flagSinMinuscula && !flagSinCaracterEspecial) //si contiene al menos uno de cada tipo de caracter corta la ejecucuion
                   break;
            }
        Collections.addAll(flagCaracteres, flagSinNumero, flagSinMayuscula, flagSinMinuscula, flagSinCaracterEspecial);
        return flagCaracteres;
    }
}
