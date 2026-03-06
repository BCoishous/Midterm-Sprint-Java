\\# Pharmacy Management System

## Team Members

- Brandon Coish
- Samantha Stroud
- Merethe Batino

## About the Application

The Pharmacy Management System is a Java-based application built using Object-Oriented Programming (OOP) principles. It is designed to manage the day-to-day operations of a pharmacy, including tracking patients, doctors, medications, and prescriptions.

The system allows pharmacy staff to:

- Add, edit, delete, and search for patients, doctors, and medications
- Accept and issue prescriptions, linking them to the correct patient and medication
- Assign patients to doctors
- Generate reports on system data including expired medications and prescription histories
- Restock medications in the pharmacy

All data is managed in memory at runtime using ArrayLists.

---

## Classes Overview

### Person _(Abstract Superclass)_

`Person` is an abstract class. It holds the attributes shared by all people in the system:

- `id` — unique identifier
- `name` — full name
- `age` — age of the person
- `phoneNumber` — contact number

---

### Patient _(extends Person)_

Represents a patient registered in the pharmacy system. Inherits all attributes from `Person` and adds:

- `medications` — an ArrayList of medications the patient is currently taking
- `prescriptions` — an ArrayList of active prescriptions linked to the patient

Key methods:

- `addMedication()` / `removeMedication()` — manages the patient's medication list
- `addPrescription()` / `removePrescription()` — manages the patient's prescription list
- `toString()` — displays full patient details including their medication and prescription lists

---

### Doctor _(extends Person)_

Represents a doctor in the system. Inherits all attributes from `Person` and adds:

- `specialization` — the doctor's area of medical expertise (e.g. "Cardiology")
- `patients` — an ArrayList of patients under this doctor's care

Key methods:

- `addPatient()` — assigns a patient to the doctor, with a built-in duplicate check
- `removePatient()` — removes a patient from the doctor's list
- `hasPatient()` — checks whether a specific patient is under this doctor's care
- `toString()` — displays full doctor details including their patient list

---

### Medication

Represents a medication available in the pharmacy. It contains:

- `id` — unique identifier
- `name` — name of the medication
- `dose` — dosage description (e.g. "500mg")
- `quantityInStock` — number of units currently available
- `expiryDate` — randomly generated date between 3 years in the past and 3 years in the future

Key methods:

- `isExpired()` — returns true if the expiry date has passed
- `restock()` — adds a given number of units to the current stock
- `toString()` — displays full medication details, flagging expired medications with `*** EXPIRED ***`

---

### Prescription

Represents a prescription issued by a doctor for a patient. This is the central linking class of the system — it holds object references to a `Doctor`, a `Patient`, and a `Medication` all in one place. It contains:

- `id` — unique identifier
- `doctor` — reference to the prescribing Doctor object
- `patient` — reference to the Patient object receiving the prescription
- `medication` — reference to the prescribed Medication object
- `issueDate` — automatically set to today's date when the prescription is created
- `expiryDate` — automatically set to one year from the issue date

Key methods:

- `isExpired()` — returns true if the prescription expiry date has passed
- `isWithinPastYear()` — returns true if the prescription was issued within the last 365 days
- `toString()` — displays full prescription details by pulling names directly from the linked objects

---

### MedicationTrackingSystem

The central management class of the entire system. It maintains four master lists — patients, doctors, medications, and prescriptions — and provides all the functionality to manage them. It uses a shared `Scanner` instance for all user input.

**Functionalities 1-5 (implemented by Brandon Coish):**

- `addPatient()` / `addDoctor()` / `addMedication()` — prompts user for details and adds to the system
- `deletePatient()` / `deleteDoctor()` / `deleteMedication()` — finds by name and removes from the system
- `editPatient()` / `editDoctor()` / `editMedication()` — finds by name and allows field-by-field editing
- `searchPatient()` / `searchDoctor()` / `searchMedication()` — finds by name and displays full details
- `acceptPrescription()` — prompts for doctor, patient, and medication names, creates a Prescription and links it to the patient
- `addPatientToDoctor()` — assigns a patient to a doctor's care list

**Functionalities 6-10 (implemented by Merethe Batino):**

<<<<<<< HEAD
- `generateFullReport()` — prints a complete summary of all patients, doctors, medications, and prescriptions currently in the system
- `generateExpiredMedicationReport()` — checks all medications and displays details of any that have passed their expiry date
- `generateDoctorPrescriptionReport()` — prompts for a doctor's name and prints all prescriptions issued by that doctor
- `generatePastYearPrescriptionReport()` — generates a report of all prescriptions issued in the past year, summarized by medication name per patient
- `restockAllMedications()` — prompts for a restock amount and adds that quantity to every medication in the system
=======
- Report generation, expired medication checks, prescription history, restocking, and the main Scanner menu
  
Comprehensive System Report - `generateComprehensiveSummaryReport()`

This feature generates a comprehensive report that summarizes all data in the system, including the total number of patients, doctors, medications, and prescriptions. It organizes the information into sections such as patient summaries, doctor summaries, medication summaries, prescription summaries, and a system health check.

Expired Drug Detection Report - `med.getExpiryDate().isBefore(LocalDate.now())`

This feature checks if any medications in the system have expired. If expired drugs are found, the system flags them in the report so the pharmacist can remove them from inventory and maintain patient safety.

 Doctor's Prescription Report - `if (prescription.getDoctor().getId() == doctor.getId())`

Lists all prescriptions issued by a specific doctor. It helps track the prescribing activity of doctors and allows administrators to review which medications they have prescribed to patients.

