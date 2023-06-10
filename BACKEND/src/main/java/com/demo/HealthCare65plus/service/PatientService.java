package com.demo.HealthCare65plus.service;

import com.demo.HealthCare65plus.beans.Patient;

public interface PatientService {

	Patient createPatient(Patient patient);

	/* Patient getPatientById(int patientId); */

	boolean updatePatient(Patient patient);

	boolean deletePatient(int patientId);

	Patient getByEmail(String email);

}
