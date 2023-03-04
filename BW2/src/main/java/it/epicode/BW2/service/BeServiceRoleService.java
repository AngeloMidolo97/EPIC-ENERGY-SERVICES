package it.epicode.BW2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.epicode.BW2.model.BeServiceRole;
import it.epicode.BW2.repository.BeServiceRoleRepository;


@Service
public class BeServiceRoleService {
	@Autowired
	BeServiceRoleRepository bs;
	
	public BeServiceRole saveRole(BeServiceRole bsr) {
		return bs.save(bsr);
	}
}
