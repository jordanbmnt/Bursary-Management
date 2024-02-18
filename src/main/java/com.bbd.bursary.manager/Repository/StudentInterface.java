package com.bbd.bursary.manager.Repository;

import com.bbd.bursary.manager.Model.Student;

import java.util.List;

public interface StudentInterface {

    int save(Student student);

    List<Student> getAll();

    List<Student> getAllApproved();

    int update(Student student);

    Student findById(Long id);

    int deleteById(Long id);

    int allocateFunds(long id, int amount);

    int updateStudentStatus(long id, int statusID);
}
