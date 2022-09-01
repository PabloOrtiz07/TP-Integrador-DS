package LectoresArchivo;

import Dominio.Medicion.Medicion;
import Dominio.Medicion.MedicionLogistica;
import Dominio.Medicion.MedicionOtros;
import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import java.io.FileReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class LeerExcel {


    private List<DatoLeidoExcel> datosLeidoExcel = new ArrayList<>();

    public void cargaDatosDeActividad(String path){


        try{
            FileReader fileReader = new FileReader(path);

            CSVParser parser = new CSVParserBuilder().withSeparator(';').build();

            CSVReader csvReader = new CSVReaderBuilder(fileReader).withCSVParser(parser).build();
            //paso la primera fila porque no me interesa
            csvReader.readNext();
            List<String[]> da = csvReader.readAll();

            for (String[] row : da) {
                DatoLeidoExcel datoLeidoExcel = new DatoLeidoExcel(
                        row[0],
                        row[1],
                        Double.parseDouble(row[2]),
                        row[3],
                        row[4]);
                this.datosLeidoExcel.add(datoLeidoExcel);
            }

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public List<MedicionLogistica> cargarMedicionesLogistica(){
      return datosLeidoExcel.stream().filter(datoLeidoExcel -> datoLeidoExcel.getActividad().equals("Logistica de productos y residuos")).map(datoLeidoExcel -> crearMedicionLogistica(datoLeidoExcel)).collect(Collectors.toList());
    }

    public MedicionLogistica crearMedicionLogistica(DatoLeidoExcel datoLeidoExcel){
         MedicionLogistica medicionLogistica = new MedicionLogistica(datoLeidoExcel.getActividad(),datoLeidoExcel.getPeriodoDeImputacion(),datoLeidoExcel.getPerioicidad()); // aca faltaria llenar con los demas datos pero no me doy cuenta
         return  medicionLogistica;
    }

    public List<MedicionOtros> cargarMedicionesOtros(){
        return datosLeidoExcel.stream().filter(datoLeidoExcel -> !datoLeidoExcel.getActividad().equals("Logistica de productos y residuos")).map(datoLeidoExcel -> crearMedicionOtro(datoLeidoExcel)).collect(Collectors.toList());
    }

    public MedicionOtros crearMedicionOtro(DatoLeidoExcel datoLeidoExcel){
        MedicionOtros medicionOtros = new MedicionOtros(datoLeidoExcel.getActividad(),datoLeidoExcel.getPeriodoDeImputacion(),datoLeidoExcel.getPerioicidad(),datoLeidoExcel.getTipoDeConsumo(),datoLeidoExcel.getConsumo()); // aca faltaria llenar con los demas datos pero no me doy cuenta
        return  medicionOtros;
    }

}