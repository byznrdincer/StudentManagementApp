package com.lbs.Studentmanagementapp.repo;

import com.lbs.Studentmanagementapp.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository <Student,Integer> {

}
