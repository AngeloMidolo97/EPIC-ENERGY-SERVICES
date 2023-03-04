package it.epicode.BW2.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import it.epicode.BW2.model.BeServiceUser;

@Repository
public interface BeServiceUserRepository extends JpaRepository<BeServiceUser, Long>  {
	
	Optional<BeServiceUser> findByUsername(String nome);
}
