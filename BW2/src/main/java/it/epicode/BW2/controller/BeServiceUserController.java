package it.epicode.BW2.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BeServiceUserController {

	@GetMapping("/hello")
	@PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
	private String hello() {
		return "hello world";
	}
}
