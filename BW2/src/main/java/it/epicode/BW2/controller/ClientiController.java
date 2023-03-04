package it.epicode.BW2.controller;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.epicode.BW2.model.BeServiceClienti;
import it.epicode.BW2.repository.ClientiRepo;
import it.epicode.BW2.service.ClientiService;

@RestController
@RequestMapping("/clienti")
@CrossOrigin
public class ClientiController {
	
	@Autowired
	ClientiService cs;
	
	@Autowired
	ClientiRepo cr;
	
//	@GetMapping("/sort/all")
//	public ResponseEntity<?> getAll(Pageable pageable) {
//		Page<BeServiceClienti> all = cr.findAll(pageable);
//		return new ResponseEntity(all, HttpStatus.OK);
//	}
	
	@GetMapping("/sort/name")
	public List<BeServiceClienti> sortedByName() {
		return cs.sortByName();
	}
	
	@GetMapping("/sort/fatturato")
	public List<BeServiceClienti> sortedByFatturato() {
		return cs.sortByFatturato();
	}
	
	@GetMapping("/sort/date")
	public List<BeServiceClienti> sortedByDate() {
		return cs.sortByDate();
	}
	
	@GetMapping("/sort/lastdate")
	public List<BeServiceClienti> sortedByUltimoContatto() {
		return cs.sortByDateUltimoContatto();
	}
	
	@GetMapping("/sort/provincia")
	public List<BeServiceClienti> sortedByProvincia() {
		return cs.sortByProvincia();
	}
	
	@GetMapping("/filter/fatturato")
	public Optional<List<BeServiceClienti>> filterByFatturato(@RequestParam BigDecimal min, @RequestParam BigDecimal max ) {
		return cs.filterByFatturato(min, max);
	}
	
	//DA SISTEMARE
//	@GetMapping("/filter/data")
//	public Optional<List<BeServiceClienti>> filterByData(@RequestParam("min") @DateTimeFormat(pattern = "MM/dd/yyyy") Date min, 
//			@RequestParam("max") @DateTimeFormat(pattern = "MM/dd/yyyy") Date max ) {
//		
//		return cs.filterByDataInserimento(min, max);
//	}
	
	@GetMapping("/filter/name")
	public Optional<List<BeServiceClienti>> filterByData(@RequestParam String name) {
		return cs.filterByNome(name);
	}
	
//	//NON FUNZIONA
//	@GetMapping("/filter/data")
//	public Optional<List<BeServiceClienti>> findByDataInserimentoBetween(@RequestParam @DateTimeFormat(pattern = "dd.MM.yyyy") Date from,
//            @RequestParam @DateTimeFormat(pattern = "dd.MM.yyyy") Date to) {
//        return cs.filterByDataInserimento(from, to);
//    }
	@GetMapping("/filter/data")
	public Optional<List<BeServiceClienti>> findByDataInserimentoBetween(@RequestParam @DateTimeFormat(pattern = "dd.MM.yyyy") Date from,
          @RequestParam @DateTimeFormat(pattern = "dd.MM.yyyy") Date to) {
      return cr.findAllByDataInserimentoBetween(from, to);
  }

	
	
}
