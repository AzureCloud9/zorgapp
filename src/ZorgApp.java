import java.util.Scanner;

class ZorgApp {
    public static void main(String[] args) {
        // One single Scanner for the whole app (avoids conflicts)
        Scanner scanner = new Scanner(System.in);

        // Step 1: login screen
        LoginSystem.login(scanner);

        // Step 2: main menu (only reach1ed after a correct login)
        User user = new User(1, "admin", "1234");
        Administration administration = new Administration(user, scanner);
        administration.menu();
    }
}
