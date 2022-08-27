package LectoresArchivo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class LecturaFactor {

    public LecturaFactor() {
    }
    public void leerFactorK(){
        try {

            InputStream inputStream = new FileInputStream("src/main/resources/configuracionConstante.properties");

            Properties properties = new Properties();
            properties.load(inputStream);
            System.out.println(properties.getProperty("constanteK"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
