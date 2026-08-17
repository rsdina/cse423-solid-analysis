You are a software architect and Java developer.

I am conducting a software architecture experiment for a university assignment. Your task is to independently reconstruct a veterinary clinic management system from the functional and architectural description provided below.

IMPORTANT EXPERIMENT RULES:

1. Do NOT access, search for, or reproduce the original Spring PetClinic source code.
2. Do NOT assume the implementation details of the original repository.
3. Reconstruct the system independently from the description below.
4. Do not intentionally optimize the design for SOLID principles. Use reasonable software engineering practices based on the requirements.
5. Do not perform a SOLID analysis yet.
6. Generate a complete project, not only the five selected files.
7. The five selected files below are provided as architectural/documentation context; they are NOT a restriction on which files you may create.
8. Create any additional classes, interfaces, configuration files, templates, repositories, services, or other files necessary to implement the described functionality.
9. Keep the implementation reasonably simple. Do not introduce unnecessary design patterns or excessive abstraction.
10. Preserve the requested functionality throughout the generated system.

SYSTEM: SPRING PETCLINIC

## What is this software?

Spring PetClinic is a sample Spring Boot application that demonstrates a veterinary clinic management system. It is an official reference application for the Spring Framework ecosystem.

## What problem does it solve?

The system solves the problem of managing a veterinary clinic's daily operations by providing a digital platform to manage pet owners, pets, veterinary visits, and veterinarian information.

## Main Features

1. Owner Management
   - Create owners
   - Update owners
   - View owners
   - Search owners

2. Pet Management
   - Register pets with owners
   - View pet information
   - Update pet information

3. Vet Management
   - View veterinarians
   - View veterinarian specialties

4. Visit Management
   - Schedule/record veterinary visits
   - View visit information

5. Search Functionality
   - Find owners by last name

## Architectural Description

The system follows a layered architecture consisting of controllers, repositories, and domain models.

- Controllers handle HTTP requests and user interactions.
- Repositories manage database access using Spring Data JPA.
- Domain/model classes represent entities such as Owner, Pet, Vet, Visit, PetType, and Specialty.
- Spring Boot and Spring MVC are used for the web application.
- Spring Data JPA is used for persistence.
- A relational database is used for storing application data.

## Key Workflows

### Adding an Owner

User fills out an owner form
→ Owner-related controller processes the HTTP POST request
→ Owner information is saved through the repository/data-access layer
→ User is redirected to the owner details page.

### Searching Owners

User enters an owner's last name
→ Controller processes the search request
→ Repository retrieves matching owners
→ Matching owners are displayed.

### Managing Pets

User selects an owner
→ User adds or updates pet information
→ Pet information is associated with the owner
→ Pet data is persisted.

### Recording a Visit

User selects a pet
→ User enters visit information
→ Visit information is stored
→ Visit information can later be displayed with the pet.

## Selected Pre-2020 Snapshot Files

The following files were selected from a pre-2020 snapshot of the human-developed system and are provided only as descriptive architectural context.

### 1. OwnerController.java

Role: Web Controller / Presentation Layer

Description:
Handles HTTP requests related to owner management, including creating, updating, viewing, and searching owners. It interacts with the owner data-access layer and is responsible for coordinating web requests and responses.

### 2. OwnerRepository.java

Role: Repository / Data Access Layer

Description:
A Spring Data JPA repository interface associated with Owner entities. It provides data-access operations such as retrieving owners and finding owners by last name.

### 3. Owner.java

Role: Domain Model / Entity

Description:
Represents a pet owner in the veterinary clinic system. It contains owner-related information such as first name, last name, address, city, telephone, and relationships with pets.

### 4. Pet.java

Role: Domain Model / Entity

Description:
Represents a pet registered with the clinic. It contains information such as pet name, birth date, pet type, and its relationship with an owner.

### 5. VetController.java

Role: Web Controller / Presentation Layer

Description:
Handles HTTP requests related to viewing veterinarian information and specialties. It coordinates the web interaction for veterinarian-related functionality.

## Technical Requirements

Build the reconstructed application using:

- Java
- Spring Boot
- Spring MVC
- Spring Data JPA
- Maven
- A relational database

The project should:

- Be a multi-file Java project.
- Use appropriate packages.
- Include domain/model classes.
- Include controllers for web requests.
- Include repository/data-access components.
- Include the necessary business/service components when required by the functionality.
- Include appropriate entity relationships.
- Include application configuration.
- Include Maven configuration.
- Include database configuration appropriate for a runnable demonstration.
- Include validation where appropriate.
- Include server-side views or another reasonable web presentation mechanism.
- Use dependency injection where dependencies are required.
- Provide complete source code rather than pseudocode.

## Expected Functional Scope

At minimum, the reconstructed application should support:

- Owner creation
- Owner search by last name
- Owner viewing/updating
- Pet registration and management
- Vet information viewing
- Vet specialty information
- Visit creation/recording
- Persistence of the relevant data

## Output Requirements

Please provide the result in the following order:

### 1. Project Overview

Briefly explain the architecture you chose.

### 2. Complete Project Structure

Show the complete directory/package structure.

### 3. Complete Source Code

Provide the complete source code for all important files required to run the application.

Do not provide pseudocode or placeholders such as:

"implement this method here"

or

"other classes omitted."

### 4. Configuration

Provide:

- pom.xml
- application configuration
- database configuration
- any required schema/data initialization files

### 5. Run Instructions

Explain exactly how to build and run the project using Maven.

### 6. Functional Verification

Briefly describe how to test the main workflows.

IMPORTANT:

Do NOT provide a SOLID analysis, SOLID violation count, or SVC at this stage. The architecture will be analyzed separately after the reconstruction is generated.

Do not intentionally modify the requirements to make the system more SOLID-compliant. The goal of this first iteration is to obtain an independent reconstruction from the supplied description.