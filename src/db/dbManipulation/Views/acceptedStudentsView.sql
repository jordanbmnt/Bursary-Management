USE BBD_BursaryDB;

GO

CREATE VIEW AcceptedStudents
AS
  SELECT S.[StudentID], U.[FirstName], U.[LastName], B.[BursaryApplicantStatus], C.[Email], C.[PhoneNumber]
  FROM [Student] AS S
    INNER JOIN [User_Details] AS U
    ON S.[UserID] = U.[UserID]
    INNER JOIN [Contact_Details] AS C
     ON U.[ContactDetailsID] = C.[ContactDetailsID]
    INNER JOIN [Bursary_Applicants] AS B
    ON S.[StudentID] = B.[StudentID]
    INNER JOIN [Application_Status] AS A
    ON B.[BursaryApplicantStatus] = A.[Index]
  WHERE A.[Status] = 'approved';