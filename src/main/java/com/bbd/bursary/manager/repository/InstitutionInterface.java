package com.bbd.bursary.manager.repository;

import java.util.List;

public interface InstitutionInterface {
    int save(Institution institution);

    int update(Institution institution);

    Institution findById(Long id);

    int deleteById(Long id);

    List<Institution > findAllStudents();

    int getBudget(long id);

}
