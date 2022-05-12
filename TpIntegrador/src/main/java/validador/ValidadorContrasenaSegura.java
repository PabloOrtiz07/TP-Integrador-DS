package validador;

import java.io.IOException;
import java.util.regex.*;

import lectorArchivo.LectorArchivo;

//Requerimientos que menciona Guia NIST 800-63
//Memorized secrets SHALL be at least 8 characters in length if chosen by the subscriber
//Compare the prospective secrets against a list that contains values known to be commonly-used:
    //Passwords obtained from previous breach corpuses.
    //Repetitive or sequential characters (e.g. ‘aaaaaa’, ‘1234abcd’).
    //Context-specific words, such as the name of the service, the username, and derivatives thereof.

public class ValidadorContrasenaSegura {
    public boolean esContrasenaValida(String contrasena, String usuario) throws IOException {

        final int MINIMO_CARACTERES = 8;

        boolean cumpleLongitudMinima = this.cumpleLongitudMinima(contrasena, MINIMO_CARACTERES);
        boolean esDiferenteAlNombreDeUsuario = this.esDiferenteAlNombreDeUsuario(contrasena, usuario);
        boolean estaEnTop10000MasInseguras = this.estaEnTop10000MasInseguras(contrasena);
        boolean tieneRepeticionDeCaracteres = this.tieneRepeticionesDeCaracteres(contrasena);
        boolean tieneMayusculaMinusculaNumeroYEspeciales = this.tieneMayusculaMinusculaNumeroYEspeciales(contrasena); //No vimos que diga algo de esto en la guia pero nos parece que tendria sentido verificarlo

        return (cumpleLongitudMinima && esDiferenteAlNombreDeUsuario && tieneMayusculaMinusculaNumeroYEspeciales &&!estaEnTop10000MasInseguras && !tieneRepeticionDeCaracteres);
    }

    private boolean cumpleLongitudMinima(String contrasena, int minimo_caracteres) {
        if(contrasena.length() < minimo_caracteres) {
           System.out.println("La contraseña debe tener como mínimo " + minimo_caracteres + " caracteres");
           return false;
        }
        return true;
    }

    private boolean esDiferenteAlNombreDeUsuario(String contrasena, String usuario){
        if (contrasena.equals(usuario)){
            System.out.println("La contraseña no puede ser igual al nombre de usuario");
            return false;
        }
       return true;
    }

    private boolean estaEnTop10000MasInseguras(String contrasena) throws IOException {
        LectorArchivo lector = new LectorArchivo();
        boolean estaEnTop10000ContrasenasInseguras = lector.estaEnArchivo(contrasena, "10000ContrasenasMasInseguras.txt");
        if(estaEnTop10000ContrasenasInseguras) {
            System.out.println("La contraseña esta entre las 10000 contraseñas mas inseguras");
            return true;
        }
        return false;
    }

    private boolean tieneRepeticionesDeCaracteres(String contrasena)
    {
        //Usando regex queda mucho mas simple el codigo pero no se si es lo mejor
        // La regex matchea con cualquier caracter (menos espacios en blanco) que se repite 3 o mas veces seguidas
        // Aca hay pruebas hechas en la pestaña de test unitarios: https://regex101.com/r/Ar0SpV/4
        String regex = "(\\S)\\1\\1+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher= pattern.matcher(contrasena);

        if(matcher.find()){ //find devuelve true si alguna parte de la cadena matchea con la regex
            System.out.println("La contraseña no puede contener el mismo caracter 3 o mas veces de manera consecutiva");
            return true;
        }
        return false;
    }

    private boolean tieneMayusculaMinusculaNumeroYEspeciales(String contrasena){
            boolean flagMayuscula = false;
            boolean flagMinuscula = false;
            boolean flagNumero = false;
            boolean flagCaracterEspecial = false;

            for(int i=0;i < contrasena.length();i++) {
                char caracterActual = contrasena.charAt(i);
                if(Character.isDigit(caracterActual))
                    flagNumero = true;
                else if (Character.isUpperCase(caracterActual))
                    flagMayuscula = true;
                else if (Character.isLowerCase(caracterActual))
                    flagMinuscula = true;
                else if(!Character.isWhitespace(caracterActual)) //si no es niguno de los anteriores y tampoco es un espacio en blanco debe ser un caracter especial
                    flagCaracterEspecial = true;

                if(flagNumero && flagMayuscula && flagMinuscula && flagCaracterEspecial) //si contiene al menos uno de cada tipo de caracter corta la ejecucuion
                    return true;
            }
            System.out.println("La contraseña debe contener al menos 1 mayuscula, 1 minuscula, 1 numero y 1 caracter especial");
            return false;
    }
}
