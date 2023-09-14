package org.dsit.gestionIftar.dao;

import java.util.List;

import org.dsit.gestionIftar.entities.AppRole;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import org.springframework.web.bind.annotation.CrossOrigin;









@CrossOrigin(origins = "*")
public interface RoleRepository extends JpaRepository<AppRole, Integer> {

	public AppRole findByRoleName(String roleName);
}
