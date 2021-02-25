
package com.coolrider.pe.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public abstract class AbstractController
{
	private final Logger logger = LoggerFactory.getLogger(getClass());

	public ResponseEntity<Object> genericResponse(Object requestService)
	{
		logger.info("AbstractController/genericResponse/requestService: {}", requestService);
		return new ResponseEntity<>(requestService, HttpStatus.OK);
	}

}