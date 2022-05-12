package main;

import validador.ValidadorContrasenaSegura;
import validador.ValidadorLogin;
import java.io.IOException;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Aprete 1 para registrarse, 2 para Iniciar Sesion");
        int seleccion = entrada.nextInt();

        if(seleccion == 1) registrarse();
        else if(seleccion == 2) login();
        else System.out.println("Seleccion invalida terminando programa");
    }

    private static void login() {
        /*Todo
        Scanner entrada = new Scanner(System.in);
        String usuario, contrasena;
        ValidadorLogin validadorLogin = new ValidadorLogin();

        System.out.println("Ingrese usuario: ");
        usuario = entrada.nextLine();
        System.out.println("Ingrese contrasena: ");
        contrasena = entrada.nextLine();
        */


    }

    private static void registrarse() throws IOException {
        Scanner entrada = new Scanner(System.in);
        String usuario, contrasena;
        ValidadorContrasenaSegura validadorContrasenaSegura = new ValidadorContrasenaSegura();

        System.out.println("Ingrese usuario: ");
        usuario = entrada.nextLine();
        System.out.println("Ingrese contrasena: ");
        contrasena = entrada.nextLine();

        if (validadorContrasenaSegura.esContrasenaValida(contrasena, usuario))
            System.out.println("Contraseña valida, usuario registrado"); //por ahora no registra nada solo verifica que la contraseña sea correcta
        else
            System.out.println("Intente con una nueva contraseña");
    }
}

