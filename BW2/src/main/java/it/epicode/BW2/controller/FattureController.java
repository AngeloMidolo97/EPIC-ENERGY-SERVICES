package it.epicode.BW2.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.epicode.BW2.model.BeServiceFatture;
import it.epicode.BW2.repository.FattureRepo;
import it.epicode.BW2.service.FattureService;

@RestController
@CrossOrigin
public class FattureController {

	@Autowired
	FattureService fs;
	
	@Autowired
	FattureRepo fr;
	
	@GetMapping("/fatture/all")
	public List<BeServiceFatture> getAll() {
		return fr.findAll();
	}
	
	@GetMapping("/fatture/cliente")
	public List<BeServiceFatture> filterByUtente(@RequestParam String nome) {
		return fs.findFattureByCliente(nome);
	}
	
	@GetMapping("/fatture/stato")
	public List<BeServiceFatture> filterByStato(@RequestParam String stato) {
		return fs.findFattureByStato(stato);
	}
	
	@GetMapping("/fatture/importo")
	public Optional<List<BeServiceFatture>> filterByImporto(@RequestParam BigDecimal min, @RequestParam BigDecimal max) {
		return fs.findFattureImporto(min, max);
	}
	
	@GetMapping("/fatture/anno")
	public Optional<List<BeServiceFatture>> filterByAnno(int anno) {
		return fs.findFattureAnno(anno);
	}
	
	//FARE DATE
	
}
