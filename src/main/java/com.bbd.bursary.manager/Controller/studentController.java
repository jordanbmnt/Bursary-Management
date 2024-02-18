package com.bbd.bursary.manager.Controller;

import com.bbd.bursary.manager.Model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.bbd.bursary.manager.Repository.StudentInterface;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/student")
public class studentController {

  @Autowired
  StudentInterface studentRepository;

  @GetMapping("/student/{id}")
  public ResponseEntity<Student> getStudentById(@PathVariable("id") long id) {
    Student student = studentRepository.findById(id);

    if (student != null) {
      return new ResponseEntity<>(student, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

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

  @PutMapping("/{id}/fund")
  public ResponseEntity<String> allocateFunds(@PathVariable("id") long id, @RequestParam("amount") int amount) {
    int rowsAffected = studentRepository.allocateFunds(id, amount);
    if (rowsAffected >  0) {
      return new ResponseEntity<>("Funds allocated successfully.", HttpStatus.OK);
    } else {
      return new ResponseEntity<>("No student found with id=" + id, HttpStatus.NOT_FOUND);
    }
  }

   @DeleteMapping("/student/{id}")
   public ResponseEntity<String> deleteStudent(@PathVariable("id") long id) {
     try {
       int result = studentRepository.deleteById(id);
       if (result == 0) {
         return new ResponseEntity<>("Cannot find Student with id=" + id, HttpStatus.OK);
       }
       return new ResponseEntity<>("Student was deleted successfully.", HttpStatus.OK);
     } catch (Exception e) {
       return new ResponseEntity<>("Cannot delete Student.", HttpStatus.INTERNAL_SERVER_ERROR);
     }
   }

}