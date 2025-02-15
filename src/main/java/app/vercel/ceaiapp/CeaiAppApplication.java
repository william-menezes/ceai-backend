package app.vercel.ceaiapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.TimeZone;

@SpringBootApplication
public class CeaiAppApplication {

	public static void main(String[] args) {

		TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
		SpringApplication.run(CeaiAppApplication.class, args);
	}

}
