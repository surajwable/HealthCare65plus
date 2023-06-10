package com.demo.HealthCare65plus.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.HealthCare65plus.beans.HealthProfessional;

public interface HealthProfessionalDao extends JpaRepository<HealthProfessional, Integer>{

}
