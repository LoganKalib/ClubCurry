package za.ac.cput.factory;

import za.ac.cput.domain.Admin;
import za.ac.cput.domain.Driver;
import za.ac.cput.domain.Vehicle;
import za.ac.cput.utils.Validation;
public class DriverFactory {
    public static Driver buildDriver(String id, double petrolAllowance, Vehicle registration, String name, String surname, String password, String username){


        if(id.length() == 13 && registration !=null
                && Validation.isValidString(name)
                && Validation.isValidString(surname)
                && Validation.isValidPassword(password)
                && !username.isEmpty()){
            return new Driver.Builder()
                    .setId(id)
                    .setName(name)
                    .setRegistration(registration)
                    .setPetrolAllowance(petrolAllowance)
                    .setSurname(surname)
                    .setUsername(username)
                    .setPassword(password).build();
        }
        return null;
    }

    public static Driver buildDriver(String id, String name, String surname, String password, String username){
        try{
            long i = Long.parseLong(id);
        }catch(NumberFormatException ex){
            System.out.println("Error: " + ex.getLocalizedMessage());
            return null;
        }

        if( id.length() == 13
                && Validation.isValidString(name)
                && Validation.isValidString(surname)
                && Validation.isValidPassword(password)
                && !username.isEmpty()){
            return new Driver.Builder()
                    .setName(name)
                    .setSurname(surname)
                    .setUsername(username)
                    .setPassword(password).build();
        }
        return null;
    }

    public static Driver buildDriver(String username, String password) {
        // Validate that the ID is a valid long number
        return new Driver.Builder()
                .setUsername(username)
                .setPassword(password)
                .build();
    }
}
