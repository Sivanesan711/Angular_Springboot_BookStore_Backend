package com.prograd.bookstore.error;

import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "error")
public class ErrorDetails {
    private String message;
	 
    //Specific errors in API request processing
    private List<String> details;
	 public ErrorDetails(String message, List<String> details) {
	        super();
	        this.message = message;
	        this.details = details;
	    }
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public List<String> getDetails() {
		return details;
	}
	public void setDetails(List<String> details) {
		this.details = details;
	}
	 
	  
	
 
}
