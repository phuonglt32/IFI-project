package com.phuong.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.phuong.entities.PhuongPersonalProjectRole;

public interface PhuongPersonalProjectRoleRepo extends JpaRepository<PhuongPersonalProjectRole, Integer>{
	@Query("SELECT v FROM PhuongProjectRole u,PhuongPersonalProjectRole v WHERE u.id = v.id.idProjectRole AND v.id.idPersonal = ?1")
	List<PhuongPersonalProjectRole> findProjectRoleByIdPerson(int id);
	
	@Query("SELECT v FROM PhuongPersonal u,PhuongPersonalProjectRole v WHERE u.id = v.id.idPersonal AND v.id.idProjectRole = ?1")
	List<PhuongPersonalProjectRole> findpersonbyidproject(int id);
	
	
	@Modifying
	@Transactional
	@Query("DELETE FROM PhuongPersonalProjectRole u WHERE u.id.idPersonal = ?1")
	void deletebypersonid(int id);
	
	
	@Modifying
	@Transactional
	@Query("DELETE FROM PhuongPersonalProjectRole u WHERE u.id.idProjectRole = ?1")
	void deletebyprojectid(int id);
}
