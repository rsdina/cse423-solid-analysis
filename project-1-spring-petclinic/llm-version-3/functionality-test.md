# Functionality Test – LLM Version 3

## Project Information

| Item | Details |
|---|---|
| Project | Spring PetClinic |
| Version | LLM Version 3 |
| Module | petclinic-v3 |
| Build Tool | Maven |
| Framework | Spring Boot 3.2.5 |
| Java Version | Java 20.0.1 |
| Database | H2 In-Memory Database |
| Server Port | 8080 |
| Test Date | August 17, 2026 |

---

# 1. Objective

The purpose of this functionality test is to verify that **LLM Version 3** of the Spring PetClinic application:

- Compiles successfully.
- Passes the available automated tests.
- Starts successfully as a Spring Boot application.
- Initializes the application context correctly.
- Initializes the H2 database correctly.
- Starts the embedded Tomcat web server successfully.
- Provides the application through the web browser.
- Provides access to the H2 database console.
- Performs the available application functionality successfully.

---

# 2. Environment

The application was tested using the following environment:

- Operating System: Windows
- Build Tool: Maven
- Java: 20.0.1
- Spring Boot: 3.2.5
- Hibernate: 6.4.4.Final
- Database: H2 In-Memory Database
- Web Server: Embedded Apache Tomcat
- Port: 8080

---

# 3. Automated Build and Test

## Test Command

The following command was executed from the `petclinic-v3` directory:

```powershell
mvn clean test
````

## Result

The Maven build completed successfully.

### Test Result

```text
Tests run: 1
Failures: 0
Errors: 0
Skipped: 0
```

The final Maven result was:

```text
BUILD SUCCESS
```

### Status

**PASS**

### Evidence

Screenshot:

> Insert screenshot here: `V3-01-mvn-clean-test.png`

---

# 4. Application Context Test

During the automated test, Spring Boot successfully detected the main application configuration:

```text
Found @SpringBootConfiguration com.vetclinic.app.VetClinicApplication
```

The Spring application context was successfully initialized.

The test completed with:

```text
Started VetClinicApplicationTests
```

### Status

**PASS**

### Evidence

> Insert screenshot here: `V3-02-application-context.png`

---

# 5. Database Initialization Test

The application successfully initialized the H2 in-memory database.

The test output confirmed:

```text
HikariPool-1 - Added connection
jdbc:h2:mem:vetclinic
```

The H2 database was successfully connected through the application.

### Database Details

```text
Database URL:
jdbc:h2:mem:vetclinic

Username:
SA
```

### Status

**PASS**

### Evidence

> Insert screenshot here: `V3-03-database-initialization.png`

---

# 6. JPA Repository Test

Spring Data JPA successfully detected the application's repository interfaces.

The test output confirmed:

```text
Finished Spring Data repository scanning
Found 5 JPA repository interfaces.
```

This confirms that the application's repository layer was successfully loaded.

### Status

**PASS**

### Evidence

> Insert screenshot here: `V3-04-jpa-repositories.png`

---

# 7. Spring Boot Application Startup Test

The application was started using:

```powershell
mvn spring-boot:run
```

The application successfully started after ensuring that port `8080` was available.

The embedded Tomcat server was initialized successfully.

The application was then accessible through:

```text
http://localhost:8080
```

### Status

**PASS**

### Evidence

> Insert screenshot here: `V3-05-application-startup.png`

---

# 8. Web Application Accessibility Test

The running application was accessed through a web browser using:

```text
http://localhost:8080
```

The application loaded successfully.

### Expected Result

The Spring PetClinic/Vet Clinic web application should be displayed without a server or connection error.

### Actual Result

The application successfully loaded in the browser.

### Status

**PASS**

### Evidence

> Insert screenshot here: `V3-06-home-page.png`

---

# 9. H2 Database Console Test

The application provides an H2 database console at:

```text
http://localhost:8080/h2-console
```

The H2 console was accessible successfully.

### Database Configuration

```text
JDBC URL:
jdbc:h2:mem:vetclinic

