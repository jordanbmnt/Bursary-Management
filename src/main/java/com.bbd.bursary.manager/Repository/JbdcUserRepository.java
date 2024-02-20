package com.bbd.bursary.manager.Repository;


import com.bbd.bursary.manager.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class JbdcUserRepository implements BBDInterface {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int save(User user) {
        return jdbcTemplate.update(
                "EXEC [BBD_BursaryDB].[dbo].[addBBDUser] @FirstName = ?, @LastName = ?, @PhoneNumber = ?, @Email = ?;",
                new Object[]{user.getFirstName(), user.getLastName(), user.getPhoneNumber(), user.getEmail()});
    }

    @Override
    public int update(User user) {
        return jdbcTemplate.update("EXEC [BBD_BursaryDB].[dbo].[UpdateBBDUserInfo] @UserId =  ?, @FirstName = ?, @LastName = ?, @Email = ?, @PhoneNumber = ?",
                new Object[]{user.getUserId(), user.getFirstName(), user.getLastName(), user.getEmail(), user.getPhoneNumber()});
    }

    @Override
    public User findById(Long id) {
        return null;
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
    public int allocateFundsToAllInstitutes(long id) {
        return jdbcTemplate.update(
                "EXEC AllocateFundsToApplicants @BursaryFundID =  ?",
                id);
    }


    @Override
    public List<User> findAllInstitutions() {
        return jdbcTemplate.query("SELECT * FROM [dbo].[InstituteInformation]", BeanPropertyRowMapper.newInstance(User.class));
    }

    @Override
    public int deleteById(Long id) {
        return 0;
    }

    @Override
    public User getUserById(Long id) {
        return null;
    }

    @Override
    public List<User> getAll() {
        return null;
    }
}
