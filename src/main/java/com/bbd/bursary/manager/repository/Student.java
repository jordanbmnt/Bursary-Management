package com.bbd.bursary.manager.repository;

import java.util.List;

public interface Student {

    List create(Student student);
    int save(Student student);

    int update(Student student);

    Student findById(Long id);

    int deleteById(Long id);
    int allocateFunds(long id, int fund);


}
