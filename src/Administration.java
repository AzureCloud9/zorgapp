import java.time.LocalDate;
import java.util.Scanner;

/**
 * class Administration represents the core of the application by showing
 * the main menu, from where all other functionality is accessible, either
 * directly or via sub-menus.
 * An Administration instance needs a User as input, which is passed via the
 * constructor to the data member 'currentUser'.
 * The patient data is available via the data member currentPatient.
 */
class Administration {
    static final int STOP = 0;
    static final int VIEW = 1;
    static final int SELECT_PATIENT = 2; // <-- NEW: Menu option to choose a patient
    static final int EDIT_PATIENT = 3;
    static final int SEARCH_PATIENT = 4; // <-- NEW: Menu option to search for a patient
    Scanner scanner;
    User currentUser;

    // We keep track of the currently selected patient
    Patient currentPatient;

    // --> NEW: An array holding our list of patients
    Patient[] patients;

    /**
     * Constructor
     */
    Administration(User user, Scanner scanner) {
        this.currentUser = user;
        this.scanner = scanner;

        // == CREATE OUR PATIENT LIST ==
        // We create an array that can hold 3 patients.
        patients = new Patient[3];

        // Fill the array with dummy data
        patients[0] = new Patient(1, "Van Puffelen", "Pierre", LocalDate.of(2000, 2, 29), 75.0, 180.0);
        patients[1] = new Patient(2, "Jansen", "Anna", LocalDate.of(1995, 5, 12), 65.0, 170.0);
        patients[2] = new Patient(3, "Klaassen", "Jan", LocalDate.of(1980, 10, 5), 90.0, 185.0);

        // Set the very first patient in the array as the current one by default
        currentPatient = patients[0];

        System.out.format("Current user: [%d] %s\n", user.getUserID(), user.getUserName());
    }

    void menu() {
        boolean nextCycle = true;

        while (nextCycle) {
            System.out.format("%s\n", "=".repeat(80));
            // Show who is currently selected
            System.out.format("Current patient: %s\n", currentPatient.fullName());

            /*
             * Print menu on screen
             */
            System.out.format("%d:  STOP\n", STOP);
            System.out.format("%d:  View patient data\n", VIEW);
            System.out.format("%d:  Select different patient\n", SELECT_PATIENT); // <-- NEW option shown
            System.out.format("%d:  Edit patient data\n", EDIT_PATIENT);
            System.out.format("%d:  Search patient\n", SEARCH_PATIENT); // <-- NEW: Search option
            System.out.print("enter #choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case STOP:
                    nextCycle = false;
                    break;

                case VIEW:
                    // Shows the details (including BMI) of whichever patient is currently selected
                    currentPatient.viewData();
                    break;

                case SELECT_PATIENT:
                    // 1. Show all patients in the list
                    System.out.println("\n--- Patient List ---");
                    for (int i = 0; i < patients.length; i++) {
                        // Print the index number and the patient's name
                        System.out.println(i + ": " + patients[i].getFirstName() + " " + patients[i].getSurname());
                    }

                    // 2. Ask the user to choose a number
                    System.out.print("Enter patient number to select: ");
                    int chosenIndex = scanner.nextInt();

                    // 3. Make sure the number exists in our array
                    if (chosenIndex >= 0 && chosenIndex < patients.length) {
                        currentPatient = patients[chosenIndex]; // Change the active patient!
                        System.out.println("Patient selected.");
                    } else {
                        System.out.println("Invalid number!");
                    }
                    break;

                case EDIT_PATIENT:
                    System.out.println(" edit mode activated! ");
                    break;

                case SEARCH_PATIENT:
                    searchPatient();
                    break;

                default:
                    System.out.println("Please enter a *valid* digit");
                    break;
            }
        }
    }

    /**
     * Search for a patient by ID or surname.
     * If found, the patient becomes the current patient.
     */
    void searchPatient() {
        System.out.println("\n--- Search Patient ---");
        System.out.println("1: Search by patient ID");
        System.out.println("2: Search by surname");
        System.out.print("Enter your choice: ");
        int searchChoice = scanner.nextInt();
        scanner.nextLine(); // Clear the newline character

        Patient foundPatient = null;

        if (searchChoice == 1) {
            // Search by ID
            System.out.print("Enter patient ID: ");
            int searchId = scanner.nextInt();
            scanner.nextLine(); // Clear the newline character

            // Look for the patient with this ID
            for (int i = 0; i < patients.length; i++) {
                if (patients[i].getId() == searchId) {
                    foundPatient = patients[i];
                    break;
                }
            }
        } else if (searchChoice == 2) {
            // Search by surname
            System.out.print("Enter surname: ");
            String searchSurname = scanner.nextLine();

            // Look for the patient with this surname
            for (int i = 0; i < patients.length; i++) {
                if (patients[i].getSurname().equalsIgnoreCase(searchSurname)) {
                    foundPatient = patients[i];
                    break;
                }
            }
        } else {
            System.out.println("Invalid choice!");
            return;
        }

        // Show the result
        if (foundPatient != null) {
            currentPatient = foundPatient;
            System.out.println("\nPatient found and selected:");
            System.out.println("ID: " + foundPatient.getId());
            System.out.println("Name: " + foundPatient.getFirstName() + " " + foundPatient.getSurname());
        } else {
            System.out.println("\nPatient not found!");
        }
    }
}
