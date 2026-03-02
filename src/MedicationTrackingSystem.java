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
     * enter details for a new patient then adds them to the system.
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
     * enter details for a new doctor and adds them to the system.
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
     * enter details for a new medication and adds it to the system.
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

//    allow the user to add, remove or edit patients
    public void fullEditPatient() {
        System.out.println("\n Edit patient menu: ");
        System.out.println(" 1. Add new Patient");
        System.out.println(" 2. Delete Patient");
        System.out.println(" 3. Edit Patient Info");
        System.out.println(" 0. Back");

        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                addPatient();
                break;
            case 2:
                deletePatient();
                break;
            case 3:
                editPatient();
                break;
            case 0:
                return;
            }
        }

//    allow the user to add, remove or edit Doctor info
    public void fullEditDoctor() {
        System.out.println("\n Edit Doctor menu: ");
        System.out.println(" 1. Add new Doctor");
        System.out.println(" 2. Delete Doctor");
        System.out.println(" 3. Edit Doctor Info");
        System.out.println(" 0. Back");

        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                addDoctor();
                break;
            case 2:
                deleteDoctor();
                break;
            case 3:
                editDoctor();
                break;
            case 0:
                return;
        }
    }

//    allow the user to add, remove or edit Medications
    public void fullEditMedications() {
        System.out.println("\n Edit Medications menu: ");
        System.out.println(" 1. Add new Medications");
        System.out.println(" 2. Delete Medications");
        System.out.println(" 3. Edit Medication Info");
        System.out.println(" 0. Back");

        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                addMedication();
                break;
            case 2:
                deleteMedication();
                break;
            case 3:
                editMedication();
                break;
            case 0:
                return;
        }
    }
    /**
     * Prompts the user for a patient name and displays their details.
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
     * Prompts the user for a doctor name and displays their details.
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
     * Prompts the user for a medication name and displays its details.
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

//    code to allow the searchs to be under one option in the menu
    public void searchMenu() {
        System.out.println("\n Search Menu: ");
        System.out.println(" 1. Search Doctor");
        System.out.println(" 2. Search Patient");
        System.out.println(" 3. Search Medication");
        System.out.println(" 0. Back");

        int choice = scanner.nextInt();
        scanner.nextLine();

    switch (choice) {
        case 1:
            searchDoctor();
            break;
        case 2:
            searchPatient();
            break;
        case 3:
            searchMedication();
            break;
        case 0:
            return;
        }
    }

    /**
     * Prompts the user to manually input a prescription
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
     * Searches the patients list for a patient matching the given name (case-insensitive).
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

}