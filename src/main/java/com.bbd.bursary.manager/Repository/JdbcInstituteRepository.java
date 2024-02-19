package com.bbd.bursary.manager.Repository;

import com.bbd.bursary.manager.Model.Institute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcInstituteRepository implements InstituteInterface {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int save(Institute institute) {
        String sql = "EXEC [BBD_BursaryDB].[dbo].[InsertInstitution] @InstituteName = ?, @PhoneNumber = ?, @Email = ?, @BBDBursaryInstituteStatus = ?;";
        return jdbcTemplate.update(sql,
                new Object[] {
                        institute.getInstituteName(),
                        institute.getPhoneNumber(),
                        institute.getEmail(),
                        institute.getBbdBursaryInstituteStatus(),
                        institute.getAllocatedAmount()
                });
    }

    @Override
    public int updateFunds(int id, double amount) {
        String sql = "EXEC [BBD_BursaryDB].[dbo].[InsertInstitution]  @InstituteID = ?, @InstituteName = ?, @PhoneNumber = ?, @Email = ?, @BBDBursaryInstituteStatus = ?;";
        return jdbcTemplate.update(sql, id, amount);
    }

    @Override
    public int updateStatus(int id, String status) {
        String sql = "UPDATE Institute_info SET BBDBursaryInstituteStatus = ? WHERE InstituteID = ?;";
        return jdbcTemplate.update(sql, id, status);
    }
}
