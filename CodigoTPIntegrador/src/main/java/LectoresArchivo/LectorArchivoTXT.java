package domain.ValidadorDeContrasenas;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidadorDeContrasenas {

    public Boolean esContrasenaValida(String contrasena, String usuario) throws IOException {

        Boolean menorQueMinimoCaracter = this.noCumpleMinimoCaracter(contrasena);
        Boolean mismoContrasenaYUsuario = this.tieneMismoContrasenaYUsuario(contrasena, usuario);
        Boolean repeticionDeCaracter = this.tieneRepeticionDeCaracter(contrasena);
        Boolean contrasenaSimple = this.faltaMayusculaMinusculaNumeroOEspeciales(contrasena);
        Boolean contrasenaEn10000MasInseguros = this.estaEn1Top0000MasInseguros(contrasena);
        return !menorQueMinimoCaracter && !mismoContrasenaYUsuario && !repeticionDeCaracter && !contrasenaSimple && !contrasenaEn10000MasInseguros;
    }

    private Boolean noCumpleMinimoCaracter(String contrasena) {
        return contrasena.length() < minimoCaracter;
    } 

    static int minimoCaracter = 8;

    private Boolean tieneMismoContrasenaYUsuario(String contrasena, String usuario) {
        return contrasena.equals(usuario);
    }

    private Boolean tieneRepeticionDeCaracter(String contrasena) {
        String regex = "(\\S)\\1\\1+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher= pattern.matcher(contrasena);
        return matcher.find();
    }

    private Boolean faltaMayusculaMinusculaNumeroOEspeciales(String contrasena) {
        boolean faltaMayuscula = true;
        boolean faltaMinuscula = true;
        boolean faltaNumero = true;
        boolean faltaEspecial = true;

        for(int i = 0; i< contrasena.length(); i++) {
            char carcaterActual = contrasena.charAt(i);
            if(Character.isUpperCase(carcaterActual)) {
                faltaMayuscula = false;
            }
            else if(Character.isLowerCase(carcaterActual)) {
                faltaMinuscula = false;
            }
            else if(Character.isDigit(carcaterActual)) {
                faltaNumero = false;
            }
            else if(!Character.isWhitespace(carcaterActual)) {
                faltaEspecial = false;
            }

            if(faltaMayuscula && faltaMinuscula && faltaNumero && faltaEspecial) {
                break;
            }
        }

        return faltaMayuscula && faltaMinuscula && faltaNumero && faltaEspecial;
    }

    private Boolean estaEn1Top0000MasInseguros(String contrasena) throws IOException{
        URL url = getClass().getClassLoader().getResource("contrasenas.txt");
        File file = new File(url.getPath());
        Scanner scanner = new Scanner(file);
        while(scanner.hasNextLine()){
            String linea = scanner.nextLine();
            if(contrasena.equals(linea)){
                scanner.close();
                return true;
            }
        }
        scanner.close();
        return false;
    }

}
