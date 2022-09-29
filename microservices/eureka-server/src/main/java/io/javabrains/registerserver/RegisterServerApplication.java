package io.javabrains.registerserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class RegisterServerApplication {

	public static void main(String[] args) {
		System.setProperty("proxyHost", "infra");
		System.setProperty("proxyPort", "8761");
		SpringApplication.run(RegisterServerApplication.class, args);
	}

}
