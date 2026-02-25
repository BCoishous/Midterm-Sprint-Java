import java.util.ArrayList;

/**
 * represents a patient in the pharmacy system.
 */
public class Patient extends Person {

    // ----- Attributes -----

    // list of medications patient is currently taking
    private ArrayList<Medication> medications;

    // list of prescriptions for this patient
    private ArrayList<Prescription> prescriptions;

    // ----- Constructor -----

    /**
     * Creates a new Patient.
     * @param id          Unique identifier for this patient.
     * @param name        Full name of the patient.
     * @param age         Age of the patient.
     * @param phoneNumber Contact phone number.
     */
    public Patient(int id, String name, int age, String phoneNumber) {
        super(id, name, age, phoneNumber); 

        // Initialize both lists 
        this.medications = new ArrayList<>();
        this.prescriptions = new ArrayList<>();
    }

    // ----- Getters -----

    public ArrayList<Medication> getMedications() {
        return medications;
    }

    public ArrayList<Prescription> getPrescriptions() {
        return prescriptions;
    }

    // ----- Methods -----

    /**
     * Adds medication to this patient's list.
     * @param medication 
     */
    public void addMedication(Medication medication) {
        medications.add(medication);
    }

    /**
     * Removes a medication from this patient's  list.
     *
     * @param medication 
     */
    public void removeMedication(Medication medication) {
        medications.remove(medication);
    }

    /**
     * Adds a prescription to this patient's list.
     *
     * @param prescription 
     */
    public void addPrescription(Prescription prescription) {
        prescriptions.add(prescription);
    }

    /**
     * Removes a prescription from this patient'slist.
     *
     * @param prescription 
     */
    public void removePrescription(Prescription prescription) {
        prescriptions.remove(prescription);
    }

    // ----- Display -----

    /**
     * Returns a full summary of this patient's details.
     */
    @Override
    public String toString() {
        // Build a readable list of medication names
        StringBuilder medNames = new StringBuilder();
        if (medications.isEmpty()) {
            medNames.append("None");
        } else {
            for (int i = 0; i < medications.size(); i++) {
                medNames.append(medications.get(i).getName());
                if (i < medications.size() - 1) medNames.append(", ");
            }
        }

        // Build a readable list of prescription IDs
        StringBuilder presIds = new StringBuilder();
        if (prescriptions.isEmpty()) {
            presIds.append("None");
        } else {
            for (int i = 0; i < prescriptions.size(); i++) {
                presIds.append("Prescription #").append(prescriptions.get(i).getId());
                if (i < prescriptions.size() - 1) presIds.append(", ");
            }
        }

        return super.toString() +                          // Reuses Person's toString
               "\n   Medications: " + medNames +
               "\n   Prescriptions: " + presIds;
    }
}