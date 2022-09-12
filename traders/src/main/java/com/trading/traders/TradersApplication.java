package com.trading.traders;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class TradersApplication {

	public static void main(String[] args) {
		SpringApplication.run(TradersApplication.class, args);
	}

}
