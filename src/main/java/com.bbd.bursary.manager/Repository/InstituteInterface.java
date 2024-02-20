package com.bbd.bursary.manager.Repository;

import com.bbd.bursary.manager.Model.Institute;

import java.util.List;

public interface InstituteInterface {
    void save(Institute institute);

    int update(Institute institute);

    int updateFunds(double amount, int id);

    int updateStatus(int id, int status);

    List<Institute> getAllInstitutes();


    Institute findById(Long instituteId);

    int deleteById(Long id);

}
