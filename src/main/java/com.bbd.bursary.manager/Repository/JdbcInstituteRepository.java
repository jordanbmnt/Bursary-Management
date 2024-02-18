package com.bbd.bursary.manager.Repository;

import com.bbd.bursary.manager.Model.Institute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcInstituteRepository implements InstituteInterface {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int save(Institute institute) {
        return jdbcTemplate.update("EXEC [BBD_BursaryDB].[dbo].[InsertInstitution] @InstituteName = ?, @PhoneNumber = ?, @Email = ?, @BBDBursaryInstituteStatus = ?;",
                new Object[] {
                        institute.getInstituteName(),
                        institute.getPhoneNumber(),
                        institute.getEmail(),
                        institute.getBbdBursaryInstituteStatus()
                });
    }

    public int updateFunds(int id, double amount) {
        return jdbcTemplate.update("EXEC [BBD_BursaryDB].[dbo].[InsertInstitution]  @InstituteID = ?, @InstituteName = ?, @PhoneNumber = ?, @Email = ?, @BBDBursaryInstituteStatus = ?", id, amount);
    }

    public int updateStatus(Institute institute) {
        return jdbcTemplate.update("UPDATE Institute_info SET BBDBursaryInstituteStatus = ? WHERE InstituteID = ?",
                new Object[] { institute.getBbdBursaryInstituteStatus()}
                );
    }
}
