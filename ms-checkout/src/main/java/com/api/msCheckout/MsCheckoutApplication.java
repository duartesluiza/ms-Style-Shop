package com.api.msCheckout;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;


@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class MsCheckoutApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsCheckoutApplication.class, args);
	}

}
