package com.bbd.bursary.manager.Controller;

import com.bbd.bursary.manager.Model.Institute;
import com.bbd.bursary.manager.Repository.JdbcInstituteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/institutes")
public class InstitutesController {

    JdbcInstituteRepository jdbcInstituteRepository;
    @Autowired
    @PostMapping("/tutorials")
    public ResponseEntity<String> createTutorial(@RequestBody Institute institute) {
        try {
            jdbcInstituteRepository.save(new Institute(institute.getTitle(), institute.getDescription(), false));
            return new ResponseEntity<>("Tutorial was created successfully.", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
