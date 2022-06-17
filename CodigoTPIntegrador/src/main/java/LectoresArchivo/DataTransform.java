package LectoresArchivo;

import Dominio.Medicion.Medicion;

import java.time.LocalDate;

public class DataTransform {

    public LocalDate transformoFecha(String Periodicidad, String Periodo){
        LocalDate fecha = LocalDate.of(2017,1,13);
        if(Periodicidad.equals("Anual")){

        }
        return fecha;
    }
    public Medicion crearMedicion(DatoLeido datoLeido) {

        Medicion medicion = new Medicion(
                datoLeido.getTipoDeActividad(),
                datoLeido.getTipoDeConsumo(),
                Double.parseDouble(datoLeido.getValor()),
                datoLeido.getPeriodicidad(),
                transformoFecha(datoLeido.getPeriodicidad(),datoLeido.getPeriodo())
        );

        return medicion;
    }
}
