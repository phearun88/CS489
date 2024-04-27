package phearun.thds_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
//@RestController
public class ThdsBackendApplication {

//	@GetMapping("/message")
//	public String message(){
//		return "Congrats to my app deployed successfully";
//	}
	public static void main(String[] args) {
		SpringApplication.run(ThdsBackendApplication.class, args);
	}

}
