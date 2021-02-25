
package com.coolrider.pe.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.coolrider.pe.model.BusinessResponse;
import com.coolrider.pe.util.BusinessData;
import com.coolrider.pe.util.HttpStatusData;

public abstract class AbstractController
{
	private final Logger logger = LoggerFactory.getLogger(getClass());

	public ResponseEntity<Object> adaptToTemplateResponse(Object data)
	{
		BusinessResponse response = new BusinessResponse();
		response.setStatus(HttpStatusData.OK.getValue());
		response.setCode(BusinessData.SUCCESS.getValue());
		response.setInformation(BusinessData.SUCCESS.getDescription());
		response.setMessagge(data);

		logger.info("AbstractController/adaptToTemplateResponse/response: {}", response);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

}