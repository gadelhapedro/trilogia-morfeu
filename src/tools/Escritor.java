package tools;

import java.io.FileWriter;
import java.io.IOException;

public class Escritor {

    public static void escrever(String texto, String nomeArquivo, String extensao, String path) {
        try {
            FileWriter writer = new FileWriter(path + nomeArquivo + "." + extensao);
            writer.write(texto);
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
