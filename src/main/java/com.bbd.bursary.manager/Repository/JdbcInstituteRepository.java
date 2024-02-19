package com.bbd.bursary.manager.Repository;
import com.bbd.bursary.manager.Model.Institute;
import com.bbd.bursary.manager.Model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JdbcInstituteRepository implements InstituteInterface {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Institute> getAllInstitutes() {
        String sql = "SELECT * FROM [BBD_BursaryDB].[dbo].[viewAllInstitutions];";
        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Institute.class));
    }

    @Override
    public void save(Institute institute) {
        String sql = "EXEC [BBD_BursaryDB].[dbo].[InsertInstitution] @InstituteName = ?, @PhoneNumber = ?, @Email = ?, @BBDBursaryInstituteStatus = ?;";
        jdbcTemplate.update(sql,
                new Object[]{
                        institute.getInstituteName(),
                        institute.getPhoneNumber(),
                        institute.getEmail(),
                        institute.getBbdBursaryInstituteStatus(),
                        institute.getAllocatedAmount()
                });
    }

    @Override
    public int update(Institute institute) {
        return 0;
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

    @Override
    public Institute findById(Long instituteId) {
        return null;
    }

    @Override
    public int deleteById(Long id) {
        String sql = "EXEC [BBD_BursaryDB].[dbo].[DeleteInstitutionById] @InstituteID = ?";
        return jdbcTemplate.update(sql, id);
    }
}
