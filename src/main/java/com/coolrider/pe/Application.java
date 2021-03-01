package com.coolrider.pe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * <h1>Application</h1>
 *
 * @author Miguel Céspedes
 * @version 1.0
 * @since february 2021
 */
@SpringBootApplication
public class Application
{

	public static void main(String[] args) throws Exception
	{
		try
		{
			SpringApplication.run(Application.class, args);
		} catch (Exception e)
		{
			throw new Exception("Exception message");

		}

	}

}
