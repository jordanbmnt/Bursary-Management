package com.bbd.bursary.manager.Repository;

//import com.bbd.bursary.manager.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.stereotype.Repository;
import com.bbd.bursary.manager.Model.User;
import com.bbd.bursary.manager.Model.Institute;

import java.util.List;
@Repository
public class jbdcUserRepository implements BBDInterface {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int save(User user) {
       final String sql = "EXEC [BBD_BursaryDB].[dbo].[addBBDUserProcedure] @FirstName = ?, @LastName = ?, @PhoneNumber = ?, @Email = ?;";
        return jdbcTemplate.update(
                sql,
                new Object[]{user.getFirstName(), user.getLastName(), user.getPhoneNumber(), user.getEmail()});
    }

    @Override
    public int update(User user) {
       final String sql = "EXEC [BBD_BursaryDB].[dbo].[UpdateBBDUserInfo] @UserId =  ?, @FirstName = ?, @LastName = ?, @Email = ?, @PhoneNumber = ?";
        return jdbcTemplate.update(sql,
                new Object[]{user.getUserId(), user.getFirstName(), user.getLastName(), user.getEmail(), user.getPhoneNumber()});
    }

    @Override
    public User findById(Long id) {
        try {
           final String sql = "SELECT * FROM User_Details WHERE UserID=?";
            User user = jdbcTemplate.queryForObject(sql,
                    BeanPropertyRowMapper.newInstance(User.class), id);
            return user;
        } catch (IncorrectResultSizeDataAccessException e) {
            return null;
        }
    }
    @Override
    public int deleteUserById(Long id) {
       final String sql = "EXEC [BBD_BursaryDB].[dbo].[DeleteBBDUserById] @UserId=?";
        return jdbcTemplate.update(sql, id);
    }

    @Override
    public List<Institute> findAllPendingInstitutions() {
        final String sql = "SELECT * from pending_institutions";
        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Institute.class));
    }

    @Override
    public List<Institute> findAllRejectedInstitutions() {
        final String sql = "SELECT * from rejected_institutions";
        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Institute.class));
    }

    public List<Institute> findAllFundedInstitutions() {
        final String sql = "SELECT * from funded_institutions";
        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Institute.class));
    }

    @Override
    public int allocateFunds(long id, int amount) {
       final String sql = "UPDATE [BBD_BursaryDB].[dbo].[Institution_Fund_Allocation] SET AllocatedAmount=? WHERE InstituteID=?";
        return jdbcTemplate.update(
                sql,
                amount, id);
    }


    @Override
    public List<Institute> findAllInstitutions() {
       final String sql = "SELECT * from Institute_Info";
        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Institute.class));
    }

}
