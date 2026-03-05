
import java.util.Scanner;

public class MedicationSystemTest {
    public static void main(String[] args) {
     MedicationTrackingSystem system = new MedicationTrackingSystem();

        Scanner scanner = new Scanner(System.in);

        boolean running = true;

//        menu section
        while (running) {
            System.out.println("/n Medication Tracking System");
            System.out.println("1. Add/Remove/Edit Patient");
            System.out.println("2. Add/Remove/Edit Doctor");
            System.out.println("3. Add/Remove/Edit Medication");
            System.out.println("4. Search");
            System.out.println("5. Accept Prescription");
            System.out.println("6. Assign Patient to Doctor");
            System.out.println("7. Generate Full Report");
            System.out.println("8. Check Expired Medications");
            System.out.println("9. Doctor Prescriptions");
            System.out.println("10. Patient Prescription (Past Year)");
            System.out.println("11. Restock Medications");
            System.out.println("Choose an option: ");

            int choice = scanner.nextInt();
//            clear buffer
            scanner.nextLine();

            switch (choice) {
//                Add, delete, or edit patients
                case 1:
                    system.fullEditPatient();
                    break;
//                Add, delete, or edit doctors
                case 2:
                    system.fullEditDoctor();
                    break;
//                Add, delete, or edit medications
                case 3:
                    system.fullEditMedications();
                    break;
//                 Search for patient Doctor or Medications
                case 4:
                    system.searchMenu();
                    break;
//                    Accept Prescription
                case 5:
                    system.acceptPrescription();
                    break;
//                    assign patient to doctor
                case 6:
                    system.addPatientToDoctor();
                    break;
//                    Generate Full Report
                case 7:
                    system.generateFullReport();
                    break;
//                    Check for expired medications
                case 8:
                    system.generateExpiredMedicationReport();
                    break;
//                    Doctor Prescriptions
                case 9:
                    system.generateDoctorPrescriptionReport();
                    break;
//                    Patient Prescription (Past Year)
                case 10:
                    system.generatePastYearPrescriptionReport();
                    break;
//                Restock Medications
                case 11:
                    system.restockAllMedications();
                    break;
                }
            }
        }
    }