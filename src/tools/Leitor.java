package tools;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Leitor {
    
    // A chave será usada para separar as informações em cada linha do arquivo
    public static ArrayList<String[]> ler (File file, String key) {
        ArrayList<String[]> info = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new java.io.FileReader(file));
            String line;
            while ((line = br.readLine()) != null) {
                info.add(line.split(key));
            }
            br.close();
            return info;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
