import java.util.HashMap;
import java.util.Map;

/**
 * Represents a student in the system.
 * Inherits the attributes of the Person class.
 * Stores personal information and tracks membership fees.
 */
public class Student extends Person {
    private String studentId;
    private String section;
    private Map<Organization, Boolean> organizationPayments;

    /**
     * Class constructor for the student class.
     * @param firstName student's first name inherited from person
     * @param lastName student's last name inherited from person
     * @param studentId identifier
     * @param section extra information
     */
    public Student(String firstName, String lastName, String studentId, String section) {
        super(firstName, lastName);
        this.studentId = studentId;
        this.section = section;
        this.organizationPayments = new HashMap<>();
    }
    // Setter and Getter Functions for Section
    public void setSection(String section) {
        this.section = section;
    }
    public String getSection() {
        return section;
    }

    // Setter and Getter Functions for Student ID
    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }
    public String getStudentId() {
        return studentId;
    }


    /**
     * Used to link students with organizations.
     * @param organization joined by students and collects fees
     */
    public void joinOrganization(Organization organization) {
        organizationPayments.put(organization, false); // Default: not paid
    }

    /**
     * Maps organization payments.
     * @return organization payments hashmap
     */
    public Map<Organization, Boolean> getOrganizationPayments() {
        return organizationPayments;
    }

    /**
     * Removes organizations from the hashmap
     * @param organization list of organizations
     */
    public void leaveOrganization(Organization organization) {
        if (organizationPayments.containsKey(organization)) {
            organizationPayments.remove(organization);
        }
    }

    /**
     * Changes boolean state to true
     * @param organization list of organizations
     */
    public void markAsPaid(Organization organization) {
        if (organizationPayments.containsKey(organization)) {
            organizationPayments.put(organization, true);
            System.out.println("Payment for " + organization.getName() + " marked as paid.");
        } else {
            System.out.println("Student is not a member of " + organization.getName());
        }
    }

    /**
     * Totals unpaid membership fees
     * @return total unpaid amount (float)
     */
    public double calculateUnpaidFees() {
        double totalUnpaid = 0;
        for (Map.Entry<Organization, Boolean> entry : organizationPayments.entrySet()) {
            if (!entry.getValue()) { // Not paid
                totalUnpaid += entry.getKey().getMembershipFee();
            }
        }
        return totalUnpaid;
    }

    @Override
    public void displayInfo() {
        super.displayInfo(); // Display name from Person
        System.out.println("Student ID: " + studentId);
        System.out.println("Section: " + section);
        System.out.println("Organizations:");
        if (organizationPayments.isEmpty()) {
            System.out.println("  (No organizations joined)");
        } else {
            for (Map.Entry<Organization, Boolean> entry : organizationPayments.entrySet()) {
                String paymentStatus = entry.getValue() ? "Paid" : "Not Paid";
                System.out.println(" - " + entry.getKey().getName() + " (Fee: " + entry.getKey().getMembershipFee() + ") - " + paymentStatus);
            }
        }
        System.out.println("Total Unpaid Fees: " + calculateUnpaidFees());
    }
}
