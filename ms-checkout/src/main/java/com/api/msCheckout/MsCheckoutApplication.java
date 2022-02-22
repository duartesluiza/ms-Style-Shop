package com.api.msCheckout;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@RestController
public class MsCheckoutApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsCheckoutApplication.class, args);
	}

	@GetMapping("/")
	public String index(){
		return "Olá mundão, tô no ar!";
	}

}
