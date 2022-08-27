package main;

import Apis.DistanciaApiCalls;
import Apis.dto.DistanciaResponse;
import Dominio.Entidades.*;
import Dominio.Lugares.*;

import Dominio.Transportes.*;
import Dominio.Viajes.Tramo;
import Dominio.Viajes.Trayecto;
import EnvioNotifiaciones.Scheduler;
import LectoresArchivo.LecturaFactor;
import Seguridad.RepositorioUsuario;
import Seguridad.Usuario;
import Seguridad.ValidadorContrasenaSegura;



import java.io.*;
import java.util.*;


public class Main {

    public static void main (String[] args) throws Exception {
        LecturaFactor lecturaFactor = new LecturaFactor();
        lecturaFactor.leerFactorK();
        Scheduler scheduler = new Scheduler();
        scheduler.comenzar();
        Scanner entrada = new Scanner(System.in);
        int seleccion;
        do{
            System.out.println("Menu inicio: Ingrese el numero de la opcion que quiere realizar");
            System.out.println("0.Salir\n1.Registrar Usuario\n2.Login\n3.Dar organizacion de alta\n4.Dar transporte publico de alta");
            System.out.println("5.Mostrar organizacion existentes");
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
                    altaTransportePublico();
                    break;
                case 5:
                    vincularMiembroConOrganizacion();
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

        System.out.println("Ingrese los datos del miembro al que pertenece el usuario:");
        Miembro miembro = cargarDatosMiembro();

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

        System.out.println("Ingrese usuario: ");
        String nombre = entrada.nextLine();
        System.out.println("Ingrese contrasena: ");
        String contrasena = entrada.nextLine();

        RepositorioUsuario repoUsuario = RepositorioUsuario.getInstance();
        try{
            Usuario usuarioEnRepo = repoUsuario.getUsuarioPorNombre(nombre);
            boolean loginValido = usuarioEnRepo.validarContrasenaCorrecta(contrasena);
            if (loginValido) {
                System.out.println("Login exitoso.");
                usuarioEnRepo.reiniciarIntentosFallidos();
                mostrarOperacionesTrasLogin(usuarioEnRepo);
            }
            else {
                System.out.println("Error al intentar realizar el Login. Ha sido bloqueado");
                usuarioEnRepo.bloquear();
            }
        }
        catch (NoSuchElementException e){
            System.out.println("No existe ese usuario");
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    private static void mostrarOperacionesTrasLogin(Usuario usuario){
        Scanner entrada = new Scanner(System.in);
        Miembro miembro = usuario.getMiembroAsociado();
        System.out.println("Bienvenido: " + miembro.getDatosPersonales());
        System.out.println("Menu inicio: Ingrese el numero de la opcion que quiere realizar");
        System.out.println("1.Solicitar vinculacion a organizacion, 2.Cargar Trayecto, 3.Ejecutar Calculadora");
        int seleccion = entrada.nextInt();

    }

    public static void altaOrganizacion() throws Exception {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Ingresa la razon social de la organizacion");
        String razonSocial = entrada.nextLine();
        System.out.println("Ingresa el tipo de la organizacion");
        //De un string paso al valor del enum. Funciona pero no es muy entendible y se repite mucho siempre lo mismo
        //Habria que ver como poder parametrizarlo
        TipoOrganizacion tipoOrganizacion = TipoOrganizacion.valueOf(entrada.nextLine().toUpperCase().replace(' ', '_'));
        System.out.println("Ingresa el tipo de clasificacion");
        TipoClasificacion tipoClasificacion = TipoClasificacion.valueOf(entrada.nextLine().toUpperCase().replace(' ', '_'));

        String[] datosUbicacion = cargarDatosUbicacion();

        Espacio espacioOrg = new Espacio(datosUbicacion[0],datosUbicacion[1],datosUbicacion[2],datosUbicacion[3],datosUbicacion[4],datosUbicacion[5], TipoEspacio.TRABAJO);
        Organizacion organizacion = new Organizacion(razonSocial,tipoOrganizacion,tipoClasificacion, espacioOrg);

        System.out.println("Agregue las areas de la organizacion");
        do{
            System.out.println("Ingresa el nombre del area");
            String nombreArea = entrada.nextLine();
            Area area = new Area(nombreArea);
            try {
                organizacion.agregarArea(area);
                System.out.println("Area agregada con exito");
            }
            catch (Exception e){
                System.out.println(e.getMessage());
            }
            System.out.println("¿Quiere agregar otra area a la organizacion? (y/n)");
        }while (entrada.nextLine().equalsIgnoreCase("y"));

        RepositorioOrganizaciones repositorioOrganizaciones = RepositorioOrganizaciones.getInstance();
        try {
            repositorioOrganizaciones.agregarOrganizacion(organizacion);
            System.out.println("Organizacion creada con exito");
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static void vincularMiembroConOrganizacion() throws Exception {
        Scanner entrada = new Scanner(System.in);
        Miembro miembro = cargarDatosMiembro();
        System.out.println("Ingrese la organizacion:");
        String razonSocial = entrada.nextLine();
        System.out.println("Ingrese el area:");
        String nombreArea = entrada.nextLine();
        Organizacion organizacion = RepositorioOrganizaciones.getInstance().getOrganizacionPorRazonSocial(razonSocial);

        System.out.println("Solicitud de aceptacion enviada");
        miembro.enviarSolicitud(organizacion, nombreArea);

        System.out.println("Solicitud de aceptacion aceptada");
        organizacion.aceptarSolicitud(miembro);
    }

    public static void altaTransportePublico(){
        Scanner entrada = new Scanner(System.in);
        System.out.println("Ingresa el tipo de transporte publico:");
        TipoDeTransportePublico tipoTransporte = TipoDeTransportePublico.valueOf(entrada.nextLine().toUpperCase());

        System.out.println("Ingresa la linea del transporte");
        String linea = entrada.nextLine();

        TransportePublico transporte = new TransportePublico(tipoTransporte,linea);

        System.out.println("Agregue las paradas de la linea");
        do{
            String[] datosUbicacion = cargarDatosUbicacion();
            System.out.println("Agregue la distancia a la proxima parada");
            double distanciaSig = entrada.nextDouble();
            Parada parada = new Parada(datosUbicacion[0],datosUbicacion[1],datosUbicacion[2],datosUbicacion[3],datosUbicacion[4],datosUbicacion[5],distanciaSig);
            transporte.agregarParada(parada);
            System.out.println("¿Quiere agregar otra parada? (y/n)");
        }while(entrada.nextLine().equalsIgnoreCase("y"));

        RepoTransportePublico repoTransportePublico = RepoTransportePublico.getInstance();
        try {
            repoTransportePublico.agregarTransportePublico(transporte);
            System.out.println("Transporte agregado con exito");
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    private static String[] cargarDatosUbicacion(){
        Scanner entrada = new Scanner(System.in);
        String[] datosUbicacion = new String[6];
        System.out.println("Datos de la direccion: ");
        System.out.println("Ingresa el pais:" );
        datosUbicacion[0] = entrada.nextLine();
        System.out.println("Ingresa la provincia:");
        datosUbicacion[1] = entrada.nextLine();
        System.out.println("Ingresa la localidad:");
        datosUbicacion[2] = entrada.nextLine();
        System.out.println("Ingresa el municipio:");
        datosUbicacion[3] = entrada.nextLine();
        System.out.println("Ingresa la calle:");
        datosUbicacion[4] = entrada.nextLine();
        System.out.println("Ingresa la altura:");
        datosUbicacion[5] = entrada.nextLine();

        return datosUbicacion;
    }

    private static Miembro cargarDatosMiembro(){
        Scanner entrada = new Scanner(System.in);
        System.out.println("Ingrese el nombre del miembro: ");
        String nombre = entrada.nextLine();
        System.out.println("Ingrese el apellido del miembro: ");
        String apellido = entrada.nextLine();
        System.out.println("Ingrese el tipo de documento del miembro: ");
        TipoDocumento tipoDocumento  = TipoDocumento.valueOf(entrada.nextLine().toUpperCase().replace(' ', '_'));
        System.out.println("Ingrese el numero de documento: ");
        String numeroDocumento = entrada.nextLine();
        Persona persona = new Persona(nombre, apellido, numeroDocumento, tipoDocumento);
        return new Miembro(persona);
    }

}



