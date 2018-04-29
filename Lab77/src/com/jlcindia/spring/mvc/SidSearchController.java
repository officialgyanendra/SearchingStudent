package com.jlcindia.spring.mvc;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
@Controller
@SessionAttributes("sidSearchCommand")
public class SidSearchController{
	@Autowired
  private SidValidator sidValidator; 
	@RequestMapping(value="/searchStudent.jlc",method=RequestMethod.POST)
	public String searchStudent(@ModelAttribute("sidSearchCommand") SidSearchCommand sidCommand , BindingResult errors, Model model, HttpServletRequest req)throws ServletException{
           String result="sidsearch";
		System.out.println("searchStudent");
		System.out.println("beforr Validation");
		sidValidator.validate(sidCommand, errors);
		System.out.println("after validation");
		if(errors.hasErrors()){
			System.out.println(errors.getErrorCount());
			return result;
		}
		String sid=sidCommand.getSid();
		System.out.println(sid);
		if(sid.equals("JLC-123")||sid.equals("JLC-999")){
			StudentTO sto=new StudentTO();
			sto.setSid(sid);
			sto.setBid("B-99");	
			sto.setName("gyanendra");
			sto.setEmail("gyanendra@gmail.com");
			sto.setPhone("927554");
			model.addAttribute("STO",sto);
			result="sidresults";
		}else{
			req.setAttribute("sidSearchCommand", sidCommand);
			StudentNotFoundException exc=new StudentNotFoundException(sid);
			req.setAttribute("msg", exc.getMessage());
			throw exc;
		}
		return result;
	}
	@ModelAttribute("sidSearchCommand")
	public SidSearchCommand createSidSerachCommand(){
		return new SidSearchCommand();
	}
	@RequestMapping(value="/sidsearch")
	protected String showSearchPage()throws ServletException {
		return "sidsearch";
	}

}
