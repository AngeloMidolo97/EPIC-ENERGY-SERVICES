package it.epicode.BW2.repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import it.epicode.BW2.model.BeServiceClienti;
import it.epicode.BW2.model.BeServiceFatture;

@Repository
public interface FattureRepo extends JpaRepository<BeServiceFatture, Long> {
	@Query(
			nativeQuery = true,
			value = "SELECT * FROM be_service_fatture "
					+ "INNER JOIN be_service_clienti ON be_service_fatture.id = be_service_clienti.id"
					+ " WHERE be_service_clienti.nome_contatto = :u"
			)
	List<BeServiceFatture> getFattureByClienti(@Param("u") String utente ); 
	
	@Query(
			nativeQuery = true,
			value = "SELECT * FROM be_service_fatture f INNER JOIN be_service_stato_fattura sf ON f.stato_id = sf.id WHERE sf.nome = :s"
			)
	List<BeServiceFatture> getFattureByStato(@Param("s") String stato); 
	
	@Query(
			nativeQuery = true,
			value = "SELECT * FROM be_service_fatture AS f "
					+ "WHERE f.importo > :m AND f.importo < :c"
			)
	Optional<List<BeServiceFatture>> findAllByImporto(@Param("m") BigDecimal min, @Param("c") BigDecimal max);
	
	@Query(
			nativeQuery = true,
			value = "SELECT * FROM be_service_fatture AS f "
					+ "WHERE f.anno = :m"
			)
	Optional<List<BeServiceFatture>> findAllByAnno(@Param("m") int anno);
}

