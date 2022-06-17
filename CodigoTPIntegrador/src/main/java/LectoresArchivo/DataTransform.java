package LectoresArchivo;

import Dominio.Medicion.Medicion;

import java.time.LocalDate;

public class DataTransform {

    public LocalDate transformoFecha(String Periodicidad, String Periodo){

        if(Periodicidad.equals("Anual")){

        }

    }
    public Medicion crearMedicion(DatoLeido datoLeido) {

        Medicion medicion = new Medicion(
                datoLeido.getTipoDeActividad(),
                datoLeido.getTipoDeConsumo(),
                datoLeido.getValor(),
                datoLeido.getPeriodicidad(),
                transformoFecha(datoLeido.getPeriodicidad(),datoLeido.getPeriodo())
        );

        return medicion;
    }
}
