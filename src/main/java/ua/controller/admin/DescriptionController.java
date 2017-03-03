package ua.controller.admin;

import static ua.util.ParamBuilder.buildParams;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;


import ua.entity.Description;
import ua.service.DescriptionService;
import ua.validator.DescriptionValidator;

@Controller
@RequestMapping("/admin/description")
@SessionAttributes(names="description")
public class DescriptionController {
	
	@Autowired
	private DescriptionService descriptionService;
	
	@ModelAttribute("description")
	public Description getForm(){
		return new Description();
	}
	
	@InitBinder("description")
	protected void initBinder(WebDataBinder binder){
		binder.setValidator(new DescriptionValidator(descriptionService));
	}
	
	@GetMapping
	public String show(Model model, @PageableDefault Pageable pageable){
		model.addAttribute("descriptions", descriptionService.findAll(pageable));
		return "description";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id,@PageableDefault Pageable pageable){
		descriptionService.delete(id);
		return "redirect:/admin/description"+ buildParams(pageable);
	}
	
	@GetMapping("/update/{id}")
	public String update(@PathVariable int id, Model model, @PageableDefault Pageable pageable){
		model.addAttribute("description", descriptionService.findOne(id));
		show(model, pageable);
		return "description";
	}
	
	@GetMapping("/cancel")
	public String cancel(SessionStatus status, @PageableDefault Pageable pageable){
		status.setComplete();
		return "redirect:/admin/description"+buildParams(pageable);
	}
	
	@PostMapping
	public String save(@ModelAttribute("description") @Valid Description description,BindingResult br ,SessionStatus status, @PageableDefault Pageable pageable, Model model){
		if(br.hasErrors()){
			show(model, pageable);
			return "description";
		}
		descriptionService.save(description);
		status.setComplete();
		return "redirect:/admin/description"+buildParams(pageable);
	}
}
