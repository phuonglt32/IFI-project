package com.phuong.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.phuong.entities.PhuongPersonal;
import com.phuong.entities.PhuongProjectRole;



public interface PhuongPersonalRepo extends JpaRepository<PhuongPersonal, Integer>{

	@Query("SELECT u FROM PhuongProjectRole u,PhuongPersonalProjectRole v WHERE u.id = v.id.idProjectRole AND v.id.idPersonal = ?1")
	List<PhuongProjectRole> findByIdrole(int id);
}
