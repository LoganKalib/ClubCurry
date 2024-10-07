package za.ac.cput.factory;

import za.ac.cput.domain.Admin;
import za.ac.cput.domain.GeneralStaff;
import za.ac.cput.domain.enums.ExpertLevel;
import za.ac.cput.utils.Validation;

public class GenStaffFactory {
    public static GeneralStaff buildGenStaff(String id, String name, String surname, String username, String password) {
            return new GeneralStaff.Builder()
                    .setId(id)
                    .setName(name)
                    .setSurname(surname)
                    .setUsername(username)
                    .setPassword(password)
                    .build();
    }

    public static GeneralStaff buildGenStaff(String username, String password) {
        // Validate that the ID is a valid long number
        return new GeneralStaff.Builder()
                .setUsername(username)
                .setPassword(password)
                .build();
    }
}
