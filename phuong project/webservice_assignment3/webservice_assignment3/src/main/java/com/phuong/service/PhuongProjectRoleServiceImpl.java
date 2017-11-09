package com.phuong.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phuong.entities.PhuongProjectRole;
import com.phuong.repository.PhuongPersonalRepo;
import com.phuong.repository.PhuongProjectRoleRepo;

@Service
public class PhuongProjectRoleServiceImpl implements PhuongProjectRoleService{
	
	private PhuongProjectRoleRepo phuongprojectrepo;
	
	
	
	@Autowired
    public void setphuongprojectRepository(PhuongProjectRoleRepo phuongprojectrepo) {
        this.phuongprojectrepo = phuongprojectrepo;
    }

	@Override
	public List<PhuongProjectRole> findAll() {
		return phuongprojectrepo.findAll();
	}

	@Override
	public PhuongProjectRole save(PhuongProjectRole cardCenter) {
		return phuongprojectrepo.save(cardCenter);
	}

	@Override
	public PhuongProjectRole findOne(Integer id) {
		return phuongprojectrepo.findOne(id);
	}

	@Override
	public void deleteById(Integer id) {
		phuongprojectrepo.delete(id);
		
	}

	@Override
	public void deleteAll() {
		phuongprojectrepo.deleteAll();
		
	}
	
}
