package com.phuong.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.phuong.entities.PhuongPersonalProjectRole;

public interface PhuongPersonalProjectRoleRepo extends JpaRepository<PhuongPersonalProjectRole, Integer>{
	@Query("SELECT v FROM PhuongProjectRole u,PhuongPersonalProjectRole v WHERE u.id = v.id.idProjectRole AND v.id.idPersonal = ?1")
	List<PhuongPersonalProjectRole> findProjectRoleByIdPerson(int id);
}
