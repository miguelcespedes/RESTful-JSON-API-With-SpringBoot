package com.coolrider.pe.config;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * <h1>SwaggerConfig</h1>
 *
 * @author Miguel Céspedes
 * @version 1.0
 * @since february 2021
 */
@Configuration
@EnableSwagger2
@EnableWebMvc
@ConfigurationProperties(prefix = "swagger")
public class SwaggerConfig
{

	@Value("${swagger.info.description}")
	private String infoDescription;

	@Value("${swagger.info.version}")
	private String infoVersion;

	@Value("${swagger.info.title}")
	private String infoTitle;

	@Value("${swagger.info.termsOfService}")
	private String termsOfService;

	@Value("${swagger.contact.name}")
	private String contactName;

	@Value("${swagger.contact.url}")
	private String contactUrl;

	@Value("${swagger.contact.email}")
	private String contactEmail;

	@Value("${swagger.license.name}")
	private String licenseName;

	@Value("${swagger.license.url}")
	private String licenseUrl;

	@Bean
	public Docket api()
	{

		return new Docket(DocumentationType.SWAGGER_2).select()
				// .apis(RequestHandlerSelectors.any())
				.apis(RequestHandlerSelectors.basePackage("com.coolrider.pe.controller"))//
				// .paths(PathSelectors.ant("/foos/*"))//
				.paths(PathSelectors.any()).build()//
				.apiInfo(apiInfo());

	}

	private ApiInfo apiInfo()
	{
		return new ApiInfo(
				infoTitle, infoDescription, infoVersion, termsOfService,
				new Contact(contactName, contactUrl, contactEmail)//
				, licenseName, licenseUrl, Collections.emptyList()
		);
	}

}
