package com.nlc.nps.restcontroller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/test")
public class NpsApiKeyController {

	@GetMapping
	public String test() {
		return "API key is valid. Access granted!";
	}
}
