package com.phuong.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.phuong.entities.PhuongProjectRole;

public interface PhuongProjectRoleRepo extends JpaRepository<PhuongProjectRole, Integer> {
	
	//@Query(value = "SELECT PhuongProjectRole from PhuongProjectRole u,PhuongPersonalProjectRole v where u.id = v.id.idProjectRole AND v.id.idPersonal = ?1")
	//List<PhuongProjectRole> findByIdrole(int id);
}
