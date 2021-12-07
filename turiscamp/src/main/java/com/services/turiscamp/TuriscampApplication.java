package com.services.turiscamp;

import static com.services.turiscamp.constant.FileConstant.USER_FOLDER;

import java.io.File;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@SpringBootApplication
public class TuriscampApplication {

	public static void main(String[] args) {
		SpringApplication.run(TuriscampApplication.class, args);
		new File(USER_FOLDER).mkdirs();
	}
	
	@Bean
		public BCryptPasswordEncoder bCryptPasswordEncoder() {
			return new BCryptPasswordEncoder();
	}

}
