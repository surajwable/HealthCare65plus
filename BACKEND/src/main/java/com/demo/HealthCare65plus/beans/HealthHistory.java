package com.demo.HealthCare65plus.beans;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class HealthHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int healthHistoryId;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "patientId")
    private Patient patient;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "docId")
    private HealthProfessional healthProfessional;

    public HealthHistory() {
    }

    public HealthHistory(int healthHistoryId, Patient patient, HealthProfessional healthProfessional) {
        this.healthHistoryId = healthHistoryId;
        this.patient = patient;
        this.healthProfessional = healthProfessional;
    }

    public int getHealthHistoryId() {
        return healthHistoryId;
    }

    public void setHealthHistoryId(int healthHistoryId) {
        this.healthHistoryId = healthHistoryId;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public HealthProfessional getHealthProfessional() {
        return healthProfessional;
    }

    public void setHealthProfessional(HealthProfessional healthProfessional) {
        this.healthProfessional = healthProfessional;
    }
}
