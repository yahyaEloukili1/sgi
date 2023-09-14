package org.dsit.gestionIftar.services;

import org.dsit.gestionIftar.entities.AppRole;
import org.dsit.gestionIftar.entities.AppUser;

public interface AccountService {

	public AppUser save(AppUser user);
	public AppRole saveRole(AppRole role);
	public void addRoleToUser(String username,String roleName);
	public AppUser finduserByUsrname(String username);
}
