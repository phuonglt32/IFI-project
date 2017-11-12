package com.phuong.service;

import java.util.List;

import com.phuong.entities.PhuongProjectRole;


public interface PhuongProjectRoleService {
	List<PhuongProjectRole> findAll();
	
	PhuongProjectRole save(PhuongProjectRole cardCenter);
	
	PhuongProjectRole findOne(Integer id);
	
	void deleteById(Integer id);
	
	void deleteAll();
}
