package com.demo.HealthCare65plus.service;

import com.demo.HealthCare65plus.beans.HealthProfessional;

public interface HealthProfessionalService {

	HealthProfessional createProfessional(HealthProfessional professional);

	//HealthProfessional getProfessionalById(int professionalId);

	boolean updateProfessional(HealthProfessional professional);

	boolean deleteProfessional(int professionalId);

	HealthProfessional getProfessionalById(int professionalId);

}
