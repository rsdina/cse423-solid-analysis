# Veterinary Clinic Management System (Independent Reconstruction)

This project is an independent reconstruction of a veterinary clinic
management system, built from a functional/architectural description
(owner, pet, vet, and visit management). It was written from scratch and
does not copy code from any existing reference implementation.

## 1. Project Overview

Layered Spring Boot web application:

- **Controllers** (`owner`, `vet`, `visit`, `system` packages) handle HTTP
  requests and delegate to repositories.
- **Repositories** (Spring Data JPA interfaces) handle persistence.
- **Domain models** (`Owner`, `Pet`, `PetType`, `Vet`, `Specialty`, `Visit`)
  represent the business entities and their relationships.
- **Views** are server-rendered with Thymeleaf templates.
- An H2 in-memory relational database is used for a runnable demo, with
  schema and seed data loaded from `db/schema.sql` and `db/data.sql`.

## 2. Project Structure

```
vet-clinic-management/
├── pom.xml
├── README.md
└── src/
    ├── main/
    │   ├── java/com/vetclinic/app/
    │   │   ├── VetClinicApplication.java
    │   │   ├── model/
    │   │   │   └── BaseEntity.java
    │   │   ├── owner/
    │   │   │   ├── Owner.java
    │   │   │   ├── Pet.java
    │   │   │   ├── PetType.java
    │   │   │   ├── OwnerRepository.java
    │   │   │   ├── PetRepository.java
    │   │   │   ├── PetTypeRepository.java
    │   │   │   ├── PetTypeFormatter.java
    │   │   │   ├── OwnerController.java
    │   │   │   └── PetController.java
    │   │   ├── vet/
    │   │   │   ├── Vet.java
    │   │   │   ├── Specialty.java
    │   │   │   ├── VetRepository.java
    │   │   │   └── VetController.java
    │   │   ├── visit/
    │   │   │   ├── Visit.java
    │   │   │   ├── VisitRepository.java
    │   │   │   └── VisitController.java
    │   │   └── system/
    │   │       ├── HomeController.java
    │   │       └── GlobalExceptionHandler.java
    │   └── resources/
    │       ├── application.properties
    │       ├── db/
    │       │   ├── schema.sql
    │       │   └── data.sql
    │       ├── templates/
    │       │   ├── welcome.html
    │       │   ├── error.html
    │       │   ├── fragments/layout.html
    │       │   ├── owners/ (findOwners, ownersList, ownerDetails, createOrUpdateOwnerForm)
    │       │   ├── pets/ (createOrUpdatePetForm, createOrUpdateVisitForm)
    │       │   └── vets/vetList.html
    │       └── static/css/style.css
    └── test/java/com/vetclinic/app/VetClinicApplicationTests.java
```

## 3 & 4. Source Code and Configuration

See the source tree above; all files are complete and runnable (no
placeholders).

## 5. Run Instructions

Requirements: JDK 17+, Maven 3.6+ (or the included wrapper, if added).

```bash
cd vet-clinic-management
mvn spring-boot:run
```

The app starts on **http://localhost:8080**. The H2 console is available
at **http://localhost:8080/h2-console** (JDBC URL: `jdbc:h2:mem:vetclinic`,
user `sa`, empty password).

To build a jar instead:

```bash
mvn clean package
java -jar target/vet-clinic-management.jar
```

## 6. Functional Verification

- **Home**: visit `/` for the landing page.
- **Search owners**: go to `/owners/find`, search by last name (try
  "Davis" for multiple results, or leave blank to list all seeded owners).
- **View/update an owner**: click an owner from search results, then
  "Edit Owner".
- **Add owner**: `/owners/new`, fill the form, submit — redirects to the
  new owner's detail page.
- **Register a pet**: from an owner's detail page, click "Add New Pet".
- **Record a visit**: from an owner's detail page, click "Add Visit" next
  to a pet.
- **View vets**: go to `/vets` to see veterinarians and their specialties.

Seed data includes 4 owners (Franklin, Davis x2, Rodriquez), pets, vets
with specialties, and a couple of past visits, so all read workflows can
be exercised immediately after startup.
