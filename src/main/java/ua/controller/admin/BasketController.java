package ua.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import ua.editor.PersonEditor;
import ua.editor.ProductionEditor;
import ua.entity.Basket;
import ua.entity.Person;
import ua.entity.Production;
import ua.service.BasketService;
import ua.service.PersonService;
import ua.service.ProductionService;

@Controller
@RequestMapping("/admin/basket")
@SessionAttributes("basket")
public class BasketController {
	
	@Autowired
	private BasketService basketService;
	
	@Autowired
	private ProductionService productionService;
	
	@Autowired
	private PersonService personService;
	
	@ModelAttribute("basket")
	public Basket getForm(){
		return new Basket();
	}
	
	@InitBinder("basket")
	protected void initBinder(WebDataBinder binder){
	   binder.registerCustomEditor(Production.class, new ProductionEditor(productionService));
	   binder.registerCustomEditor(Person.class, new PersonEditor(personService));
	}
	
	@GetMapping
	public String show(Model model){
		model.addAttribute("baskets", basketService.findAll());
		model.addAttribute("productions", productionService.findAll());
		model.addAttribute("persons", personService.findAll());
		return "basket";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Integer id){
		basketService.delete(id);
		return "redirect:/admin/basket";
	}
	
	@GetMapping("/update/{id}")
	public String update(@PathVariable Integer id, Model model){
		model.addAttribute("basket", basketService.findOne(id));
		show(model);
		return "basket";
	}
	
	@GetMapping("/cancel")
	public String cancel(SessionStatus status){
		status.setComplete();
		return "redirect:/admin/basket";
	}
	
	@PostMapping
	public String save(@ModelAttribute("basket") Basket basket, SessionStatus status){
		basketService.save(basket);
		status.setComplete();
		return "redirect:/admin/basket";
	}

}
