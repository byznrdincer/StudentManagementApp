package com.lbs.Studentmanagementapp.service.IMPL;

import com.lbs.Studentmanagementapp.dto.EnrollmentDTO;
import com.lbs.Studentmanagementapp.dto.EnrollmentSaveDTO;
import com.lbs.Studentmanagementapp.dto.EnrollmentUpdateDTO;
import com.lbs.Studentmanagementapp.entity.Batch;
import com.lbs.Studentmanagementapp.entity.Enrollment;
import com.lbs.Studentmanagementapp.entity.Student;
import com.lbs.Studentmanagementapp.repo.BatchRepo;
import com.lbs.Studentmanagementapp.repo.EnrollmentRepo;
import com.lbs.Studentmanagementapp.repo.StudentRepo;
import com.lbs.Studentmanagementapp.service.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EnrollmentServiceIMPL implements EnrollmentService {

    @Autowired
    private EnrollmentRepo enrollmentRepo;

    @Autowired
    private StudentRepo studentRepo;

    @Autowired
    private BatchRepo batchRepo;

    @Override
    public String addEnrollment(EnrollmentSaveDTO enrollmentSaveDTO) {

        // Veritabanından öğrenci ve batch bilgilerini alıyoruz.
        Student student = studentRepo.findById(enrollmentSaveDTO.getStudent_id()).orElse(null);
        Batch batch = batchRepo.findById(enrollmentSaveDTO.getBatch_id()).orElse(null);

        if (student == null || batch == null) {
            throw new IllegalArgumentException("Student or Batch not found");
        }

        // Enrollment objesini oluşturup veritabanına kaydediyoruz.
        Enrollment enrollment = new Enrollment(student, batch, enrollmentSaveDTO.getJoindate(), enrollmentSaveDTO.getFee());
        enrollmentRepo.save(enrollment);

        return enrollment.getJoindate();
    }

    @Override
    public List<EnrollmentDTO> getAllEnrollments() {
        List<Enrollment> getEnrollments = enrollmentRepo.findAll();
        List<EnrollmentDTO> enrollmentDTOList = new ArrayList<>();

        for (Enrollment enrollment : getEnrollments) {
            EnrollmentDTO enrollmentDTO = new EnrollmentDTO(
                    enrollment.getEnrollid(),
                    enrollment.getStudent(),
                    enrollment.getBatch(),
                    enrollment.getJoindate(),
                    enrollment.getFee()
            );
            enrollmentDTOList.add(enrollmentDTO);
        }

        return enrollmentDTOList;
    }

    @Override
    public String updateEnrollment(EnrollmentUpdateDTO enrollmentUpdateDTO) {

        // Enrollment ID var mı kontrol ediyoruz
        Optional<Enrollment> optionalEnrollment = enrollmentRepo.findById(enrollmentUpdateDTO.getEnrollid());

        if (optionalEnrollment.isPresent()) {
            Enrollment enrollment = optionalEnrollment.get();
            enrollment.setStudent(studentRepo.findById(enrollmentUpdateDTO.getStudent_id()).orElse(null));
            enrollment.setBatch(batchRepo.findById(enrollmentUpdateDTO.getBatch_id()).orElse(null));
            enrollment.setJoindate(enrollmentUpdateDTO.getJoindate());
            enrollment.setFee(enrollmentUpdateDTO.getFee());

            enrollmentRepo.save(enrollment);
            return enrollment.getJoindate();
        } else {
            System.out.println("Enrollment ID Not Found");
        }
        return null;
    }

    @Override
    public boolean deleteEnrollment(int id) {

        // Enrollment ID var mı kontrol ediyoruz
        Optional<Enrollment> optionalEnrollment = enrollmentRepo.findById(id);

        if (optionalEnrollment.isPresent()) {
            enrollmentRepo.deleteById(id);
            return true;
        } else {
            System.out.println("Enrollment ID Not Found");
        }

        return false;
    }
}
