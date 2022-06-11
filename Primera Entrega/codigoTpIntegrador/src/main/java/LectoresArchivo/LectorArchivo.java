package LectoresArchivo;

import java.io.File;
import java.io.IOException;
import java.net.URL;
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
