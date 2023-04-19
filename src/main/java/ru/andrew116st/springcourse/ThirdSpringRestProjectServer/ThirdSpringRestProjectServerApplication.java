package ru.andrew116st.springcourse.ThirdSpringRestProjectServer;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ThirdSpringRestProjectServerApplication {

	public static void main(String[] args) {

		SpringApplication.run(ThirdSpringRestProjectServerApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

}