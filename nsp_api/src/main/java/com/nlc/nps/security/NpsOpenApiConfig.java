package com.nlc.nps.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
@Configuration
public class NpsOpenApiConfig {

	@Bean
	public OpenAPI customOpenAPI() {
		final String securitySchemeName = "apiKeyScheme";
		return new OpenAPI().info(new Info().title("NLC CRM API").version("1.0"))
				.addSecurityItem(new SecurityRequirement().addList(securitySchemeName))
				.components(new io.swagger.v3.oas.models.Components().addSecuritySchemes(securitySchemeName,
						new SecurityScheme().name("X-API-KEY").type(SecurityScheme.Type.APIKEY)
								.in(SecurityScheme.In.HEADER).name("X-API-KEY")));
	}
}
