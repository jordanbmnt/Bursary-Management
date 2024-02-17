package com.bbd.bursary.manager.repository;

import java.util.List;

public interface BBDInterface {
    int save(BBDAdmin bbdAdmin);

    int update(BBDAdmin bbdAdmin);

    int deleteById(Long id);

    int allocateFunds(long id, int amount);
    List<Institution> findAllInstitutions();
}
