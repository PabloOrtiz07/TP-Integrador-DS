package Seguridad;


import Dominio.Entidades.Miembro;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.pow;

public class Usuario {

    private boolean esAdministrador;
    private final String nombre;
    private final String contrasena;

    private Miembro miembroAsociado;
    private int cantidadIntentosFallidos = 0;
    private LocalTime horaDesbloqueo;

    public String getNombre() {
        return nombre;
    }
    public Usuario(String nombre, String contrasena){
        this.nombre = nombre;
        this.contrasena = contrasena;
    }

    public void setMiembroAsociado(Miembro miembroAsociado){this.miembroAsociado = miembroAsociado;}
    public Miembro getMiembroAsociado() {
        return miembroAsociado;
    }

    public boolean validarContrasenaCorrecta(String contrasena) throws Exception{
        if(this.estaBloqueado())
            throw new Exception("Esta bloqueado hasta las" + this.getHoraDesbloqueo());
        return this.contrasena.equals(contrasena);
    }

    public void reiniciarIntentosFallidos(){
        this.cantidadIntentosFallidos = 0;
    }

    public void bloquear(){
        this.horaDesbloqueo = LocalTime.now().plusSeconds((long) this.calcularSegundosBloqueo());
        this.cantidadIntentosFallidos++;
    }
    public LocalTime getHoraDesbloqueo(){
        return this.horaDesbloqueo;
    }

    public boolean estaBloqueado(){
        return horaDesbloqueo!= null && LocalTime.now().isBefore(horaDesbloqueo);
    }

    private double calcularSegundosBloqueo(){
       return (pow(2.0,this.cantidadIntentosFallidos) - 1)/2;
    }



}
