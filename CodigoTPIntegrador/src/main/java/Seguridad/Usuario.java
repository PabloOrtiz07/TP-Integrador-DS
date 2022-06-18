package Seguridad;


import java.time.LocalTime;

import static java.lang.Math.pow;

public class Usuario {

    private final String nombre;
    private final String contrasena;
    private int cantidadIntentosFallidos = 0;
    private LocalTime horaDesbloqueo;
    public String getNombre() {
        return nombre;
    }
    public Usuario(String name, String contrasena){
        this.nombre = name;
        this.contrasena = contrasena;
    }
    public LocalTime getHoraDesbloqueo(){
        return this.horaDesbloqueo;
    }
    public void bloquearHasta(LocalTime horaDesbloqueo) {
        this.horaDesbloqueo = horaDesbloqueo;
    }

    public int getCantidadIntentosFallidos() {
        return cantidadIntentosFallidos;
    }

    public void agregarIntentoFallido() {
        this.cantidadIntentosFallidos++;
    }

    public boolean estaBloqueado(){
        return horaDesbloqueo!= null && LocalTime.now().isBefore(horaDesbloqueo);
    }

    public boolean validarContrasenaCorrecta(String contrasena) throws Exception{
        if(this.estaBloqueado())
            throw new Exception("Esta bloqueado hasta las" + this.getHoraDesbloqueo());
        return this.contrasena.equals(contrasena);
    }

    public void reiniciarIntentosFallidos(){
        this.cantidadIntentosFallidos = 0;
    }

    public void bloquearusuario(){
        this.horaDesbloqueo = LocalTime.now().plusSeconds((long) this.calcularSegundosBloqueo());
    }

    private double calcularSegundosBloqueo(){
       return (pow(2.0,this.cantidadIntentosFallidos) - 1)/2;
    }

}
