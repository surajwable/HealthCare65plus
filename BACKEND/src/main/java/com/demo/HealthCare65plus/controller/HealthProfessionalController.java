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
import com.demo.HealthCare65plus.beans.ProfCategory;
import com.demo.HealthCare65plus.service.HealthHistoryService;
import com.demo.HealthCare65plus.service.HealthProfessionalService;
import com.demo.HealthCare65plus.service.ProfCategoryService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/prof")
public class HealthProfessionalController {

	@Autowired
	HealthProfessionalService professionalService;

	@Autowired
    HealthHistoryService healthHistoryService;
	@Autowired
	ProfCategoryService profCategoryService;
	
	@PostMapping("/registerExpert")
	public ResponseEntity<HealthProfessional> createProfessional(@RequestBody HealthProfessional professional) {
		HealthProfessional createdProfessional = professionalService.createProfessional(professional);
		return ResponseEntity.status(HttpStatus.CREATED).body(createdProfessional);
	}
	
    @PostMapping("/{healthProfessionalId}/category/{categoryId}")
    public ResponseEntity<String> assignCategoryToHealthProfessional(@PathVariable int healthProfessionalId, @PathVariable int categoryId) {
        HealthProfessional healthProfessional = professionalService.getProfessionalById(healthProfessionalId);
        ProfCategory category = profCategoryService.getCategoryById(categoryId);

        if (healthProfessional == null || category == null) {
            return ResponseEntity.notFound().build();
        }

        healthProfessional.setCategory(category);
        professionalService.updateProfessional(healthProfessional);

        return ResponseEntity.status(HttpStatus.CREATED).body("Category assigned to health professional successfully.");
    }
    

	@GetMapping("/professionals/{professionalId}")
	public ResponseEntity<HealthProfessional> getProfessionalById(@PathVariable int professionalId) {
		HealthProfessional professional = professionalService.getProfessionalById(professionalId);
		if (professional != null) {
			return ResponseEntity.ok(professional);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PutMapping("/professionals")
	public ResponseEntity<String> updateProfessional(@RequestBody HealthProfessional professional) {
		boolean updated = professionalService.updateProfessional(professional);
		if (updated) {
			return ResponseEntity.ok("Health professional updated successfully: " + professional);
		} else {
			return ResponseEntity.badRequest().build();
		}
	}

	@DeleteMapping("/professionals/{professionalId}")
	public ResponseEntity<String> deleteProfessional(@PathVariable int professionalId) {
		boolean deleted = professionalService.deleteProfessional(professionalId);
		if (deleted) {
			return ResponseEntity.ok("Health professional deleted successfully: " + professionalId);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
//	@PostMapping("/getAppointments")
//	public ResponseEntity<HealthHistory> getAppointments( /*@RequestBody HealthHistory appointments,*/@PathVariable int docId) {
//		
//		HealthHistory appointments = healthHistoryService.getAppointments(docId);
//		if (appointments != null) {
//			return ResponseEntity.ok(appointments);
//		} else {
//			return ResponseEntity.notFound().build();
//		}
//	}
	
	@GetMapping("/{healthProfessionalId}/appointments")
	public ResponseEntity<List<HealthHistory>> getProfessionalAppointments(@PathVariable int healthProfessionalId) {
	    // Retrieve the health professional by ID
	    HealthProfessional healthProfessional = professionalService.getProfessionalById(healthProfessionalId);
	    if (healthProfessional != null) {
	        // Retrieve appointments for the health professional
	        List<HealthHistory> appointments = healthHistoryService.getAppointmentsByHealthProfessional(healthProfessional);
	        return ResponseEntity.ok(appointments);
	    } else {
	        return ResponseEntity.notFound().build();
	    }
	}

}
