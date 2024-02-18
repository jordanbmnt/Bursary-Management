CREATE PROCEDURE DeleteBBDUserById
  @UserID INT
AS
BEGIN

  IF EXISTS (SELECT 1
  FROM User_Details
  WHERE UserID = @UserID)
    BEGIN
    DELETE FROM Bursary_Applicants WHERE StudentID = @StudentId;
  END

  IF EXISTS (SELECT 1
  FROM Bursary_Applicant_Grades
  WHERE BursaryApplicantID IN (SELECT BursaryApplicantID
  FROM Bursary_Applicants
  WHERE StudentID = @StudentId))
    BEGIN
    DELETE FROM Bursary_Applicant_Grades WHERE BursaryApplicantID IN (SELECT BursaryApplicantID
    FROM Bursary_Applicants
    WHERE StudentID = @StudentId);
  END

  DELETE FROM Student WHERE StudentID = @StudentId;
END;