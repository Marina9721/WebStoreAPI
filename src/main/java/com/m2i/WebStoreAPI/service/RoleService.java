package com.m2i.WebStoreAPI.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.m2i.WebStoreAPI.entity.Role;
import com.m2i.WebStoreAPI.repository.RoleRepository;

@Service
public class RoleService {

	@Autowired
	RoleRepository repo2;
	
	public void create(Role r) {
		repo2.save(r);
	}

	public Role getById(int id) {
		return repo2.findById(id).orElse(null);
	}

	public List<Role> getAll() {
		return repo2.findAll();
	}

	public void update(int id, Role r) {
		Role role = repo2.findById(id).orElse(null);
		if (r!= null) {
			role.setRoleName( r.getRoleName() );
			role.setUsers( r.getUsers());
			repo2.save(role);
		}
	}

	public void delete(int id) {
		Role role = repo2.findById(id).orElse(null);
		if (role!= null) {
			repo2.delete(role);
		}
		
	}

}
