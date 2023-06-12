package com.demo.HealthCare65plus.beans;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;


import com.demo.HealthCare65plus.service.HealthHistoryService;
import com.demo.HealthCare65plus.service.HealthHistoryServiceImpl;

@Entity
@Table(name = "Professionals")
public class HealthProfessional extends User {

    private String specialization;

    @OneToMany(mappedBy = "healthProfessional", cascade = CascadeType.ALL)
    private List<HealthHistory> healthHistories;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "categoryId")
    private ProfCategory category;
    


    public HealthProfessional() {
        super();
    }

    public HealthProfessional(int userId, String name, String contact, String address, Date dateOfBirth,
                              String email, String password, List<HealthHistory> healthHistories,
                              String specialization, ProfCategory category) {
        super(userId, name, contact, address, dateOfBirth, email, password);
        this.healthHistories = healthHistories;
        this.specialization = specialization;
        this.category = category;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public List<HealthHistory> getHealthHistories() {
        return healthHistories;
    }

    public void setHealthHistories(List<HealthHistory> healthHistories) {
        this.healthHistories = healthHistories;
    }

    public ProfCategory getCategory() {
        return category;
    }

    public void setCategory(ProfCategory category) {
        this.category = category;
    }
    
	
    public void viewPatientHealthHistory(Patient patient) {
        if (patient != null) {
            List<HealthHistory> patientHealthHistory = patient.getRecords();
            // Process and display the patient's health history
            for (HealthHistory history : patientHealthHistory) {
                System.out.println(history);
            }
        }
    }

    public void updatePatientHealthHistory(HealthHistory history) {
        if (history != null) {
            // Assuming you have a service for health history, inject it using @Autowired or instantiate it
            HealthHistoryService healthHistoryService = new HealthHistoryServiceImpl();

            // Update the necessary fields of the health history
            // history.set... // Update the fields accordingly

            // Save the updated health history
            healthHistoryService.updateHealthHistory(history);
        }
    }

}