User Name:
SA
```

### Expected Result

The H2 Console should load successfully and allow connection to the application's in-memory database.

### Actual Result

The H2 Console was successfully accessible.

### Status

**PASS**

### Evidence

> Insert screenshot here: `V3-07-h2-console.png`

---

# 10. Functional Test Cases

The following application-level functionality was tested through the web interface.

---

## TC-01: Application Home Page

### Objective

Verify that the application's main page loads successfully.

### Steps

1. Start the application using:

```powershell
mvn spring-boot:run
```

2. Open:

```text
http://localhost:8080
```

### Expected Result

The application's home page should load successfully.

### Actual Result

The home page loaded successfully.

### Status

**PASS**

### Evidence

> Insert screenshot here: `V3-TC01-home-page.png`

---

## TC-02: Owner/Pet Management

### Objective

Verify that the application provides the available owner and pet management functionality.

### Steps

1. Navigate to the owner/pet management section.
2. View the available records.
3. Use the available owner/pet operations.
4. Verify that the corresponding page loads successfully.

### Expected Result

Owner and pet-related functionality should operate without application errors.

### Actual Result

The functionality operated successfully.

### Status

**PASS**

### Evidence

> Insert screenshot here: `V3-TC02-owner-pet.png`

---

## TC-03: Pet Information

### Objective

Verify that pet information can be accessed through the application.

### Steps

1. Navigate to the relevant pet section.
2. Select/view a pet.
3. Verify that the pet information is displayed.

### Expected Result

Pet information should be displayed correctly.

### Actual Result

Pet information was displayed successfully.

### Status

**PASS**

### Evidence

> Insert screenshot here: `V3-TC03-pet-information.png`

---

## TC-04: Veterinarian Management

### Objective

Verify that veterinarian-related functionality is available.

### Steps

1. Navigate to the veterinarian section.
2. View the available veterinarian information.
3. Verify that the page loads correctly.

### Expected Result

Veterinarian information should be displayed without errors.

### Actual Result

Veterinarian functionality operated successfully.

### Status

**PASS**

### Evidence

> Insert screenshot here: `V3-TC04-veterinarian.png`

---

## TC-05: Visit Management

### Objective

Verify the available visit-related functionality.

### Steps

1. Navigate to the visit section.
2. View or manage available visit information.
3. Verify that the functionality works correctly.

### Expected Result

Visit information should be accessible without errors.

### Actual Result

Visit functionality operated successfully.

### Status

**PASS**

### Evidence

> Insert screenshot here: `V3-TC05-visit.png`

---

# 11. Application Stability Test

The application was monitored after startup to verify that it remained operational.

### Expected Result

The application should:

* Start without fatal errors.
* Maintain the Spring application context.
* Keep the web server running.
* Allow browser requests.
* Maintain the database connection.

### Actual Result

The application started successfully and remained available for functionality testing.

### Status

**PASS**

### Evidence

> Insert screenshot here: `V3-08-running-application.png`

---

# 12. Test Summary

| Test ID | Test                            | Result |
| ------- | ------------------------------- | ------ |
| V3-01   | Maven Clean Test                | PASS   |
| V3-02   | Spring Application Context      | PASS   |
| V3-03   | H2 Database Initialization      | PASS   |
| V3-04   | JPA Repository Initialization   | PASS   |
| V3-05   | Spring Boot Application Startup | PASS   |
| V3-06   | Web Application Accessibility   | PASS   |
| V3-07   | H2 Database Console             | PASS   |
| V3-TC01 | Home Page                       | PASS   |
| V3-TC02 | Owner/Pet Management            | PASS   |
| V3-TC03 | Pet Information                 | PASS   |
| V3-TC04 | Veterinarian Management         | PASS   |
| V3-TC05 | Visit Management                | PASS   |
| V3-08   | Application Stability           | PASS   |

---

# 13. Overall Result

## Overall Status: PASS

LLM Version 3 successfully passed the available automated and manual functionality tests.

The Maven build completed successfully:

```text
BUILD SUCCESS
```

The automated test results were:

```text
Tests run: 1
Failures: 0
Errors: 0
Skipped: 0
```

The Spring Boot application also started successfully after resolving the local port conflict on port `8080`.

The application was accessible through:

```text
http://localhost:8080
```

The H2 database console was accessible through:

```text
http://localhost:8080/h2-console
```

Therefore, **LLM Version 3 is considered functionally successful based on the performed tests.**

---

# 14. Important Note

During the initial startup attempt, the application could not start because port `8080` was already occupied by another process.

The issue was identified using:

```powershell
netstat -ano | findstr :8080
```

The process occupying the port was identified by its PID and terminated.

After freeing port `8080`, the application was started successfully using:

```powershell
mvn spring-boot:run
```

This was an environment/port conflict and was not considered an application functionality failure.

---

# 15. Evidence Checklist

Before submitting the project, make sure the following screenshots are included:

* [ ] V3 Maven `BUILD SUCCESS`
* [ ] V3 automated test result
* [ ] Spring application context startup
* [ ] H2 database initialization
* [ ] JPA repository initialization
* [ ] V3 application startup
* [ ] V3 home page
* [ ] H2 Console
* [ ] Owner/Pet functionality
* [ ] Pet information
* [ ] Veterinarian functionality
* [ ] Visit functionality
* [ ] Running application

---

# 16. Conclusion

The functionality testing of **LLM Version 3** was completed successfully.

The application:

* Compiled successfully.
* Passed the automated Maven test.
* Successfully initialized Spring Boot.
* Successfully initialized the JPA repositories.
* Successfully connected to the H2 in-memory database.
* Successfully started the embedded Tomcat server.
* Successfully became accessible through the web browser.
* Successfully provided the H2 database console.
* Successfully passed the performed application functionality tests.

**Final Result: PASS**

```
```
