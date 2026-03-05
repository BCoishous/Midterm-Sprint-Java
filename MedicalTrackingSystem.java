
//**Generating Comprehensive summary report */ 
public void generateComprehensiveSummaryReport() {
    System.out.println("\n" + "".repeat(80));
    System.out.println("" + " ".repeat(78) + "");
    System.out.println("" + String.format("%78s", "PHARMACY MEDICATION TRACKING SYSTEM").replaceAll(" +$", " "));
    System.out.println("" + String.format("%78s", "COMPREHENSIVE SYSTEM SUMMARY REPORT").replaceAll(" +$", " "));
    System.out.println("" + " ".repeat(78) + "");
    System.out.println("".repeat(80));
    
    System.out.println("\nReport Generated: " + LocalDate.now() + " at " + java.time.LocalTime.now().format(
            java.time.format.DateTimeFormatter.ofPattern("HH:mm:ss")));
    System.out.println("=".repeat(80));

    // ===== SYSTEM STATISTICS =====
    System.out.println("\n[ SYSTEM STATISTICS ]");
    System.out.println("-".repeat(80));
    System.out.println("Total Patients:      " + String.format("%3d", patients.size()));
    System.out.println("Total Doctors:       " + String.format("%3d", doctors.size()));
    System.out.println("Total Medications:   " + String.format("%3d", medications.size()));
    System.out.println("Total Prescriptions: " + String.format("%3d", prescriptions.size()));
    System.out.println("=".repeat(80));

    // ===== PATIENTS SUMMARY =====
    generatePatientsSummary();

    // ===== DOCTORS SUMMARY =====
    generateDoctorsSummary();

    // ===== MEDICATIONS SUMMARY =====
    generateMedicationsSummary();

    // ===== PRESCRIPTIONS SUMMARY =====
    generatePrescriptionsSummary();

    // ===== SYSTEM HEALTH CHECK =====
    generateSystemHealthCheck();

    System.out.println("\n" + "".repeat(80));
    System.out.println("" + String.format("%78s", "End of Report").replaceAll(" +$", " █"));
    System.out.println("".repeat(80) + "\n");
}

/**
 * generate patient summary 
 */
private void generatePatientsSummary() {
    System.out.println("\n[ PATIENTS SUMMARY ]");
    System.out.println("-".repeat(80));

    if (patients.isEmpty()) {
        System.out.println("No patients registered in the system.");
        return;
    }

    System.out.printf("%-5s %-20s %-5s %-15s %-15s %-15s\n", 
                      "ID", "Name", "Age", "Phone", "Medications", "Prescriptions");
    System.out.println("-".repeat(80));

    int totalMedications = 0;
    int totalPrescriptions = 0;
    int ageSum = 0;
        Object patients;

    for (Patient patient : patients) {
        int medCount = patient.getMedications().size();
        int presCount;
        presCount = patient.getPrescriptions().size();
        
        totalMedications += medCount;
        totalPrescriptions += presCount;
        ageSum += patient.getAge();

        System.out.printf("%-5d %-20s %-5d %-15s %-15d %-15d\n",
                         patient.getId(),
                         patient.getName(),
                         patient.getAge(),
                         patient.getPhoneNumber(),
                         medCount,
                         presCount);
    }

    System.out.println("-".repeat(80));
    System.out.println("PATIENT STATISTICS:");
    System.out.println("  Total Patients: " + Arrays.toString(patients.size()));
    if (patients != null && !patients.isEmpty()) {
    double averageAge = (double) ageSum / patients.size();
    System.out.println("  Average Age: " + String.format("%.1f", averageAge) + " years");
    } else {
    System.out.println("  Average Age: N/A (no patients)");
}
    System.out.println("  Total Medications Prescribed: " + totalMedications);
    System.out.println("  Total Prescriptions: " + totalPrescriptions);
    System.out.println("  Avg Medications per Patient: " + String.format("%.2f", (double) totalMedications / patients.size()));
}

/**
 * generate doctors summary 
 */
private void generateDoctorsSummary() {
    System.out.println("\n[ DOCTORS SUMMARY ]");
    System.out.println("-".repeat(80));

    if (doctors.isEmpty()) {
        System.out.println("No doctors registered in the system.");
        return;
    }

    System.out.printf("%-5s %-20s %-15s %-20s %-15s\n",
                      "ID", "Name", "Specialization", "Phone", "Patients");
    System.out.println("-".repeat(80));

    int totalPatientsUnderCare = 0;
    int totalPrescriptionsIssued = 0;
        Iterable<Doctor> doctors = null;

    for (Doctor doctor : doctors) {
        int patientCount = doctor.getPatients().size();
        totalPatientsUnderCare += patientCount;

        // Count prescriptions issued by this doctor
        int prescCount = 0;
        Iterable<Prescription> prescriptions = null;
        for (Prescription prescription : prescriptions) {
            if (prescription.getDoctor() != null &&
           prescription.getDoctor().getId() == doctor.getId());
        }
        totalPrescriptionsIssued += prescCount;

        System.out.printf("%-5d %-20s %-15s %-20s %-15d\n",
                         doctor.getId(),
                         doctor.getName(),
                         doctor.getSpecialization(),
                         doctor.getPhoneNumber(),
                         patientCount);
    }

    System.out.println("-".repeat(80));
    System.out.println("DOCTOR STATISTICS:");
    System.out.println("  Total Doctors: " + Arrays.toString(doctors.size()));
    System.out.println("  Total Patients Under Care: " + totalPatientsUnderCare);
    System.out.println("  Total Prescriptions Issued: " + totalPrescriptionsIssued);
    System.out.println("  Avg Patients per Doctor: " + String.format("%.2f", 
                       (double) totalPatientsUnderCare / doctors.size()));

    // Show specializations breakdown
    System.out.println("\n  Specialization Breakdown:");
    java.util.Map<String, Integer> specMap = new java.util.HashMap<>();
    for (Doctor doctor : doctors) {
        specMap.put(doctor.getSpecialization(),
                   specMap.getOrDefault(doctor.getSpecialization(), 0) + 1);
    }
    for (String spec : specMap.keySet()) {
        System.out.println("    - " + spec + ": " + specMap.get(spec) + " doctor(s)");
    }
}

