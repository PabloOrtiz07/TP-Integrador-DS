package Dominio.Lugares;

public class Parada extends Ubicacion{
    private int distanciaSiguiente;
    private int distanciaAnterior;
    public Parada(String[] datosUbicacion, int distanciaSiguiente) {
        super(datosUbicacion);
        this.distanciaSiguiente = distanciaSiguiente;
    }

    public int getDistanciaSiguiente() {
        return distanciaSiguiente;
    }
    public void setDistanciaAnterior(int distanciaAnterior) {
        this.distanciaAnterior = distanciaAnterior;
    }

}
