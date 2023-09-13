package org.dsit.gestionIftar.dao;

import org.dsit.gestionIftar.entities.District;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "*")
public interface DistrictRepository extends JpaRepository<District, Integer> {

}
