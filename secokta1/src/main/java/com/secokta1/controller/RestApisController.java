package com.secokta1.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class RestApisController {
	
	@GetMapping("/redirect")
	public String redirect(String code) {
		return code;
	}
	
	@GetMapping("/redirectmyapp")
	public String redirectmyapp(String code) {
		return code;
	}
	
	@GetMapping("/hellointernaluser")
	public String hellointernaluser(@AuthenticationPrincipal OidcUser principal) {
		return "Hello, Internal user ! " + principal.getName();
	}

}
