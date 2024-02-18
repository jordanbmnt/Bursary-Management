CREATE PROCEDURE UpdateBBDUserInfo
  @UserID INT,
  @FirstName NVARCHAR(100),
  @LastName NVARCHAR(100),
  @Email NVARCHAR(320),
  @PhoneNumber NVARCHAR(12)
AS
BEGIN
  -- Update the User Details
  UPDATE [dbo].[User_Details]
    SET FirstName = @FirstName, LastName = @LastName
    WHERE UserID = (SELECT UserID
  FROM [dbo].[User_Details]
  WHERE UserID = @UserID);

  -- Update the Contact Details
  UPDATE dbo.Contact_Details
    SET Email = @Email, PhoneNumber = @PhoneNumber
    WHERE ContactDetailsID = (SELECT ContactDetailsID
  FROM dbo.User_Details
  WHERE UserID = @UserID);
END;
