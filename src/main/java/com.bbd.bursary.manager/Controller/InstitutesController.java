package com.bbd.bursary.manager.Controller;

import com.bbd.bursary.manager.Model.Institute;
import com.bbd.bursary.manager.Repository.JdbcInstituteRepository;
import com.bbd.bursary.manager.Repository.InstituteInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/institute")
public class InstitutesController {

    @Autowired
    InstituteInterface instituteRepository;

//    @GetMapping
//    public ResponseEntity<List<Institute>> getAllInstitutes() {
//        List<Institute> institutes = instituteRepository.getAllInstitutes();
//        if(institutes == null) {
//            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
//        } else {
//           return new ResponseEntity<>(institutes, HttpStatus.OK);
//        }
//    }

    @PostMapping
    public ResponseEntity<String> addInstitute(@RequestBody Institute institute) {
        try {
            instituteRepository.save(institute);
            return new ResponseEntity<>("Institute was created successfully.", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/funds/{id}")
    public ResponseEntity<String> allocateInstituteFunds(@RequestBody() double amount, @PathVariable("id") int id) {

            int rowsAffected = instituteRepository.updateFunds(amount, id);
            if(rowsAffected > 0) {
                return new ResponseEntity<>("Funds allocated successfully", HttpStatus.OK);
            } else {
                System.out.print("rowsAffected" + rowsAffected);
                return new ResponseEntity<>("No student found with id=" + id, HttpStatus.NOT_FOUND);
            }
    }

    @PutMapping("/status/{id}")
    public ResponseEntity<String> updateInstitutePendingStatus(@PathVariable("id") int instituteId, @RequestParam("instituteId") int status) {

        int rowsAffected = instituteRepository.updateStatus(instituteId, status);
        if(rowsAffected > 0) {
            return new ResponseEntity<>("Status updated successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("No institute found with id=" + instituteId, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteInstitution(@PathVariable("id") long id) {
        try {
            int result = instituteRepository.deleteById(id);
            if(result == 0) {
                return new ResponseEntity<>("Cannot find institute with id" + id, HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>("Institute was deleted successfully.", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Cannot delete institute.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
