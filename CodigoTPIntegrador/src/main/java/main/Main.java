package main;

import Dominio.Entidades.Actividad;

import Apis.DistanciaApiCalls;
import Apis.dto.DistanciaResponse;
import Seguridad.RepositorioUsuario;
import Seguridad.Usuario;
import Seguridad.ValidadorContrasenaSegura;
import Seguridad.ValidadorLogin;
import org.jetbrains.annotations.NotNull;


import java.time.LocalDate;
import java.io.*;
import java.util.*;
import com.opencsv.*;
import com.opencsv.CSVReader;

public class Main {

    public static void main (String[] args) throws IOException {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Ingrese 0 para salir, 1 para registrarse, 2 para Iniciar Sesion");
        int seleccion = entrada.nextInt();
        do{
            if(seleccion == 1) registrarse();
            else if(seleccion == 2) login();
            else if(seleccion == 3) calcularDistancia();
            else System.out.println("Seleccion invalida");
            System.out.println("Ingrese 0 para salir, 1 para registrarse, 2 para Iniciar Sesion");
            seleccion = entrada.nextInt();
        }while (seleccion != 0);
    }
    private static void registrarse() throws IOException {
        Scanner entrada = new Scanner(System.in);
        String nombre, contrasena;

        System.out.println("Ingrese usuario: ");
        nombre = entrada.nextLine();
        System.out.println("Ingrese contrasena: ");
        contrasena = entrada.nextLine();

        ValidadorContrasenaSegura validadorContrasenaSegura = new ValidadorContrasenaSegura();
        List<Boolean> flagsErrores = validadorContrasenaSegura.esContrasenaValida(contrasena, nombre);

        if(noHayErrores(flagsErrores)){
            try {
                RepositorioUsuario repoUsuario = RepositorioUsuario.getInstance();
                repoUsuario.agregarUsuario(new Usuario(nombre,contrasena));
                System.out.println("Contraseña segura. Usuario creado");
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
        else
            printErroresContrasena(flagsErrores);
    }

    private static boolean noHayErrores(List<Boolean> flagsErrores){
        return !flagsErrores.contains(true);
    }
    private static void printErroresContrasena(@NotNull List<Boolean> flagsErrores) {
        if(flagsErrores.get(0)) System.out.println("La contraseña debe tener al menos " + ValidadorContrasenaSegura.minimoCaracteres() + " caracteres");
        if(flagsErrores.get(1)) System.out.println("La contraseña no puede ser igual al nombre de usuario");
        if(flagsErrores.get(2)) System.out.println("La contraseña esta en el top 10000 contraseñas mas inseguras");
        if(flagsErrores.get(3)) System.out.println("La contraseña no puede tener un caracter repetido 3 o mas veces de manera consecutiva");
        if(flagsErrores.get(4)) System.out.println("La contraseña debe tener al menos 1 numero");
        if(flagsErrores.get(5)) System.out.println("La contraseña debe tener al menos 1 mayuscula");
        if(flagsErrores.get(6)) System.out.println("La contraseña debe tener al menos 1 minuscula");
        if(flagsErrores.get(7)) System.out.println("La contraseña debe tener al menos 1 caracter especial");
    }

    private static void login() {
        Scanner entrada = new Scanner(System.in);
        ValidadorLogin validadorLogin = new ValidadorLogin();

        System.out.println("Ingrese usuario: ");
        String nombre = entrada.nextLine();
        System.out.println("Ingrese contrasena: ");
        String contrasena = entrada.nextLine();

        try{
            boolean loginValido = validadorLogin.validarLogin(nombre, contrasena);
            if (loginValido)
                System.out.println("Login exitoso.");
            else
                System.out.println("Error al intentar realizar el Login. Ha sido bloqueado");
        } catch (Exception e) {
                System.out.println(e.getMessage());
        }
    }
    public static void calcularDistancia(){
        DistanciaApiCalls distanciaRestClient = new DistanciaApiCalls();
        try{
            DistanciaResponse distanciaResponse = distanciaRestClient.calcularDistancia();
            System.out.println("Distancia entre las ubicaciones: " + distanciaResponse.getValor() + " " + distanciaResponse.getUnidad());
        }catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void cargaDatosDeActividad  (String path){
        //esta lista deberia ser global?
        List<Actividad> datosDeActividad = new ArrayList<>();

        try{
            FileReader fileReader = new FileReader(path);

            CSVParser parser = new CSVParserBuilder().withSeparator(';').build();

            CSVReader csvReader = new CSVReaderBuilder(fileReader).withCSVParser(parser).build();
            //paso la primera fila porque no me interesa
            csvReader.readNext();
            List<String[]> da = csvReader.readAll();

            for (String[] row : da) {

                Actividad actividad = new Actividad(
                        row[0],
                        row[1],
                        Double.parseDouble(row[2]),
                        row[3],
                        LocalDate.parse(row[4])
                );
                datosDeActividad.add(actividad);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}

