package Dominio.Entidades;

public class Reporganizaciones {
    private Organizacion [] organizacions;

    //como este metodo es privado y no tengo acceso, se puede instanciar por unica vez
    private Reporganizaciones(){

    }

    public Organizacion[] getOrganizacions() {
        return organizacions;
    }

    public void setOrganizacions(Organizacion[] organizacions) {
        this.organizacions = organizacions;
    }



}
