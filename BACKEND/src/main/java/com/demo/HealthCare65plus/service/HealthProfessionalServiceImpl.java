package com.demo.HealthCare65plus.service;

import com.demo.HealthCare65plus.beans.HealthProfessional;
import com.demo.HealthCare65plus.dao.HealthProfessionalDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HealthProfessionalServiceImpl implements HealthProfessionalService {

	 @Autowired
    HealthProfessionalDao healthProfessionalDao;

  
    @Override
    public HealthProfessional createProfessional(HealthProfessional professional) {
        return healthProfessionalDao.save(professional);
    }

    @Override
    public boolean updateProfessional(HealthProfessional professional) {
        if (healthProfessionalDao.existsById(professional.getUserId())) {
            healthProfessionalDao.save(professional);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteProfessional(int professionalId) {
        if (healthProfessionalDao.existsById(professionalId)) {
            healthProfessionalDao.deleteById(professionalId);
            return true;
        }
        return false;
    }

	@Override
	public HealthProfessional getProfessionalById(int professionalId) {
		return healthProfessionalDao.findById(professionalId).orElse(null);
	}
}
