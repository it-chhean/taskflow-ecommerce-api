package com.taskflow.studentmanagement.exception;

public class ResourceNotFoundException extends RuntimeException {


    public ResourceNotFoundException(String message) {
        super(message);
    }

    public static ResourceNotFoundException department(Object id) {
		return new ResourceNotFoundException("Score not found with id: " + id);
	}
    
}
