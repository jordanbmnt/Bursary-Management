package com.bbd.bursary.manager.Controller;

import com.bbd.bursary.manager.Model.Institute;
import com.bbd.bursary.manager.Repository.JdbcInstituteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/institute")
public class InstitutesController {

    JdbcInstituteRepository jdbcInstituteRepository;
    @Autowired
    @PostMapping("/institute")
    public ResponseEntity<String> addInstitute(@RequestBody Institute institute) {
        try {
            jdbcInstituteRepository.save(institute);
            return new ResponseEntity<>("Institute was created successfully.", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/institute/{id}")
    public ResponseEntity<String> allocateInstituteFunds(@PathVariable("id") int instituteId, @RequestParam("amount") double allocatedAmount) {

            int rowsAffected = jdbcInstituteRepository.updateFunds(instituteId, allocatedAmount);
            if(rowsAffected > 0) {
                return new ResponseEntity<>("Funds allocated successfully", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("No student found with id=" + id, HttpStatus.NOT_FOUND);
            }
    }
}
