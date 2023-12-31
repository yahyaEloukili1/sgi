package org.dsit.gestionIftar.services;

import org.dsit.gestionIftar.dao.RoleRepository;
import org.dsit.gestionIftar.dao.UserRepository;
import org.dsit.gestionIftar.entities.AppRole;
import org.dsit.gestionIftar.entities.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;






@Service
@Transactional
public class AccountServiceImpl implements AccountService {

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;
	
	@Override
	public AppUser save(AppUser user) {
		String hashPW = bCryptPasswordEncoder.encode(user.getPassword());
		user.setPassword(hashPW);
		
		return userRepository.save(user);
	}

	@Override
	public AppRole saveRole(AppRole role) {
		
		return roleRepository.save(role);
	}

	@Override
	public void addRoleToUser(String username, String roleName) {
		AppRole role = roleRepository.findByRoleName(roleName);
		AppUser user = userRepository.findByUsername(username);
		user.getRoles().add(role);
		
	}

	@Override
	public AppUser finduserByUsrname(String username) {
	
		return userRepository.findByUsername(username);
	}

}
