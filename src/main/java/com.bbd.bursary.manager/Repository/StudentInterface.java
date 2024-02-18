package com.bbd.bursary.manager.Repository;

import com.bbd.bursary.manager.Model.Student;

import java.util.List;

public interface StudentInterface {

    int save(Student student);

    int update(Student student);

    Student findById(Long studentId);

    int deleteById(Long id);

    int allocateFunds(long id, int amount);

    int updateStudentStatus(long id, int statusID);

    List<Student> getAll();

    List<Student> getAllApproved();

    List<Student> getAllRejected();

    List<Student> getAllPending();
}
