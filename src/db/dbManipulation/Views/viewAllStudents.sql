USE BBD_BursaryDB;

GO

CREATE VIEW StudentDetails
AS
  SELECT S.[StudentID], U.[FirstName], U.[LastName], C.[PhoneNumber], C.[Email]
  FROM [Student] AS S
    INNER JOIN [User_Details] AS U
    ON S.[UserID] = U.[UserID]
    INNER JOIN [Contact_Details] AS C
    ON U.[ContactDetailsID] = C.[ContactDetailsID];