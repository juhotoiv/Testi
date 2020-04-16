package com.juho.testi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;

import com.juho.testi.domain.*;

@SpringBootApplication
public class TestiApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestiApplication.class, args);
	}
	
	
	// POISTA MYÖHEMMIN KAIKKI TÄMÄN JÄLKEEN
	// Loggeri
	private static final Logger log = LoggerFactory.getLogger(TestiApplication.class);
	
	// Esimerkkikysymysten poisto ja lisääminen tietokantaan
	@Bean
	public CommandLineRunner questionDemo(RadioRepository rqRepository) {
		return (args) -> {
			
			log.info("delete old test data");
			rqRepository.deleteAll();
			log.info("save demo radio questions to db");
			rqRepository.save(new Radio("Mitä kuuluu?"));
			rqRepository.save(new Radio("Miten menee?"));
			rqRepository.save(new Radio("Moi?"));
		};
	}
	
	

}
