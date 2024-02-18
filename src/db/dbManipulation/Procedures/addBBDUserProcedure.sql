USE BBD_BursaryDB;

GO
CREATE PROCEDURE AddBBDUser
  @FirstName VARCHAR(100),
  @LastName VARCHAR(100),
  @PhoneNumber VARCHAR(12),
  @Email VARCHAR(320)
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
    (@FirstName, @LastName, @NewContactDetailsID, 1);

END;

GO