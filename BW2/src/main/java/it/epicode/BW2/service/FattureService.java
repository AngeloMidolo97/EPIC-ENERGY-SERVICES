package it.epicode.BW2.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.epicode.BW2.model.BeServiceClienti;
import it.epicode.BW2.model.BeServiceFatture;
import it.epicode.BW2.repository.FattureRepo;

@Service
public class FattureService {
	
	@Autowired
	FattureRepo fr;
	
	public List<BeServiceFatture> findFattureByCliente(String nome){
		return fr.getFattureByClienti(nome);
	};
	
	public List<BeServiceFatture> findFattureByStato(String stato){
		return fr.getFattureByStato(stato);
	};
	
	public Optional<List<BeServiceFatture>> findFattureImporto(BigDecimal min, BigDecimal max){
		return fr.findAllByImporto(min, max);
	};
	
	public Optional<List<BeServiceFatture>> findFattureAnno(int anno){
		return fr.findAllByAnno(anno);
	};
	
	
}
