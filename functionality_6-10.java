import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// Base class representing a person.
class Person {
    String name;
    String contactInfo;

    Person(String name, String contactInfo) {
        this.name = name;
        this.contactInfo = contactInfo;
    }
}

// Class representing a patient, inheriting from Person.
class Patient extends Person {
    String medicalHistory;
    
    Patient(String name, String contactInfo, String medicalHistory) {
        super(name, contactInfo);
        this.medicalHistory = medicalHistory;
    }
}

// Class representing a doctor, inheriting from Person.
class Doctor extends Person {
    String specialization;
    
    Doctor(String name, String contactInfo, String specialization) {
        super(name, contactInfo);
        this.specialization = specialization;
    }
}

// Class representing medication.
class Medication {
    String name;
    Date expiryDate;
    int stock;

    Medication(String name, Date expiryDate, int stock) {
        this.name = name;
        this.expiryDate = expiryDate;
        this.stock = stock;
    }
}

// Class representing a prescription.
class Prescription {
    Patient patient;
    Doctor doctor;
    List<Medication> medications;

    Prescription(Patient patient, Doctor doctor) {
        this.patient = patient;
        this.doctor = doctor;
        this.medications = new ArrayList<>();
    }

    void addMedication(Medication medication) {
        medications.add(medication);
    }
}

// Class for tracking medication management including reporting and expiry checks.
class MedicationTrackingSystem {
    List<Medication> medicationList;

    MedicationTrackingSystem() {
        medicationList = new ArrayList<>();
    }

    void addMedication(Medication medication) {
        medicationList.add(medication);
    }

    void checkExpiries() {
        Date currentDate = new Date();
        for (Medication med : medicationList) {
            if (med.expiryDate.before(currentDate)) {
                System.out.println(med.name + " has expired.");
            }
        }
    }

    void reportLowStock() {
        for (Medication med : medicationList) {
            if (med.stock < 5) {
                System.out.println(med.name + " is low on stock.");
            }
        }
    }

    void restockMedication(String name, int quantity) {
        for (Medication med : medicationList) {
            if (med.name.equals(name)) {
                med.stock += quantity;
                System.out.println(name + " has been restocked by " + quantity + ".");
            }
        }
    }
}

// Main class to run the pharmacy management system.
public class PharmacySystem {
    public static void main(String[] args) {
    }
}