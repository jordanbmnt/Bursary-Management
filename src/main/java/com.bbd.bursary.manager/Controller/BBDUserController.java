package com.bbd.bursary.manager.Controller;

import java.util.ArrayList;
import java.util.List;
import com.bbd.bursary.manager.Model.User;
import  com.bbd.bursary.manager.Repository.BBDInterface;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/user")


public class BBDUserController {
    @Autowired
    BBDInterface bbdInterface;


    @GetMapping("/institutions/getAll")
    public ResponseEntity<List<User>> getAllInstitutions() {
        try {
            List<User> users = new ArrayList<User>();

            bbdInterface.findAllInstitutions().forEach(users::add);
            if (users.isEmpty()) {
                System.out.println("Entered");
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(users, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateTutorial(@PathVariable("id") long id, @RequestBody User user) {
        User _user = bbdInterface.findById(id);

        if (_user != null) {
            _user.setUserId(id);
            _user.setFirstName(user.getFirstName());
            _user.setLastName(user.getLastName());
            _user.setEmail(user.getEmail());
            _user.setPhoneNumber(user.getPhoneNumber());

            bbdInterface.update(_user);
            return new ResponseEntity<>("User was updated successfully.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Cannot find user id=", HttpStatus.NOT_FOUND);
        }
    }
}
