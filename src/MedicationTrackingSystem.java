import java.util.ArrayList;
import java.util.List;

public class MedicationTrackingSystem {
    // fields
    private List<Patient> patients = new ArrayList<>();
    private List<Doctor> doctors = new ArrayList<>();

    // constructor
    public MedicationTrackingSystem() {}

    // methods
    // add Patients, Doctors and Medication
    public void addPatient(Patient patient) {
        patients.add(patient);
        System.out.println("Added patient: " + patient.getName());
    }

    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
        System.out.println("Added doctor: " + doctor.getName());
    }

//    public void addMedication(Medication medication) {
//        medication.add(medication);
//        System.out.println("Added medication: " + medication.getName());
//    }


}