package Dominio.Entidades;

public class Contacto{
    private String email;
    private String telefono;

    private Boolean notificacionPorEmail;

    private  Boolean notificacionPorWhatsapp;

    public Contacto(String email, String telefono, Boolean notificacionPorEmail, Boolean notificacionPorWhatsapp) {
        this.email = email;
        this.telefono = telefono;
        this.notificacionPorEmail = notificacionPorEmail;
        this.notificacionPorWhatsapp = notificacionPorWhatsapp;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Boolean getNotificacionPorEmail() {
        return notificacionPorEmail;
    }

    public void setNotificacionPorEmail(Boolean notificacionPorEmail) {
        this.notificacionPorEmail = notificacionPorEmail;
    }

    public Boolean getNotificacionPorWhatsapp() {
        return notificacionPorWhatsapp;
    }

    public void setNotificacionPorWhatsapp(Boolean notificacionPorWhatsapp) {
        this.notificacionPorWhatsapp = notificacionPorWhatsapp;
    }
}
