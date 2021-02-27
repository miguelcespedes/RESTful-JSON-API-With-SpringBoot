package com.coolrider.pe.config;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * <h1>GenericConfig</h1>
 *
 * @author Miguel Céspedes
 * @version 1.0
 * @since february 2021
 */
@Configuration
@ComponentScan("com.coolrider.pe")
public class GenericConfig
{
	private final Logger logger = LoggerFactory.getLogger(getClass());

	@Bean
	@Qualifier("mapBean")
	public HashMap<String, Object> load()
	{
		HashMap<String, Object> mapBean = new HashMap<String, Object>();
		mapBean.put("file", "sjdfkjsadf.json");
		logger.info("GenericConfig/load/mapBean: {}", mapBean);
		return mapBean;
	}



}
