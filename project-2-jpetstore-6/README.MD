# JPetStore 6 - Pet Store E-Commerce System

## Software Overview

The JPetStore 6 is an open source sample ecommerce web application created by the MyBatis project. This software is used to show the integration of the Spring Framework and MyBatis in order to create a layered enterprise web application. This software simulates an online pet store that allows users to shop for products and perform other activities.

## What problem does it solve?

The application solves the problem of creating an online shopping facility for the pet store since it allows customers to view the different product categories available in the store, get more information about the products, manage their accounts, add products into the shopping cart, and make their orders.

## Main Features

- User registration and authentication
- Account profile management
- Browse product categories
- Search products by keyword
- View product and item details
- Shopping cart management
- Order placement and order history
- Inventory management during order processing

--- 

## Project Structure

```text
jpetstore-6
└── src
    └── main
        └── java
            └── org
                └── mybatis
                    └── jpetstore
                        ├── controller
                        ├── service
                        │   ├── AccountService.java
                        │   ├── CatalogService.java
                        │   └── OrderService.java
                        ├── mapper
                        │   ├── AccountMapper.java
                        │   ├── CategoryMapper.java
                        │   ├── ItemMapper.java
                        │   ├── OrderMapper.java
                        │   └── ProductMapper.java
                        ├── domain
                        │   ├── Account.java
                        │   ├── Category.java
                        │   ├── Item.java
                        │   ├── Order.java
                        │   └── Product.java
                        └── persistence
```

---

## Selected Files Description

### 1. CatalogService.java

**Role:** Business Service (Service Layer)

**Description**

CatalogService contains business logic of product catalogs. It can find product categories, products, and product items and enables search of the products. This service serves as an interface that links controller layer and MyBatis mapper interfaces without having any presentation-layer or database-related logic.

**SOLID Observation**

This class implements the Single Responsibility Principle (SRP) since it is dedicated only to business operations with the catalog. Dependencies are provided with help of Spring Framework.
---

### 2. AccountService.java

**Role:** Business Service (Service Layer)

**Description**

AccountService provides customer account operations including authentication, registration, updates, and retrieval. This service deals with account-related business logic and uses mappers' interfaces to store data persistently. Transactions are managed using annotations from Spring framework where necessary.

**SOLID Observation**

This class satisfies the requirement of SRP principle.

---

### 3. OrderService.java

**Role:** Business Service (Service Layer)

**Description**

OrderService deals with the customers' orders, creating new orders, fetching previous orders, updating the inventory, and managing multiple persistence activities needed for the order process. It serves as the primary business class for order functionalities.

**Observation of SOLID**

The class mainly adheres to SRP since its main concern is order process and not database operations, which are delegated to MyBatis mapper interfaces.

---

### 4. CategoryMapper.java

**Role:** Data Access Layer (Mapper Interface)

**Description**

The CategoryMapper manages the operations related to product categories in the database. The mapper has operations to fetch category data from the database with the help of the MyBatis SQL mapping. 

**SOLID Observation**

It follows SRP since it is only concerned about category persistence operations and DIP as well since other higher level services use the abstractions of mappers.

---

### 5. Category.java

**Role:** Domain Model

**Description**

Category is the product category entity in the pet store. It holds information like category id, name, description etc. Since it is an entity, it does not have any business processing logic, but only holds data related to the Category entity.

**SOLID Observation**

It follows SRP since it is responsible only for holding the Category entity information.

---
