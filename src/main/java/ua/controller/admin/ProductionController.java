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

import ua.editor.CategoryEditor;
import ua.editor.DescriptionEditor;
import ua.entity.Category;
import ua.entity.Description;
import ua.entity.Production;
import ua.service.CategoryService;
import ua.service.DescriptionService;
import ua.service.ProductionService;


@Controller
@RequestMapping("/admin/production")
@SessionAttributes(names="production")
public class ProductionController {
	
	@Autowired
	private ProductionService  productionService;
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private DescriptionService descriptionService;
	
	@InitBinder("production")
	protected void initBinder(WebDataBinder binder){
	   binder.registerCustomEditor(Category.class, new CategoryEditor(categoryService));
	   binder.registerCustomEditor(Description.class, new DescriptionEditor(descriptionService));
	}
	
	@ModelAttribute("production")
	public Production getForm(){
		return new Production();
	}
	
	@GetMapping
	public String show(Model model){
		model.addAttribute("productions", productionService.findAll());
		model.addAttribute("categoryes", categoryService.findAll());
		model.addAttribute("descriptions", descriptionService.findAll());
		return "production";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id){
		productionService.delete(id);
		return "redirect:/admin/production";
	}
	
	@GetMapping("/update/{id}")
	public String update(@PathVariable int id, Model model){
		model.addAttribute("production", productionService.findOne(id));
		show(model);
		return "production";
	}
	
	@GetMapping("/cancel")
	public String cancel(SessionStatus status){
		status.setComplete();
		return "redirect:/admin/production";
	}
	
	@PostMapping
	public String save(@ModelAttribute("production") Production production, SessionStatus status){
		productionService.save(production);
		status.setComplete();
		return "redirect:/admin/production";
	}
	
}
