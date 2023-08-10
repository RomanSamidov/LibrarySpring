package my.project.library;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching

public class LibrarySpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibrarySpringApplication.class, args);
	}

}
