
CREATE PROCEDURE AllocateFundsToApplicants
    @BursaryFundID INT

AS

BEGIN

    -- Declare variables to hold the allocated amount and the number of applicants

    DECLARE @AllocatedAmount MONEY;

    DECLARE @TotalApplicants INT;

    DECLARE @AllocationPerApplicant MONEY;

    -- Get the allocated amount for the specified BursaryFundID

    SELECT @AllocatedAmount = AllocatedAmount FROM Institution_Fund_Allocation WHERE BursaryFundID = @BursaryFundID;

    -- Calculate the number of applicants to determine the allocation per applicant

    SELECT @TotalApplicants = COUNT(*) FROM Bursary_Applicants;

    -- Check if there are any applicants and if there is enough total funding

    IF @TotalApplicants >   0 AND @AllocatedAmount >   0

    BEGIN

        -- Calculate the amount to allocate per applicant

        SET @AllocationPerApplicant = @AllocatedAmount / @TotalApplicants;

        -- Update the Bursary_Applicants table with the allocated amount for each applicant

        UPDATE Bursary_Applicants

        SET BursaryAmount = @AllocationPerApplicant;

        -- Return a success message

        SELECT 'Funds allocated to applicants successfully.' AS Message;

    END

    ELSE

    BEGIN

        -- Return an error message if there are no applicants or not enough funds

        SELECT 'No funds available for allocation or no applicants found.' AS Message;

    END

END;

GO
