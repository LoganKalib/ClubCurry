package za.ac.cput.factory;

import za.ac.cput.domain.Admin;
import za.ac.cput.utils.Validation;

/**
 * Factory class for creating instances of Admin.
 * Provides methods to create Admin objects with validation logic.
 */
public class AdminFactory {

    /**
     * Creates an Admin object if the provided data is valid.
     *
     * @param id       the ID of the Admin (must be a valid 13-digit string)
     * @param name     the name of the Admin
     * @param surname  the surname of the Admin
     * @param username the username of the Admin
     * @param password the password of the Admin
     * @return a new Admin object if the data is valid; otherwise, returns null
     */
    public static Admin buildAdmin(String id, String name, String surname, String username, String password) {
        // Validate that the ID is a valid long number
        try {
            long i = Long.parseLong(id);
        } catch (NumberFormatException ex) {
            System.out.println("Error: " + ex.getLocalizedMessage());
            return null;
        }

        // Check if all fields are valid according to the business rules
        if (Validation.isValidString(name)
                && Validation.isValidString(surname)
                && Validation.isValidString(username)) {
            return new Admin.Builder()
                    .setId(id)
                    .setName(name)
                    .setSurname(surname)
                    .setUsername(username)
                    .setPassword(password)
                    .build();
        }
        return null;
    }
    public static Admin buildAdmin(String username, String password) {
        // Validate that the ID is a valid long number
            return new Admin.Builder()
                    .setUsername(username)
                    .setPassword(password)
                    .build();
    }
}
