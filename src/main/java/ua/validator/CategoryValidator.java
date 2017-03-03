package ua.validator;


import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.entity.Category;
import ua.service.CategoryService;

public class CategoryValidator implements Validator {
	
	
	private final CategoryService categoryService;

	
	public CategoryValidator(CategoryService categoryService) {
        this.categoryService = categoryService;
    }			

	
    public boolean supports(Class<?> clazz) {
        return Category.class.equals(clazz);
    }
    

    public void validate(Object target, Errors errors) {
    	Category category = (Category) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nameCategory", "", "enter category please!");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "model", "", "enter model");
        if(categoryService.findByNameCategory(category.getNameCategory())!=null&&categoryService.findByModel(category.getModel())!=null) {
            errors.rejectValue("nameCategory","","This description of category and model already exist!");}
    }
    
}
