# Java17 Spring Boot 3 App - Mapping from and to DTOs and Entities

This project aims to facilitate the mapping between DTOs (Data Transfer Objects) and Entities in a Java 17 and Spring Boot 3 application. 

## Project Overview

The primary objective of this project is to streamline the mapping process, particularly when dealing with DTOs constructed using Java records, which aren't fully supported by conventional mappers like ModelMapper due to their nature (final fields that can be only initialized when constructor called).

To achieve this, we utilize **MapStruct**, a code generator that simplifies the implementation of mapping interfaces. It helps to reduce boilerplate code and enhances maintainability by providing a clear and concise way to define mappings between DTOs and Entities.

## Key Features

1. **Java Records for DTOs**: Utilizing Java records for DTOs to succinctly represent data structures.
2. **BaseEntity**: A base entity class containing common fields that should be extended by project-specific entities. This can be modified to suit different project contexts.
3. **Generic Entity to ID Mapper**: Using Java reflection, we've implemented a generic mapper for mapping entities to their corresponding IDs.
4. **MapStruct Mappings**: Defining mapping interfaces for DTOs and Entities using MapStruct, allowing for concise and efficient mapping logic.
5. **Singleton Mapper Instances**: Ensuring a single instance of each mapper is created by providing a factory method within the mapping definition interface. This helps maintain consistency and reduces resource consumption.

## Project Structure

```
project/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── com.houssem.dtojavarecordmapper/
│   │   │   │   ├── dto/
│   │   │   │   │   ├── CategoryDto.java
│   │   │   │   │   ├── RequestDto.java
│   │   │   │   │   └── ...
│   │   │   │   ├── entity/
│   │   │   │   │   ├── BaseEntity.java
│   │   │   │   │   ├── Category.java
│   │   │   │   │   ├── Request.java
│   │   │   │   │   └── ...
│   │   │   │   ├── mapper/
│   │   │   │   │   ├── common/
│   │   │   │   │   |  ├──EntityIdMapper.java
│   │   │   │   │   |  ├──GenericMapper.java
│   │   │   │   │   ├── CategoryMapper.java
│   │   │   │   │   ├── RequestCommonMapper.java
│   │   │   │   │   ├── RequestMapper.java
│   │   │   │   │   └── ...
│   │   │   │   └── ...
│   │   │   └── ...
│   │   └── resources/
│   │       └── application.properties
│   └── test/
│       ├── java/
│       │   ├── com.houssem.dtojavarecordmapper/
│       │   │   └── ...
│       └── resources/
│           └── ...
├── pom.xml
└── README.md
```

## Usage

1. **Define DTOs**: Create DTO classes using Java records in the `dto` package.
2. **Extend BaseEntity**: Extend the `BaseEntity` class in your project-specific entity classes located in the `entity` package.
3. **Implement Mappings**: Implement mapping interfaces for each entity using MapStruct in the `mapper` package.
4. **Access Mappers**: Import the singleton mapper instances created by the factory method provided within the mapping definition interfaces.
5. **Unit Tests**: Refer to unit tests to understand various use cases and ensure mappings work as expected.

## Main dependencies

- Java 17
- Spring Boot 3
- MapStruct
- Spring data JPA
- H2 data base

For further details and examples, refer to the project source code. Feel free to contribute or raise issues if you encounter any problems.  
  
Happy coding!
