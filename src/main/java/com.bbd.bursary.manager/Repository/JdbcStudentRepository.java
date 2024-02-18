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
    return jdbcTemplate.update(
        "EXEC [BBD_BursaryDB].[dbo].[AddStudent] @FirstName = ?, @LastName = ?, @PhoneNumber = ?, @Email = ?, @RaceID = ?, @ID_Number = ?, @HeadOfDepartmentID = ?, @Motivation = ?;",
        new Object[] { student.getFirstName(), student.getLastName(), student.getPhoneNumber(), student.getEmail(),
            student.getRace(), student.getIdentityDocument(), student.getHeadOfDepartmentID(),
            student.getMotivation() });
  }

  @Override
  public int update(Student student) {
    return jdbcTemplate.update(
        "EXEC [BBD_BursaryDB].[dbo].[UpdateStudentInfoIfPending] @StudentId =  ?, @FirstName = ?, @LastName = ?, @Email = ?, @PhoneNumber = ?",
        new Object[] { student.getStudentId(), student.getFirstName(), student.getLastName(), student.getEmail(),
            student.getPhoneNumber() });
  }

  @Override
  public Student findById(Long id) {
    try {
      return jdbcTemplate.queryForObject(
          "SELECT * FROM [BBD_BursaryDB].[dbo].[StudentDetails] WHERE StudentId=?",
          BeanPropertyRowMapper.newInstance(Student.class), id);
    } catch (IncorrectResultSizeDataAccessException e) {
      return null;
    }
  }

  @Override
  public int deleteById(Long id) {
    return jdbcTemplate.update("EXEC [BBD_BursaryDB].[dbo].[DeleteStudentById] @StudentId=?", id);
  }

  @Override
  public int allocateFunds(long id, int amount) {
    return jdbcTemplate.update(
        "UPDATE [BBD_BursaryDB].[dbo].[Bursary_Applicants] SET BursaryAmount=? WHERE StudentID=?",
        amount, id);
  }

  @Override
  public int updateStudentStatus(long id, int statusID) {
    return jdbcTemplate.update(
        "UPDATE [BBD_BursaryDB].[dbo].[Bursary_Applicants] SET BursaryAmount=? WHERE StudentID=?",
        statusID, id);
  }

  @Override
  public List<Student> getAll() {
    return jdbcTemplate.query("SELECT * FROM [BBD_BursaryDB].[dbo].[StudentDetails]",
        BeanPropertyRowMapper.newInstance(Student.class));
  }

  @Override
  public List<Student> getAllApproved() {
    return jdbcTemplate.query("SELECT * FROM [BBD_BursaryDB].[dbo].[AcceptedStudents]",
        BeanPropertyRowMapper.newInstance(Student.class));
  }


  @Override
  public List<Student> getAllRejected() {
    return jdbcTemplate.query("SELECT * FROM [BBD_BursaryDB].[dbo].[RejectedStudents]",
            BeanPropertyRowMapper.newInstance(Student.class));
  }
}
