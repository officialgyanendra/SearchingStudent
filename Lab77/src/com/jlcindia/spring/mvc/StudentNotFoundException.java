package com.jlcindia.spring.mvc;

public class StudentNotFoundException extends RuntimeException {
private String sid;

public StudentNotFoundException(String sid) {
	this.sid = sid;
}
public String getMessage(){
	String msg="Student Not found";
	if(sid!=null){
		msg="Student id "+sid+" not found";
	}
	return msg;
}
public String toString() {
	return getMessage();
}

}
