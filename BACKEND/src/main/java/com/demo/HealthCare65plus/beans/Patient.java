package com.demo.HealthCare65plus.beans;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="Patient")
public class Patient extends User 
{
	 @OneToMany(mappedBy="user",cascade=CascadeType.ALL)
    private List<HealthHistory> records;

	public Patient() {
		super();
	}

	public Patient(int userId, String name, String contact, String address, Date dateOfBirth,
                   String email, String password, List<HealthHistory> records) {
        super(userId, name, contact, address, dateOfBirth, email, password);
        this.records = records;
    }

    public List<HealthHistory> getRecords() {
        return records;
    }

    public void setRecords(List<HealthHistory> records) {
        this.records = records;
    }

	public Integer getPatientId() {

		return null;
	}
	
	/*
	 * public Appointment bookAppointment(HealthProfessional healthProfessional,
	 * ProfCategory category, Date appointmentDate) { Appointment appointment = new
	 * Appointment(); appointment.setPatient(this);
	 * appointment.setHealthProfessional(healthProfessional);
	 * appointment.setCategory(category);
	 * appointment.setAppointmentDate(appointmentDate);
	 * 
	 * // Save the appointment using a service or repository //
	 * appointmentService.createAppointment(appointment);
	 * 
	 * return appointment; }
	 */
}
