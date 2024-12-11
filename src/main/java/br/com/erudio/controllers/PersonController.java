package br.com.erudio.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.erudio.data.vo.v1.PersonVO;
import br.com.erudio.data.vo.v2.PersonVOV2;
import br.com.erudio.services.PersonServices;
import br.com.erudio.util.MediaType;

@RestController
@RequestMapping("/person/v1")
public class PersonController {
	@Autowired	//For this annotation is required the annotation @Service in the class called	//Use this annotation instead initialize a new object
	private PersonServices personService;
	
	@GetMapping(produces = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML })
	public List<PersonVO> findAll() {
		return personService.findAll();
	};
	
	@GetMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML })
	public PersonVO findById(@PathVariable(value = "id") Long id) {
		return personService.findById(id);
	};
	
	@PostMapping(consumes = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML }, produces = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML })
	public PersonVO create(@RequestBody PersonVO person) {	//This annotation is for get the send body of request
		return personService.create(person);
	};
	
	@PostMapping(value = "/v2", consumes = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML }, produces = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML })
	public PersonVOV2 createV2(@RequestBody PersonVOV2 person) {	//This annotation is for get the send body of request
		return personService.createV2(person);
	};
	
	@PutMapping(consumes = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML }, produces = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML })
	public PersonVO update(@RequestBody PersonVO person) {
		return personService.update(person);
	};
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
		personService.delete(id);
		return ResponseEntity.noContent().build();	//Show for the user the correct response with a correct status code (204 instead 200)
	};
}