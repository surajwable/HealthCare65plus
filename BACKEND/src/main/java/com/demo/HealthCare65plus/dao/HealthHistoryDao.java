package com.demo.HealthCare65plus.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.HealthCare65plus.beans.HealthHistory;
import com.demo.HealthCare65plus.beans.HealthProfessional;

public interface HealthHistoryDao extends JpaRepository<HealthHistory, Integer>{

	List<HealthHistory> findByHealthProfessional(HealthProfessional healthProfessional);

}
