package com.coolrider.pe.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.coolrider.pe.exception.BusinessException;
import com.coolrider.pe.model.GenericMap;
import com.coolrider.pe.util.CommonUtil;

@ControllerAdvice
@Component
public class ExceptionAdviceController
{
	static final Logger logger = LoggerFactory.getLogger(ExceptionAdviceController.class);

	@ExceptionHandler(Exception.class)
	public ResponseEntity<GenericMap> genericExceptionHandler(Exception ex) throws Exception
	{
		// construyendo response
		GenericMap response = new GenericMap();

		if (ex instanceof BusinessException)
		{
			response.put("code", ((BusinessException) ex).getBusinessCode());
			response.put("message", ((BusinessException) ex).getBusinessMessage());
		} else
		{
			response.put("code", "F99");
			response.put("message", ex.getMessage());
		}

		// enviando cabeceras
		HttpHeaders headers = new HttpHeaders();
		headers.set("status", "HTTP/1.1 200 OK");
		headers.setContentType(MediaType.APPLICATION_JSON_UTF8);

		return new ResponseEntity<>(CommonUtil.easyMap("error", response), headers, HttpStatus.OK);

	}
}