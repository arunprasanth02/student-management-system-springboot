package com.studentmanagement.spring.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.studentmanagement.spring.project.model.Student;
import com.studentmanagement.spring.project.repository.StudentRepository;

@Controller
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;
    
    // SAVE STUDENT
    @PostMapping("/students")
    public String saveStudent(@ModelAttribute Student student) {
        studentRepository.save(student);
        return "redirect:/students";
    }

    // LIST STUDENTS
    @GetMapping("/students")
    public String listStudents(Model model) {
        model.addAttribute("students", studentRepository.findAll());
        return "students";
    }

    // SHOW ADD FORM
    @GetMapping("/students/new")
    public String showAddForm(Model model) {
        model.addAttribute("student", new Student());
        return "add-student";
    }

    

    // SHOW EDIT FORM
    @GetMapping("/students/edit/{id}")
    public String showEditForm(@PathVariable("id") int srollno, Model model) {
        Student student = studentRepository.findById(srollno)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        model.addAttribute("student", student);
        return "edit-student";
    }

    // UPDATE STUDENT
    @PostMapping("/students/update/{id}")
    public String updateStudent(@PathVariable("id") int srollno,
                                @ModelAttribute Student student) {

        Student existing = studentRepository.findById(srollno)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        existing.setSname(student.getSname());
        existing.setEmail(student.getEmail());
        existing.setLocation(student.getLocation());

        studentRepository.save(existing);
        return "redirect:/students";
    }

    // DELETE STUDENT
    @GetMapping("/students/delete/{id}")
    public String deleteStudent(@PathVariable("id") int srollno) {
        studentRepository.deleteById(srollno);
        return "redirect:/students";
    }
}
