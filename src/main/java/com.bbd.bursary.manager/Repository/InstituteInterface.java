package com.bbd.bursary.manager.Repository;

import com.bbd.bursary.manager.Model.Institute;
import org.springframework.context.annotation.Bean;

import java.util.List;

public interface InstituteInterface {
    int save(Institute institute);

    int update(Institute institute);

    int updateFunds(int id, double amount);

    int updateStatus(int id, String status);

    Institute findById(Long instituteId);

    int deleteById(Long id);

}