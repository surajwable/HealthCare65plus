package com.demo.HealthCare65plus.service;

import com.demo.HealthCare65plus.beans.Patient;
import com.demo.HealthCare65plus.dao.PatientDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientServiceImpl implements PatientService {

	@Autowired
	PatientDao patientDao;


	@Override
	public Patient createPatient(Patient patient) {
		return patientDao.save(patient);
	}

	/*
	 * @Override public Patient getPatientById(int patientId) { return
	 * patientDao.findById(patientId).orElse(null); }
	 */

	@Override
	public boolean updatePatient(Patient patient) {
//		if (patientDao.existsById(patient.getUserId())) {
//			patientDao.save(patient);
		Patient pat=patientDao.findByEmail(patient.getEmail());
		pat.setContact(patient.getContact());
		pat.setAddress(patient.getAddress());
		pat.setPassword(patient.getPassword());
		patientDao.save(pat);	
			return true;
//		}
//		return false;
	}

	@Override
	public boolean deletePatient(int patientId) {
		patientDao.deleteById(patientId);
		return true;
	}

	@Override
	public Patient getByEmail(String email) {
		
		return patientDao.findByEmail(email);
	}
}
