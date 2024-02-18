CREATE PROCEDURE DeleteBBDUserById
  @UserID INT
AS
BEGIN
  BEGIN TRY
        BEGIN TRANSACTION;
        
        DELETE FROM [dbo].[Contact_Details]
        WHERE ContactDetailsID IN (SELECT ContactDetailsID
  FROM dbo.User_Details
  WHERE UserID = @UserID);
        
        DELETE FROM [dbo].[User_Details]
        WHERE UserID = @UserID;
        
        COMMIT TRANSACTION;
    END TRY
    BEGIN CATCH
        ROLLBACK TRANSACTION;
        RAISERROR ('The deletion process failed!',  16,  1);
    END CATCH
END;
GO