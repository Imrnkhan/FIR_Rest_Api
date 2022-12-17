# FIR_Rest_Api

# Evaluation - 6

### Build Rest API for Masai FIR **Application**

**Features of this application:**

1. Users can register themselves.
2. Users can log into the system.
3. The application allows users to file an FIR against multiple users
4. Users can view the past FIRs filed by him
5. Users can withdraw an FIR within 24hrs of filing

User should have following fields-

| firstName :   String
lastName :    String
mobileNumber : String
address  :  String
age: Integer
gender: String
password : String |
| --- |

FIR should have following fields-

| crimeDetail :   String
timeStamp :   LocalDateTime
policeStation : String |
| --- |

### Rest API for User Resource

| HTTP Method | URL Path | Status Code | Description |
| --- | --- | --- | --- |
| POST | /masaifir/user/register | 201(CREATED) | Register a User |
| POST | /masaifir/user/login | 200(OK) | Login a User |
| GET | /masaifir/user/fir | 200(OK) | get list of all FIRs filed by the user |
| DELETE | /masaifir/user/fir/{firId} | 200(OK) | User can withdraw/delete an FIR within 24hrs of filing |

### Rest API for FIR Resource

| HTTP Method | URL Path | Status Code | Description |
| --- | --- | --- | --- |
| POST | /masaifir/user/fir | 201(CREATED) | File an FIR against one or many users |

### Task - 1

- Build Rest API for User, FIR
- Use MySQL database
- Use Response Entity depending upon the output.

### Task - 2

- Complete the All User and FIR APIs
- Establish a relationship between User and FIR.

### Task - 3

- Implement Exception Handling in the project
    - Handle Custom Exception
    - Create Custom Error Structure Response for Client
    - Create Global Exception Handler to handle the exceptions globally: All other exception handled in this single place
- Swagger Rest API Documentation
- Add Validations
    - First Name must not contain numbers or special characters
    - Last Name must not contain numbers or special characters
    - Mobile number must have 10 digits
    - Age must be above 8 years
    - Gender must be either male or female or transgender
    - Password should be alphanumeric and must contain 6-12 characters having at least one special character, one upper case, one lowercase, and one digit.
    

### Task - 4

- Implement Authentication (Verifying the User credentials)
