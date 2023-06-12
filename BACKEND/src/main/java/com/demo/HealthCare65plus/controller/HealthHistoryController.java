package com.demo.HealthCare65plus.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.HealthCare65plus.beans.HealthHistory;
import com.demo.HealthCare65plus.service.HealthHistoryService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/healthHistory")
public class HealthHistoryController {

    @Autowired
    HealthHistoryService healthHistoryService;

    @PostMapping
    public ResponseEntity<HealthHistory> createHealthHistory(@RequestBody HealthHistory healthHistory) {
        HealthHistory createdHealthHistory = healthHistoryService.createHealthHistory(healthHistory);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdHealthHistory);
    }

    @GetMapping("/{healthHistoryId}")
    public ResponseEntity<HealthHistory> getHealthHistoryById(@PathVariable int healthHistoryId) {
        HealthHistory healthHistory = healthHistoryService.getHealthHistoryById(healthHistoryId);
        if (healthHistory != null) {
            return ResponseEntity.ok(healthHistory);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    

    @GetMapping("/{healthHistoryId}")
    public ResponseEntity<List<HealthHistory>> getAllHealthHistory()
    {
        List<HealthHistory> healthHistory = (List<HealthHistory>) healthHistoryService.getAll();
        if (healthHistory != null) {
            return ResponseEntity.ok(healthHistory);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{healthHistoryId}")
    public ResponseEntity<String> updateHealthHistory(@PathVariable int healthHistoryId,
                                                      @RequestBody HealthHistory healthHistory) {
        healthHistory.setHealthHistoryId(healthHistoryId);
        boolean updated = healthHistoryService.updateHealthHistory(healthHistory);
        if (updated) {
            return ResponseEntity.ok("Health history updated successfully: " + healthHistoryId);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{healthHistoryId}")
    public ResponseEntity<String> deleteHealthHistory(@PathVariable int healthHistoryId) {
        boolean deleted = healthHistoryService.deleteHealthHistory(healthHistoryId);
        if (deleted) {
            return ResponseEntity.ok("Health history deleted successfully: " + healthHistoryId);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    
    @PostMapping("/bookAppointment")
    public ResponseEntity<HealthHistory> bookAppointment(@RequestBody HealthHistory healthHistory) {
        HealthHistory bookedAppointment = healthHistoryService.createHealthHistory(healthHistory);
        return ResponseEntity.status(HttpStatus.CREATED).body(bookedAppointment);
    }

}
