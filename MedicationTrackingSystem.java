import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * MedicationTrackingSystem is the central management class of the pharmacy.
 */
public class MedicationTrackingSystem {

    // ----- System Data Lists -----
    private ArrayList<Patient> patients;
    private ArrayList<Doctor> doctors;
    private ArrayList<Medication> medications;
    private ArrayList<Prescription> prescriptions;

    private Scanner scanner;

    // ID counters — auto-increment 
    private int nextPatientId = 1;
    private int nextDoctorId = 1;
    private int nextMedicationId = 1;
    private int nextPrescriptionId = 1;

   
    // ----- Constructor -----

    /**
     * empty lists ready to be populated.
     */
    public MedicationTrackingSystem() {
        this.patients = new ArrayList<>();
        this.doctors = new ArrayList<>();
        this.medications = new ArrayList<>();
        this.prescriptions = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

   
    // ADD / DELETE
  
    /**
     * enter details for a new patient then add them to the system.
     */
    public void addPatient() {
        System.out.println("\n--- Add New Patient ---");

        System.out.print("Enter patient name: ");
        String name = scanner.nextLine();

        System.out.print("Enter patient age: ");
        int age = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter patient phone number: ");
        String phone = scanner.nextLine();

        Patient newPatient = new Patient(nextPatientId++, name, age, phone);
        patients.add(newPatient);

        System.out.println("Patient \"" + name + "\" added successfully with ID " + newPatient.getId() + ".");
    }

    /**
     * enter details for a new doctor and add them to the system.
     */
    public void addDoctor() {
        System.out.println("\n--- Add New Doctor ---");

        System.out.print("Enter doctor name: ");
        String name = scanner.nextLine();

        System.out.print("Enter doctor age: ");
        int age = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter doctor phone number: ");
        String phone = scanner.nextLine();

        System.out.print("Enter doctor specialization: ");
        String specialization = scanner.nextLine();

        Doctor newDoctor = new Doctor(nextDoctorId++, name, age, phone, specialization);
        doctors.add(newDoctor);

        System.out.println("Doctor \"" + name + "\" added successfully with ID " + newDoctor.getId() + ".");
    }

    /**
     * enter details for a new medication and add it to the system.
     */
    public void addMedication() {
        System.out.println("\n--- Add New Medication ---");

        System.out.print("Enter medication name: ");
        String name = scanner.nextLine();

        System.out.print("Enter medication dose (e.g. 500mg): ");
        String dose = scanner.nextLine();

        System.out.print("Enter quantity in stock: ");
        int quantity = Integer.parseInt(scanner.nextLine());

        Medication newMedication = new Medication(nextMedicationId++, name, dose, quantity);
        medications.add(newMedication);

        System.out.println("Medication \"" + name + "\" added successfully with ID " + newMedication.getId() + ".");
        System.out.println("Expiry date randomly set to: " + newMedication.getExpiryDate());
    }

    /**
     * removes patient name from the system.
     */
    public void deletePatient() {
        System.out.println("\n--- Delete Patient ---");

        System.out.print("Enter the name of the patient to delete: ");
        String name = scanner.nextLine();

        // Search for the patient by name
        Patient found = findPatientByName(name);

        if (found != null) {
            patients.remove(found);
            System.out.println("Patient \"" + name + "\" has been removed from the system.");
        } else {
            System.out.println("No patient found with the name \"" + name + "\".");
        }
    }

    /**
     * removes doctor name from the system. 
     */
    public void deleteDoctor() {
        System.out.println("\n--- Delete Doctor ---");

        System.out.print("Enter the name of the doctor to delete: ");
        String name = scanner.nextLine();

        Doctor found = findDoctorByName(name);

        if (found != null) {
            doctors.remove(found);
            System.out.println("Doctor \"" + name + "\" has been removed from the system.");
        } else {
            System.out.println("No doctor found with the name \"" + name + "\".");
        }
    }

    /**
     * removes medication from the system.
     */
    public void deleteMedication() {
        System.out.println("\n--- Delete Medication ---");

        System.out.print("Enter the name of the medication to delete: ");
        String name = scanner.nextLine();

        Medication found = findMedicationByName(name);

        if (found != null) {
            medications.remove(found);
            System.out.println("Medication \"" + name + "\" has been removed from the system.");
        } else {
            System.out.println("No medication found with the name \"" + name + "\".");
        }
    }

    /**
     * search for a patient by name and edit their details.
     */
    public void editPatient() {
        System.out.println("\n--- Edit Patient ---");

        System.out.print("Enter the name of the patient to edit: ");
        String name = scanner.nextLine();

        Patient found = findPatientByName(name);

        if (found != null) {
            System.out.println("Current details: " + found);
            System.out.println("Enter new details (press Enter to keep current value):");

            System.out.print("New name [" + found.getName() + "]: ");
            String newName = scanner.nextLine();
            if (!newName.isEmpty()) found.setName(newName);

            System.out.print("New age [" + found.getAge() + "]: ");
            String newAge = scanner.nextLine();
            if (!newAge.isEmpty()) found.setAge(Integer.parseInt(newAge));

            System.out.print("New phone [" + found.getPhoneNumber() + "]: ");
            String newPhone = scanner.nextLine();
            if (!newPhone.isEmpty()) found.setPhoneNumber(newPhone);

            System.out.println("Patient updated successfully.");
        } else {
            System.out.println("No patient found with the name \"" + name + "\".");
        }
    }

    /**
     * search for a doctor by name and edit their details.
     */
    public void editDoctor() {
        System.out.println("\n--- Edit Doctor ---");

        System.out.print("Enter the name of the doctor to edit: ");
        String name = scanner.nextLine();

        Doctor found = findDoctorByName(name);

        if (found != null) {
            System.out.println("Current details: " + found);
            System.out.println("Enter new details (press Enter to keep current value):");

            System.out.print("New name [" + found.getName() + "]: ");
            String newName = scanner.nextLine();
            if (!newName.isEmpty()) found.setName(newName);

            System.out.print("New age [" + found.getAge() + "]: ");
            String newAge = scanner.nextLine();
            if (!newAge.isEmpty()) found.setAge(Integer.parseInt(newAge));

            System.out.print("New phone [" + found.getPhoneNumber() + "]: ");
            String newPhone = scanner.nextLine();
            if (!newPhone.isEmpty()) found.setPhoneNumber(newPhone);

            System.out.print("New specialization [" + found.getSpecialization() + "]: ");
            String newSpec = scanner.nextLine();
            if (!newSpec.isEmpty()) found.setSpecialization(newSpec);

            System.out.println("Doctor updated successfully.");
        } else {
            System.out.println("No doctor found with the name \"" + name + "\".");
        }
    }

    /**
     * search for a medication by name and edit its details.
     */
    public void editMedication() {
        System.out.println("\n--- Edit Medication ---");

        System.out.print("Enter the name of the medication to edit: ");
        String name = scanner.nextLine();

        Medication found = findMedicationByName(name);

        if (found != null) {
            System.out.println("Current details: " + found);
            System.out.println("Enter new details (press Enter to keep current value):");

            System.out.print("New name [" + found.getName() + "]: ");
            String newName = scanner.nextLine();
            if (!newName.isEmpty()) found.setName(newName);

            System.out.print("New dose [" + found.getDose() + "]: ");
            String newDose = scanner.nextLine();
            if (!newDose.isEmpty()) found.setDose(newDose);

            System.out.print("New quantity in stock [" + found.getQuantityInStock() + "]: ");
            String newQty = scanner.nextLine();
            if (!newQty.isEmpty()) found.setQuantityInStock(Integer.parseInt(newQty));

            System.out.println("Medication updated successfully.");
        } else {
            System.out.println("No medication found with the name \"" + name + "\".");
        }
    }


    /**
     * enter patient name and displays their details.
     */
    public void searchPatient() {
        System.out.println("\n--- Search Patient ---");

        System.out.print("Enter patient name to search: ");
        String name = scanner.nextLine();

        Patient found = findPatientByName(name);

        if (found != null) {
            System.out.println("\nPatient found:");
            System.out.println(found);
        } else {
            System.out.println("No patient found with the name \"" + name + "\".");
        }
    }

    /**
     * enter doctor name and displays their details.
     */
    public void searchDoctor() {
        System.out.println("\n--- Search Doctor ---");

        System.out.print("Enter doctor name to search: ");
        String name = scanner.nextLine();

        Doctor found = findDoctorByName(name);

        if (found != null) {
            System.out.println("\nDoctor found:");
            System.out.println(found);
        } else {
            System.out.println("No doctor found with the name \"" + name + "\".");
        }
    }

    /**
     * enter a medication name and displays its details.
     */
    public void searchMedication() {
        System.out.println("\n--- Search Medication ---");

        System.out.print("Enter medication name to search: ");
        String name = scanner.nextLine();

        Medication found = findMedicationByName(name);

        if (found != null) {
            System.out.println("\nMedication found:");
            System.out.println(found);
        } else {
            System.out.println("No medication found with the name \"" + name + "\".");
        }
    }

    /**
     * manually input a prescription
     */
    public void acceptPrescription() {
        System.out.println("\n--- Accept Prescription ---");

        // Find the doctor
        System.out.print("Enter the prescribing doctor's name: ");
        String doctorName = scanner.nextLine();
        Doctor doctor = findDoctorByName(doctorName);
        if (doctor == null) {
            System.out.println("No doctor found with the name \"" + doctorName + "\". Prescription cancelled.");
            return;
        }

        // Find the patient
        System.out.print("Enter the patient's name: ");
        String patientName = scanner.nextLine();
        Patient patient = findPatientByName(patientName);
        if (patient == null) {
            System.out.println("No patient found with the name \"" + patientName + "\". Prescription cancelled.");
            return;
        }

        // Find the medication
        System.out.print("Enter the medication name: ");
        String medName = scanner.nextLine();
        Medication medication = findMedicationByName(medName);
        if (medication == null) {
            System.out.println("No medication found with the name \"" + medName + "\". Prescription cancelled.");
            return;
        }

        // Create the prescription and link it to the patient
        Prescription prescription = new Prescription(nextPrescriptionId++, doctor, patient, medication);
        prescriptions.add(prescription);
        patient.addPrescription(prescription);
        patient.addMedication(medication);

        System.out.println("\nPrescription accepted successfully!");
        System.out.println(prescription);
    }

    /**
     * Prompts the user for a doctor name and patient name,
     * then assigns the patient to the doctor's list.
     */
    public void addPatientToDoctor() {
        System.out.println("\n--- Add Patient to Doctor ---");

        System.out.print("Enter the doctor's name: ");
        String doctorName = scanner.nextLine();
        Doctor doctor = findDoctorByName(doctorName);

        if (doctor == null) {
            System.out.println("No doctor found with the name \"" + doctorName + "\".");
            return;
        }

        System.out.print("Enter the patient's name: ");
        String patientName = scanner.nextLine();
        Patient patient = findPatientByName(patientName);

        if (patient == null) {
            System.out.println("No patient found with the name \"" + patientName + "\".");
            return;
        }

    
        doctor.addPatient(patient);
    }

    // PRIVATE HELPER METHODS

    /**
     * Searches the patients list for a patient matching the given name
     *
     * @param name 
     * @return 
     */
    public Patient findPatientByName(String name) {
        for (Patient patient : patients) {
            if (patient.getName().equalsIgnoreCase(name)) {
                return patient;
            }
        }
        return null;
    }

    /**
     * Searches the doctors list for a doctor matching the given name
     *
     * @param name 
     * @return 
     */
    public Doctor findDoctorByName(String name) {
        for (Doctor doctor : doctors) {
            if (doctor.getName().equalsIgnoreCase(name)) {
                return doctor;
            }
        }
        return null;
    }

    /**
     * Searches the medications list for a medication matching the given name
     * @param name 
     * @return 
     */
    public Medication findMedicationByName(String name) {
        for (Medication medication : medications) {
            if (medication.getName().equalsIgnoreCase(name)) {
                return medication;
            }
        }
        return null;
    }

    // GETTERS FOR LISTS

    public ArrayList<Patient> getPatients() { return patients; }
    public ArrayList<Doctor> getDoctors() { return doctors; }
    public ArrayList<Medication> getMedications() { return medications; }
    public ArrayList<Prescription> getPrescriptions() { return prescriptions; }


// 6 — GENERATE FULL SYSTEM REPORT

/**
 * Prints a full summary report of all data in the system 
 */
public void generateFullReport() {
    System.out.println("\n========================================");
    System.out.println("         FULL SYSTEM REPORT             ");
    System.out.println("========================================");
    System.out.println("Report Generated: " + LocalDate.now());

    // --- Patients ---
    System.out.println("\n--- Patients (" + patients.size() + ") ---");
    if (patients.isEmpty()) {
        System.out.println("No patients in the system.");
    } else {
        for (Patient patient : patients) {
            System.out.println(patient);
            System.out.println();
        }
    }

    // --- Doctors ---
    System.out.println("\n--- Doctors (" + doctors.size() + ") ---");
    if (doctors.isEmpty()) {
        System.out.println("No doctors in the system.");
    } else {
        for (Doctor doctor : doctors) {
            System.out.println(doctor);
            System.out.println();
        }
    }

    // --- Medications ---
    System.out.println("\n--- Medications (" + medications.size() + ") ---");
    if (medications.isEmpty()) {
        System.out.println("No medications in the system.");
    } else {
        for (Medication med : medications) {
            System.out.println(med);
        }
    }

    // --- Prescriptions ---
    System.out.println("\n--- Prescriptions (" + prescriptions.size() + ") ---");
    if (prescriptions.isEmpty()) {
        System.out.println("No prescriptions in the system.");
    } else {
        for (Prescription prescription : prescriptions) {
            System.out.println(prescription);
            System.out.println();
        }
    }

    System.out.println("========================================");
    System.out.println("           END OF REPORT                ");
    System.out.println("========================================\n");
}

// 7 — CHECK FOR EXPIRED MEDICATIONS

/**
 * Checks all medications in the system and prints a report
 * of any that have passed their expiry date.
 */
public void generateExpiredMedicationReport() {
    System.out.println("\n========================================");
    System.out.println("      EXPIRED MEDICATION REPORT         ");
    System.out.println("========================================");
    System.out.println("Report Generated: " + LocalDate.now());
    System.out.println();

    boolean anyExpired = false;

    for (Medication med : medications) {
        if (med.isExpired()) {
            System.out.println(med);
            anyExpired = true;
        }
    }

    if (!anyExpired) {
        System.out.println("No expired medications found in the system.");
    }

    System.out.println("\n========================================");
    System.out.println("           END OF REPORT                ");
    System.out.println("========================================\n");
}

// 8 — PRINT ALL PRESCRIPTIONS FOR A DOCTOR

/**
 * Prompts the user for a doctor's name and prints all
 * prescriptions that have been issued by that doctor.
 */
public void generateDoctorPrescriptionReport() {
    System.out.println("\n--- Prescriptions by Doctor ---");

    System.out.print("Enter the doctor's name: ");
    String doctorName = scanner.nextLine();

    Doctor doctor = findDoctorByName(doctorName);

    if (doctor == null) {
        System.out.println("No doctor found with the name \"" + doctorName + "\".");
        return;
    }

    System.out.println("\n========================================");
    System.out.println("     PRESCRIPTION REPORT FOR DR. " + doctor.getName().toUpperCase());
    System.out.println("========================================");
    System.out.println("Specialization: " + doctor.getSpecialization());
    System.out.println("Report Generated: " + LocalDate.now());
    System.out.println();

    boolean anyFound = false;

    for (Prescription prescription : prescriptions) {
        if (prescription.getDoctor().getId() == doctor.getId()) {
            System.out.println(prescription);
            System.out.println();
            anyFound = true;
        }
    }

    if (!anyFound) {
        System.out.println("No prescriptions found for Dr. " + doctor.getName() + ".");
    }

    System.out.println("========================================");
    System.out.println("           END OF REPORT                ");
    System.out.println("========================================\n");
}

// 9 — PAST YEAR PRESCRIPTIONS BY DRUG NAME

/**
 * Generates a report of all prescriptions issued in the past year
 */
public void generatePastYearPrescriptionReport() {
    System.out.println("\n========================================");
    System.out.println("   PRESCRIPTIONS FROM THE PAST YEAR     ");
    System.out.println("========================================");
    System.out.println("Report Generated: " + LocalDate.now());
    System.out.println();

    boolean anyFound = false;

    for (Patient patient : patients) {
        ArrayList<String> pastYearDrugs = new ArrayList<>();

        for (Prescription prescription : patient.getPrescriptions()) {
            if (prescription.isWithinPastYear()) {
                pastYearDrugs.add(prescription.getMedication().getName());
                anyFound = true;
            }
        }

        if (!pastYearDrugs.isEmpty()) {
            System.out.println("Patient: " + patient.getName());
            System.out.print("  Medications: ");
            for (int i = 0; i < pastYearDrugs.size(); i++) {
                System.out.print(pastYearDrugs.get(i));
                if (i < pastYearDrugs.size() - 1) System.out.print(", ");
            }
            System.out.println();
            System.out.println();
        }
    }

    if (!anyFound) {
        System.out.println("No prescriptions found from the past year.");
    }

    System.out.println("========================================");
    System.out.println("           END OF REPORT                ");
    System.out.println("========================================\n");
}

// 10 — RESTOCK MEDICATIONS

/**
 * Prompts the user for a restock amount and adds that
 * quantity to every medication in the system.
 */
public void restockAllMedications() {
    System.out.println("\n--- Restock All Medications ---");

    if (medications.isEmpty()) {
        System.out.println("No medications in the system to restock.");
        return;
    }

    System.out.print("Enter the amount to add to all medications: ");
    int amount = Integer.parseInt(scanner.nextLine());

    System.out.println();
    for (Medication med : medications) {
        med.restock(amount);
    }

    System.out.println("\nAll medications have been restocked successfully.");
}

}