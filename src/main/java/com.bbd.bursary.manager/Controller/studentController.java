package com.bbd.bursary.manager.Controller;
import java.util.ArrayList;
import java.util.List;

import com.bbd.bursary.manager.Model.Student;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bbd.bursary.manager.Repository.StudentInterface;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/student")
public class StudentController {

  @Autowired
  StudentInterface studentRepository;

  @PostMapping("/student")
  public ResponseEntity<String> createStudent(@RequestBody Student student) {
    try {
      studentRepository.save(new Student(student.getStudentId(), student.getFirstName(), student.getLastName(), student.getIdentityDocument(), student.getPhoneNumber(), student.getEmail(),
      student.getRace(), student.getHeadOfDepartmentID(),
      student.getMotivation()));
      return new ResponseEntity<>("Student was created successfully.", HttpStatus.CREATED);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

}