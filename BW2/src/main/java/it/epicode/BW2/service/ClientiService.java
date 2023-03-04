package it.epicode.BW2.service;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import it.epicode.BW2.model.BeServiceClienti;
import it.epicode.BW2.repository.ClientiRepo;

@Service
public class ClientiService {
	
	@Autowired
	ClientiRepo cr;
	
	public List<BeServiceClienti> sortByName(){
		return cr.sortByNomeContatto();
//		return cr.findAll(Sort.by(Sort.Direction.ASC, "nomeContatto"));
	}
	
	public List<BeServiceClienti> sortByFatturato(){
		return cr.findAll(Sort.by(Sort.Direction.ASC, "fatturatoAnnuale"));
	}
	public List<BeServiceClienti> sortByDate(){
		return cr.findAll(Sort.by(Sort.Direction.ASC, "dataInserimento"));
	}
	public List<BeServiceClienti> sortByDateUltimoContatto(){
		return cr.findAll(Sort.by(Sort.Direction.ASC, "dataUltimoContatto"));
	}

	public List<BeServiceClienti> sortByProvincia() {
		return cr.sortByNomeProvincia();
	}
	
	//FILTER
	
	public Optional<List<BeServiceClienti>> filterByFatturato(BigDecimal min, BigDecimal max){
		return cr.findAllByFatturatoAnnuale(min, max);
	}
//	public Optional<List<BeServiceClienti>> filterByDataInserimento(Date from, Date to){
//		return cr.findAllByDataInserimento(from, to);
//	}
//	public Optional<List<BeServiceClienti>> filterByDataUltimoContatto(Timestamp data){
//		return cr.findAllByDataUltimoContatto(data);
//	}
	public Optional<List<BeServiceClienti>> filterByNome(String nome){
		return cr.findAllByNomeContattoContaining(nome);
	}
	
}
