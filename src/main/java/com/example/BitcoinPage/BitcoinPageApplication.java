package com.example.BitcoinPage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class BitcoinPageApplication {

	public static void main(String[] args) {
		SpringApplication.run(BitcoinPageApplication.class, args);
	}

	@RequestMapping("/")
	public String index() {
		return "This is the frontpage";
	}

	@GetMapping("/hello")
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
		return String.format("Hello %s!", name);
	}

	@GetMapping("/bitcoinpage")
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
		return "This is the bitcoin page. This will be the home of various relevant information of bitcoin";
	}

}
