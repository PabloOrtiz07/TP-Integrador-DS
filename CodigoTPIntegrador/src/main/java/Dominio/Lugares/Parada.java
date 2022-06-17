package Dominio.Lugares;

public class Parada extends Ubicacion{
    private int distanciaSiguiente;
    private int distanciaAnterior;
    public Parada(String pais, String provincia, String localidad, String municipio, String calle, String altura, int distanciaSiguiente) {
        super(pais, provincia, localidad, municipio, calle, altura);
        this.distanciaSiguiente = distanciaSiguiente;
    }

    public int getDistanciaSiguiente() {
        return distanciaSiguiente;
    }
    public void setDistanciaAnterior(int distanciaAnterior) {
        this.distanciaAnterior = distanciaAnterior;
    }

}
