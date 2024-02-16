CREATE VIEW rejected_institutions AS
SELECT  
    Institute_Info.InstituteName,
    Contact_Details.PhoneNumber,
    Contact_Details.Email
FROM  
    [BBD_BursaryDB].[dbo].[Institute_Info] AS Institute_Info
JOIN  
    [BBD_BursaryDB].[dbo].[Contact_Details] AS Contact_Details
ON  
    Institute_Info.ContactDetailsID = Contact_Details.ContactDetailsID
WHERE  
    Institute_Info.BBDBursaryInstituteStatus =  3;