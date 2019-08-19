package com.example.demo;

import java.util.stream.LongStream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.model.Contact;
import com.example.demo.repository.ContactRepository;

@SpringBootApplication
public class Lean1Application {

	public static void main(String[] args) {
		SpringApplication.run(Lean1Application.class, args);
	}
	@Bean
	CommandLineRunner init(ContactRepository repository)
	{
		return args -> {
			repository.deleteAll();
			LongStream.range(1, 11).mapToObj(i ->{
				Contact c = new Contact();
			c.setName("contact"+i);
			c.setEmail("contact"+i+"@gmail.com");
			c.setPhone("(111) 111-1111");
			return c;
			})
			.map(v -> repository.save(v))
			.forEach(System.out::println);
		};
	}
	
}
