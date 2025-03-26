import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileCreator {

    public static void createSampleFile(String directory, String fileName, String content) {
        File dir = new File(directory);
        if(!dir.exists()){
            dir.mkdirs();
        }
        File file = new File(directory, fileName);
        if(file.exists()){
            System.out.println("Error file already exists-" +fileName);
            return;
        }
        try (FileWriter writer = new FileWriter(file)) {
            writer.write(content);
            System.out.println("File created: " + file.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
