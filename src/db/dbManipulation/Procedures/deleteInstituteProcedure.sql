USE BBD_BursaryDB;
GO

CREATE PROCEDURE dbo.DeleteInstitution
  @InstituteID INT
AS
BEGIN
  DECLARE @ContactDetailsID INT;
  DECLARE @UserID INT;

  SELECT @ContactDetailsID = ContactDetailsID
  FROM dbo.Institute_Info
  WHERE InstituteID = @InstituteID;

  SELECT @UserID = UserID
  FROM dbo.User_Details
  WHERE ContactDetailsID = @ContactDetailsID;

  DELETE FROM dbo.User_Details WHERE UserID = @UserID;

  DELETE FROM dbo.Contact_Details WHERE ContactDetailsID = @ContactDetailsID;

  DELETE FROM dbo.Institute_Info WHERE InstituteID = @InstituteID;
END;
GO
