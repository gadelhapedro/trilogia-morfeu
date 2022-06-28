package tools;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

public class Loader {

    public static ArrayList<File> load(File file) {
        if (!file.isDirectory()){
            return null;
        }
        ArrayList<File> files = new ArrayList<>();
        files.addAll(Arrays.asList(file.listFiles()));
        return files;
    }
}
