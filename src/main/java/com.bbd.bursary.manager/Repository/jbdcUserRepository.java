package com.bbd.bursary.manager.Repository;

<<<<<<< HEAD:src/main/java/com.bbd.bursary.manager/Repository/JbdcUserRepository.java

import com.bbd.bursary.manager.Model.User;
=======
>>>>>>> 669ff6c2324b996a08975497ddd73a74bf72776c:src/main/java/com.bbd.bursary.manager/Repository/jbdcUserRepository.java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
<<<<<<< HEAD:src/main/java/com.bbd.bursary.manager/Repository/JbdcUserRepository.java
=======
import com.bbd.bursary.manager.Model.User;
import com.bbd.bursary.manager.Model.Institute;
>>>>>>> 669ff6c2324b996a08975497ddd73a74bf72776c:src/main/java/com.bbd.bursary.manager/Repository/jbdcUserRepository.java

import java.util.List;
@Repository
public class jbdcUserRepository implements BBDInterface {
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
<<<<<<< HEAD:src/main/java/com.bbd.bursary.manager/Repository/JbdcUserRepository.java
        return null;
=======
        try {
           final String sql = "SELECT * FROM User_Details WHERE UserID=?";
            User user = jdbcTemplate.queryForObject(sql,
                    BeanPropertyRowMapper.newInstance(User.class), id);
            return user;
        } catch (IncorrectResultSizeDataAccessException e) {
            return null;
        }
>>>>>>> 669ff6c2324b996a08975497ddd73a74bf72776c:src/main/java/com.bbd.bursary.manager/Repository/jbdcUserRepository.java
    }

    @Override
    public int deleteUserById(Long id) {
        return jdbcTemplate.update("EXEC [BBD_BursaryDB].[dbo].[DeleteBBDUserById] @UserId=?", id);
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
<<<<<<< HEAD:src/main/java/com.bbd.bursary.manager/Repository/JbdcUserRepository.java
=======
       final String sql = "UPDATE [BBD_BursaryDB].[dbo].[Institution_Fund_Allocation] SET AllocatedAmount=? WHERE InstituteID=?";
>>>>>>> 669ff6c2324b996a08975497ddd73a74bf72776c:src/main/java/com.bbd.bursary.manager/Repository/jbdcUserRepository.java
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
<<<<<<< HEAD:src/main/java/com.bbd.bursary.manager/Repository/JbdcUserRepository.java
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
=======
    public List<Institute> findAllInstitutions() {
       final String sql = "SELECT * from Institute_Info";
        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Institute.class));
>>>>>>> 669ff6c2324b996a08975497ddd73a74bf72776c:src/main/java/com.bbd.bursary.manager/Repository/jbdcUserRepository.java
    }

}
