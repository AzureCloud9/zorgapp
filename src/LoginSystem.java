import java.util.Scanner;

/**
 * LoginSystem – asks for a username and password.
 *
 * Only one account exists:
 * username : admin
 * password : 1234
 *
 * It keeps asking until the right combination is entered.
 */
class LoginSystem {

    static void login(Scanner scanner) {
        System.out.println("===== Login =====");

        while (true) {
            System.out.print("Username : ");
            String username = scanner.nextLine();

            System.out.print("Password : ");
            String password = scanner.nextLine();

            if (username.equals("admin") && password.equals("1234")) {
                System.out.println("Login successful!\n");
                return; // exit the method, go to the main menu
            } else {
                System.out.println("Wrong username or password. Try again.\n");
            }
        }
    }
}
