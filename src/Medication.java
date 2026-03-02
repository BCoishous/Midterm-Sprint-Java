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
     * Creates a new Medication
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
     * @return
     */
    private LocalDate generateRandomExpiryDate() {
        Random random = new Random();

        
        int dayOffset = random.nextInt(2191) - 1095; 

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
     * @return true if the expiry date is before today
     */
    public boolean isExpired() {
        return expiryDate.isBefore(LocalDate.now());
    }

    /**
     * Adds a given amount to the current stock.
     * @param amount 
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
     * Returns a summary of this medication's details.
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