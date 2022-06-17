package LectoresArchivo;

import Dominio.Medicion.Medicion;
import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;


//TODO: no son interfaces, son clases cambiar eso en el modelo
public class LectorArchivo {
    public Boolean estaEnArchivo(String busqueda, String nombreArchivo) throws IOException {
        URL url = getClass().getClassLoader().getResource(nombreArchivo);
        File file = new File(url.getPath());
        Scanner scanner = new Scanner(file);
        while(scanner.hasNextLine()){
            String linea = scanner.nextLine();
            if(busqueda.equals(linea)){
                return true;
            }
        }
        return false;
    }

    public void cargaDaatosDeActividad(String path, List<Medicion> datosDeActividad){

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
                datosDeActividad.add(medicion);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
