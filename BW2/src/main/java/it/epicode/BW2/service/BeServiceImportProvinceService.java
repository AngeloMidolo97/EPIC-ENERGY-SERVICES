package it.epicode.BW2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.epicode.BW2.model.BeServiceImportProvince;
import it.epicode.BW2.repository.BeServiceImportProvinceRepo;

@Service
public class BeServiceImportProvinceService {
	
	@Autowired
	BeServiceImportProvinceRepo br;
	
	public BeServiceImportProvince save(BeServiceImportProvince bsr) {
		return br.save(bsr);
	}
}
