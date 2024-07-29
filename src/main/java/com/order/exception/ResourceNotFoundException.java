package com.order.exception;

public class ResourceNotFoundException extends RuntimeException{
	
	
		// extra properties that you want to manage
	public ResourceNotFoundException()
		{
			super("Resource not found on the server !!");
		}
		
		public ResourceNotFoundException(String message)
		{
			super(message);
		}
	}


