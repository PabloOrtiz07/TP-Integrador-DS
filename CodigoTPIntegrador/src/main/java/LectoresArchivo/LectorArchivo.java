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

}
