package com.bbd.bursary.manager.Repository;


import com.bbd.bursary.manager.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class jbdcUserRepository implements BBDInterface {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int save(User user) {
        return jdbcTemplate.update(
                "EXEC [BBD_BursaryDB].[dbo].[addBBDUserProcedure] @FirstName = ?, @LastName = ?, @PhoneNumber = ?, @Email = ?;",
                new Object[]{user.getFirstName(), user.getLastName(), user.getPhoneNumber(), user.getEmail()});
    }

    @Override
    public int update(User user) {
        return jdbcTemplate.update("EXEC [BBD_BursaryDB].[dbo].[UpdateBBDUserInfo] @UserId =  ?, @FirstName = ?, @LastName = ?, @Email = ?, @PhoneNumber = ?",
                new Object[]{user.getUserId(), user.getFirstName(), user.getLastName(), user.getEmail(), user.getPhoneNumber()});
    }

    @Override
    public User findById(Long id) {
        try {
            User user = jdbcTemplate.queryForObject("SELECT * FROM User_Details WHERE id=?",
                    BeanPropertyRowMapper.newInstance(User.class), id);

            return user;
        } catch (IncorrectResultSizeDataAccessException e) {
            return null;
        }
    }
    @Override
    public int deleteUserById(Long id) {
        return jdbcTemplate.update("EXEC [BBD_BursaryDB].[dbo].[DeleteBBDUserById] @UserId=?", id);
    }

    @Override
    public int allocateFunds(long id, int amount) {
        return jdbcTemplate.update(
                "UPDATE [BBD_BursaryDB].[dbo].[Institution_Fund_Allocation] SET AllocatedAmount=? WHERE UserID=?",
                amount, id);
    }


    @Override
    public List<User> findAllInstitutions() {
        return jdbcTemplate.query("SELECT * from Institute_Info", BeanPropertyRowMapper.newInstance(User.class));
    }
}
