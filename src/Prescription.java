import java.time.LocalDate;

/**
 * Prescription represents a prescription issued by a doctor for a patient.
 * It is the central linking class of the system — it holds references to
 * a Doctor, a Patient, and a Medication all in one place.
 *
 * The prescription expiry date defaults to one year from the issue date.
 */
public class Prescription {

    // ----- Attributes -----

    private int id;
    private Doctor doctor;          // Reference to the prescribing doctor
    private Patient patient;        // Reference to the patient receiving the prescription
    private Medication medication;  // Reference to the prescribed medication
    private LocalDate issueDate;    // The date the prescription was created
    private LocalDate expiryDate;   // Defaults to one year after the issue date

    // ----- Constructor -----

    /**
     * Creates a new Prescription, automatically setting:
     *  - Issue date to today
     *  - Expiry date to exactly one year from today
     *
     * @param id         Unique identifier for this prescription.
     * @param doctor     The doctor issuing the prescription.
     * @param patient    The patient receiving the prescription.
     * @param medication The medication being prescribed.
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
     * @return true if the expiry date is before today, false otherwise.
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
     * Pulls the name directly from the linked Doctor, Patient, and Medication objects.
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