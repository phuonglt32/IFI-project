package com.phuong.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phuong.entities.PhuongPersonal;
import com.phuong.entities.PhuongProjectRole;
import com.phuong.repository.PhuongPersonalRepo;

@Service
public class PhuongPersonalServiceImpl implements PhuongPersonalService {
	
	private PhuongPersonalRepo phuongpersonalrepo;
	
	
	
	@Autowired
    public void setphuongpersonalRepository(PhuongPersonalRepo Repository) {
        this.phuongpersonalrepo = Repository;
    }

	@Override
	public List<PhuongPersonal> findAll() {
		return phuongpersonalrepo.findAll();
	}

	@Override
	public PhuongPersonal save(PhuongPersonal cardCenter) {
		return phuongpersonalrepo.save(cardCenter);
	}

	@Override
	public PhuongPersonal findOne(Integer id) {
		return phuongpersonalrepo.findOne(id);
	}

	@Override
	public void deleteById(Integer id) {
		phuongpersonalrepo.delete(id);
		
	}

	@Override
	public void deleteAll() {
		phuongpersonalrepo.deleteAll();
		
	}

	@Override
	public List<PhuongProjectRole> findbypersonal(Integer id) {
		return phuongpersonalrepo.findByIdrole(id);
	}

	@Override
	public void deleteByIds(List<PhuongPersonal> list) {
		phuongpersonalrepo.deleteInBatch(list);
		
	}

	@Override
	public List<PhuongPersonal> findByName(String name) {
		return phuongpersonalrepo.findByName(name);
	}
	
}
