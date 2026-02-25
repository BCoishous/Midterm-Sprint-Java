
public abstract class Person {

    private int id;
    private String name;
    private int age;
    private String phoneNumber;

    // ----- Constructor -----

    /**
     * @param id          
     * @param name        
     * @param age         
     * @param phoneNumber 
     */
    public Person(int id, String name, int age, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
    }

    // ----- Getters -----

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    // ----- Setters -----

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    // ----- Display -----

    /**
     * Returns a formatted string of basic details
     */
    @Override
    public String toString() {
        return "ID: " + id +
               " | Name: " + name +
               " | Age: " + age +
               " | Phone: " + phoneNumber;
    }
}