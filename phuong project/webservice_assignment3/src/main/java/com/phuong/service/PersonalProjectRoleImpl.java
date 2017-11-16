package com.phuong.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phuong.entities.PhuongPersonalProjectRole;
import com.phuong.repository.PhuongPersonalProjectRoleRepo;

@Service
public class PersonalProjectRoleImpl implements PersonalProjectRoleService {

	private PhuongPersonalProjectRoleRepo personproject;
	
	@Autowired
    public void setphuongpersonalRepository(PhuongPersonalProjectRoleRepo personproject) {
        this.personproject = personproject;
    }
	@Override
	public List<PhuongPersonalProjectRole> findAll() {
		return personproject.findAll();
	}

	@Override
	public PhuongPersonalProjectRole save(PhuongPersonalProjectRole cardCenter) {
		return personproject.save(cardCenter);
	}

	@Override
	public PhuongPersonalProjectRole findOne(Integer id) {
		return null;
	}

	@Override
	public void deleteById(PhuongPersonalProjectRole id) {
		personproject.delete(id);
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public List<PhuongPersonalProjectRole> findprojectbyperson(Integer id) {
		return personproject.findProjectRoleByIdPerson(id);
	}
	@Override
	public List<PhuongPersonalProjectRole> findpersonbyporject(Integer id) {
		return personproject.findpersonbyidproject(id);
	}
	
	
	@Override
	public void deletebypersonid(Integer id) {
		personproject.deletebypersonid(id);
		
	}
	@Override
	public void deletebyprojectid(Integer id) {
		personproject.deletebyprojectid(id);
		
	}
	
}
