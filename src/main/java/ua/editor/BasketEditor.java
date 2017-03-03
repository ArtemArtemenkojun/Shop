package ua.editor;

import java.beans.PropertyEditorSupport;
import ua.entity.Basket;
import ua.service.BasketService;

public class BasketEditor extends PropertyEditorSupport{

	private final BasketService basketService;

	public BasketEditor(BasketService basketService) {
		this.basketService = basketService;
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		Basket basket = basketService.findOne(Integer.valueOf(text));
		setValue(basket);
	}
}
