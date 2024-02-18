USE BBD_BursaryDB;

GO
CREATE PROCEDURE AddStudent
  @FirstName VARCHAR(100),
  @LastName VARCHAR(100),
  @PhoneNumber VARCHAR(12),
  @Email VARCHAR(320),
  @RaceID INT,
  @ID_Number CHAR(13),
  @HeadOfDepartmentID INT,
  @Motivation VARBINARY
AS
BEGIN
  SET
  NOCOUNT ON;

  INSERT INTO
  [dbo].[Contact_Details]
    ([PhoneNumber], [Email])
  VALUES
    (@PhoneNumber, @Email);

  DECLARE @NewContactDetailsID INT;

  SET
  @NewContactDetailsID = SCOPE_IDENTITY();

  INSERT INTO
  [dbo].[User_Details]
    (
    [FirstName],
    [LastName],
    [ContactDetailsID],
    [RoleID]
    )
  VALUES
    (@FirstName, @LastName, @NewContactDetailsID, 3);

  DECLARE @NewUserID INT;

  SET
  @NewUserID = SCOPE_IDENTITY();

  INSERT INTO
  [dbo].[Student]
    ([UserID], [ID_Number], [RaceID])
  VALUES
    (@NewUserID, @ID_Number, @RaceID);

  DECLARE @NewStudentID INT;

  SET
  @NewStudentID = SCOPE_IDENTITY();

  INSERT INTO
  [dbo].[Bursary_Applicants]
    (
    [StudentID],
    [HeadOfDepartmentID],
    [BursaryAmount],
    [Motivation],
    [BursaryApplicantStatus]
    )
  VALUES
    (
      @NewStudentID,
      @HeadOfDepartmentID,
      0,
      @Motivation,
      1
  );

END;

GO