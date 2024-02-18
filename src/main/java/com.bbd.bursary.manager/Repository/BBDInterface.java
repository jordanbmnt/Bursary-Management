package com.bbd.bursary.manager.Repository;

import java.util.List;
import com.bbd.bursary.manager.Model.User;

public interface BBDInterface {
    int save(User user);

    int update(User user);

    int deleteUserById(Long id);

    int allocateFunds(long id, int amount);
    List<User> findAllInstitutions();
}
