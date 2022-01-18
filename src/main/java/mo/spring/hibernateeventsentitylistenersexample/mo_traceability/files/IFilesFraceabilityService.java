package mo.spring.hibernateeventsentitylistenersexample.mo_traceability.files;

import java.nio.file.Path;

public interface IFilesFraceabilityService {
    void write(Path filePath, String data);
}
