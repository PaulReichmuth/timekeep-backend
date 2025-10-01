package de.pnreichmuth.timekeep_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class TimekeepBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(TimekeepBackendApplication.class, args);
	}
}
