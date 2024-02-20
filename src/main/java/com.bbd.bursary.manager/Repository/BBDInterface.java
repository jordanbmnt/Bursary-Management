package com.bbd.bursary.manager.Repository;

import java.util.List;

import com.bbd.bursary.manager.Model.Student;
import com.bbd.bursary.manager.Model.User;

public interface BBDInterface {
    int save(User user);

    int update(User user);
    User findById(Long id);
    int deleteUserById(Long id);

    int allocateFunds(long id, int amount);

    int allocateFundsToAllInstitutes(long id);

    List<User> findAllInstitutions();

    // New method to delete by ID
    int deleteById(Long id);
    User getUserById(Long id);

    List<User> getAll();
}
