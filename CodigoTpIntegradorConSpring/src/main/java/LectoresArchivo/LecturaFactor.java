package LectoresArchivo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class LecturaFactor {

    public LecturaFactor() {
    }

    public Double leerFactorK() {
        try {

            InputStream inputStream = new FileInputStream("src/main/resources/configuracionConstante.properties");

            Properties properties = new Properties();
            properties.load(inputStream);
            Double valorDeLaConstante = Double.valueOf(properties.getProperty("constanteK"));
            return valorDeLaConstante;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}