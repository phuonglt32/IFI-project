package com.phuong.service;

import java.util.List;

import com.phuong.entities.PhuongPersonal;
import com.phuong.entities.PhuongProjectRole;

public interface PhuongPersonalService {
	List<PhuongPersonal> findAll();
	
	PhuongPersonal save(PhuongPersonal cardCenter);
	
	PhuongPersonal findOne(Integer id);
	
	void deleteById(Integer id);
	
	void deleteAll();
	
	List<PhuongProjectRole> findbypersonal(Integer id);
}
