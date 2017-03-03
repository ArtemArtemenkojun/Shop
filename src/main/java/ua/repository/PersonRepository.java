package ua.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.entity.Person;

public interface PersonRepository extends JpaRepository<Person, Integer>{

	Person findByEmail(String email);

}
