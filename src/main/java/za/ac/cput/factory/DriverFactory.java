package za.ac.cput.factory;

import za.ac.cput.domain.Admin;
import za.ac.cput.domain.Driver;
import za.ac.cput.domain.Vehicle;
import za.ac.cput.utils.Validation;
public class DriverFactory {
    public static Driver buildDriver(String id, double petrolAllowance, Vehicle registration, String name, String surname, String password, String username){
            return new Driver.Builder()
                    .setId(id)
                    .setName(name)
                    .setRegistration(registration)
                    .setPetrolAllowance(petrolAllowance)
                    .setSurname(surname)
                    .setUsername(username)
                    .setPassword(password).build();
    }

    public static Driver buildDriver(String id, String name, String surname, String password, String username){

            return new Driver.Builder()
                    .setName(name)
                    .setSurname(surname)
                    .setUsername(username)
                    .setPassword(password).build();
    }

    public static Driver buildDriver(String username, String password) {
        // Validate that the ID is a valid long number
        return new Driver.Builder()
                .setUsername(username)
                .setPassword(password)
                .build();
    }
}
