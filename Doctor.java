import java.util.ArrayList;

/**
 * Doctor represents a doctor in the pharmacy system.
 * It extends Person, inheriting ID, name, age, and phone number.
 * Each doctor also has a specialization and manages a list of patients.
 */
public class Doctor extends Person {

    // ----- Attributes -----

    // The doctor's medical specialization (e.g. "Cardiology", "General Practice")
    private String specialization;

    // The list of patients this doctor is currently managing
    private ArrayList<Patient> patients;

    // ----- Constructor -----

    /**
     * Creates a new Doctor.
     * super() is called first to initialize the shared Person fields.
     *
     * @param id             Unique identifier for this doctor.
     * @param name           Full name of the doctor.
     * @param age            Age of the doctor.
     * @param phoneNumber    Contact phone number.
     * @param specialization The doctor's area of medical specialization.
     */
    public Doctor(int id, String name, int age, String phoneNumber, String specialization) {
        super(id, name, age, phoneNumber); // Calls the Person constructor first

        this.specialization = specialization;
        this.patients = new ArrayList<>();  // Start with an empty patient list
    }

    // ----- Getters -----

    public String getSpecialization() {
        return specialization;
    }

    public ArrayList<Patient> getPatients() {
        return patients;
    }

    // ----- Setters -----
    // (Used by the edit functionality in MedicationTrackingSystem)

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    // ----- Methods -----

    /**
     * Adds a patient to this doctor's patient list.
     * Called by the "Add Patient to Doctor" functionality.
     *
     * @param patient The patient to add.
     */
    public void addPatient(Patient patient) {
        // Avoid adding the same patient twice
        if (!patients.contains(patient)) {
            patients.add(patient);
            System.out.println(patient.getName() + " has been added to Dr. " + getName() + "'s patient list.");
        } else {
            System.out.println(patient.getName() + " is already under Dr. " + getName() + "'s care.");
        }
    }

    /**
     * Removes a patient from this doctor's patient list.
     *
     * @param patient The patient to remove.
     */
    public void removePatient(Patient patient) {
        if (patients.remove(patient)) {
            System.out.println(patient.getName() + " has been removed from Dr. " + getName() + "'s patient list.");
        } else {
            System.out.println(patient.getName() + " was not found in Dr. " + getName() + "'s patient list.");
        }
    }

    /**
     * Checks whether a specific patient is under this doctor's care.
     *
     * @param patient The patient to look for.
     * @return true if the patient is in the list, false otherwise.
     */
    public boolean hasPatient(Patient patient) {
        return patients.contains(patient);
    }

    // ----- Display -----

    /**
     * Returns a full summary of this doctor's details.
     * Reuses Person's toString() and adds specialization and patient info.
     */
    @Override
    public String toString() {
        // Build a readable list of patient names
        StringBuilder patientNames = new StringBuilder();
        if (patients.isEmpty()) {
            patientNames.append("None");
        } else {
            for (int i = 0; i < patients.size(); i++) {
                patientNames.append(patients.get(i).getName());
                if (i < patients.size() - 1) patientNames.append(", ");
            }
        }

        return super.toString() +                            // Reuses Person's toString
               "\n   Specialization: " + specialization +
               "\n   Patients: " + patientNames;
    }
}