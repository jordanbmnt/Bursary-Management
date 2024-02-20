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

    @GetMapping("/institutions/getAllInstitutions")
    public ResponseEntity<List<Institute>> getAllInstitutions() {
        try {
            List<Institute> institutes = bbdInterface.findAllInstitutions();

            if (institutes.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(institutes, HttpStatus.OK);
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
            
    @GetMapping("/institutions/getAllFundedInstitutions")
    public ResponseEntity<List<Institute>> getAllFundedInstitutions() {
        try {
            List<Institute> institutes = bbdInterface.findAllFundedInstitutions();

            if (institutes.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(institutes, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/institutions/getAllRejectedInstitutions")
    public ResponseEntity<List<Institute>> getAllRejectedInstitutions() {
        try {
            List<Institute> institutes = bbdInterface.findAllRejectedInstitutions();

            if (institutes.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(institutes, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/institutions/getAllPendingInstitutions")
    public ResponseEntity<List<Institute>> getAllPendingInstitutions() {
        try {
            List<Institute> institutes = bbdInterface.findAllPendingInstitutions();

            if (institutes.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(institutes, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") long id) {
        User user = bbdInterface.findById(id);

        if (user != null) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/institution/{id}")
    public ResponseEntity<String> allocateFunds(@PathVariable("id") long id, @RequestParam("amount") int amount) {
        int rowsAffected = bbdInterface.allocateFunds(id, amount);
        if (rowsAffected >  0) {
            return new ResponseEntity<>("Funds allocated successfully.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("No Institution found with that id", HttpStatus.NOT_FOUND);
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
            System.out.println(_user);
            bbdInterface.update(_user);
            return new ResponseEntity<>("User was updated successfully.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Cannot find user id=", HttpStatus.NOT_FOUND);
        }
    }
}
