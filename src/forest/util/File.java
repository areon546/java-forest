package forest.util;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class File {
    private static final String path = "forest-data/";

    //
    public static void NewFile(String filename) {
        java.io.File a = new java.io.File(path+filename);
        try {
            a.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // writeFile overwrites the contents of File.path+filename.
    public static void writeFile(String filename, String[] cntn) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(path + filename));

            for (String line : cntn) {
                bw.write(line+"\n");
            }

            bw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
