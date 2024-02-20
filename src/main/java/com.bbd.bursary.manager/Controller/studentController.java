package com.bbd.bursary.manager.Controller;

import com.bbd.bursary.manager.Model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.bbd.bursary.manager.Repository.StudentInterface;

import java.util.List;

@CrossOrigin(origins = "*")
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
  public ResponseEntity<Student> getStudentById(@PathVariable("id") final long id) {
    Student student = studentRepository.findById(id);
    if (student != null) {
      return new ResponseEntity<>(student, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @PostMapping
  public ResponseEntity<String> createStudent(@RequestBody final Student student) {
    try {
      studentRepository.save(student);
      return new ResponseEntity<>("Student was created successfully.", HttpStatus.CREATED);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @PutMapping("/{id}")
  public ResponseEntity<String> updateStudent(@PathVariable("id") final long id, @RequestBody final Student student) {
    try{
      int rowsAffected = studentRepository.update(id, student);
      return rowsAffected > 0 ? new ResponseEntity<>("Student updated successfully.", HttpStatus.OK) : new ResponseEntity<>("Student can not be updated because status is not pending.", HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>("Student did not update", HttpStatus.NOT_FOUND);
    }
  }


  @PutMapping("/status/{id}/{status}")
  public ResponseEntity<String> updateStudentStatus(@PathVariable("id") final long id, @PathVariable("status") final int statusID) {
    try{
      studentRepository.updateStudentStatus(id, statusID);
      return new ResponseEntity<>("Student updated successfully.", HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>("Student did not update", HttpStatus.NOT_FOUND);
    }
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<String> deleteStudent(@PathVariable("id") final long id) {
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
