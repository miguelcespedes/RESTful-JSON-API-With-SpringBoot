
package com.coolrider.pe.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.bazaarvoice.jolt.Chainr;
import com.bazaarvoice.jolt.JsonUtil;
import com.bazaarvoice.jolt.JsonUtilImpl;
import com.bazaarvoice.jolt.JsonUtils;
import com.coolrider.pe.model.GenericMap;
import com.coolrider.pe.util.CommonUtil;

public abstract class AbstractController
{
	private final Logger logger = LoggerFactory.getLogger(getClass());
	private static final JsonUtil util = new JsonUtilImpl();

	public ResponseEntity<GenericMap> adaptToTemplateResponse(GenericMap untransformed)
	{
		try
		{
			untransformed = CommonUtil.easyMap("message", untransformed);
			logger.debug("adaptToTemplateResponse/untransformed: {}", JsonUtils.toJsonString(untransformed));
			GenericMap transformed = CommonUtil.toGenericMap(Chainr.fromSpec(JsonUtils.classpathToList("/tpl/response.json")).transform(untransformed));
			logger.debug("adaptToTemplateResponse/transformed: {}", JsonUtils.toJsonString(transformed));
			return new ResponseEntity<>(transformed, HttpStatus.OK);

		} catch (Exception e)
		{
			logger.error("../Exception: {}", e.getMessage());
			return null;
		}

	}

}