package org.dsit.gestionIftar.dao;

import org.dsit.gestionIftar.entities.Annexe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;



@CrossOrigin(origins = "*")
public interface AnnexeRepository extends JpaRepository<Annexe, Integer> {

}
