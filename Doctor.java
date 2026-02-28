import java.util.ArrayList;

/**
 * represents a doctor in the pharmacy system.
 */
public class Doctor extends Person {

    // ----- Attributes -----

    private String specialization;

    private ArrayList<Patient> patients;

    // ----- Constructor -----

    /**
     * Creates a new Doctor.
     * @param id            
     * @param name           
     * @param age            
     * @param phoneNumber    
     * @param specialization 
     */
    public Doctor(int id, String name, int age, String phoneNumber, String specialization) {
        super(id, name, age, phoneNumber); 
        this.specialization = specialization;
        this.patients = new ArrayList<>();  
    }

   
    // ----- Getters -----

    public String getSpecialization() {
        return specialization;
    }

    public ArrayList<Patient> getPatients() {
        return patients;
    }

    
    // ----- Setters -----

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    
    // ----- Methods -----

    /**
     * Adds a patient to this doctor's patient list.
     * @param patient 
     */
    public void addPatient(Patient patient) {
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
     * @param patient 
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
     * @param patient 
     * @return true if the patient is in the list
     */
    public boolean hasPatient(Patient patient) {
        return patients.contains(patient);
    }

    // ----- Display -----

    /**
     * Returns a full summary of this doctor's details.
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