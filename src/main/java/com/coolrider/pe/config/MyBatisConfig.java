package com.coolrider.pe.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * <h1>GenericConfig</h1>
 *
 * @author Miguel Céspedes
 * @version 1.0
 * @since february 2021
 */
@Configuration
@MapperScan("com.coolrider.pe.mapper")
public class MyBatisConfig
{
	

}
