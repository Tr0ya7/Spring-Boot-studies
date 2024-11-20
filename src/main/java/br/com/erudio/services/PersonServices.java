package br.com.erudio.services;

import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import br.com.erudio.model.Person;

@Service	//An object as a Service is incert in run-time in the application
public class PersonServices {
	private final AtomicLong counter = new AtomicLong();
	private Logger logger = Logger.getLogger(PersonServices.class.getName());
	
	public Person findById(String id) {
		logger.info("Find one person!");
		
		Person person = new Person();
		person.setId(counter.getAndIncrement());
		person.setFirstName("luiz");
		person.setLastName("Barros");
		person.setAddress("Dois Córregos - São Paulo");
		person.setGender("Male");
		
		return person;
	}
}