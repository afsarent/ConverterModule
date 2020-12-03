package co.entrar.exam.ConverterModule.service;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.util.stream.Stream;
public interface StorageService {

    void init() throws Exception;

    String store(MultipartFile file) throws Exception;

    Stream<Path> loadAll() throws Exception;

    Path load(String filename);

    Resource loadAsResource(String filename) throws FileNotFoundException;

    void deleteAll();

}
