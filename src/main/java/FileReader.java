import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileReader {

    public String convertFile(String filePath) {
        byte[] encoded = new byte[0];
        try {
            encoded = Files.readAllBytes(Paths.get(filePath));
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        return new String(encoded);
    }
}
