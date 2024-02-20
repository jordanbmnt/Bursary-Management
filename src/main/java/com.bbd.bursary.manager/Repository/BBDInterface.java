package com.bbd.bursary.manager.Repository;

import java.util.List;

import com.bbd.bursary.manager.Model.Student;
import com.bbd.bursary.manager.Model.User;
import com.bbd.bursary.manager.Model.Institute;

public interface BBDInterface {
    int save(User user);

    int update(User user);
    User findById(Long id);
    int deleteUserById(Long id);

    List<Institute> findAllPendingInstitutions();
    List<Institute> findAllRejectedInstitutions();
    List<Institute> findAllFundedInstitutions();

    int allocateFunds(long id, int amount);
<<<<<<< HEAD

    int allocateFundsToAllInstitutes(long id);

    List<User> findAllInstitutions();

    // New method to delete by ID
    int deleteById(Long id);
    User getUserById(Long id);

    List<User> getAll();
=======
    List<Institute> findAllInstitutions();
>>>>>>> 669ff6c2324b996a08975497ddd73a74bf72776c
}
