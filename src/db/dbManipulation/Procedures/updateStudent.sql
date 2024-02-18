CREATE PROCEDURE UpdateStudentInfoIfPending
  @StudentId INT,
  @FirstName NVARCHAR(100),
  @LastName NVARCHAR(100),
  @Email NVARCHAR(320),
  @PhoneNumber NVARCHAR(12)
AS
BEGIN
  IF EXISTS (
        SELECT 1
  FROM [dbo].[Bursary_Applicants]
    INNER JOIN [dbo].[Application_Status] ON [Bursary_Applicants].[BursaryApplicantStatus] = [Application_Status].[Index]
  WHERE [Bursary_Applicants].[StudentID] = @StudentId AND [Application_Status].[Status] = 'pending'
    )
    BEGIN
    UPDATE [dbo].[User_Details]
        SET FirstName = @FirstName, LastName = @LastName
        WHERE UserID = (SELECT UserID
    FROM [dbo].[Student]
    WHERE StudentID = @StudentId);

    UPDATE [dbo].[Contact_Details]
        SET Email = @Email, PhoneNumber = @PhoneNumber
        WHERE ContactDetailsID = (SELECT ContactDetailsID
    FROM [dbo].[User_Details]
    WHERE UserID = (SELECT [UserID]
    FROM [dbo].[Student]
    WHERE StudentID = @StudentId));
  END
    ELSE
    BEGIN
    PRINT 'Student status is not pending. Update not performed.';
  END
END;
