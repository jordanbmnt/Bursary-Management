
package com.bbd.bursary.manager.Repository;

import com.bbd.bursary.manager.Model.Institute;

import java.util.List;

public interface InstituteInterface {
    int save(Institute institute);

    int update(Institute institute);

    Institute findById(Long id);

    int deleteById(Long id);

    List<Institute > findAllStudents();

    int getBudget(long id);

}
