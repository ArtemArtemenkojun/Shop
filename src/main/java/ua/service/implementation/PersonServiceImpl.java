package ua.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import ua.entity.Person;
import ua.repository.PersonRepository;
import ua.service.PersonService;

@Service
public class PersonServiceImpl implements PersonService{
	@Autowired
	private PersonRepository personRepository;
	
	public List<Person> findAll() {
		return personRepository.findAll();
	}

	public void delete(int id) {
		personRepository.delete(id);
	}

	public Person findOne(int id) {
		return personRepository.findOne(id);
	}

	public void save(Person person) {
		personRepository.save(person);
	}

	@Override
	public Page<Person> findAll(Pageable pageable) {
		
		return personRepository.findAll(pageable);
	}

	@Override
	public Person findByEmail(String email) {
	
		return personRepository.findByEmail(email);
	}
	
	

}