/**
 * medications summary 
 */
private void generateMedicationsSummary() {
    System.out.println("\n[ MEDICATIONS SUMMARY ]");
    System.out.println("-".repeat(80));

    if (medications.isEmpty()) {
        System.out.println("No medications in the system.");
        return;
    }

    System.out.printf("%-5s %-25s %-12s %-10s %-12s %-10s\n",
                      "ID", "Name", "Dose", "Stock", "Expiry Date", "Status");
    System.out.println("-".repeat(80));

    int totalStock = 0;
    int expiredCount = 0;
    int lowStockCount = 0;
    Iterable<Medication> medications;

    for (Medication med : medications) {
        totalStock += med.getQuantityInStock();

        String status = "OK";
        if (med.getExpiryDate() != null && med.getExpiryDate().isBefore(LocalDate.now()));
             else if (med.getQuantityInStock() <= 10) {
            status = "LOW";
            lowStockCount++;
        }

        System.out.printf("%-5d %-25s %-12s %-10d %-12s %-10s\n",
                         med.getId(),
                         med.getName(),
                         med.getDose(),
                         med.getQuantityInStock(),
                         med.getExpiryDate(),
                         status);
    }

    System.out.println("-".repeat(80));
    System.out.println("MEDICATION STATISTICS:");
    System.out.println("  Total Medications: " + medications.size());
    System.out.println("  Total Units in Stock: " + totalStock);
    System.out.println("  Avg Stock per Medication: " + String.format("%.2f", 
                       (double) totalStock / medications.size()));
    System.out.println("  Expired Medications: " + expiredCount);
    System.out.println("  Low Stock Medications (≤10): " + lowStockCount);

    // Stock levels analysis
    int highStock = 0;
    int normalStock = 0;
    for (Medication med : medications) {
        if (med.getQuantityInStock() > 50) highStock++;
        else if (med.getQuantityInStock() >= 10) normalStock++;
    }
    System.out.println("\n  Stock Distribution:");
    System.out.println("    - High (>50): " + highStock);
    System.out.println("    - Normal (10-50): " + normalStock);
    System.out.println("    - Low (≤10): " + lowStockCount);
}
/**
     * Helper method to generate the prescriptions summary section
     */

/**
 * system health check 
 */
private void generateSystemHealthCheck() {
    System.out.println("\n[ SYSTEM HEALTH CHECK ]");
    System.out.println("-".repeat(80));

    ArrayList<String> alerts = new ArrayList<>();
    ArrayList<String> warnings = new ArrayList<>();

    // Check for expired medications
    long expiredMeds = medications.stream().filter(Medication::isExpired).count();
    if (expiredMeds > 0) {
        alerts.add("⚠ " + expiredMeds + " expired medication(s) detected - IMMEDIATE ACTION REQUIRED");
    }

    // Check for low stock
    long lowStockMeds = medications.stream()
                                  .filter(m -> m.getQuantityInStock() <= 10)
                                  .count();
    if (lowStockMeds > 0) {
        warnings.add("⚠ " + lowStockMeds + " medication(s) with low stock levels");
    }

    // Check for patients without doctors
    long patientWithoutDoctors = patients.stream()
                                        .filter(p -> !hasDoctorAssigned(p))
                                        .count();
    if (patientWithoutDoctors > 0) {
        warnings.add("⚠ " + patientWithoutDoctors + " patient(s) not assigned to any doctor");
    }

    // Check for doctors without patients
    long doctorsWithoutPatients = doctors.stream()
                                        .filter(d -> d.getPatients().isEmpty())
                                        .count();
    if (doctorsWithoutPatients > 0) {
        warnings.add("ℹ " + doctorsWithoutPatients + " doctor(s) currently not assigned any patients");
    }

    // Display alerts
    if (alerts.isEmpty() && warnings.isEmpty()) {
        System.out.println("✓ System is healthy - No critical issues detected");
    } else {
        if (!alerts.isEmpty()) {
            System.out.println("ALERTS:");
            for (String alert : alerts) {
                System.out.println("  " + alert);
            }
        }

        if (!warnings.isEmpty()) {
            System.out.println("\nWARNINGS:");
            for (String warning : warnings) {
                System.out.println("  " + warning);
            }
        }
    }

    System.out.println("=".repeat(80));
}

    private void generatePrescriptionsSummary() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
/**
     * check if a patient has a doctor assigned
     */

    private static class prescriptions {

        private static String size() {
            throw new UnsupportedOperationException("Not supported yet.");
        }


        public prescriptions() {
        }
    }

    private static class medications {

        private static boolean isEmpty() {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        private static String size() {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        private static Object stream() {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        public medications() {
        }
    }

    private static class patients {

        private static Object[] size() {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        private static boolean isEmpty() {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        private static Object stream() {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        public patients() {
        }
    }

    private static class doctors {

        private static Object stream() {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        private static boolean isEmpty() {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        private static Object[] size() {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        public doctors() {
        }
    }

    private static class Patient {

        public Patient() {
        }

        private Object getPrescriptions() {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        private Object getMedications() {
            throw new UnsupportedOperationException("Not supported yet.");
        }
    }
