package com.demo.HealthCare65plus.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.HealthCare65plus.beans.HealthHistory;
import com.demo.HealthCare65plus.beans.HealthProfessional;
import com.demo.HealthCare65plus.beans.Patient;
import com.demo.HealthCare65plus.service.HealthHistoryService;
import com.demo.HealthCare65plus.service.PatientService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/patient")
public class PatientController {

	@Autowired
	PatientService patientService;
	
	@Autowired
	HealthHistoryService healthHistoryService;


	@PostMapping("/register")
	public ResponseEntity<Patient> createPatient(@RequestBody Patient patient) {
		Patient createdPatient = patientService.createPatient(patient);
		return ResponseEntity.status(HttpStatus.CREATED).body(createdPatient);
	}

	/*
	 * @GetMapping("/patients/{patientId}") public ResponseEntity<Patient>
	 * getPatientById(@PathVariable int patientId) { Patient patient =
	 * patientService.getPatientById(patientId); if (patient != null) { return
	 * ResponseEntity.ok(patient); } else { return
	 * ResponseEntity.notFound().build(); } }
	 */
	@PostMapping("/login")
	public ResponseEntity<Patient> login(@RequestBody Patient patient)
	{
		Patient pat=patientService.getByEmail(patient.getEmail());
		if (pat != null) 
		{
			return	ResponseEntity.ok(pat); 
		}
		else 
		{
			return ResponseEntity.notFound().build(); 
			
		}	
	}
		
@PutMapping("/updatePat")
public ResponseEntity<String> updatePatient(@RequestBody Patient patient) {
	boolean updated = patientService.updatePatient(patient);
	if (updated) {
		return ResponseEntity.ok("Patient updated successfully: " + patient.getAddress()+" "+patient.getUserId());
	} else {
		return ResponseEntity.badRequest().build();
	}
}

@DeleteMapping("/deleteById/{patientId}")
public ResponseEntity<String> deletePatient(@PathVariable int patientId) {
	boolean deleted = patientService.deletePatient(patientId);
	if (deleted) {
		return ResponseEntity.ok("Patient deleted successfully: " + patientId);
	} else {
		return ResponseEntity.notFound().build();
	}
}

//@PostMapping("/bookAppointment")
//public ResponseEntity<String> bookAppointment(@RequestBody Appointment appointment) {
//    // Perform necessary validation and business logic for booking the appointment
//    // Call the appropriate service method to handle the appointment booking
//    
//    // Example logic to handle the appointment booking
//    boolean booked = patientService.bookAppointment(appointment);
//    if (booked) {
//        return ResponseEntity.ok("Appointment booked successfully");
//    } else {
//        return ResponseEntity.badRequest().build();
//    }
//}




//@GetMapping("/patients/{patientId}") 
//public ResponseEntity<HealthProfessional> getAppointments(@PathVariable int patientId)
//{ 
//	
//	List<HealthHistory> history =  healthHistoryService.
//	for(HealthHistory e: history) {
//		e
//	}
//	return  ResponseEntity.notFound().build();
//}		
}
