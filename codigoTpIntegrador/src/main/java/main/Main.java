package main;

import validador.ValidadorContrasenaSegura;
import validador.ValidadorLogin;
import java.io.IOException;
import java.util.*;

import static java.lang.Math.pow;


public class Main {

    public static void main(String[] args) throws IOException {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Aprete 1 para registrarse, 2 para Iniciar Sesion");
        int seleccion = entrada.nextInt();

        if(seleccion == 1) registrarse();
        else if(seleccion == 2) login();
        else System.out.println("Seleccion invalida terminando programa");
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

    private static void login() {
        Scanner entrada = new Scanner(System.in);
        String usuario, contrasena;
        ValidadorLogin validadorLogin = new ValidadorLogin();
        boolean loginValido = false;

        //ciclo hasta un login valido solamente para poder probar que funciona el bloqueo por error
        //si no el programa terminaria su ejecucion y por como esta implementado ahora mismo se resetearian los valores de intentos
        while(!loginValido){
            System.out.println("Ingrese usuario: ");
            usuario = entrada.nextLine();
            System.out.println("Ingrese contrasena: ");
            contrasena = entrada.nextLine();
            loginValido = validadorLogin.validarLogin(usuario, contrasena);
        }

    }


}

