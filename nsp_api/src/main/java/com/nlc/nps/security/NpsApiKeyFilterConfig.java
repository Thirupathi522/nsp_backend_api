package com.nlc.nps.security;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NpsApiKeyFilterConfig {

	@Bean
	public FilterRegistrationBean<NpsApiKeyAuthFilter> apiKeyFilter(NpsApiKeyAuthFilter filter) {
		FilterRegistrationBean<NpsApiKeyAuthFilter> registrationBean = new FilterRegistrationBean<>();
		registrationBean.setFilter(filter);
		registrationBean.addUrlPatterns("/api/*"); // Adjust to your secured endpoints
		return registrationBean;
	}
}
