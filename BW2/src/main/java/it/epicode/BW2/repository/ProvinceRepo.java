package it.epicode.BW2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.epicode.BW2.model.BeServiceProvince;

@Repository
public interface ProvinceRepo extends JpaRepository<BeServiceProvince, Long> {

}
