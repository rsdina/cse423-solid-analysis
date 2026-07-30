# Spring PetClinic - Veterinary Clinic Management System

## Software Overview

Spring PetClinic is an example open source application created by the Spring team to illustrate best practices in developing enterprise applications using the Spring Framework. It demonstrates a veterinary clinic management system and describes how Spring Boot, Spring MVC, Spring Data JPA and other technologies can be used to build a layered web application.

## What problem does it solve?

This application automates the daily operations of a veterinary clinic by allowing staff to manage pet owners, pets, veterinarians, pet types and veterinary visits. Instead of maintaining paper records, users can store clinic information on a web interface, and search, update and retrieve it.

## Main Features

- Register new pet owners
- Search owners by last name
- Update owner information
- Register pets for each owner
- Manage pet types
- Record veterinary visits
- View veterinarian information and specialties
- Store and retrieve clinic data using a relational database

## Project Structure
spring-petclinic/
└── src/
    └── main/
        └── java/
            └── org/
                └── springframework/
                    └── samples/
                        └── petclinic/
                            ├── owner/
                            │   ├── OwnerController.java
                            │   ├── OwnerRepository.java
                            │   ├── Owner.java
                            │   ├── Pet.java
                            │   └── PetType.java
                            │
                            ├── visit/
                            │   ├── VisitController.java
                            │   ├── VisitRepository.java
                            │   └── Visit.java
                            │
                            ├── vet/
                            │   ├── VetController.java
                            │   ├── VetRepository.java
                            │   ├── Vet.java
                            │   └── Specialty.java
                            │
                            ├── model/
                            └── system/

---

## Selected Files Description

### 1. OwnerController.java

**Role:** Presentation Layer (Controller)

**Description**

OwnerController handles all web requests related to the handling of the pet owners. This includes operations for creating new owners, searching for owners using their last names, updating owner's data, and displaying owner's data. Controller receives the HTTP requests and passes them through data validation and then delegates the persistence operation to the repository and returns the view to be rendered.

**SOLID Observation**

The class adheres to the principle of single responsibility (SRP). This class basically deals with requests coming from the owners. The loose coupling is provided using the repository classes which are injected into the constructor to do database related work.

---

### 2. OwnerRepository.java

**Role:** Repository Layer

**Description**

The OwnerRepository is used to specify the access operations for the Owner entity. Methods to search for owners by last name, get owners by ID, and save owners are provided by this repository. It helps to keep database interactions behind the scenes and helps controllers do the persistence task without using any SQL statements.

**SOLID Observations**

The repository adheres to SRP by focusing solely on persistence activities and satisfies DIP since higher-level modules interact with the abstraction instead of the concrete database implementation.

---

### 3. Owner.java

**Role:** Domain Model

**Description**

Owner is a representation of a pet owner in the system. This class contains the information about the owner like the owner’s name, address, city, phone number, and list of pets belonging to that person. This class is responsible for defining the business data and owner-pet relation using JPA entity mapping.

**SOLID Observation**

This class adheres to the SRP principle since it implements only the Owner domain entity and keeps only owner-related data.

---

### 4. Pet.java

**Role:** Domain Model

**Description**

Pet is a representation of the individual pet registered in the clinic. This class contains information like the pet’s name, birth date, pet type, owner and veterinary visit. This class is responsible for establishing the relation between the pet, its owner and visits using JPA annotations.

**SOLID Observation**

The class adheres to SRP principle since it implements only the Pet domain entity and keeps the pet-related data.
---

### 5. VetController.java

**Role:** Presentation Layer (Controller)

**Description**

VetController handles requests involving veterinarians. This controller gets information about the veterinarians from the repository and displays the veterinarians along with their specializations to the user. This controller handles only requests that involve veterinarians.

**SOLID Analysis**

This controller adheres to SRP as it handles only requests that involve veterinarians.
---
