import java.time.LocalDate;
import java.util.Random;

/**
 * represents a drug available in the pharmacy system.
 */
public class Medication {

    // ----- Attributes -----

    private int id;
    private String name;
    private String dose;         
    private int quantityInStock;
    private LocalDate expiryDate;

    // ----- Constructor -----

    /**
     * Creates a new Medication with a randomly generated expiry date.
     * @param id             
     * @param name           
     * @param dose           
     * @param quantityInStock 
     */
    public Medication(int id, String name, String dose, int quantityInStock) {
        this.id = id;
        this.name = name;
        this.dose = dose;
        this.quantityInStock = quantityInStock;
        this.expiryDate = generateRandomExpiryDate();
    }

    // ----- Random Expiry Date Generator -----

    /**
     * Generates a random expiry date between 3 years ago and 3 years from now.
     * This means some medications will already be expired when added — which
     * is intentional so the expired medication report has something to find!
     *
     * How it works:
     *  - We start from today's date
     *  - We pick a random number of days between -1095 (3 years ago)
     *    and +1095 (3 years from now)
     *  - We add that offset to today to get the expiry date
     *
     * @return A randomly generated LocalDate for the expiry date.
     */
    private LocalDate generateRandomExpiryDate() {
        Random random = new Random();

        // Range: -1095 days (3 years ago) to +1095 days (3 years ahead)
        int dayOffset = random.nextInt(2191) - 1095; // 2191 = total range, shift back by 1095

        return LocalDate.now().plusDays(dayOffset);
    }

    // ----- Getters -----

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDose() {
        return dose;
    }

    public int getQuantityInStock() {
        return quantityInStock;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    // ----- Setters -----
    // (Used by the edit and restock functionality in MedicationTrackingSystem)

    public void setName(String name) {
        this.name = name;
    }

    public void setDose(String dose) {
        this.dose = dose;
    }

    public void setQuantityInStock(int quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    // ----- Helper Methods -----

    /**
     * Checks whether this medication is expired based on today's date.
     *
     * @return true if the expiry date is before today, false otherwise.
     */
    public boolean isExpired() {
        return expiryDate.isBefore(LocalDate.now());
    }

    /**
     * Adds a given amount to the current stock.
     * Used by the restock functionality.
     *
     * @param amount The number of units to add to stock.
     */
    public void restock(int amount) {
        if (amount > 0) {
            this.quantityInStock += amount;
            System.out.println(name + " restocked by " + amount +
                               " units. New stock: " + quantityInStock);
        } else {
            System.out.println("Restock amount must be greater than zero.");
        }
    }

    // ----- Display -----

    /**
     * Returns a formatted summary of this medication's details.
     * Flags the medication as EXPIRED if its expiry date has passed.
     */
    @Override
    public String toString() {
        String expiryStatus = isExpired() ? " *** EXPIRED ***" : "";

        return "ID: " + id +
               " | Name: " + name +
               " | Dose: " + dose +
               " | Stock: " + quantityInStock +
               " | Expiry: " + expiryDate + expiryStatus;
    }
}