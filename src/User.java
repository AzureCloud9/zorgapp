/**
 * A User represents a person who can log in to ZorgApp.
 *
 * Every user has:
 * - an ID (a unique number, e.g. 1, 2, 3)
 * - a userName (the name they type to log in, e.g. "admin")
 * - a password (the secret word they type to prove it is them)
 */
class User {
    int userID;
    String userName;
    String password; // <-- NEW: the password for this user

    /**
     * Create a new user.
     *
     * @param id       Unique number for this user.
     * @param name     The username (used to log in).
     * @param password The password (used to log in).
     */
    public User(int id, String name, String password) {
        this.userID = id;
        this.userName = name;
        this.password = password;
    }

    String getUserName() {
        return userName;
    }

    int getUserID() {
        return userID;
    }

    String getPassword() {
        return password;
    }
}
