/**
 * Represents a person in the system.
 * Stores the name of a person and displays it.
 */
public class Person {
    private String firstName;
    private String lastName;

    /**
     * Constructs a person with the given details.
     *
     * @param firstName the first name of the person
     * @param lastName the last name of the person
     */
    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // Setter and Getter Functions for First Name
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    // Setter and Getter Functions for Last Name
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    // Getter function for Full name
    public String getFullName() {
        return firstName + " " + lastName;
    }

    // Display Function (Overrode in Student Class)
    public void displayInfo() {
        System.out.println("Name: " + getFullName());
    }
}