package it.epicode.BW2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Scope;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.apache.commons.io.FileUtils;

import it.epicode.BW2.model.BeServiceImportComuni;
import it.epicode.BW2.model.BeServiceImportProvince;
import it.epicode.BW2.model.BeServiceRole;
import it.epicode.BW2.model.BeServiceUser;
import it.epicode.BW2.repository.BeServiceComuniRepo;
import it.epicode.BW2.repository.BeServiceImportProvinceRepo;
import it.epicode.BW2.repository.BeServiceRoleRepository;
import it.epicode.BW2.repository.BeServiceUserRepository;
import it.epicode.BW2.repository.ClientiRepo;
import it.epicode.BW2.service.BeServiceImportProvinceService;
import it.epicode.BW2.service.ClientiService;

@SpringBootApplication
@Component
@Scope("prototype")
public class Bw2Application implements CommandLineRunner {

	@Autowired
	BeServiceRoleRepository rr;
	
	@Autowired
	BeServiceUserRepository ur;
	
	BeServiceImportProvince service;
	
	BeServiceImportComuni serviceC;
	
	@Autowired
	BeServiceImportProvinceRepo br;
	
	@Autowired
	BeServiceImportProvinceService bs;
	
	@Autowired
	BeServiceComuniRepo bsr;
	
	@Autowired
	ClientiRepo cr;
	
	ClientiService cs;
	
	@Autowired
	PasswordEncoder pe;

	public static void main(String[] args) {
		SpringApplication.run(Bw2Application.class, args);
		
	}

	@Override
	public void run(String... args) throws Exception {
		
//			List<BeServiceRole> role = rr.findAll();
//					
//			initUser(role);
		
//		String password = pe.encode("test");
//		System.out.println(password);

	
		//caricaListaProvince();
		//caricaListaComuni();
		System.out.println("test");
	}

	public static final String FILE_PATH = "province-italiane.csv";
	
	

	private List<BeServiceImportProvince> listProvince = new ArrayList<>();

	public void caricaListaProvince() throws IOException {
		File file = new File(FILE_PATH);

		BufferedReader lineReader = new BufferedReader(new FileReader(FILE_PATH));
		String lineText = null;

		int count = 0;

		lineReader.readLine(); // skip header line
		
		//service = new BeServiceImportProvince();

		while ((lineText = lineReader.readLine()) != null) {
			String[] data = lineText.split(";");
			service = new BeServiceImportProvince();
			service.setSigla(data[0]);
			service.setNome(data[1]);
			service.setRegione(data[2]);
			System.out.println(data[0]+data[1]+data[2]);
			br.save(service);
		}

		lineReader.close();

	}
	
	public void caricaListaComuni() throws IOException {
		File file = new File(FILE_PATH);
		
		BufferedReader lineReader = new BufferedReader(new FileReader(FILE_PATH));
		String lineText = null;
		
		int count = 0;
		
		lineReader.readLine(); // skip header line
		
		//service = new BeServiceImportProvince();
		
		while ((lineText = lineReader.readLine()) != null) {
			String[] data = lineText.split(";");
			serviceC = new BeServiceImportComuni();
			serviceC.setCodiceProvincia(data[0]);
			serviceC.setProgressivoComune(data[1]);
			serviceC.setNomeComune(data[2]);
			//serviceC.setNomeProvincia(data[3]);
			bsr.save(serviceC);
		}
		
		lineReader.close();
		
		
	}

	private List<BeServiceRole> initRole() {
		List<BeServiceRole> result = new ArrayList<BeServiceRole>();
		BeServiceRole role = new BeServiceRole();
		role.setRoleName("ROLE_ADMIN");
		result.add(role);
		System.out.println("Saved Role: " + role.getRoleName());

		
		role = new BeServiceRole();
		role.setRoleName("ROLE_USER");
		result.add(role);
		System.out.println("Saved Role: " + role.getRoleName());

		return result;
	}
//	
	private BeServiceUser initUser(List<BeServiceRole> roles) {
		BeServiceUser user = new BeServiceUser();
		user.setEmail("user@email.em");
		user.setNome("Mario");
		user.setCognome("Rossi");
		user.setUsername("m.rossi");
		
		
		
		user.setPassword(pe.encode("test"));
		user.setBeServiceRoles(roles);
		ur.save(user);
		
		
		
		
		System.out.println("Saved User: " + user.getNome());

		return user;
	}
	

}
