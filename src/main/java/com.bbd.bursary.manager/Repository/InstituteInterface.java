package com.bbd.bursary.manager.Repository;

import com.bbd.bursary.manager.Model.Institute;
import com.bbd.bursary.manager.Model.Student;

import java.util.List;

public interface InstituteInterface {
    void save(Institute institute);

    int update(Institute institute);

    int updateFunds(int id, double amount);

    int updateStatus(int id, String status);

    List<Student> getAllInstitutes();

    Institute findById(Long instituteId);

    int deleteById(Long id);

}