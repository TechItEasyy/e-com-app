package com.e_commerce.exception;

public class ResourceNotFoundException extends  RuntimeException{
	
	public ResourceNotFoundException()
	{
		super("identyfier is not found");
	}
	
	
	public ResourceNotFoundException(String message)
	{
		super(message);
	}

}
