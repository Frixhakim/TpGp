package com.todo.repositories;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.todo.entities.Patient;



public interface PatientRepository extends JpaRepository<Patient, Long> {
	public Page<Patient> findByNomContains(String k,Pageable pageable);
}
