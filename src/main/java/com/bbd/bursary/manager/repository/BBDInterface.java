package com.bbd.bursary.manager.repository;

import java.util.List;

public interface BBDInterface {
    List create(BBDAdmin bbdAdmin);
    int save(BBDAdmin bbdAdmin);

    int update(BBDAdmin bbdAdmin);

    int allocateFunds(long id, int fund);
    List<User> findAllInstitutions();
}
