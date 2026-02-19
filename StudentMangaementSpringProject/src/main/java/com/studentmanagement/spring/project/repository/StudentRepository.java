package com.studentmanagement.spring.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.studentmanagement.spring.project.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
