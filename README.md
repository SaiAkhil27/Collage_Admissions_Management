# College Admissions & Curriculum Management System

## Project Overview
The **College Management System** is a web-based application designed to manage various academic and administrative tasks within a college. It supports the assignment of subjects to professors, enrollment of students, and the handling of student admissions, with a focus on simplifying operations and improving efficiency.

## Features
- **Professor Management**: Assign students and subjects to professors.
- **Student Management**: Enroll students, assign them to subjects, and link them with professors.
- **Admission System**: Manage admissions, linking students with admission records.
- **Subject Management**: Assign subjects to both students and professors.
- **Report Generation**: Generate reports of student-professor assignments.

## Technologies Used
- **Java**: Core programming language.
- **Spring Boot**: Backend framework for rapid application development.
- **Spring Data JPA**: ORM for handling data persistence with Hibernate.
- **MySQL**: Database management system.
- **Lombok**: Java library to reduce boilerplate code.
- **Postman**: API testing and development tool.
- **DBeaver**: Database management and query tool.
  
 ## Prerequisites
- Java 17 or later
- MySQL 8.x
- Maven 3.x
- Postman (optional)

## Installation

1. **Clone the Repository:**
   ```bash
   git clone https://github.com/SaiAkhil27/College-Management-System.git
   cd College-Management-System


 **Configure MySQL**
 
2. **Install MySQL and create a database:**
    ```sql
    CREATE DATABASE college_management_system;
    ```
    
3. **Update `application.properties` file with your MySQL credentials:**
    ```properties
    
    spring.datasource.url=jdbc:mysql://localhost:3306/college_management_system?useSSL=false
    spring.datasource.username=root
    spring.datasource.password=yourpassword
    spring.jpa.hibernate.ddl-auto=update
    spring.jpa.show-sql=true
    spring.jpa.properties.hibernate.format_sql=true
    ```

## ORM Relationships

### Student and Professor (Many-to-Many)
- A professor can have many students, and a student can be assigned to multiple professors.

```java
@ManyToMany
@JoinTable(
    name = "student_professor_mapping",
    joinColumns = @JoinColumn(name = "student_id"),
    inverseJoinColumns = @JoinColumn(name = "professor_id")
)
```

### Professor and Subject (One-to-Many)
- A professor can teach many subjects. The relationship is defined as One-to-Many, where one professor can be assigned multiple subjects, but each subject is assigned to one professor.

```java
@OneToMany(mappedBy = "professor")
private List<SubjectEntity> subjects;
```
### Student and Admission (One-to-One)
- Each student is associated with one admission, and each admission is linked to one student. The relationship is defined as One-to-One.

```java
@OneToOne
@JoinColumn(name = "admission_id")
private AdmissionEntity admission;
```
### Student and Subject (Many-to-Many)
- A Subject can have many students, and a student can be assigned to multiple Subjects.

```java
@ManyToMany
@JoinTable(
    name = "student_subject_mapping",
    joinColumns = @JoinColumn(name = "student_id"),
    inverseJoinColumns = @JoinColumn(name = "subject_id")
)
```







