package ua.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ua.entity.Person;

public interface PersonService {
	
	List<Person>findAll();
	
	void delete (int id);
	
	Person findOne(int id);
	
	void save(Person person);
	
	Page<Person> findAll(Pageable pageable);

	Person findByEmail(String email);

}
