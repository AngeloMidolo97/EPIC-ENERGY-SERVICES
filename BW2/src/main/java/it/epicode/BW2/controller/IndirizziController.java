package it.epicode.BW2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.epicode.BW2.model.BeServiceIndirizzi;
import it.epicode.BW2.repository.IndirizziRepo;

@RestController
@RequestMapping("/indirizzi")
public class IndirizziController {
	@Autowired
	IndirizziRepo ir;
	
	@GetMapping("/all")
	public List<BeServiceIndirizzi> getall(){
		return ir.findAll();
	}
}
