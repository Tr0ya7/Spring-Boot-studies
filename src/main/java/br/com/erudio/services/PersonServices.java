package br.com.erudio.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.erudio.data.vo.v1.PersonVO;
import br.com.erudio.data.vo.v2.PersonVOV2;
import br.com.erudio.exceptions.ResourceNotFoundException;
import br.com.erudio.mapper.DozerMapper;
import br.com.erudio.mapper.custom.PersonMapper;
import br.com.erudio.model.Person;
import br.com.erudio.repository.PersonRepository;

@Service	//An object as a Service is insert in run-time in the application
public class PersonServices {
	private Logger logger = Logger.getLogger(PersonServices.class.getName());
	
	@Autowired
	PersonRepository repository;
	
	@Autowired
	PersonMapper personMapper;
	
	public PersonVO create(PersonVO person) {
		logger.info("Create one person!");
		Person entity = DozerMapper.parseObject(person, Person.class);			
		return DozerMapper.parseObject(repository.save(entity), PersonVO.class);	//Send the info in Person object but send to user view a type object PersonVO
	}
	
	public PersonVOV2 createV2(PersonVOV2 person) {
		logger.info("Create one person!");
		Person entity = personMapper.convertVoToEntity(person);
		return personMapper.convertEntityToVo(repository.save(entity));	//Send the info in Person object but send to user view a type object PersonVOV2
	}
	
	public PersonVO update(PersonVO person) {
		logger.info("Updating one person!");
		
		Person entity = repository.findById(person.getId()).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setAddress(person.getAddress());
		entity.setGender(person.getGender());
		
		return DozerMapper.parseObject(entity, PersonVO.class);
	}
	
	public List<PersonVO> findAll() {
		logger.info("Find all people!");
		System.out.print(repository.findAll());
		return DozerMapper.parseListObjects(repository.findAll(), PersonVO.class);
	}
	
	public PersonVO findById(Long id) {
		logger.info("Find one person!");
		return DozerMapper.parseObject(repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID")), PersonVO.class);
	}
	
	public void delete(Long id) {
		logger.info("Deleting...");
		 
		repository.delete(repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID")));
		
	}
}