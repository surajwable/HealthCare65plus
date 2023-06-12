package com.demo.HealthCare65plus.service;

import java.util.List;

import com.demo.HealthCare65plus.beans.HealthHistory;
import com.demo.HealthCare65plus.beans.HealthProfessional;

public interface HealthHistoryService {

	HealthHistory createHealthHistory(HealthHistory healthHistory);

	HealthHistory getHealthHistoryById(int healthHistoryId);

	boolean updateHealthHistory(HealthHistory healthHistory);

	boolean deleteHealthHistory(int healthHistoryId);

	HealthHistory getAppointments(int docId);

	List<HealthHistory> getAll();

	List<HealthHistory> getAppointmentsByHealthProfessional(HealthProfessional healthProfessional);

}
