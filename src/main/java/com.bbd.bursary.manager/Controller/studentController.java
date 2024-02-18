package com.bbd.bursary.manager.Controller;

import com.bbd.bursary.manager.Model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.bbd.bursary.manager.Repository.StudentInterface;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/student")
public class studentController {

  @Autowired
  StudentInterface studentRepository;

  @GetMapping
  public ResponseEntity<List<Student>> getStudents() {
    List<Student> students = studentRepository.getAll();
    return new ResponseEntity<>(students, HttpStatus.OK);
  }

  @GetMapping("/approved")
  public ResponseEntity<List<Student>> getApprovedStudents() {
    List<Student> students = studentRepository.getAllApproved();
    return new ResponseEntity<>(students, HttpStatus.OK);
  }

  @GetMapping("/pending")
  public ResponseEntity<List<Student>> getPendingStudents() {
    List<Student> students = studentRepository.getAllPending();
    return new ResponseEntity<>(students, HttpStatus.OK);
  }

  @GetMapping("/rejected")
  public ResponseEntity<List<Student>> getRejectedStudents() {
    List<Student> students = studentRepository.getAllRejected();
    return new ResponseEntity<>(students, HttpStatus.OK);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Student> getStudentById(@PathVariable("id") long id) {
    Student student = studentRepository.findById(id);
    if (student != null) {
      return new ResponseEntity<>(student, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @PostMapping
  public ResponseEntity<String> createStudent(@RequestBody Student student) {
    try {
      studentRepository.save(student);
      return new ResponseEntity<>("Student was created successfully.", HttpStatus.CREATED);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @PutMapping("/{id}/fund")
  public ResponseEntity<String> allocateFunds(@PathVariable("id") long id, @RequestParam("amount") int amount) {
    int rowsAffected = studentRepository.allocateFunds(id, amount);
    if (rowsAffected >  0) {
      return new ResponseEntity<>("Funds allocated successfully.", HttpStatus.OK);
    } else {
      return new ResponseEntity<>("No student found with id=" + id, HttpStatus.NOT_FOUND);
    }
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<String> deleteStudent(@PathVariable("id") long id) {
    try {
      int result = studentRepository.deleteById(id);
      if (result ==  0) {
        return new ResponseEntity<>("Cannot find Student with id=" + id, HttpStatus.NOT_FOUND);
      }
      return new ResponseEntity<>("Student was deleted successfully.", HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>("Cannot delete Student.", HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
}
