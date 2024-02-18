package com.bbd.bursary.manager.Controller;

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
import org.springframework.web.bind.annotation.RestController;

import com.bbd.bursary.manager.Repository.StudentInterface;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/student")
public class studentController {

  @Autowired
  StudentInterface studentRepository;

  @GetMapping("/student/{id}")
  public ResponseEntity<Student> getTutorialById(@PathVariable("id") long id) {
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

  @PutMapping("/student/{id}")
  public ResponseEntity<String> updateStudent(@PathVariable("id") long id, @RequestBody Student student) {
    Student _student = studentRepository.findById(id);

    if (_student != null) {
      _student.setStudentId(id);
      _student.setFirstName(student.getFirstName());
      _student.setLastName(student.getLastName());
      _student.setPhoneNumber(student.getPhoneNumber());
      _student.setIdentityDocument(student.getIdentityDocument());
      _student.setHeadOfDepartmentID(student.getHeadOfDepartmentID());
      _student.setMotivation(student.getMotivation());
      _student.setEmail(student.getEmail());
      _student.setRace(student.getRace());

      studentRepository.update(_student);
      return new ResponseEntity<>("Tutorial was updated successfully.", HttpStatus.OK);
    } else {
      return new ResponseEntity<>("Cannot find Tutorial with id=" + id, HttpStatus.NOT_FOUND);
    }
  }

   @DeleteMapping("/student/{id}")
   public ResponseEntity<String> deleteStudent(@PathVariable("id") long id) {
     try {
       int result = studentRepository.deleteById(id);
       if (result == 0) {
         return new ResponseEntity<>("Cannot find Tutorial with id=" + id, HttpStatus.OK);
       }
       return new ResponseEntity<>("Tutorial was deleted successfully.", HttpStatus.OK);
     } catch (Exception e) {
       return new ResponseEntity<>("Cannot delete tutorial.", HttpStatus.INTERNAL_SERVER_ERROR);
     }
   }

  // @GetMapping("/student/published")
  // public ResponseEntity<List<Tutorial>> findByPublished() {
  //   try {
  //     List<Tutorial> tutorials = tutorialRepository.findByPublished(true);

  //     if (tutorials.isEmpty()) {
  //       return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  //     }
  //     return new ResponseEntity<>(tutorials, HttpStatus.OK);
  //   } catch (Exception e) {
  //     return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
  //   }
  // }

}