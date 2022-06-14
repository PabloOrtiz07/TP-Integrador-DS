package Seguridad;


import java.time.LocalTime;

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

    public boolean contrasenaCorrecta(String contrasenaIngresada){
        return this.contrasena.equals(contrasenaIngresada);
    }

    public void loginExitoso(){
        this.cantidadIntentosFallidos = 0;
    }

}
