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
     *
     * @param firstName inherited from Person
     * @param lastName inherited from Person
     * @param studentId an identifier of the Student
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

    public Map<Organization, Boolean> getOrganizationPayments() {
        return organizationPayments;
    }

    public void leaveOrganization(Organization organization) {
        if (organizationPayments.containsKey(organization)) {
            organizationPayments.remove(organization);
        }
    }

    public void markAsPaid(Organization organization) {
        if (organizationPayments.containsKey(organization)) {
            organizationPayments.put(organization, true);
            System.out.println("Payment for " + organization.getName() + " marked as paid.");
        } else {
            System.out.println("Student is not a member of " + organization.getName());
        }
    }

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
