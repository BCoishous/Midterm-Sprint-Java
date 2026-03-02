import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

// Base class
class Person {
    private String name;
    private String contactInfo;

    public Person(String name, String contactInfo) {
        this.name = name;
        this.contactInfo = contactInfo;
    }

    public String getName() {
        return name;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Contact: " + contactInfo;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }
}

// Patient
class Patient extends Person {
    private final String medicalHistory;

    public Patient(String name, String contactInfo, String medicalHistory) {
        super(name, contactInfo);
        this.medicalHistory = medicalHistory;
    }

    public String getMedicalHistory() {
        return medicalHistory;
    }

    @Override
    public String toString() {
        return super.toString() + ", Medical History: " + medicalHistory;
    }
}

// Doctor
class Doctor extends Person {
    private final String specialization;

    public Doctor(String name, String contactInfo, String specialization) {
        super(name, contactInfo);
        this.specialization = specialization;
    }

    public String getSpecialization() {
        return specialization;
    }

    @Override
    public String toString() {
        return super.toString() + ", Specialization: " + specialization;
    }
}

// Medication
class Medication {
    private String name;
    private Date expiryDate;
    private int stock;

    public Medication(String name, Date expiryDate, int stock) {
        this.name = name;
        this.expiryDate = expiryDate;
        this.stock = stock;
    }

    public String getName() {
        return name;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public int getStock() {
        return stock;
    }

    public void increaseStock(int quantity) {
        if (quantity > 0) {
            stock += quantity;
        }
    }

    @Override
    public String toString() {
        return name + " (Stock: " + stock + ")";
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }
}

// Prescription
class Prescription {
    private Patient patient;
    private Doctor doctor;
    private List<Medication> medications;

    public Prescription(Patient patient, Doctor doctor) {
        this.patient = patient;
        this.doctor = doctor;
        this.medications = new ArrayList<>();
    }

    public void addMedication(Medication medication) {
        medications.add(medication);
    }

    public void printPrescriptionDetails() {
        System.out.println("\n--- Prescription Details ---");
        System.out.println("Patient: " + patient.getName());
        System.out.println("Doctor: " + doctor.getName());
        System.out.println("Specialization: " + doctor.getSpecialization());
        System.out.println("Medications:");

        for (Medication med : medications) {
            System.out.println(" - " + med.getName());
        }
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public List<Medication> getMedications() {
        return medications;
    }

    public void setMedications(List<Medication> medications) {
        this.medications = medications;
    }
}

// Tracking system
class MedicationTrackingSystem {
    private List<Medication> medicationList;

    public MedicationTrackingSystem() {
        medicationList = new ArrayList<>();
    }

    public void addMedication(Medication medication) {
        medicationList.add(medication);
    }

    public void reportLowStock() {
        for (Medication med : medicationList) {
            if (med.getStock() < 5) {
                System.out.println(med.getName() + " is low on stock.");
            }
        }
    }

    public List<Medication> getMedicationList() {
        return medicationList;
    }

    public void setMedicationList(List<Medication> medicationList) {
        this.medicationList = medicationList;
    }
}

// Main class (must match file name: PharmacySystem.java)
public class PharmacySystem {

    // Helper method to safely create Date
    public static Date createDate(int year, int month, int day) {
        Calendar cal = Calendar.getInstance();
        cal.set(year, month - 1, day); // month is 0-based
        return cal.getTime();
    }

    public static void main(String[] args) {

        Doctor doctor = new Doctor("Dr. Smith", "smith@email.com", "Cardiology");
        Patient patient = new Patient("John Doe", "john@email.com", "No allergies");

        System.out.println("Patient Information:");
        System.out.println(patient);

        // Proper date creation
        Medication med1 = new Medication("Aspirin", createDate(2030, 6, 10), 3);
        Medication med2 = new Medication("Ibuprofen", createDate(2030, 4, 15), 10);

        Prescription prescription = new Prescription(patient, doctor);
        prescription.addMedication(med1);
        prescription.addMedication(med2);

        prescription.printPrescriptionDetails();

        MedicationTrackingSystem system = new MedicationTrackingSystem();
        system.addMedication(med1);
        system.addMedication(med2);

        system.reportLowStock();
    }
}