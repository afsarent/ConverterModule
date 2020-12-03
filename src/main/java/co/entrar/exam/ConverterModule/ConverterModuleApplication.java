package co.entrar.exam.ConverterModule;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ConverterModuleApplication {
	public static final String rootPath = "/home/entrarcodes";
	public static void main(String[] args) {
		SpringApplication.run(ConverterModuleApplication.class, args);
		
		//Not working 
		/*try {
			initializeRoot();
		} catch (IOException e) {
			System.out.println("Could not created root dir : "+e.toString());
			e.printStackTrace();
		}*/
	}

	private static void initializeRoot() throws IOException {
		File dir = new File(rootPath);
		if(!dir.exists()) {
			System.out.println("Creating directory");
			Path path = Paths.get(rootPath);
			Files.createDirectories(path);
			System.out.println("Directory is created!");
		}
		
		
	}
}
