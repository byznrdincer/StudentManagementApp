package com.lbs.Studentmanagementapp.service.IMPL;

import com.lbs.Studentmanagementapp.dto.StudentDTO;
import com.lbs.Studentmanagementapp.dto.StudentSaveDTO;
import com.lbs.Studentmanagementapp.dto.StudentUpdateDTO;
import com.lbs.Studentmanagementapp.entity.Student;
import com.lbs.Studentmanagementapp.repo.StudentRepo;
import com.lbs.Studentmanagementapp.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceIMPL implements StudentService {
    private final StudentRepo studentRepo;

    public StudentServiceIMPL(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    @Override
    public String addStudent(StudentSaveDTO studentSaveDTO) {
        Student student = mapToEntity(studentSaveDTO);
        studentRepo.save(student);
        return student.getStudentName();
    }

    @Override
    public List<StudentDTO> getAllStudents() {
        List<Student> getStudents = studentRepo.findAll();
        List<StudentDTO> studentDTOList = new ArrayList<>();

        getStudents.forEach(student -> studentDTOList.add(mapToDTO(student)));
        return studentDTOList;
    }

    @Override
    public String updateStudent(StudentUpdateDTO studentUpdateDTO) {
        return studentRepo.findById(studentUpdateDTO.getStudentId())
                .map(student -> {
                    student.setStudentName(studentUpdateDTO.getStudentName());
                    student.setAddress(studentUpdateDTO.getAddress());
                    student.setPhone(studentUpdateDTO.getPhone());
                    studentRepo.save(student);
                    return student.getStudentName();
                })
                .orElse("Student ID Not Found");
    }

    @Override
    public boolean deleteStudent(int Id) {
        if (studentRepo.existsById(Id)) {
            studentRepo.deleteById(Id);
            return true; // Başarılı bir şekilde silindiyse `true` döner
        } else {
            System.out.println("Student ID Not Found");
            return false; // Silinemezse `false` döner
        }
    }


    private Student mapToEntity(StudentSaveDTO dto) {
        return new Student(dto.getStudentName(), dto.getAddress(), dto.getPhone());
    }

    private StudentDTO mapToDTO(Student student) {
        return new StudentDTO(
                student.getStudentId(),
                student.getStudentName(),
                student.getAddress(),
                student.getPhone()
        );
    }
}
