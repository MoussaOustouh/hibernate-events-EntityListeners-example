package mo.spring.hibernateeventsentitylistenersexample.mo_traceability.files;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

@Service
public class FilesFraceabilityService implements IFilesFraceabilityService{


    public FilesFraceabilityService() {
    }

    public static void writeInFile(Path filePath, String data) {
        try {
            if(!Files.exists(filePath)){
                Files.createFile(filePath);
            }

            Files.write(filePath, data.getBytes(StandardCharsets.UTF_8), StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void write(Path filePath, String data) {
        try {
            if(Files.notExists(filePath)){
                if(Files.notExists(filePath.getParent())){
                    Files.createDirectory(filePath.getParent());
                }
                Files.createFile(filePath);
            }

            Files.write(filePath, data.getBytes(StandardCharsets.UTF_8), StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
