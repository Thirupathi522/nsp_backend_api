package com.nlc.nps.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
public class NpsApiKeyAuthFilter extends OncePerRequestFilter {

	@Value("${api.key}")
	private String apiKey;

	private static final String API_KEY_HEADER_NAME = "X-API-KEY";

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		String requestApiKey = request.getHeader(API_KEY_HEADER_NAME);

		if (apiKey.equals(requestApiKey)) {
			filterChain.doFilter(request, response);
		} else {
			response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			response.getWriter().write("Unauthorized: Invalid API Key");
		}
	}
}