Patient Prescription Summary (Past Year) - `prescriptionDate.isAfter(LocalDate.now().minusYears(1))`

This generates a summary of all prescriptions given to patients in the last year. It simplifies the information by listing only the names of the medications, allowing users to quickly see medication trends.

Pharmacy Drug Restocking - `med.setQuantityInStock(100);`

Automatically restocks medications in the pharmacy inventory. The system can either reset all medications to a fixed stock level or assign a random quantity to simulate restocking. This ensures the pharmacy maintains sufficient medication supplies.


>>>>>>> f1b90a4a5f556a57af73dd461bba44265e0fdc2d

**Additional Functionalities (implemented by Samantha Stroud):**

- `fullEditPatient()` / `fullEditDoctor()` / `fullEditMedication()` — provides full editing of all details for a patient, doctor, or medication record
- `searchMenu()` — interactive menu allowing staff to search for patients, doctors, and medications by name and display their full details
- `MedicationSystemTest.java` — test file verifying all system functionalities work correctly end to end

---

## How to Clone the Repository

Make sure you have Git installed, then run the following in your terminal:

```bash
git clone https://github.com/BCoishous/Midterm-Sprint-Java.git
cd Midterm-Sprint-Java
```

This will download all source files to your local machine and navigate into the project folder.

---

## Compile Time Dependencies

This project has **no external dependencies**. It uses only the Java Standard Library (Java SE) which comes bundled with the JDK. The following standard library packages are used:

| Package               | Used In                                   | Purpose                        |
| --------------------- | ----------------------------------------- | ------------------------------ |
| `java.util.ArrayList` | Patient, Doctor, MedicationTrackingSystem | Dynamic list storage           |
| `java.util.Random`    | Medication                                | Generating random expiry dates |
| `java.util.Scanner`   | MedicationTrackingSystem                  | Reading user input             |
| `java.time.LocalDate` | Medication, Prescription                  | Date handling                  |

**Required:**

- Java Development Kit (JDK) version 25.0.1 or higher
- No build tools required
- No third party libraries required

---

## Build Process

This project is compiled using the standard Java compiler `javac` which is included with the JDK. No build tools are required.

Compile all source files from the project directory:

```bash
javac Person.java Patient.java Doctor.java Medication.java Prescription.java MedicationTrackingSystem.java Main.java
```

The order matters — `Person` must be compiled before `Patient` and `Doctor` since they extend it, and `Prescription` must be compiled after `Doctor`, `Patient`, and `Medication` since it references all three.

---

## How to Run

After compiling, run the program with:

```bash
java Main
```

This launches the main menu where you can interact with all system functionalities.

---

## Source Code Directory Structure

```
Midterm-Sprint-Java/
│
├── Person.java                   # Abstract superclass for Patient and Doctor
├── Patient.java                  # Represents a patient, extends Person
├── Doctor.java                   # Represents a doctor, extends Person
├── Medication.java               # Represents a medication
├── Prescription.java             # Links a Doctor, Patient, and Medication
├── MedicationTrackingSystem.java # Central system management class
├── Main.java                     # Entry point, contains the Scanner menu
└── README.md                     # Project documentation
```

---

## Development Standards

The following standards were followed throughout the development of this project:

**Naming Conventions**

- Class names use `PascalCase` e.g. `MedicationTrackingSystem`
- Method and variable names use `camelCase` e.g. `addPatient()`, `nextPatientId`
- Constants would use `UPPER_SNAKE_CASE` if present

**OOP Principles**

- **Encapsulation** — all class fields are `private`, accessed only through public getters and setters
- **Inheritance** — `Patient` and `Doctor` both extend the abstract `Person` class, avoiding code duplication
- **Polymorphism** — all classes override `toString()` for consistent, readable output
- **Abstraction** — `Person` is abstract, enforcing that only concrete subtypes can be instantiated

**Code Style**

- All classes, methods, and non-obvious logic are documented with Javadoc comments
- Methods are kept focused — each method does one clear thing
- User-facing messages are clear and descriptive
- Input validation is handled gracefully with informative error messages rather than crashes

**Git Standards**

- All new features are developed on separate branches
- Branch naming follows the format `feature/description` e.g. `feature/functionalities-1-5`
- Commits are made per functionality with clear, descriptive messages
- All features are merged to `main` via Pull Requests on GitHub

---

## Class Diagram

---

## Database Design

A database for this pharmacy system would be structured around four main tables,
mirroring the four core classes in the application.

**Patients Table**
Stores all patient information including a unique patient ID, name, age, and phone
number. This maps directly to the `Patient` class in the system.

**Doctors Table**
Stores all doctor information including a unique doctor ID, name, age, phone number,
and specialization. This maps directly to the `Doctor` class in the system.

**Medications Table**
Stores all medication information including a unique medication ID, name, dose,
quantity in stock, and expiry date. This maps directly to the `Medication` class.

**Prescriptions Table**
Acts as the central linking table of the entire database — the same role the
`Prescription` class plays in the application. It stores a unique prescription ID,
the issue date, the expiry date, and foreign keys referencing the doctor, patient,
and medication involved. This table connects all three groups together.

**Doctor-Patient Table**
A separate junction table to handle the many-to-many relationship between doctors
and patients — since one doctor can manage many patients and one patient can be seen
by many doctors. It stores a doctor ID and patient ID as a pair.

This structure supports all system functionalities — editing records, searching,
assigning patients to doctors, checking expired medications, and generating reports
— while keeping data organized, consistent, and easy to query.
