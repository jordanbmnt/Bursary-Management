DECLARE @Motivation VARBINARY(MAX);

SET
  @Motivation = CAST(
    'This is a dummy motivation message.' AS VARBINARY(MAX)
  );

EXEC AddStudent @FirstName = 'Jordan',
@LastName = 'Beaumont',
@PhoneNumber = '1234567890',
@Email = 'john.doe@example.com',
@RaceID = 1,
@ID_Number = '1234567890123',
@HeadOfDepartmentID = 1,
@Motivation = @Motivation;