package Dominio.Lugares;

public class Parada extends Ubicacion{

    protected String pais;
    protected String provincia;
    protected String localidad;
    protected String municipio;
    protected String calle;
    protected String altura;
    private double distanciaSiguiente;
    private double distanciaAnterior;

    public Parada(String pais, String provincia, String localidad,String municipio, String calle, String altura, double distanciaSiguiente) {
        super(pais,provincia,localidad,municipio,calle,altura);
        this.distanciaAnterior = distanciaAnterior;
    }

    public double getDistanciaSiguiente() {
        return distanciaSiguiente;
    }
    public void setDistanciaAnterior(double distanciaAnterior) {
        this.distanciaAnterior = distanciaAnterior;
    }

}
