package com.demo.HealthCare65plus.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.HealthCare65plus.beans.HealthHistory;
import com.demo.HealthCare65plus.beans.HealthProfessional;
import com.demo.HealthCare65plus.dao.HealthHistoryDao;

@Service
@Transactional
public class HealthHistoryServiceImpl implements HealthHistoryService {

    @Autowired
    private HealthHistoryDao healthHistoryDao;

    @Override
    public HealthHistory createHealthHistory(HealthHistory healthHistory) {
        return healthHistoryDao.save(healthHistory);
    }

    @Override
    public HealthHistory getHealthHistoryById(int healthHistoryId) {
        return healthHistoryDao.findById(healthHistoryId).orElse(null);
    }

    @Override
    public boolean updateHealthHistory(HealthHistory healthHistory) {
        if (healthHistoryDao.existsById(healthHistory.getHealthHistoryId())) {
            healthHistoryDao.save(healthHistory);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteHealthHistory(int healthHistoryId) {
        if (healthHistoryDao.existsById(healthHistoryId)) {
            healthHistoryDao.deleteById(healthHistoryId);
            return true;
        }
        return false;
    }

//	@Override
//	public HealthHistory getAppointments(int docId) {
//		
//		return healthHistoryDao.findById(docId);
//	}
    
//    @Override
//    public HealthHistory getAppointments(int docId) {
//        return healthHistoryDao.findById(docId).orElse(null);
//    }
    
    public HealthHistory getAppointments(int docId) {
	Optional<HealthHistory> healthHistory=healthHistoryDao.findById(docId);
	if(healthHistory.isPresent()) {
		HealthHistory optionalHistory=healthHistory.get();
	}
	return null;	
    }

    @Override
    public List<HealthHistory> getAll() {
        return healthHistoryDao.findAll();
    }

    @Override
    public List<HealthHistory> getAppointmentsByHealthProfessional(HealthProfessional healthProfessional) {
        return healthHistoryDao.findByHealthProfessional(healthProfessional);
    }

}
