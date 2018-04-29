package com.jlcindia.spring.mvc;



import org.springframework.stereotype.Component;
import org.springframework.validation.*;
@Component
public class SidValidator implements Validator {
public boolean supports(Class clazz){
	return StudentTO.class.equals(clazz);
}
public void validate(Object obj, Errors errors){
	SidSearchCommand sidSearchCommand=(SidSearchCommand)obj;
	String sid=sidSearchCommand.getSid();
	
	if(sid==null || sid.length()==0){
	errors.rejectValue("sid","error.sid.required");
	}else if(!sid.startsWith("JLC-")){
		errors.rejectValue("sid","error.sid.format",null,"Invalid Format");
	}else{
		try{
			String temp=sid.substring(4);
			int x=Integer.parseInt(temp);
			if(x<100||x>999)
				errors.rejectValue("sid","error.sid.range",null,"Invalid Format");
		}catch(Exception e){
			errors.rejectValue("sid","error.sid.integer",null,"Invalid Format");
		}
	}
	
}

}
