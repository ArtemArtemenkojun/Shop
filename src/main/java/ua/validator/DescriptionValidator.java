package ua.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.entity.Description;
import ua.service.DescriptionService;

public class DescriptionValidator implements Validator{
	
	private final DescriptionService descriptionService;
	
	public DescriptionValidator(DescriptionService descriptionService) {
        this.descriptionService = descriptionService;
    }
	
	public boolean supports(Class<?> clazz) {
        return Description.class.equals(clazz);
    }

	public void validate(Object target, Errors errors) {
		Description description = (Description) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "size", "", "enter size please!");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "color", "", "enter color please!");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "material", "", "enter material please!");
		if(descriptionService.findBySize(description.getSize()) !=null && descriptionService.findByColor(description.getColor())!=null 
				&& descriptionService.findByMaterial(description.getMaterial())!=null){
			errors.rejectValue("color","","This description already exist!");
			}
		}
	
}
