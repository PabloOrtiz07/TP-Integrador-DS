package main;

import Dominio.Entidades.*;
import Dominio.Lugares.Espacio;
import Dominio.Lugares.TipoEspacio;
import Dominio.Medicion.Medicion;

import Apis.DistanciaApiCalls;
import Apis.dto.DistanciaResponse;
import Seguridad.RepositorioUsuario;
import Seguridad.Usuario;
import Seguridad.ValidadorContrasenaSegura;
import Seguridad.ValidadorLogin;


import java.time.LocalDate;
import java.io.*;
import java.util.*;
import com.opencsv.*;
import com.opencsv.CSVReader;

public class Main {

    public static void main (String[] args) throws IOException {
        Scanner entrada = new Scanner(System.in);
        int seleccion;
        do{
            System.out.println("Menu inicio: Ingrese el numero de la opcion que quiere realizar");
            System.out.println("0.Salir\n1.Registrar Usuario\n2.Login\n3.Dar organizacion de alta\n4.Dar area de alta en una organizacion\n5.Cargar mediciones");
            //Para probar
            System.out.println("6.Mostrar organizacion existentes");
            seleccion = entrada.nextInt();
            switch (seleccion){
                case 0:
                    System.out.println("Saliendo del programa");
                    break;
                case 1:
                    registrarUsuario();
                    break;
                case 2:
                    login();
                    break;
                case 3:
                    altaOrganizacion();
                    break;
                case 4:
                    altaArea();
                    break;
                case 6:
                    RepositorioOrganizaciones repositorioOrganizaciones = RepositorioOrganizaciones.getInstance();
                    for(Organizacion org:repositorioOrganizaciones.getOrganizaciones()) {
                        System.out.print("Razon social: " + org.getRazonSocial() + ". Areas: ");
                        for (Area area : org.getAreas())
                            System.out.print(area.getNombreArea() + " ");
                        System.out.println();
                    }
                    break;
                default:
                    System.out.println("Operacion invalida");
                    break;
            }
        }while(seleccion != 0);
    }
    private static void registrarUsuario() throws IOException {
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
    private static void printErroresContrasena(List<Boolean> flagsErrores) {
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
    public static void altaOrganizacion(){
        Scanner entrada = new Scanner(System.in);
        System.out.println("Ingresa la razon social de la organizacion");
        String razonSocial = entrada.nextLine();
        System.out.println("Ingresa el tipo de la organizacion");
        //De un string paso al valor del enum. Funciona pero no es muy entendible y se repite mucho siempre lo mismo
        //Habria que ver como poder parametrizarlo
        TipoOrganizacion tipoOrganizacion = TipoOrganizacion.valueOf(entrada.nextLine().toUpperCase().replace(' ', '_'));
        System.out.println("Ingresa el tipo de clasificacion");
        TipoClasificacion tipoClasificacion = TipoClasificacion.valueOf(entrada.nextLine().toUpperCase().replace(' ', '_'));

        System.out.println("Ingresa el pais donde se ubica la organizacion");
        String pais = entrada.nextLine();
        System.out.println("Ingresa la provincia donde se ubica la organizacion");
        String provincia = entrada.nextLine();
        System.out.println("Ingresa la localidad donde se ubica la organizacion");
        String localidad = entrada.nextLine();
        System.out.println("Ingresa el municipio donde se ubica la organizacion");
        String municipio = entrada.nextLine();
        System.out.println("Ingresa la calle donde se ubica la organizacion");
        String calle = entrada.nextLine();
        System.out.println("Ingresa la altura a la que se encuentra la organizacion");
        String altura = entrada.nextLine();

        Espacio espacioOrg = new Espacio(pais,provincia,localidad,municipio,calle,altura, TipoEspacio.TRABAJO);
        Organizacion organizacion = new Organizacion(razonSocial,tipoOrganizacion,tipoClasificacion, espacioOrg);

        System.out.println("Agregue las areas de la organizacion");
        do{
            System.out.println("Ingresa el nombre del area");
            String nombreArea = entrada.nextLine();
            Area area = new Area(nombreArea, organizacion);
            try {
                organizacion.agregarArea(area);
                System.out.println("Area agregada con exito");
            }
            catch (Exception e){
                System.out.println(e.getMessage());
            }
            System.out.println("¿Quiere agregar otra area a la organizacion? (y/n)");
        }while (entrada.nextLine().toLowerCase().equals("y"));

        RepositorioOrganizaciones repositorioOrganizaciones = RepositorioOrganizaciones.getInstance();
        try {
            repositorioOrganizaciones.agregarOrganizacion(organizacion);
            System.out.println("Organizacion creada con exito");
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public static void altaArea() {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Ingresa la organizacion a la que se quiere agregar el area");
        String razonSocial = entrada.nextLine();
        RepositorioOrganizaciones repositorioOrganizaciones = RepositorioOrganizaciones.getInstance();
        Organizacion organizacion = repositorioOrganizaciones.getOrganizacionPorRazonSocial(razonSocial);

        if (organizacion == null) {
            System.out.println("No existe esa organizacion");
        } else {
            System.out.println("Ingresa el nombre del area");
            String nombreArea = entrada.nextLine();
            Area area = new Area(nombreArea, organizacion);
            try {
                organizacion.agregarArea(area);
                System.out.println("Area agregada con exito");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

