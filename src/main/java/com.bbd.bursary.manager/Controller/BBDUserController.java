package com.bbd.bursary.manager.Controller;

import java.util.ArrayList;
import java.util.List;

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

import com.bbd.bursary.manager.Model.User;
import com.bbd.bursary.manager.Repository.BBDInterface;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")


public class BBDUserController {
    @Autowired
    BBDInterface bbdInterface;


    @GetMapping("/institutions")
    public ResponseEntity<List<User>> getAllInstitutions() {
        try {
            List<User> users = new ArrayList<User>();

            bbdInterface.findAllInstitutions().forEach(users::add);
            if (users.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(users, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
