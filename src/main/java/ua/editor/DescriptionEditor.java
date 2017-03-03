package ua.editor;

import java.beans.PropertyEditorSupport;

import ua.entity.Description;
import ua.service.DescriptionService;


public class DescriptionEditor extends PropertyEditorSupport{

	private final DescriptionService descriptionService;

	public DescriptionEditor(DescriptionService descriptionService) {
		this.descriptionService = descriptionService;
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		Description ingredient = descriptionService.findOne(Integer.valueOf(text));
		setValue(ingredient);
	}
}
