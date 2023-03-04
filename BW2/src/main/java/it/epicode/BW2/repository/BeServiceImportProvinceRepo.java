package it.epicode.BW2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.epicode.BW2.model.BeServiceImportProvince;

@Repository
public interface BeServiceImportProvinceRepo extends JpaRepository<BeServiceImportProvince, Integer> {

}
