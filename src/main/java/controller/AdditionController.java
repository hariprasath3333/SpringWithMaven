package controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.client.support.HttpAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import entity.AddtionEntity;
import service.AdditionService;

@Controller
public class AdditionController {
	
	@Autowired
	private Validator validator;
	
	@Autowired
	private AdditionService additionService;
	
	@RequestMapping("/index")
	public ModelAndView showPage(){
		ModelAndView modelAndView = new ModelAndView("Addition");
		System.out.println("Index");
		modelAndView.addObject("addtionEntity",new AddtionEntity());
		return modelAndView;
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ModelAndView addNumbers(@Valid @ModelAttribute("addtionEntity") AddtionEntity addtionEntity,
			BindingResult bindingResult, Model model){
		ModelAndView modelAndView = new ModelAndView("Addition");
		validator.validate(addtionEntity, bindingResult);
		if(bindingResult.hasErrors()){
			ModelAndView x = new ModelAndView("Addition");
			x.addObject("addtionEntity",addtionEntity);
			return x;
		}
		int result = additionService.add(addtionEntity.getValueOne(),addtionEntity.getValueTwo());
		addtionEntity.setResult(result);
		return modelAndView;
	}

}
