# SpringRestSample

### Description : 

REST api application with CRUD Operations.To add some records run the junit test.

### REST Apis:  

#### Find All Employees : (GET)

http://localhost:8080/employees

#### Find Employee by id : (GET)

http://localhost:8080/employees/{id}

#### Save Employee : (POST)

http://localhost:8080/employees

#### Update Employee : (PUT)

http://localhost:8080/employees/{id}

#### Delete Employee : (DELETE)

http://localhost:8080/employees/{id} 

#### Map Employee to Department : (PUT)

http://localhost:8080/employees/mapEmployeeToDepartment

RequestParams : "employeeId","departmentId"

#### Find All Department : (GET)

http://localhost:8080/department

#### Find Department by id : (GET)

http://localhost:8080/department/{id}

#### Save Department : (POST)

http://localhost:8080/department

#### Update Department : (PUT)

http://localhost:8080/department/{id}

#### Delete Department : (DELETE)

http://localhost:8080/department/{id}




# Using Specifications

#### Find employees by department id and by salary which greater than some value : (GET)

http://localhost:8080/employees/findGtGivenSalaryByDepartment/{departmentId} 

Sorted by salary in descending order 

#### Find employees by employee id : (GET)

http://localhost:8080/employees/findByEmployeeId/{employeeId}

#### Find employees by salary which greater than some value : (GET)

http://localhost:8080/employees/findGtGivenSalary

Sorted by firstName in Ascending order

#### Find employees by Designation (Enum and Enumerated) : (GET)

http://localhost:8080/employees/findByDesignation/{designation}


