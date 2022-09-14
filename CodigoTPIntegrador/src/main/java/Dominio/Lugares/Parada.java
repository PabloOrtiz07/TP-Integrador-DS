package Dominio.Lugares;

public class Parada extends Ubicacion {

    protected String pais;
    protected String provincia;
    protected String localidad;
    protected String municipio;
    protected String calle;
    protected String altura;
    private Parada paradaSiguiente = null;
    private Parada paradaAnterior = null;
    private double distanciaSiguiente;
    private double distanciaAnterior;

    public Parada(String pais, String provincia, Integer localidad, String municipio, String calle, String altura, double distanciaSiguiente) {
        super(pais, provincia, localidad, municipio, calle, altura);
        this.distanciaSiguiente = distanciaSiguiente;
    }

    public Parada getParadaSiguiente() {
        return paradaSiguiente;
    }

    public void setParadaSiguiente(Parada paradaSiguiente) {
        this.paradaSiguiente = paradaSiguiente;
    }

    public Parada getParadaAnterior() {
        return paradaAnterior;
    }

    public void setParadaAnterior(Parada paradaAnterior) {
        this.paradaAnterior = paradaAnterior;
    }

    public double getDistanciaSiguiente() {
        return distanciaSiguiente;
    }

    public void setDistanciaSiguiente(double distanciaSiguiente) {
        this.distanciaSiguiente = distanciaSiguiente;
    }

    public double getDistanciaAnterior() {
        return distanciaAnterior;
    }

    public void setDistanciaAnterior(double distanciaAnterior) {
        this.distanciaAnterior = distanciaAnterior;
    }
}

