package com.lbs.Studentmanagementapp.controller;

import com.lbs.Studentmanagementapp.dto.EnrollmentDTO;
import com.lbs.Studentmanagementapp.dto.EnrollmentSaveDTO;
import com.lbs.Studentmanagementapp.dto.EnrollmentUpdateDTO;
import com.lbs.Studentmanagementapp.service.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.lbs.Studentmanagementapp.dto.EnrollmentDTO;
import com.lbs.Studentmanagementapp.dto.EnrollmentSaveDTO;
import com.lbs.Studentmanagementapp.dto.EnrollmentUpdateDTO;
import com.lbs.Studentmanagementapp.service.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/enrollment")
public class EnrollmentController {

    @Autowired
    private EnrollmentService enrollmentService;

    @PostMapping(path = "/save")
    public ResponseEntity<String> saveEnrollment(@RequestBody EnrollmentSaveDTO enrollmentSaveDTO) {
        enrollmentService.addEnrollment(enrollmentSaveDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("Enrollment added successfully");
    }

    @GetMapping("/getAllEnrollments")
    public ResponseEntity<List<EnrollmentDTO>> getAllEnrollments() {
        List<EnrollmentDTO> allEnrollments = enrollmentService.getAllEnrollments();
        if (allEnrollments.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.ok(allEnrollments);  // HTTP 200 OK ile listeyi döndür
    }

    @PutMapping(path = "/update")
    public ResponseEntity<String> updateEnrollment(@RequestBody EnrollmentUpdateDTO enrollmentUpdateDTO) {
        String updatedEnrollment = enrollmentService.updateEnrollment(enrollmentUpdateDTO);
        return updatedEnrollment != null ?
                ResponseEntity.ok(updatedEnrollment) :
                ResponseEntity.status(HttpStatus.NOT_FOUND).body("Enrollment not found");
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<String> deleteEnrollment(@PathVariable(value = "id") int id) {
        boolean isDeleted = enrollmentService.deleteEnrollment(id);
        return isDeleted ?
                ResponseEntity.status(HttpStatus.NO_CONTENT).body("Enrollment deleted successfully") :
                ResponseEntity.status(HttpStatus.NOT_FOUND).body("Enrollment not found");
    }
}
