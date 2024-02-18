package com.bbd.bursary.manager.Repository;

import com.bbd.bursary.manager.Model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JdbcStudentRepository implements StudentInterface {

  @Autowired
  private JdbcTemplate jdbcTemplate;

  @Override
  public int save(Student student) {
    String sql = "EXEC [BBD_BursaryDB].[dbo].[AddStudent] @FirstName = ?, @LastName = ?, @PhoneNumber = ?, @Email = ?, @RaceID = ?, @ID_Number = ?, @HeadOfDepartmentID = ?, @Motivation = ?;";
    return jdbcTemplate.update(
        sql,
        new Object[] { student.getFirstName(), student.getLastName(), student.getPhoneNumber(), student.getEmail(),
            student.getRace(), student.getIdentityDocument(), student.getHeadOfDepartmentID(),
            student.getMotivation() });
  }

  @Override
  public int update(Student student) {
    String sql = "EXEC [BBD_BursaryDB].[dbo].[UpdateStudentInfoIfPending] @StudentId =  ?, @FirstName = ?, @LastName = ?, @Email = ?, @PhoneNumber = ?";
    return jdbcTemplate.update(
        sql,
        new Object[] { student.getStudentId(), student.getFirstName(), student.getLastName(), student.getEmail(),
            student.getPhoneNumber() });
  }

  @Override
  public Student findById(Long id) {
    String sql = "SELECT * FROM [BBD_BursaryDB].[dbo].[StudentDetails] WHERE StudentId=?";
    try {
      return jdbcTemplate.queryForObject(
          sql,
          BeanPropertyRowMapper.newInstance(Student.class), id);
    } catch (IncorrectResultSizeDataAccessException e) {
      return null;
    }
  }

  @Override
  public int deleteById(Long id) {
    String sql = "EXEC [BBD_BursaryDB].[dbo].[DeleteStudentById] @StudentId=?";
    return jdbcTemplate.update(sql, id);
  }

  @Override
  public int allocateFunds(long id, int amount) {
    String sql = "UPDATE [BBD_BursaryDB].[dbo].[Bursary_Applicants] SET BursaryAmount=? WHERE StudentID=?";
    return jdbcTemplate.update(
        sql,
        amount, id);
  }

  @Override
  public int updateStudentStatus(long id, int statusID) {
    String sql = "UPDATE [BBD_BursaryDB].[dbo].[Bursary_Applicants] SET BursaryAmount=? WHERE StudentID=?";
    return jdbcTemplate.update(
        sql,
        statusID, id);
  }

  @Override
  public List<Student> getAll() {
    String sql = "SELECT * FROM [BBD_BursaryDB].[dbo].[StudentDetails]";
    return jdbcTemplate.query(sql,
        BeanPropertyRowMapper.newInstance(Student.class));
  }

  @Override
  public List<Student> getAllApproved() {
    String sql = "SELECT * FROM [BBD_BursaryDB].[dbo].[AcceptedStudents]";
    return jdbcTemplate.query(sql,
        BeanPropertyRowMapper.newInstance(Student.class));
  }


  @Override
  public List<Student> getAllRejected() {
    String sql = "SELECT * FROM [BBD_BursaryDB].[dbo].[RejectedStudents]";
    return jdbcTemplate.query(sql,
            BeanPropertyRowMapper.newInstance(Student.class));
  }

  @Override
  public List<Student> getAllPending() {
    String sql = "SELECT * FROM [BBD_BursaryDB].[dbo].[PendingStudents]";
    return jdbcTemplate.query(sql,
            BeanPropertyRowMapper.newInstance(Student.class));
  }
}
