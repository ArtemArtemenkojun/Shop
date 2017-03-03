package ua.editor;

import java.beans.PropertyEditorSupport;

import ua.entity.Production;
import ua.service.ProductionService;

public class ProductionEditor extends PropertyEditorSupport{

	private final ProductionService productionService;

	public ProductionEditor(ProductionService productionService) {
		this.productionService = productionService;
	}
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		Production production = productionService.findOne(Integer.valueOf(text));
		setValue(production);
	}
}
