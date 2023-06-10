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
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int healthHistoryId;
	@ManyToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name="patientId")
	private Patient user;
	@ManyToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name="docId")
	private HealthProfessional healthProfessionalId;

	public HealthHistory(int healthHistoryId, Patient userId, HealthProfessional healthProfessionalId) {

		this.healthHistoryId = healthHistoryId;
		this.user = userId;
		this.healthProfessionalId = healthProfessionalId;
	}

	public int getHealthHistoryId() {
		return healthHistoryId;
	}

	public void setHealthHistoryId(int healthHistoryId) {
		this.healthHistoryId = healthHistoryId;
	}

	public User getUserId() {
		return user;
	}

	public void setUserId(Patient userId) {
		this.user = userId;
	}

	public HealthProfessional getHealthProfessionalId() {
		return healthProfessionalId;
	}

	public void setHealthProfessionalId(HealthProfessional healthProfessionalId) {
		this.healthProfessionalId = healthProfessionalId;
	}
}
