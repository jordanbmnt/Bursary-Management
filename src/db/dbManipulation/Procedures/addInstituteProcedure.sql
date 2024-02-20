USE BBD_BursaryDB;

GO
CREATE PROCEDURE dbo.InsertInstitution
  @InstituteName VARCHAR(100),
  @PhoneNumber VARCHAR(12),
  @Email VARCHAR(320),
  @BBDBursaryInstituteStatus INT
AS
BEGIN

  INSERT INTO dbo.Contact_Details
    (PhoneNumber, Email)
  VALUES
    (@PhoneNumber, @Email);

  DECLARE @NewContactDetailsID INT;
  SET @NewContactDetailsID = SCOPE_IDENTITY();

  INSERT INTO dbo.Institute_Info
    (InstituteName, ContactDetailsID, BBDBursaryInstituteStatus)
  VALUES
    (@InstituteName, @NewContactDetailsID, @BBDBursaryInstituteStatus);
END;
GO
