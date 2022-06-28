package tools;

import java.io.File;
import java.util.ArrayList;

public class Validation {
    
    public static boolean checkFile(File file) {
        ArrayList<File> files = Loader.load(file);
        for (File f : files) {
            if (!f.exists() || f.isDirectory()) {
                return false;
            }
            if(!checkFormat(f)){
                return false;
            }
        }
        return true;
    }

    public static boolean checkFormat(File file) {
        ArrayList<String[]> info = Leitor.ler(file, ";");
        if (info.size() == 0) {
            return false;
        }
        if (info.get(0).length > 1) {
            return false;
        }
        return info.get(1).length == 49;
    }

}
