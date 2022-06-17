package LectoresArchivo;

import Dominio.Medicion.Medicion;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DataTransform {

    public LocalDate transformoFecha(String periodicidad, String periodo){

        if(periodicidad.equals("Anual")) {
            DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy");
            LocalDate fecha = LocalDate.parse(periodo, formato);
            return fecha;
        }
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("MM-yyyy");
        LocalDate fecha = LocalDate.parse(periodo, formato);
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
