#Task 1: Abstract Factory

Write a program that supports writing and reading from files and DB (Access DB using JDBC.ODBC) 
Writing to a file includes these features: Defining the file name to write or read from Wrapping with a buffer Writing/Reading Persons
Writing to the DB is also done in three steps: Loading driver and creating connection Person to DB serializer which breaks Objects into Record and vise versa Writing/Reading Persons
Client chooses to work with files or DB but once the choice was made – client code is identical in both cases.
This means that and beside specifying the source (File/DB) working with the actual resource should be transparent and includes the following operations: 
* void writePerson (Person) 
* Person readPersons() 
* Person readPerson (String name)