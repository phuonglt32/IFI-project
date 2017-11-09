package com.phuong.service;

import java.util.List;

import com.phuong.entities.PhuongPersonal;
import com.phuong.entities.PhuongPersonalProjectRole;

public interface PersonalProjectRoleService {
	List<PhuongPersonalProjectRole> findAll();

	PhuongPersonalProjectRole save(PhuongPersonalProjectRole cardCenter);

	PhuongPersonalProjectRole findOne(Integer id);

	void deleteById(Integer id);

	void deleteAll();
	
	List<PhuongPersonalProjectRole> findprojectbyperson(Integer id);
}
