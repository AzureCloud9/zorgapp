import java.time.LocalDate;

class Patient {
    static final int RETURN = 0;
    static final int SURNAME = 1;
    static final int FIRSTNAME = 2;
    static final int DATEOFBIRTH = 3;
    static final int WEIGHT = 4;
    static final int HEIGHT = 5;

    int id;
    String surname;
    String firstName;
    LocalDate dateOfBirth;
    double weight;
    double height;

    /**
     * Constructor
     * 
     */
    Patient(int id, String surname, String firstName, LocalDate dateOfBirth, double weight, double height) {
        this.id = id;
        this.surname = surname;
        this.firstName = firstName;
        this.dateOfBirth = dateOfBirth;
        this.weight = weight;
        this.height = height;
    }

    String getSurname() {
        return surname;
    }

    String getFirstName() {
        return firstName;
    }

    double getWeight() {
        return weight;
    }

    double getHeight() {
        return height;
    }

    /**
     * Calculate Body Mass Index (BMI).
     * Formula: weight (kg) / height (m)^2
     * Height is stored in cm, so divide by 100 to get metres.
     */
    double getBMI() {
        double heightInMetres = height / 100.0;
        return weight / (heightInMetres * heightInMetres);
    }

    /**
     * Display patient data.
     */
    void viewData() {
        System.out.format("===== Patient id=%d ==============================\n", id);
        System.out.format("%-17s %s\n", "Surname:", surname);
        System.out.format("%-17s %s\n", "firstName:", firstName);
        System.out.format("%-17s %s\n", "Date of birth:", dateOfBirth);
        System.out.format("%-17s %.1f kg\n", "Weight:", weight);
        System.out.format("%-17s %.1f cm\n", "Height:", height);
        System.out.format("%-17s %.1f\n", "BMI:", getBMI());
    }

    /**
     * Shorthand for a Patient's full name
     */
    String fullName() {
        return String.format("%s %s [%s]", firstName, surname, dateOfBirth.toString(), weight, height);
    }
}
