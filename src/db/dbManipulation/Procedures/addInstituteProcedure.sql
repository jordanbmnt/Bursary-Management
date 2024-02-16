USE BBD_BursaryDB;

GO
CREATE PROCEDURE AddInstitute
  @InstituteName VARCHAR(100),
  @PhoneNumber VARCHAR(12),
  @Email VARCHAR(320),
  @Accreditation VARCHAR(320)
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
  [dbo].[Institute_Info]
    (
    [InstituteName],
    [ContactDetailsID],
    [BBDBursaryInstituteStatus]
    )
  VALUES
    (@InstituteName, @NewContactDetailsID, 1);

  DECLARE @InstituteID INT;

  SET
  @InstituteID = SCOPE_IDENTITY();

  INSERT INTO
  [dbo].[Accreditation]
    ([Name])
  VALUES
    (@Accreditation);

  DECLARE @AccreditationID INT;

  SET
  @AccreditationID = SCOPE_IDENTITY();

  INSERT INTO
  [dbo].[Institute_Accreditation]
    ([AccreditationID], [InstituteID])
  VALUES
    (@AccreditationID, @InstituteID);

END;

GO