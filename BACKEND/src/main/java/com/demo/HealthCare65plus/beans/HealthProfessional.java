package com.demo.HealthCare65plus.beans;

import java.util.Date;
import java.util.List;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Professionals")
public class HealthProfessional extends User {
	/*
	 * @Id
	 * 
	 * @GeneratedValue(strategy=GenerationType.IDENTITY) 
	 * private int healthProfessionalId;
	 */
    private String specialization;
    @OneToMany(mappedBy="healthProfessionalId",cascade=CascadeType.ALL)
    private List<HealthHistory> records;
    
    @ManyToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name="categoryId")
	private ProfCategory category;

    public HealthProfessional(int userId, String name, String contact, String address, Date dateOfBirth,
                              String email, String password, 
                              List<HealthHistory> healthHistories,
                              int healthProfessionalId, String specialization) {
        super(userId, name, contact, address, dateOfBirth, email, password);
//        this.healthProfessionalId = healthProfessionalId;
        this.specialization = specialization;
    }

	/*
	 * public int getHealthProfessionalId() { return healthProfessionalId; }
	 */

	/*
	 * public void setHealthProfessionalId(int healthProfessionalId) {
	 * this.healthProfessionalId = healthProfessionalId; }
	 */

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

//	public Integer getHealthProfessionalId() {
//		// TODO Auto-generated method stub
//		return null;
//	}
}
