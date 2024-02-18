package com.bbd.bursary.manager.Repository;

import com.bbd.bursary.manager.Model.User;

import java.util.List;


public interface BBDInterface {
    int save(User bbdUser);

    int update(User bbdUser);

    int deleteUserById(Long id);

    int allocateFunds(long id, int amount);
//    List<Institution> findAllInstitutions();
}
