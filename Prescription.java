import java.time.LocalDate;

/**
 * represents a prescription issued by a doctor for a patient.
 */
public class Prescription {

    // ----- Attributes -----

    private int id;
    private Doctor doctor;          
    private Patient patient;      
    private Medication medication;  
    private LocalDate issueDate;    
    private LocalDate expiryDate;  


    // ----- Constructor -----

    /**
     * Creates a new Prescription, automatically setting:
     *  - Issue date to today
     *  - Expiry date to exactly one year from today
     * @param id         
     * @param doctor     
     * @param patient    
     * @param medication 
     */
    public Prescription(int id, Doctor doctor, Patient patient, Medication medication) {
        this.id = id;
        this.doctor = doctor;
        this.patient = patient;
        this.medication = medication;
        this.issueDate = LocalDate.now();            // Today's date
        this.expiryDate = issueDate.plusYears(1);    // Exactly one year from today
    }

    // ----- Getters -----

    public int getId() {
        return id;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public Medication getMedication() {
        return medication;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    // ----- Helper Methods -----

    /**
     * Checks whether this prescription has expired based on today's date.
     *
     * @return true if the expiry date is before today
     */
    public boolean isExpired() {
        return expiryDate.isBefore(LocalDate.now());
    }

    /**
     * Checks whether this prescription was issued within the past year.
     * Used by the MedicationTrackingSystem when generating the
     * "all patient prescriptions for the past year" report.
     *
     * @return true if the issue date is within the last 365 days.
     */
    public boolean isWithinPastYear() {
        LocalDate oneYearAgo = LocalDate.now().minusYears(1);
        return issueDate.isAfter(oneYearAgo);
    }

    // ----- Display -----

    /**
     * Returns a full summary of this prescription.
     */
    @Override
    public String toString() {
        return "Prescription ID: " + id +
               "\n   Issued:    " + issueDate +
               "\n   Expires:   " + expiryDate + (isExpired() ? " *** EXPIRED ***" : "") +
               "\n   Doctor:    Dr. " + doctor.getName() + " (" + doctor.getSpecialization() + ")" +
               "\n   Patient:   " + patient.getName() +
               "\n   Medication: " + medication.getName() + " | Dose: " + medication.getDose();
    }
}