package com.bbd.bursary.manager.repository;

import java.util.List;

public interface StudentInterface {

    int save(Student student);

    int update(Student student);

    Student findById(Long id);

    int deleteById(Long id);
    int allocateFunds(long id, int amount);


}
