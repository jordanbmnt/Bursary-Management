package com.bbd.bursary.manager.Controller;

import java.util.ArrayList;
import java.util.List;

import com.bbd.bursary.manager.Model.User;
import com.bbd.bursary.manager.Repository.BBDInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/user")
public class BBDUserController {

    @Autowired
    BBDInterface bbdInterface;

    @GetMapping("/institutions")
    public ResponseEntity<List<User>> getAllInstitutions() {
        try {
            List<User> users = bbdInterface.findAllInstitutions();
            if (users.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(users, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public ResponseEntity<List<User>> getUsers() {
        List<User> users = bbdInterface.getAll();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }



    @PostMapping("/createUser")
    public ResponseEntity<String> createUser(@RequestBody User user) {
        try {
            bbdInterface.save(user);
            return new ResponseEntity<>("User was created successfully.", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PutMapping("/allocatedFunds/{id}")
    public ResponseEntity<String> allocateYearlyFund(@PathVariable("id") long id) {
        try {
            bbdInterface.allocateFundsToAllInstitutes(id);
            return new ResponseEntity<>("Funds were successfully allocated.", HttpStatus.CREATED);
        } catch (Exception e) {
            System.out.print(e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") long id) {
        try {
            int result = bbdInterface.deleteById(id);
            if (result == 0) {
                return new ResponseEntity<>("Cannot find User with id=" + id, HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>("User was deleted successfully.", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Cannot delete User.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
