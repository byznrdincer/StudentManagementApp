package com.lbs.Studentmanagementapp.service.IMPL;

import com.lbs.Studentmanagementapp.dto.StudentDTO;
import com.lbs.Studentmanagementapp.dto.StudentLoginDTO;
import com.lbs.Studentmanagementapp.dto.StudentSaveDTO;
import com.lbs.Studentmanagementapp.dto.StudentUpdateDTO;
import com.lbs.Studentmanagementapp.entity.Student;
import com.lbs.Studentmanagementapp.repo.StudentRepo;
import com.lbs.Studentmanagementapp.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


import org.springframework.web.server.ResponseStatusException;
import java.util.Optional;

@Service
public class StudentServiceIMPL implements StudentService {

    @Autowired
    private StudentRepo studentRepo;

    @Override
    public String addStudent(StudentSaveDTO studentSaveDTO) {
        // DTO'dan gelen verilerle yeni bir Student nesnesi oluşturuluyor
        Student student = new Student(
                studentSaveDTO.getStudentName(),
                studentSaveDTO.getAddress(),
                studentSaveDTO.getPhone()
        );

        // Student nesnesi veritabanına kaydediliyor
        studentRepo.save(student);

        // Öğrencinin adını döndürüyoruz (başarı mesajı olarak kullanılacak)
        return student.getStudentName();
    }

    @Override
    public List<StudentDTO> getAllStudents() {
        // Tüm öğrencileri almak için gereken kod
        return studentRepo.findAll().stream()
                .map(this::mapToDTO)
                .toList();
    }

    @Override
    public String updateStudent(StudentUpdateDTO studentUpdateDTO) {
        // Öğrenciyi güncellemek için gereken kod
        return "Öğrenci başarıyla güncellendi"; // Bu metodun sonunda bir geri dönüş verin.
    }

    @Override
    public StudentDTO getStudentById(int id) {
        // Öğrenciyi ID ile almak için kod
        Optional<Student> studentOpt = studentRepo.findById(id);
        if (studentOpt.isPresent()) {
            Student student = studentOpt.get();
            return new StudentDTO(
                    student.getStudentId(),
                    student.getStudentName(),
                    student.getAddress(),
                    student.getPhone()
            );
        } else {
            return null; // Öğrenci bulunamazsa null döner
        }
    }

    @Override
    public boolean deleteStudent(int id) {
        // Öğrenciyi silmek için gerekli kod
        Optional<Student> student = studentRepo.findById(id);
        if (student.isPresent()) {
            studentRepo.delete(student.get());
            return true; // Öğrenci silinirse true döner
        }
        return false; // Öğrenci bulunamazsa false döner
    }

    @Override
    public boolean validateStudentLogin(StudentLoginDTO studentLoginDTO) {
        Optional<Student> student = studentRepo.findByStudentNameAndStudentId(studentLoginDTO.getStudentName(), studentLoginDTO.getStudentId());

        return student.isPresent(); // Öğrenci bulunursa true döner
    }

    @Override
    public StudentDTO findById(Long id) {
        // Öğrenci ID ile bilgileri almak için gereken kod
        return studentRepo.findById(id.intValue())
                .map(this::mapToDTO)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Öğrenci bulunamadı"));
    }

    private StudentDTO mapToDTO(Student student) {
        return new StudentDTO(student.getStudentId(), student.getStudentName(), student.getAddress(), student.getPhone());
    }
}
