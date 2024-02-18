USE BBD_BursaryDB;

GO

CREATE PROCEDURE dbo.UpdateInstitution
  @InstituteID INT,
  @InstituteName VARCHAR(100),
  @PhoneNumber VARCHAR(12),
  @Email VARCHAR(320),
  @BBDBursaryInstituteStatus INT
AS
BEGIN

  UPDATE dbo.Contact_Details
    SET PhoneNumber = @PhoneNumber,
        Email = @Email
    WHERE ContactDetailsID = (SELECT ContactDetailsID
  FROM dbo.Institute_Info
  WHERE InstituteID = @InstituteID);

  UPDATE dbo.Institute_Info
    SET InstituteName = @InstituteName,
        BBDBursaryInstituteStatus = @BBDBursaryInstituteStatus
    WHERE InstituteID = @InstituteID;
END;
GO
