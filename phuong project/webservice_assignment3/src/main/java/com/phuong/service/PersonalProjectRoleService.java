package com.phuong.service;

import java.util.List;

import com.phuong.entities.PhuongPersonalProjectRole;

public interface PersonalProjectRoleService {
	List<PhuongPersonalProjectRole> findAll();

	PhuongPersonalProjectRole save(PhuongPersonalProjectRole cardCenter);

	PhuongPersonalProjectRole findOne(Integer id);

	void deleteById(PhuongPersonalProjectRole id);

	void deleteAll();
	
	List<PhuongPersonalProjectRole> findprojectbyperson(Integer id);
	
	List<PhuongPersonalProjectRole> findpersonbyporject(Integer id);
	
	void deletebypersonid(Integer id);
	
	void deletebyprojectid(Integer id);
}
