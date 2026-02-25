
import java.util.Scanner;

public class MedicationSystemTest {
    public static void main(String[] args) {
     MedicationTrackingSystem system = new MedicationTrackingSystem();

        Scanner scanner = new Scanner(System.in);

        boolean running = true;

        while (running) {
            System.out.println("/n Medication Tracking System");
            System.out.println("1. Add Patient");
            System.out.println("2. Add Doctor");
            System.out.println("3. Add Medication");
            System.out.println("4. Search");
            System.out.println("5. Accept Prescription");
            System.out.println("6. Assign Patient to Doctor");
            System.out.println("7. Generate Full Report");
            System.out.println("8. Check Expired Medications");
            System.out.println("9. Doctor Prescriptions");
            System.out.println("10. Patient Prescription (Past Year)");
            System.out.println("11. Restock Medications");
            System.out.println("0. Exit");
            System.out.println("Choose an option: ");

            int choice = scanner.nextInt();
//            clear buffer
            scanner.nextLine();

            switch (choice) {
//                Add Patient
                case 1:
//                    Patient newPatient = new Patient(30, "Sammie Marie", 24, "1234567890");
                    system.addPatient();
                    break;
//                Add Doctor
                case 2:
//                    Doctor newDoctor = new Doctor(201, "Dr.Smith", 42, "09876543212","Cardiologist" );
                    system.addDoctor();
                    break;
//                Add Medication
                case 3:
//                    Medication newMedication = new Medication(3145, "Atenolol", "2mg", 45 );
                    system.addMedication();
                    break;
//                 Search
                case 4:
                    break;
            }
        }

    }
}