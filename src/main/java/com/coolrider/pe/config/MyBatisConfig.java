package com.coolrider.pe.config;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <h1>MyBatisConfig</h1>
 *
 * @author Miguel Céspedes
 * @version 1.0
 * @since february 2021
 */
@Configuration
public class MyBatisConfig
{
	private final Logger logger = LoggerFactory.getLogger(getClass());

	@Bean
	@ConfigurationProperties("spring.datasource")
	public DataSource dataSource()
	{
		return DataSourceBuilder.create().build();
	}

}
