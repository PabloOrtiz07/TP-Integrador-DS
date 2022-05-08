package contrasena;

import java.io.File;
import java.util.*;

public class Main {

    public static void main(String[] args){
        String usuario;
        String contrasena;
        Scanner entrada = new Scanner(System.in);

        System.out.println("Ingrese usuario: ");
        usuario = entrada.nextLine();
        System.out.println("Ingrese contrasena: ");
        contrasena = entrada.nextLine();

        System.out.println(usuario + " " +contrasena);
    }

    /* codigo que no funcionaba
    public static boolean validarContrasena (String contrasena) throws FileNotFoundException {
        try {
            File f = new File ("10000ContrasenasMasInseguras.txt");
            System.out.println(f.exists());
            Scanner s = new Scanner(f);
        }
        //catch the exception
        catch(FileNotFoundException e) {
            e.printStackTrace();
        }
        return true;
    }
    */
}

