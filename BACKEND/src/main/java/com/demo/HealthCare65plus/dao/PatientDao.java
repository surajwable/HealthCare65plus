package com.demo.HealthCare65plus.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.HealthCare65plus.beans.Patient;

public interface PatientDao extends JpaRepository<Patient, Integer>{
	Patient findByEmail(String email);
}
