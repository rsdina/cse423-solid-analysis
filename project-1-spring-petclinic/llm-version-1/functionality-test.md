# Functionality Test — LLM Version 1

## 1. Overview

This document records the functional testing performed on **LLM Version 1**
of the Spring PetClinic reconstruction.

The purpose of this testing is to verify that the reconstructed application
can be successfully built, executed, and used through its major functional
features.

The testing consists of two parts:

1. Automated testing using Maven.
2. Manual functional testing through the application's web interface.

---

## 2. Test Environment

| Item | Details |
|------|---------|
| Project | Spring PetClinic Reconstruction |
| Version | LLM Version 1 |
| Project Directory | `llm-version-1/petclinic-recon` |
| Build Tool | Maven |
| Application Framework | Spring Boot |
| Application Type | Web Application |
| Automated Test Result | **PASS** |
| Manual Test Result | **PASS** |
| Overall Result | **PASS** |

---

# 3. Automated Testing

## 3.1 Test Command

The automated tests were executed using the following Maven command:

```bash
mvn clean test
````

## 3.2 Test Result

The Maven build completed successfully.

```text
BUILD SUCCESS
```

All available automated tests executed successfully without test failures
or errors.

| Test Category   | Result |
| --------------- | ------ |
| Compilation     | PASS   |
| Automated Tests | PASS   |
| Test Failures   | 0      |
| Test Errors     | 0      |
| Maven Build     | PASS   |

### Automated Testing Conclusion

The successful Maven build and automated test execution confirm that the
LLM Version 1 implementation is able to compile and pass its available
automated test suite.

---

# 4. Application Startup Testing

The application was executed using:

```bash
mvn spring-boot:run
```

The Spring Boot application started successfully and was accessible through
the web browser.

### Result

**PASS**

The application successfully started without blocking runtime errors.

---

# 5. Manual Functional Testing

After successfully starting the application, the major user-facing
functionalities were tested through the web interface.

## 5.1 Functional Test Cases

| Test ID | Functionality        | Expected Result                              | Actual Result                                   | Status   |
| ------- | -------------------- | -------------------------------------------- | ----------------------------------------------- | -------- |
| TC-01   | Application Startup  | Application should start successfully        | Application started successfully                | **PASS** |
| TC-02   | Home Page            | Home page should load correctly              | Home page loaded successfully                   | **PASS** |
| TC-03   | Find Owners          | Owner search/list functionality should work  | Owner functionality worked successfully         | **PASS** |
| TC-04   | Add Owner            | A new owner should be added successfully     | New owner was added successfully                | **PASS** |
| TC-05   | View Owner Details   | Owner information should be displayed        | Owner details displayed successfully            | **PASS** |
| TC-06   | Edit Owner           | Existing owner information should be updated | Owner information was updated successfully      | **PASS** |
| TC-07   | Add Pet              | A pet should be added to an owner            | Pet was added successfully                      | **PASS** |
| TC-08   | View Pet Information | Pet information should be displayed          | Pet information displayed successfully          | **PASS** |
| TC-09   | Edit Pet             | Existing pet information should be updated   | Pet information was updated successfully        | **PASS** |
| TC-10   | Add Visit            | A visit should be added for a pet            | Visit was added successfully                    | **PASS** |
| TC-11   | View Veterinarians   | Veterinarian information should be displayed | Veterinarian information displayed successfully | **PASS** |

---

# 6. Detailed Functional Test Results

## TC-01 — Application Startup

**Objective:**
Verify that the LLM Version 1 application can start successfully.

**Procedure:**

```bash
mvn spring-boot:run
```

**Expected Result:**
The Spring Boot application should start without runtime errors.

**Actual Result:**
The application started successfully.

**Status:** **PASS**

---

## TC-02 — Home Page

**Objective:**
Verify that the application's home page is accessible.

**Expected Result:**
The PetClinic home page should load successfully.

**Actual Result:**
The home page loaded successfully.

**Status:** **PASS**

---

## TC-03 — Find Owners

**Objective:**
Verify that users can access the owner functionality and search/view
available owners.

**Expected Result:**
The owner functionality should display the appropriate owner information.

**Actual Result:**
Owner information was displayed successfully.

**Status:** **PASS**

---

## TC-04 — Add Owner

**Objective:**
Verify that a new owner can be added to the system.

**Expected Result:**
The new owner should be successfully created and stored.

**Actual Result:**
The new owner was successfully added.

**Status:** **PASS**

---

## TC-05 — View Owner Details

**Objective:**
Verify that the system displays the details of an existing owner.

**Expected Result:**
The selected owner's information should be displayed.

**Actual Result:**
Owner details were displayed successfully.

**Status:** **PASS**

---

## TC-06 — Edit Owner

**Objective:**
Verify that existing owner information can be modified.

**Expected Result:**
The modified owner information should be successfully saved.

**Actual Result:**
Owner information was successfully updated.

**Status:** **PASS**

---

## TC-07 — Add Pet

**Objective:**
Verify that a new pet can be associated with an owner.

**Expected Result:**
The new pet should be successfully added to the selected owner.

**Actual Result:**
The pet was successfully added.

**Status:** **PASS**

---

## TC-08 — View Pet Information

**Objective:**
Verify that pet information can be viewed through the owner's details.

**Expected Result:**
The pet's information should be displayed correctly.

**Actual Result:**
Pet information was displayed successfully.

**Status:** **PASS**

---

## TC-09 — Edit Pet

**Objective:**
Verify that existing pet information can be modified.

**Expected Result:**
The modified pet information should be successfully saved.

**Actual Result:**
Pet information was successfully updated.

**Status:** **PASS**

---

## TC-10 — Add Visit

**Objective:**
Verify that a visit can be added for an existing pet.

**Expected Result:**
The visit should be successfully created and associated with the pet.

**Actual Result:**
The visit was successfully added.

**Status:** **PASS**

---

## TC-11 — View Veterinarians

**Objective:**
Verify that veterinarian information can be accessed.

**Expected Result:**
The system should display the available veterinarian information.

**Actual Result:**
Veterinarian information was displayed successfully.

**Status:** **PASS**

---

# 7. Screenshot Evidence

Screenshots were captured during the manual functionality testing of
LLM Version 1.

The screenshots are stored in the `Screenshot/` directory and provide
visual evidence of the application's successful execution.

Example directory structure:

```text
Screenshot/
├── Screenshot_1.png
├── Screenshot_2.png
├── Screenshot_3.png
├── Screenshot_4.png
├── Screenshot_5.png
├── Screenshot_6.png
├── Screenshot_7.png
└── ...
```

The screenshots document the successful execution of the tested
application functionalities.

---

# 8. Test Summary

| Category                  |         Total Tested | Passed | Failed |
| ------------------------- | -------------------: | -----: | -----: |
| Automated Testing         | Available test suite |    All |      0 |
| Manual Functional Testing |                   11 |     11 |      0 |

---

# 9. Overall Test Result

**OVERALL RESULT: PASS**

LLM Version 1 successfully passed the performed functionality testing.

The application:

* Successfully compiled using Maven.
* Successfully passed the available automated tests.
* Successfully started as a Spring Boot application.
* Successfully loaded the web interface.
* Successfully performed the tested owner operations.
* Successfully performed the tested pet operations.
* Successfully performed the tested visit functionality.
* Successfully displayed veterinarian information.
* Successfully passed the manual functional tests.
* Successfully produced screenshot evidence for the tested functionality.

Therefore, **LLM Version 1 is considered functionally valid** and can
proceed to the next stage of the project: **software architecture and
SOLID principle analysis**.




