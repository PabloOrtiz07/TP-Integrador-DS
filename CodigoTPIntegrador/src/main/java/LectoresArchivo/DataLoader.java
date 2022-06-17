package LectoresArchivo;

import Dominio.Medicion.Medicion;
import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class DataLoader {
    public List<Medicion> cargaDatosDeActividad(String path){
        List<Medicion> mediciones = new ArrayList<>();
        try{
            FileReader fileReader = new FileReader(path);

            CSVParser parser = new CSVParserBuilder().withSeparator(';').build();

            CSVReader csvReader = new CSVReaderBuilder(fileReader).withCSVParser(parser).build();
            //paso la primera fila porque no me interesa
            csvReader.readNext();
            List<String[]> da = csvReader.readAll();

            for (String[] row : da) {

                Medicion medicion = new Medicion(
                        row[0],
                        row[1],
                        Double.parseDouble(row[2]),
                        row[3],
                        row[4]
                );
                mediciones.add(medicion);
            }

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return mediciones;
    }
}
