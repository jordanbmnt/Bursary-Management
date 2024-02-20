package com.bbd.bursary.manager.Repository;

import com.bbd.bursary.manager.Model.User;

import java.util.List;
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
    List<Institute> findAllInstitutions();
}
