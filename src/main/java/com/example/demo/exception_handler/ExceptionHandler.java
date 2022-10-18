package com.example.demo.exception_handler;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;

@RestControllerAdvice
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ExceptionHandler {

	@org.springframework.web.bind.annotation.ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleInvalidArgument(MethodArgumentNotValidException exception){
		
		Map<String, String> errorMap = new HashMap<String, String>();
		exception.getBindingResult().getFieldErrors().forEach(error ->{
			errorMap.put(error.getField(), error.getDefaultMessage());
		});
		
		return errorMap;
	}
	
//	@org.springframework.web.bind.annotation.ExceptionHandler(HttpMessageNotReadableException.class)
//	public Map<String, String> handleInvalidArgument1(HttpMessageNotReadableException exception){
//		
//		Map<String, String> errorMap = new HashMap<String, String>();
//		exception.getFieldErrors().forEach(error ->{
//			errorMap.put(error.getField(), error.getDefaultMessage());
//		});
////		errorMap.put(exception.get(), exception.getMessage());
//		
//		return errorMap;
//	} 
	
	
//	@org.springframework.web.bind.annotation.ExceptionHandler(InvalidFormatException.class)
//	public Map<String, String> handleInvalidArgument1(InvalidFormatException exception){
//		
//		Map<String, String> errorMap = new HashMap<String, String>();
////		exception.getBindingResult().getFieldErrors().forEach(error ->{
////			errorMap.put(error.getField(), error.getDefaultMessage());
//		errorMap.put(exception.getOriginalMessage(), exception.getMessage());
//		return errorMap;
//	}
//	
//	@Override
//	@org.springframework.web.bind.annotation.ExceptionHandler(HttpRequestMethodNotSupportedException.class)
//	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
//			HttpHeaders headers, HttpStatus status, WebRequest request) {
//		// TODO Auto-generated method stub
//		return super.handleHttpRequestMethodNotSupported(ex, headers, status, request);
//	}
}
