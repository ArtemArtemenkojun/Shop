package ua.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.entity.Person;
import ua.service.PersonService;

public class PersonValidator implements Validator{

private final PersonService personService;
	
	public PersonValidator(PersonService personService) {
		this.personService = personService;
	}

	public boolean supports(Class<?> clazz) {
		return Person.class.equals(clazz);
	}

	public void validate(Object target, Errors errors) {
		Person person = (Person) target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "", "Can't be empty");
		if(personService.findByEmail(person.getEmail())!=null){
			errors.rejectValue("email", "", "Already exist");
		}
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "role", "", "Can't be empty");
	}

}
