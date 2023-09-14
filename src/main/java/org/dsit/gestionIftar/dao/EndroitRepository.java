package org.dsit.gestionIftar.dao;

import org.dsit.gestionIftar.entities.Annexe;
import org.dsit.gestionIftar.entities.Categorie;
import org.dsit.gestionIftar.entities.Endroit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;



@CrossOrigin(origins = "*")
public interface EndroitRepository extends JpaRepository<Endroit, Integer> {

}
