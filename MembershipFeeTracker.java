import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Map;

/**
 * The main class of the project.
 * Contains all the methods relevant to the membership fee management.
 */
public class MembershipFeeTracker {
    /**
     * This is the main method of the project.
     * <p>
     * This is the entry point of the entire program.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Student> students = new ArrayList<>();
        List<Organization> organizations = new ArrayList<>();

        while (true) {
            // Main Menu
            System.out.println("\n==== Membership Fee Tracker ====");
            System.out.println("1. Manage Organizations");
            System.out.println("2. Manage Students");
            System.out.println("3. View All Students");
            System.out.println("4. Manage Membership Fee Payments");
            System.out.println("5. Search Student Record");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    // Manage organizations menu
                    manageOrganizations(scanner, organizations);
                    break;

                case 2:
                    // Manage students menu
                    manageStudents(scanner, students, organizations);
                    break;

                case 3:
                    // Display all students in a table
                    viewAllStudents(students);
                    break;

                case 4:
                    // Manage payments menu
                    managePayments(scanner, students);
                    break;

                case 5:
                    // Searches student by StudentID
                    searchStudent(scanner, students);
                    break;

                case 0:
                    // Terminates the program
                    System.out.println("Exiting program. Bye!");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    // Default case
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    /**
     * Adds, deletes, and updates organizations
     * @param scanner for user inputs
     * @param organizations list of organizations
     */
    private static void manageOrganizations(Scanner scanner, List<Organization> organizations) {
        while (true) {
            System.out.println("\n==== Manage Organizations ====");
            System.out.println("1. Add Organization");
            System.out.println("2. Edit Organization");
            System.out.println("3. Delete Organization");
            System.out.println("4. View All Organizations");
            System.out.println("5. Return to Main Menu");
            System.out.print("Enter your choice: ");

            int orgChoice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (orgChoice) {
                case 1:
                    // Add Organization
                    System.out.println("\n\n==== Add Organization ====");
                    System.out.print("Enter organization name: ");
                    String orgName = scanner.nextLine();
                    System.out.print("Enter membership fee: ");
                    double membershipFee = scanner.nextDouble();
                    organizations.add(new Organization(orgName, membershipFee));
                    System.out.println("Organization added: " + orgName);
                    break;

                case 2:
                    // Edit Organization
                    if (organizations.isEmpty()) {
                        System.out.println("No organizations available to edit.");
                        break;
                    }
                    System.out.println("\n\n==== Edit Organization ====");
                    System.out.println("Available Organizations:");
                    for (int i = 0; i < organizations.size(); i++) {
                        System.out.println(i + 1 + ". " + organizations.get(i).getName());
                    }
                    System.out.print("Enter the number of the organization to edit: ");
                    int orgEditIndex = scanner.nextInt() - 1;
                    scanner.nextLine();

                    if (orgEditIndex >= 0 && orgEditIndex < organizations.size()) {
                        Organization orgToEdit = organizations.get(orgEditIndex);
                        System.out.print("Enter new name for " + orgToEdit.getName() + ": ");
                        String newOrgName = scanner.nextLine();
                        System.out.print("Enter new membership fee: ");
                        double newMembershipFee = scanner.nextDouble();
                        orgToEdit.setName(newOrgName);
                        orgToEdit.setMembershipFee(newMembershipFee);
                        System.out.println("Organization updated successfully.");
                    } else {
                        System.out.println("Invalid choice.");
                    }
                    break;

                case 3:
                    // Delete Organization
                    if (organizations.isEmpty()) {
                        System.out.println("No organizations available to delete.");
                        break;
                    }
                    System.out.println("\n\n==== Add Organization ====");
                    System.out.println("Available Organizations:");
                    for (int i = 0; i < organizations.size(); i++) {
                        System.out.println(i + 1 + ". " + organizations.get(i).getName());
                    }
                    System.out.print("Enter the number of the organization to delete: ");
                    int orgDelIndex = scanner.nextInt() - 1;
                    scanner.nextLine(); // Consume newline

                    if (orgDelIndex >= 0 && orgDelIndex < organizations.size()) {
                        Organization orgToRemove = organizations.remove(orgDelIndex);
                        System.out.println("Organization '" + orgToRemove.getName() + "' deleted successfully.");
                    } else {
                        System.out.println("Invalid choice.");
                    }
                    break;

                case 4:
                    // View All Organizations
                    if (organizations.isEmpty()) {
                        System.out.println("No organizations available.");
                    } else {
                        System.out.println("\n==== Organizations List ====");
                        for (int i = 0; i < organizations.size(); i++) {
                            Organization org = organizations.get(i);
                            System.out.println((i + 1) + ". " + org.getName() + " (Fee: " + org.getMembershipFee() + ")");
                        }
                    }
                    break;

                case 5:
                    return;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    /**
     * Adds, deleted, updates student details
     * @param scanner for user inputs
     * @param students list of students
     * @param organizations list of organizations
     */
    private static void manageStudents(Scanner scanner, List<Student> students, List<Organization> organizations) {
        while (true) {
            System.out.println("\n\n==== Manage Students ====");
            System.out.println("1. Add Student");
            System.out.println("2. Edit Student");
            System.out.println("3. Delete Student");
            System.out.println("4. View All Students");
            System.out.println("5. Return to Main Menu");
            System.out.print("Enter your choice: ");

            int studentChoice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (studentChoice) {
                case 1:
                    // Add Student
                    System.out.println("\n\n==== Add Student ====");
                    System.out.print("Enter first name: ");
                    String firstName = scanner.nextLine();
                    System.out.print("Enter last name: ");
                    String lastName = scanner.nextLine();
                    System.out.print("Enter student ID: ");
                    String studentId = scanner.nextLine();
                    System.out.print("Enter section: ");
                    String section = scanner.nextLine();

                    Student student = new Student(firstName, lastName, studentId, section);
                    students.add(student);

                    if (!organizations.isEmpty()) {
                        System.out.println("Available Organizations:");
                        for (int i = 0; i < organizations.size(); i++) {
                            System.out.println((i + 1) + ". " + organizations.get(i).getName());
                        }
                        System.out.println("Enter the number of the organization to join (or 0 to finish):");
                        int orgChoice;
                        while ((orgChoice = scanner.nextInt()) != 0) {
                            if (orgChoice > 0 && orgChoice <= organizations.size()) {
                                student.joinOrganization(organizations.get(orgChoice - 1));
                                System.out.println("Joined " + organizations.get(orgChoice - 1).getName());
                            } else {
                                System.out.println("Invalid choice. Try again.");
                            }
                        }
                    } else {
                        System.out.println("No organizations available. Add an organization first.");
                    }
                    break;

                case 2:
                    // Edit Student
                    editStudent(scanner, students, organizations);
                    break;

                case 3:
                    // Delete Student
                    deleteStudent(scanner, students);
                    break;

                case 4:
                    // Display Students in a Table
                    viewAllStudents(students);
                    break;

                case 5:
                    return;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    /**
     * Deletes student by entering student ID
     * @param scanner for user inputs
     * @param students list of students
     */
    private static void deleteStudent(Scanner scanner, List<Student> students) {
        if (students.isEmpty()){
            System.out.println("No students available to delete.");
            return;
        }

        viewAllStudents(students);
        System.out.println("\n\n==== Delete Student ====");
        System.out.print("Enter student ID: ");
        String studentId = scanner.nextLine();
        Student studentToDelete = searchAlgo(students, studentId);
        if (studentToDelete == null) {
            System.out.println("Student '" + studentId + "' not found.");
        }else{
            students.remove(studentToDelete);
            System.out.println("Student '" + studentToDelete.getFullName() + "' deleted successfully.");
        }


    }

    /**
     * Update student details
     * @param scanner for user inputs
     * @param students list of students
     * @param organizations list of organizations
     */
    private static void editStudent(Scanner scanner, List<Student> students, List<Organization> organizations) {
        if (students.isEmpty()) {
            System.out.println("No students available to edit. Add students first.");
            return;
        }

        System.out.println("\n\n==== Edit Student ====");
        System.out.print("Enter Student ID: ");
        String studentId = scanner.nextLine();

        Student studentToEdit = searchAlgo(students, studentId);

        if (studentToEdit == null) {
            System.out.println("Student with ID " + studentId + " not found.");
            return;
        }

        System.out.println("\nEditing Student: " + studentToEdit.getFullName());
        System.out.println("1. Edit Name");
        System.out.println("2. Edit Section");
        System.out.println("3. Join an Organization");
        System.out.println("4. Leave an Organization");
        System.out.println("5. Cancel");
        System.out.print("Enter your choice: ");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (choice) {
            case 1:
                System.out.print("Enter new first name: ");
                String newFirstName = scanner.nextLine();
                System.out.print("Enter new last name: ");
                String newLastName = scanner.nextLine();
                studentToEdit.setFirstName(newFirstName);
                studentToEdit.setLastName(newLastName);
                System.out.println("Name updated successfully.");
                break;

            case 2:
                System.out.print("Enter new section: ");
                String newSection = scanner.nextLine();
                studentToEdit.setSection(newSection);
                System.out.println("Section updated successfully.");
                break;

            case 3:
                // Join an Organization
                if (organizations.isEmpty()) {
                    System.out.println("No organizations available. Add organizations first.");
                } else {
                    System.out.println("Available Organizations:");
                    for (int i = 0; i < organizations.size(); i++) {
                        if (!studentToEdit.getOrganizationPayments().containsKey(organizations.get(i))) {
                            System.out.println((i + 1) + ". " + organizations.get(i).getName());
                        }
                    }

                    System.out.print("Enter the number of the organization to join (or 0 to cancel): ");
                    int orgChoice = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    if (orgChoice > 0 && orgChoice <= organizations.size()) {
                        Organization selectedOrg = organizations.get(orgChoice - 1);
                        if (!studentToEdit.getOrganizationPayments().containsKey(selectedOrg)) {
                            studentToEdit.joinOrganization(selectedOrg);
                            System.out.println("Joined organization: " + selectedOrg.getName());
                        } else {
                            System.out.println("Student is already a member of this organization.");
                        }
                    } else {
                        System.out.println("Cancelled joining organization.");
                    }
                }
                break;

            case 4:
                // Leave an Organization
                if (studentToEdit.getOrganizationPayments().isEmpty()) {
                    System.out.println("The student is not part of any organizations.");
                } else {
                    System.out.println("Current Organizations:");
                    List<Organization> studentOrgs = new ArrayList<>(studentToEdit.getOrganizationPayments().keySet());
                    for (int i = 0; i < studentOrgs.size(); i++) {
                        System.out.println((i + 1) + ". " + studentOrgs.get(i).getName());
                    }

                    System.out.print("Enter the number of the organization to leave (or 0 to cancel): ");
                    int orgChoice = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    if (orgChoice > 0 && orgChoice <= studentOrgs.size()) {
                        Organization selectedOrg = studentOrgs.get(orgChoice - 1);
                        studentToEdit.leaveOrganization(selectedOrg);
                        System.out.println("Left organization: " + selectedOrg.getName());
                    } else {
                        System.out.println("Cancelled leaving organization.");
                    }
                }
                break;

            case 5:
                System.out.println("Edit cancelled.");
                break;

            default:
                System.out.println("Invalid choice. Returning to main menu.");
        }
    }

    /**
     * Marks students as paid/unpaid in organizations
     * @param scanner for user inputs
     * @param students list of students
     */
    private static void managePayments(Scanner scanner, List<Student> students) {
        if (students.isEmpty()) {
            System.out.println("No students available. Add students first.");
            return;
        }

        System.out.println("\n==== Manage Payments ====");
        System.out.println("Available Students:");
        viewAllStudents(students);
        System.out.print("Enter No.: ");
        int studentIndex = scanner.nextInt() - 1;
        scanner.nextLine(); // Consume newline

        if (studentIndex < 0 || studentIndex >= students.size()) {
            System.out.println("Invalid student number.");
            return;
        }

        Student selectedStudent = students.get(studentIndex);
        System.out.println("\nOrganizations for " + selectedStudent.getFullName() + ":");
        List<Organization> organizations = new ArrayList<>(selectedStudent.getOrganizationPayments().keySet());

        if (organizations.isEmpty()) {
            System.out.println("This student has not joined any organizations.");
            return;
        }

        for (int i = 0; i < organizations.size(); i++) {
            Organization org = organizations.get(i);
            String status = selectedStudent.getOrganizationPayments().get(org) ? "Paid" : "Unpaid";
            System.out.println((i + 1) + ". " + org.getName() + " - " + status);
        }

        System.out.print("Enter the number of the organization to update payment status: ");
        int orgIndex = scanner.nextInt() - 1;
        scanner.nextLine(); // Consume newline

        if (orgIndex < 0 || orgIndex >= organizations.size()) {
            System.out.println("Invalid organization number.");
            return;
        }

        Organization selectedOrg = organizations.get(orgIndex);

        System.out.print("Mark as (paid/unpaid): ");
        String paymentStatus = scanner.nextLine().toLowerCase();

        if (paymentStatus.equals("paid")) {
            selectedStudent.markAsPaid(selectedOrg);
            System.out.println("Marked as paid for " + selectedOrg.getName());
        } else if (paymentStatus.equals("unpaid")) {
            selectedStudent.getOrganizationPayments().put(selectedOrg, false);
            System.out.println("Marked as unpaid for " + selectedOrg.getName());
        } else {
            System.out.println("Invalid input. No changes made.");
        }
    }

    /**
     * Method that searches students by StudentId.
     * @param students list of students
     * @param studentId search key
     * @return element that matched search key
     */
    private static Student searchAlgo(List<Student> students, String studentId) {
        Student foundStudent = null;
        for (Student s : students) {
            if (s.getStudentId().equalsIgnoreCase(studentId)) {
                foundStudent = s;
                break;
            }
        }
        return foundStudent;
    }

    /**
     * Search method for search option
     * @param scanner for user input
     * @param students list of students
     */
    private static void searchStudent(Scanner scanner, List<Student> students) {
        if (students.isEmpty()) {
            System.out.println("No students available. Add students first.");
            return;
        }

        System.out.println("\n==== Search Student by ID ====");
        System.out.print("Enter Student ID: ");
        String studentId = scanner.nextLine();

        Student foundStudent = null;
        for (Student s : students) {
            if (s.getStudentId().equalsIgnoreCase(studentId)) {
                foundStudent = s;
                break;
            }
        }

        if (foundStudent == null) {
            System.out.println("No student found with ID: " + studentId);
        } else {
            displayStudentDetails(foundStudent);
        }
    }

    /**
     * Displays a single student's details
     * @param student list of students
     */
    private static void displayStudentDetails(Student student) {
        System.out.println("\n==== Student Details ====");
        System.out.println("Name: " + student.getFullName());
        System.out.println("Student ID: " + student.getStudentId());
        System.out.println("Section: " + student.getSection());

        System.out.println("\nOrganizations:");
        if (student.getOrganizationPayments().isEmpty()) {
            System.out.println("None");
        } else {
            for (Organization org : student.getOrganizationPayments().keySet()) {
                String status = student.getOrganizationPayments().get(org) ? "Paid" : "Unpaid";
                System.out.println("- " + org.getName() + " (Status: " + status + ")");
            }
        }

        System.out.printf("Total Unpaid Fees: %.2f%n", student.calculateUnpaidFees());
    }

    /**
     * Displays all student details in a table
     * @param students list of students
     */
    private static void viewAllStudents(List<Student> students) {
        if (students.isEmpty()) {
            System.out.println("No students added yet.");
            return;
        }

        System.out.println("\n==== Students List ====");
        System.out.printf("%-5s %-20s %-20s %-15s %-15s %-30s %-30s %-15s%n",
                "No.", "First Name", "Last Name", "Student ID", "Section",
                "Paid Organizations", "Unpaid Organizations", "Total Unpaid Fees");
        for (int i = 0; i < 160; i++) {
            System.out.print('-');
        }
        System.out.println();

        for (int i = 0; i < students.size(); i++) {
            Student s = students.get(i);

            // Retrieve Paid Organizations
            String paidOrganizations = s.getOrganizationPayments()
                    .entrySet()
                    .stream()
                    .filter(Map.Entry::getValue) // Filter paid organizations
                    .map(entry -> entry.getKey().getName())
                    .reduce((org1, org2) -> org1 + ", " + org2)
                    .orElse("None");

            // Retrieve Unpaid Organizations
            String unpaidOrganizations = s.getOrganizationPayments()
                    .entrySet()
                    .stream()
                    .filter(entry -> !entry.getValue()) // Filter unpaid organizations
                    .map(entry -> entry.getKey().getName())
                    .reduce((org1, org2) -> org1 + ", " + org2)
                    .orElse("None");

            // Calculate total unpaid fees
            double totalUnpaidFees = s.calculateUnpaidFees();

            // Display student information in a tabular format
            System.out.printf("%-5d %-20s %-20s %-15s %-15s %-30s %-30s %-15.2f%n",
                    i + 1,
                    s.getFirstName(),
                    s.getLastName(),
                    s.getStudentId(),
                    s.getSection(),
                    paidOrganizations,
                    unpaidOrganizations,
                    totalUnpaidFees);
        }
    }

}
