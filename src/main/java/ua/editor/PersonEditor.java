package ua.editor;

import java.beans.PropertyEditorSupport;

import ua.entity.Person;
import ua.service.PersonService;


public class PersonEditor extends PropertyEditorSupport{

	private final PersonService personService;

	public PersonEditor(PersonService personService) {
		this.personService = personService;
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		Person person = personService.findOne(Integer.valueOf(text));
		setValue(person);
	}
}
