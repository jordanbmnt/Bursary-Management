CREATE PROCEDURE DeleteInstitute
    @InstituteID INT
AS
BEGIN
    -- Check if the institute exists
    IF EXISTS (SELECT  1 FROM Institute_Info WHERE InstituteID = @InstituteID)
    BEGIN
        -- Delete related records from Institution_Fund_Allocation
        DELETE FROM Institution_Fund_Allocation WHERE InstituteID = @InstituteID;

        -- Delete related records from Institute_Accreditation
        DELETE FROM Institute_Accreditation WHERE InstituteID = @InstituteID;

        -- Delete related records from Courses
        DELETE FROM Courses WHERE InstituteID = @InstituteID;

        -- Delete related records from Head_Of_Department
        DELETE FROM Head_Of_Department WHERE InstituteID = @InstituteID;

        -- Delete related records from Bursary_Applicants
        DELETE FROM Bursary_Applicants WHERE HeadOfDepartmentID IN (SELECT HeadOfDepartmentID FROM Head_Of_Department WHERE InstituteID = @InstituteID);

        -- Delete the institute record from Institute_Info
        DELETE FROM Institute_Info WHERE InstituteID = @InstituteID;

        -- Return a success message
        SELECT 'Institute deleted successfully.' AS Message;
    END
    ELSE
    BEGIN
        -- Return an error message if the institute does not exist
        SELECT 'Institute not found.' AS Message;
    END
END;
GO
