CREATE VIEW funded_institutions AS
SELECT   
    Institute_Info.InstituteName,
    Institution_Fund_Allocation.AllocatedAmount,
    Contact_Details.PhoneNumber,
    Contact_Details.Email
FROM   
    [BBD_BursaryDB].[dbo].[Institute_Info]
JOIN   
    [BBD_BursaryDB].[dbo].[Institution_Fund_Allocation]
ON   
    Institute_Info.InstituteID = Institution_Fund_Allocation.InstituteID
JOIN   
    [BBD_BursaryDB].[dbo].[Contact_Details]
ON   
    Institute_Info.ContactDetailsID = Contact_Details.ContactDetailsID;
