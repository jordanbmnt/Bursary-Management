USE BBD_BursaryDB;
GO

CREATE PROCEDURE dbo.DeleteInstitution
  @InstituteID INT
AS
BEGIN
  DECLARE @ContactDetailsID INT;
  SELECT @ContactDetailsID = ContactDetailsID
  FROM dbo.Institute_Info
  WHERE InstituteID = @InstituteID;

  DELETE FROM dbo.Head_Of_Department
  WHERE UserID IN (SELECT UserID FROM dbo.User_Details WHERE ContactDetailsID = @ContactDetailsID);

  DELETE FROM dbo.Contact_Details WHERE ContactDetailsID = @ContactDetailsID;

  DELETE FROM dbo.Institute_Info WHERE InstituteID = @InstituteID;
END;
GO
